/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.courseproject.dulko.database.DAO;

import by.bsuir.courseproject.dulko.database.DBConnection;
import by.bsuir.courseproject.dulko.database.model.Instructor;
import by.bsuir.courseproject.dulko.database.model.DBObject;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Евгения
 */
public class InstructorDAOImpl implements InstructorDAO {

    @Override
    public List getInstructors() {
        Instructor instructor = null;
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List instructors = new ArrayList();
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT * FROM instructor");
            rs = ps.executeQuery();
            while (rs.next()) {
                instructor = new Instructor(rs.getInt("id_instructor"));
                instructor.setSurname(rs.getString("surname"));
                instructor.setName(rs.getString("name"));
                instructor.setLastname(rs.getString("lastname"));
                instructor.setPhoneNumber(rs.getString("phone_number"));
                instructor.setInstructorCategory(rs.getString("instructor_category"));
                instructor.setNameProgramm(rs.getString("name_programm"));
                instructors.add(instructor);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InstructorDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return instructors;
    }

    @Override
    public int create(DBObject object) {
        Instructor instructor = (Instructor) object;
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("INSERT INTO instructor (surname, name, lastname, phone_number, instructor_category, name_programm) VALUES (?,?,?,?,?,?)");
            ps.setString(1, instructor.getSurname());
            ps.setString(2, instructor.getName());
            ps.setString(3, instructor.getLastname());
            ps.setString(4, instructor.getPhoneNumber());
            ps.setString(5, instructor.getInstructorCategory());
            ps.setString(6, instructor.getNameProgramm());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(InstructorDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, null);
        }
        return 0;
    }

    @Override
    public DBObject read(int id_instructor) {
        Instructor instructor = new Instructor(id_instructor);
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT surname, name, lastname, phone_number, instructor_category, name_programm FROM instructor WHERE id_instructor = ?");
            ps.setInt(1, id_instructor);
            rs = ps.executeQuery();
            rs.next();
            instructor.setSurname(rs.getString("surname"));
            instructor.setName(rs.getString("name"));
            instructor.setLastname(rs.getString("lastname"));
            instructor.setPhoneNumber(rs.getString("phone_number"));
            instructor.setInstructorCategory(rs.getString("instructor_category"));
            instructor.setNameProgramm(rs.getString("name_programm"));
        } catch (SQLException ex) {
            Logger.getLogger(InstructorDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return instructor;
    }

    @Override
    public void update(DBObject newObject) {
        Instructor newInstructor = (Instructor) newObject;
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("UPDATE instructor SET surname = ?, name = ?, lastname = ?, phone_number = ?, instructor_category = ?, name_programm = ? WHERE id_instructor = ?");
            ps.setString(1, newInstructor.getSurname());
            ps.setString(2, newInstructor.getName());
            ps.setString(3, newInstructor.getLastname());
            ps.setString(4, newInstructor.getPhoneNumber());
            ps.setString(5, newInstructor.getInstructorCategory());
            ps.setString(6, newInstructor.getNameProgramm());
            ps.setInt(7, newObject.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(InstructorDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, null);
        }
    }

    @Override
    public void delete(int id_instructor) {
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("DELETE FROM instructor WHERE id_instructor = ?");
            ps.setInt(1, id_instructor);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(InstructorDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(InstructorDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public DBObject getInstructorBySurname(String name) {
        Instructor instructor = null;
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT id_instructor, surname FROM instructor WHERE surname = ?");
            ps.setString(1, name);
            rs = ps.executeQuery();
            rs.next();
            instructor = new Instructor(rs.getInt("id_instructor"));
            instructor.setInstructorCategory(rs.getString("surname"));
        } catch (SQLException ex) {
            Logger.getLogger(InstructorDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return instructor;
    }

    @Override
    public Instructor getInstructorById(int id) {
        Instructor instructor = null;
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT id_instructor, surname FROM instructor WHERE id_instructor = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            instructor = new Instructor(rs.getInt("id_instructor"));
            instructor.setSurname(rs.getString("surname"));
            instructor.setName(rs.getString("name"));
            instructor.setLastname(rs.getString("lastname"));
            instructor.setPhoneNumber(rs.getString("phone_number"));
            instructor.setInstructorCategory(rs.getString("instructor_category"));
            instructor.setNameProgramm(rs.getString("name_programm"));
        } catch (SQLException ex) {
            Logger.getLogger(InstructorDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return instructor;
    }

}
