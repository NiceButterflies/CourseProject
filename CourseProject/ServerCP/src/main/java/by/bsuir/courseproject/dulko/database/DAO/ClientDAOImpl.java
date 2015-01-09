/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.courseproject.dulko.database.DAO;

import by.bsuir.courseproject.dulko.database.DBConnection;
import by.bsuir.courseproject.dulko.database.model.Client;
import by.bsuir.courseproject.dulko.database.model.DBObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Евгения
 */
public class ClientDAOImpl implements ClientDAO {

    @Override
    public List getClients() {
        Client client = null;
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List clients = new ArrayList();
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT * FROM client");
            rs = ps.executeQuery();
            while (rs.next()) {
                client = new Client(rs.getInt("id_client"));
                client.setSurname(rs.getString("surname"));
                client.setName(rs.getString("name"));
                client.setLastname(rs.getString("lastname"));
                client.setPhoneNumber(rs.getString("phone_number"));
                client.setIdDiscount(rs.getInt("id_discount"));
                clients.add(client);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return clients;
    }

    @Override
    public Client getClientWhereLogin(String login) {
        Client client = null;
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT * FROM client WHERE phone_number = ?");
            ps.setString(1, login);
            rs = ps.executeQuery();
            rs.next();
            client = new Client(rs.getInt("id_client"));
            client.setSurname(rs.getString("surname"));
            client.setName(rs.getString("name"));
            client.setLastname(rs.getString("lastname"));
            client.setPhoneNumber(rs.getString("phone_number"));
            client.setIdDiscount(rs.getInt("id_discount"));
        } catch (SQLException ex) {
            Logger.getLogger(ClientDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return client;
    }

    @Override
    public int create(DBObject object) {
        Client client = (Client) object;
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("INSERT INTO client (surname, name, lastname, phone_number, id_discount) VALUES (?,?,?,?,?)");
            ps.setString(1, client.getSurname());
            ps.setString(2, client.getName());
            ps.setString(3, client.getLastname());
            ps.setString(4, client.getPhoneNumber());
            ps.setInt(5, client.getIdDiscount());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ClientDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, null);
        }
        return 0;
    }

    @Override
    public DBObject read(int id_client) {
        Client client = new Client(id_client);
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT surname, name, lastname, phone_number, id_discount FROM client WHERE id_client = ?");
            ps.setInt(1, id_client);
            rs = ps.executeQuery();
            rs.next();
            client.setSurname(rs.getString("surname"));
            client.setName(rs.getString("name"));
            client.setLastname(rs.getString("lastname"));
            client.setPhoneNumber(rs.getString("phone_number"));
            client.setIdDiscount(rs.getInt("id_discount"));
        } catch (SQLException ex) {
            Logger.getLogger(ClientDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return client;
    }

    @Override
    public void update(DBObject newObject) {
        Client newClient = (Client) newObject;
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("UPDATE client SET surname = ?, name = ?, lastname = ?, phone_number = ?, id_discount = ? WHERE id_client = ?");
            ps.setString(1, newClient.getSurname());
            ps.setString(2, newClient.getName());
            ps.setString(3, newClient.getLastname());
            ps.setString(4, newClient.getPhoneNumber());
            ps.setInt(5, newClient.getIdDiscount());
            ps.setInt(6, newObject.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClientDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, null);
        }
    }

    @Override
    public void delete(int id_client) {
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("DELETE FROM client WHERE id_client = ?");
            ps.setInt(1, id_client);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ClientDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, null);
        }
    }

    private void finallyBlock(Statement ps, ResultSet rs) {
        try {
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public DBObject getClientBySurname(String name) {
        Client client = null;
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT id_client, surname FROM client WHERE surname = ?");
            ps.setString(1, name);
            rs = ps.executeQuery();
            rs.next();
            client = new Client(rs.getInt("id_client"));
            client.setSurname(rs.getString("surname"));
        } catch (SQLException ex) {
            Logger.getLogger(ClientDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return client;
    }

}
