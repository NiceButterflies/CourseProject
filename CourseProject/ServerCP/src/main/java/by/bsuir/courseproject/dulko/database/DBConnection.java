/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.courseproject.dulko.database;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Евгения
 */
public final class DBConnection {

    private static String driverClassName;
    private static String url, username, password;
    private static int maxConnection;
    private static ArrayBlockingQueue<Connection> freeConnections;
    private static ArrayBlockingQueue<Connection> allConnections;
    private static DBConnection connection;

    private DBConnection() {
        ResourceBundle bundle = ResourceBundle.getBundle("database");
        driverClassName = bundle.getString("jdbc.driverClassName");
        url = bundle.getString("jdbc.url");
        username = bundle.getString("jdbc.username");
        password = bundle.getString("jdbc.password");
        maxConnection = Integer.parseInt(bundle.getString("jdbc.maxCon"));
        this.freeConnections = new ArrayBlockingQueue<Connection>(maxConnection);
        this.allConnections = new ArrayBlockingQueue<Connection>(maxConnection);
    }

    /**
     * Inits connection
     *
     * @return database.controller.DBConnection object
     */
    public static DBConnection init() {
        if (connection == null) {
            connection = new DBConnection();
            try {
                Driver driver = (Driver) Class.forName(driverClassName).newInstance();
                DriverManager.registerDriver(driver);
                int i = 0;
                while (i != maxConnection) {
                    freeConnections.add(newConnection());
                    i++;
                }
                allConnections.addAll(freeConnections);
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return connection;
    }

    /**
     *
     * @return java.sql.Connection;
     */
    public Connection getConnection() {
        Connection con;
        if (!freeConnections.isEmpty()) {
            con = (Connection) freeConnections.poll();
            try {
                if (con.isClosed()) {
                    allConnections.remove();
                    con = newConnection();
                    allConnections.add(con);
                }
            } catch (SQLException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            con = newConnection();
        }
        return con;
    }

    private static Connection newConnection() {
        Connection con = null;
        try {
            Locale.setDefault(Locale.ENGLISH);
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    /**
     * Return java.sql.Connection to the database.controller.DBConnectionPool
     * object
     *
     * @param con
     */
    public synchronized void freeConnection(Connection con) {
        if ((con != null) && (freeConnections.size() <= maxConnection)) {
            freeConnections.add(con);
        }
    }

    /**
     * Close all java.sql.Connection in database.controller.DBConnectionPool
     */
    public void release() {
        for (Connection con : allConnections) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        freeConnections.clear();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        release();
    }
}
