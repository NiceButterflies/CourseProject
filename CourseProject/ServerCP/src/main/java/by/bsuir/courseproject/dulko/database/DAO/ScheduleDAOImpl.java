/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.courseproject.dulko.database.DAO;

import by.bsuir.courseproject.dulko.database.DBConnection;
import by.bsuir.courseproject.dulko.database.model.Schedule;
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

/**
 *
 * @author Евгения
 */
public class ScheduleDAOImpl implements ScheduleDAO {

    @Override
    public List getScheduls() {
        Schedule schedule = null;
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List scheduls = new ArrayList();
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT * FROM schedule ORDER BY weekday, time");
            rs = ps.executeQuery();
            while (rs.next()) {
                schedule = new Schedule(rs.getInt("id"));
                schedule.setWeekday(rs.getString("weekday"));
                schedule.setTime(rs.getString("time"));
                schedule.setIdProgramm(rs.getInt("id_programm"));
                schedule.setIdInstructor(rs.getInt("id_instructor"));
                scheduls.add(schedule);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return scheduls;
    }

    @Override
    public int create(DBObject object) {
        Schedule schedule = (Schedule) object;
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("INSERT INTO schedule (weekday, time, id_programm, id_instructor) VALUES (?,?,?,?)");
            ps.setString(1, schedule.getWeekday());
            ps.setString(2, schedule.getTime());
            ps.setInt(3, schedule.getIdProgramm());
            ps.setInt(4, schedule.getIdInstructor());

            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, null);
        }
        return 0;
    }

    @Override
    public DBObject read(int id) {
        Schedule schedule = new Schedule(id);
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT weekday, time, id_programm, id_instructor FROM schedule WHERE id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            schedule.setWeekday(rs.getString("weekday"));
            schedule.setTime(rs.getString("time"));
            schedule.setIdProgramm(rs.getInt("id_programm"));
            schedule.setIdInstructor(rs.getInt("id_instructor"));

        } catch (SQLException ex) {
            Logger.getLogger(ScheduleDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return schedule;
    }

    @Override
    public void update(DBObject newObject) {
        Schedule newSchedule = (Schedule) newObject;
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("UPDATE schedule SET weekday = ?, time = ?, id_programm = ?, id_instructor = ? WHERE id = ?");
            ps.setString(1, newSchedule.getWeekday());
            ps.setString(2, newSchedule.getTime());
            ps.setInt(3, newSchedule.getIdProgramm());
            ps.setInt(4, newSchedule.getIdInstructor());
            ps.setInt(5, newObject.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, null);
        }
    }

    @Override
    public void delete(int id) {
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("DELETE FROM schedule WHERE id = ?");
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ScheduleDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Schedule getSchedule(int id) {
        Schedule schedule = null;
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT * FROM schedule WHERE id=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            schedule = new Schedule(rs.getInt("id"));
            schedule.setWeekday(rs.getString("weekday"));
            schedule.setTime(rs.getString("time"));
            schedule.setIdProgramm(rs.getInt("id_programm"));
            schedule.setIdInstructor(rs.getInt("id_instructor"));
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return schedule;
    }

    @Override
    public List getScheduleByIdProgramm(int id) {
        Schedule schedule = null;
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List scheduls = new ArrayList();
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT * FROM schedule WHERE id_programm=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                schedule = new Schedule(rs.getInt("id"));
                schedule.setWeekday(rs.getString("weekday"));
                schedule.setTime(rs.getString("time"));
                schedule.setIdProgramm(rs.getInt("id_programm"));
                schedule.setIdInstructor(rs.getInt("id_instructor"));
                scheduls.add(schedule);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return scheduls;
    }

}
