/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.courseproject.dulko.database.DAO;

import by.bsuir.courseproject.dulko.database.DBConnection;
import by.bsuir.courseproject.dulko.database.model.DBObject;
import by.bsuir.courseproject.dulko.database.model.Programm;
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
public class ProgrammDAOImpl implements ProgrammDAO {

    @Override
    public List getProgramms() {
        Programm programm = null;
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List programms = new ArrayList();
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT * FROM programm");
            rs = ps.executeQuery();
            while (rs.next()) {
                programm = new Programm(rs.getInt("id_programm"));
                programm.setNameProgramm(rs.getString("name_programm"));
                programms.add(programm);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "WWWWWWWWWWWWWW");
            Logger.getLogger(ProgrammDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return programms;
    }

    @Override
    public int create(DBObject object) {
        Programm programm = (Programm) object;
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("INSERT INTO programm (name_programm) VALUES (?)");
            ps.setString(1, programm.getNameProgramm());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ProgrammDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, null);
        }
        return 0;
    }

    @Override
    public DBObject read(int id_programm) {
        Programm programm = new Programm(id_programm);
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT name_programm FROM programm WHERE id_programm = ?");
            ps.setInt(1, id_programm);
            rs = ps.executeQuery();
            rs.next();
            programm.setNameProgramm(rs.getString("name_programm"));
        } catch (SQLException ex) {
            Logger.getLogger(ProgrammDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return programm;
    }

    @Override
    public void update(DBObject newObject) {
        Programm newProgramm = (Programm) newObject;
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("UPDATE programm SET name_programm = ? WHERE id_programm =?");
            ps.setString(1, newProgramm.getNameProgramm());
            ps.setInt(2, newObject.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProgrammDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, null);
        }
    }

    @Override
    public void delete(int id_programm) {
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("DELETE FROM programm WHERE id_programm = ?");
            ps.setInt(1, id_programm);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ProgrammDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ProgrammDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public DBObject getProgrammByNameProgramm(String name) {
        Programm programm = null;
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT id_programm, name_programm FROM programm WHERE name_programm = ?");
            ps.setString(1, name);
            rs = ps.executeQuery();
            rs.next();
            programm = new Programm(rs.getInt("id_programm"));
            programm.setNameProgramm(rs.getString("name_programm"));
        } catch (SQLException ex) {
            Logger.getLogger(ProgrammDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return programm;
    }
}
