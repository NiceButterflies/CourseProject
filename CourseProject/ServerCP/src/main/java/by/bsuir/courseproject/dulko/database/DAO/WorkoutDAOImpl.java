/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.courseproject.dulko.database.DAO;

import by.bsuir.courseproject.dulko.database.DBConnection;
import by.bsuir.courseproject.dulko.database.model.DBObject;
import by.bsuir.courseproject.dulko.database.model.Schedule;
import by.bsuir.courseproject.dulko.database.model.Workout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Евгения
 */
public class WorkoutDAOImpl implements WorkoutDAO {

    @Override
    public List getWorkouts() {
        Workout workout = null;
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List workouts = new ArrayList();
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT * FROM workout");
            rs = ps.executeQuery();
            while (rs.next()) {
                workout = new Workout(rs.getInt("id_workout"));
                workout.setIdClient(rs.getInt("id_client"));
                workout.setIdProgramm(rs.getInt("id_programm"));
                workout.setIdSchedule(rs.getInt("id"));
                workout.setIdSubscription(rs.getInt("id_subscription"));
                workouts.add(workout);
            }
        } catch (SQLException ex) {
            Logger.getLogger(WorkoutDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return workouts;
    }

    @Override
    public List getWorkoutsByIdClient(int id) {
        Workout workout = null;
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List workouts = new ArrayList();
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT * FROM workout WHERE id_client=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                workout = new Workout(rs.getInt("id_workout"));
                workout.setIdClient(rs.getInt("id_client"));
                workout.setIdProgramm(rs.getInt("id_programm"));
                workout.setIdSchedule(rs.getInt("id"));
                workout.setIdSubscription(rs.getInt("id_subscription"));
                workouts.add(workout);
            }
        } catch (SQLException ex) {
            Logger.getLogger(WorkoutDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return workouts;
    }

    @Override
    public List getWorkoutsByIdProgramm(int id) {
        Workout workout = null;
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List workouts = new ArrayList();
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT * FROM workout WHERE id_programm=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                workout = new Workout(rs.getInt("id_workout"));
                workout.setIdClient(rs.getInt("id_client"));
                workout.setIdProgramm(rs.getInt("id_programm"));
                workout.setIdSchedule(rs.getInt("id"));
                workout.setIdSubscription(rs.getInt("id_subscription"));
                workouts.add(workout);
            }
        } catch (SQLException ex) {
            Logger.getLogger(WorkoutDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return workouts;
    }

    @Override
    public List getWorkoutsByIdSudscription(int id) {
        Workout workout = null;
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List workouts = new ArrayList();
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT * FROM workout WHERE id_subscription=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                workout = new Workout(rs.getInt("id_workout"));
                workout.setIdClient(rs.getInt("id_client"));
                workout.setIdProgramm(rs.getInt("id_programm"));
                workout.setIdSchedule(rs.getInt("id"));
                workout.setIdSubscription(rs.getInt("id_subscription"));
                workouts.add(workout);
            }
        } catch (SQLException ex) {
            Logger.getLogger(WorkoutDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return workouts;
    }

    @Override
    public List getWorkoutsByIdSchedule(int id) {
        Workout workout = null;
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List workouts = new ArrayList();
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT * FROM workout WHERE id_schedule=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                workout = new Workout(rs.getInt("id_workout"));
                workout.setIdClient(rs.getInt("id_client"));
                workout.setIdProgramm(rs.getInt("id_programm"));
                workout.setIdSchedule(rs.getInt("id"));
                workout.setIdSubscription(rs.getInt("id_subscription"));
                workouts.add(workout);
            }
        } catch (SQLException ex) {
            Logger.getLogger(WorkoutDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return workouts;
    }

    @Override
    public int create(DBObject object) {
        Workout workout = (Workout) object;
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("INSERT INTO workout (id_client, id_programm, id, id_subscription) VALUES (?,?,?,?)");
            ps.setInt(1, workout.getIdClient());
            ps.setInt(2, workout.getIdProgramm());
            ps.setInt(3, workout.getIdSchedule());
            ps.setInt(4, workout.getIdSubscription());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(WorkoutDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, null);
        }
        return 0;
    }

    @Override
    public DBObject read(int id) {
        Workout workout = new Workout(id);
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT id_client, id_programm, id, id_subscription FROM workout WHERE id_workout = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            workout.setIdClient(rs.getInt("id_client"));
            workout.setIdProgramm(rs.getInt("id_programm"));
            workout.setIdSchedule(rs.getInt("id"));
            workout.setIdSubscription(rs.getInt("id_subscription"));
        } catch (SQLException ex) {
            Logger.getLogger(WorkoutDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return workout;
    }

    @Override
    public void update(DBObject newObject) {
        Workout newWorkout = (Workout) newObject;
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("UPDATE workout SET id_client = ?, id_programm = ?, id = ?, id_subscription = ? WHERE id_workout = ?");
            ps.setInt(1, newWorkout.getIdClient());
            ps.setInt(2, newWorkout.getIdProgramm());
            ps.setInt(3, newWorkout.getIdSchedule());
            ps.setInt(4, newWorkout.getIdSubscription());
            ps.setInt(5, newObject.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(WorkoutDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
            ps = connection.prepareStatement("DELETE FROM workout WHERE id_workout = ?");
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(WorkoutDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, null);
        }
    }

    private void finallyBlock(PreparedStatement ps, ResultSet rs) {
        try {
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(WorkoutDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getCongestionTrainers(Schedule schedule) {
        Workout workout = null;
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int num = 0;
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT (count(id_client)) as num "
                    + "FROM workout, schedule WHERE workout.id = schedule.id and "
                    + "schedule.id_instructor = ? and schedule.weekday = ? "
                    + "and schedule.time = ?");
            ps.setInt(1, schedule.getIdInstructor());
            ps.setString(2, schedule.getWeekday());
            ps.setString(3, schedule.getTime());
            rs = ps.executeQuery();
            rs.next();
            num = rs.getInt("num");
        } catch (SQLException ex) {
            Logger.getLogger(WorkoutDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return num;
    }

    @Override
    public List getWorkoutsByIdScheduleByIdClient(int idP, int idC) {
        Workout workout = null;
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List workouts = new ArrayList();
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT * FROM workout WHERE id_programm=? and id_client=?");
            ps.setInt(1, idP);
            ps.setInt(2, idC);
            rs = ps.executeQuery();
            while (rs.next()) {
                workout = new Workout(rs.getInt("id_workout"));
                workout.setIdClient(rs.getInt("id_client"));
                workout.setIdProgramm(rs.getInt("id_programm"));
                workout.setIdSchedule(rs.getInt("id"));
                workout.setIdSubscription(rs.getInt("id_subscription"));
                workouts.add(workout);
            }
        } catch (SQLException ex) {
            Logger.getLogger(WorkoutDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return workouts;
    }

}
