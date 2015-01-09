/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.courseproject.dulko.database.DAO;

import by.bsuir.courseproject.dulko.database.DBConnection;
import by.bsuir.courseproject.dulko.database.model.DBObject;
import by.bsuir.courseproject.dulko.database.model.Query;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Евгения
 */
public class QueryDAOImpl implements QueryDAO {

    @Override
    public List getQuerys(String status) {
        Query query = null;
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List querys = new ArrayList();
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT * FROM query WHERE status=? GROUP BY id_client, id_programm, id_subscription");
            ps.setString(1, status);
            rs = ps.executeQuery();
            while (rs.next()) {
                query = new Query(rs.getInt("id_query"));
                query.setIdClient(rs.getInt("id_client"));
                query.setIdProgramm(rs.getInt("id_programm"));
                query.setIdSchedule(rs.getInt("id"));
                query.setIdSubscription(rs.getInt("id_subscription"));
                query.setStatus(rs.getString("status"));
                querys.add(query);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QueryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return querys;
    }

    @Override
    public List getQuerysByIdClient(int id) {
        Query query = null;
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List querys = new ArrayList();
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT * FROM query WHERE id_client=? GROUP BY id_client, id_programm, id_subscription");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                query = new Query(rs.getInt("id_query"));
                query.setIdClient(rs.getInt("id_client"));
                query.setIdProgramm(rs.getInt("id_programm"));
                query.setIdSchedule(rs.getInt("id"));
                query.setIdSubscription(rs.getInt("id_subscription"));
                query.setStatus(rs.getString("status"));
                querys.add(query);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QueryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return querys;
    }

    @Override
    public List getQuerysByIdProgramm(int id) {
        Query query = null;
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List querys = new ArrayList();
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT * FROM query WHERE id_programm=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                query = new Query(rs.getInt("id_query"));
                query.setIdClient(rs.getInt("id_client"));
                query.setIdProgramm(rs.getInt("id_programm"));
                query.setIdSchedule(rs.getInt("id"));
                query.setIdSubscription(rs.getInt("id_subscription"));
                query.setStatus(rs.getString("status"));
                querys.add(query);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QueryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return querys;
    }

    @Override
    public List getQuerysByIdSudscription(int id) {
        Query query = null;
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List querys = new ArrayList();
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT * FROM query WHERE id_subscription=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                query = new Query(rs.getInt("id_query"));
                query.setIdClient(rs.getInt("id_client"));
                query.setIdProgramm(rs.getInt("id_programm"));
                query.setIdSchedule(rs.getInt("id"));
                query.setIdSubscription(rs.getInt("id_subscription"));
                query.setStatus(rs.getString("status"));
                querys.add(query);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QueryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return querys;
    }

    @Override
    public List getQuerysByIdSchedule(int id) {
        Query query = null;
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List querys = new ArrayList();
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT * FROM query WHERE id=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                query = new Query(rs.getInt("id_query"));
                query.setIdClient(rs.getInt("id_client"));
                query.setIdProgramm(rs.getInt("id_programm"));
                query.setIdSchedule(rs.getInt("id"));
                query.setIdSubscription(rs.getInt("id_subscription"));
                query.setStatus(rs.getString("status"));
                querys.add(query);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QueryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return querys;
    }

    @Override
    public int create(DBObject object) {
        Query query = (Query) object;
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("INSERT INTO query (id_client, id_programm, id, id_subscription, status) VALUES (?,?,?,?,?)");
            ps.setInt(1, query.getIdClient());
            ps.setInt(2, query.getIdProgramm());
            ps.setInt(3, query.getIdSchedule());
            ps.setInt(4, query.getIdSubscription());
            ps.setString(5, query.getStatus());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(QueryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, null);
        }
        return 0;
    }

    @Override
    public DBObject read(int id) {
        Query query = new Query(id);
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT id_client, id_programm, id, id_subscription, status FROM query WHERE id_query = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            query.setIdClient(rs.getInt("id_client"));
            query.setIdProgramm(rs.getInt("id_programm"));
            query.setIdSchedule(rs.getInt("id_shedule"));
            query.setIdSubscription(rs.getInt("id_subscription"));
            query.setStatus(rs.getString("status"));
        } catch (SQLException ex) {
            Logger.getLogger(QueryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return query;
    }

    @Override
    public void update(DBObject newObject) {
        Query newQuery = (Query) newObject;
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("UPDATE query SET id_client = ?, id_programm = ?, id = ?, id_subscription = ?, status=? WHERE id_query = ?");
            ps.setInt(1, newQuery.getIdClient());
            ps.setInt(2, newQuery.getIdProgramm());
            ps.setInt(3, newQuery.getIdSchedule());
            ps.setInt(4, newQuery.getIdSubscription());
            ps.setString(5, newQuery.getStatus());
            ps.setInt(6, newObject.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
            ps = connection.prepareStatement("DELETE FROM query WHERE id_query = ?");
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(QueryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(QueryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List getQuerysByClientProgramSubscription(int idC, int idP, int idS, String status) {
        Query query = null;
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List querys = new ArrayList();
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT * FROM query WHERE id_client=? and id_programm=? and id_subscription = ? and status=?");
            ps.setInt(1, idC);
            ps.setInt(2, idP);
            ps.setInt(3, idS);
            ps.setString(4, status);
            rs = ps.executeQuery();
            while (rs.next()) {
                query = new Query(rs.getInt("id_query"));
                query.setIdClient(rs.getInt("id_client"));
                query.setIdProgramm(rs.getInt("id_programm"));
                query.setIdSchedule(rs.getInt("id"));
                query.setIdSubscription(rs.getInt("id_subscription"));
                query.setStatus(rs.getString("status"));
                querys.add(query);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QueryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return querys;
    }
    
    @Override
    public List getQuerysByClientProgramSubscription(int idC, int idP, int idS) {
        Query query = null;
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List querys = new ArrayList();
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT * FROM query WHERE id_client=? and id_programm=? and id_subscription = ?");
            ps.setInt(1, idC);
            ps.setInt(2, idP);
            ps.setInt(3, idS);
            rs = ps.executeQuery();
            while (rs.next()) {
                query = new Query(rs.getInt("id_query"));
                query.setIdClient(rs.getInt("id_client"));
                query.setIdProgramm(rs.getInt("id_programm"));
                query.setIdSchedule(rs.getInt("id"));
                query.setIdSubscription(rs.getInt("id_subscription"));
                query.setStatus(rs.getString("status"));
                querys.add(query);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QueryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return querys;
    }

}
