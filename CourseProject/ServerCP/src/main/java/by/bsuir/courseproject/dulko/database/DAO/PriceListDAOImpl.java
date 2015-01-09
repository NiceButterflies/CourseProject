/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.courseproject.dulko.database.DAO;

import by.bsuir.courseproject.dulko.database.DBConnection;
import by.bsuir.courseproject.dulko.database.model.PriceList;
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
public class PriceListDAOImpl implements PriceListDAO {

    @Override
    public List getPriceList() {
        PriceList priceList = null;
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List priceLists = new ArrayList();
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT * FROM price_list");
            rs = ps.executeQuery();
            while (rs.next()) {
                priceList = new PriceList(rs.getInt("id_subscription"));
                priceList.setIdProgramm(rs.getInt("id_programm"));
                priceList.setTypeSubscription(rs.getString("type_subscription"));
                priceList.setDurationSubscription(rs.getString("duration_subscription"));
                priceList.setPrice(rs.getInt("price"));
                priceLists.add(priceList);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PriceListDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return priceLists;
    }

    @Override
    public int create(DBObject object) {
        PriceList priceList = (PriceList) object;
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("INSERT INTO price_list (id_programm, type_subscription, duration_subscription, price) VALUES (?,?,?,?)");
            ps.setInt(1, priceList.getIdProgramm());
            ps.setString(2, priceList.getTypeSubscription());
            ps.setString(3, priceList.getDurationSubscription());
            ps.setInt(4, priceList.getPrice());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(PriceListDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, null);
        }
        return 0;
    }

    @Override
    public DBObject read(int id_subscription) {
        PriceList priceList = new PriceList(id_subscription);
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT id_programm, type_subscription, duration_subscription, price FROM price_list WHERE id_subscription = ?");
            ps.setInt(1, id_subscription);
            rs = ps.executeQuery();
            rs.next();
            priceList.setIdProgramm(rs.getInt("id_programm"));
            priceList.setTypeSubscription(rs.getString("type_subscription"));
            priceList.setDurationSubscription(rs.getString("duration_subscription"));
            priceList.setPrice(rs.getInt("price"));
        } catch (SQLException ex) {
            Logger.getLogger(PriceListDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return priceList;
    }

    @Override
    public void update(DBObject newObject) {
        PriceList newPriceList = (PriceList) newObject;
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("UPDATE price_list SET id_programm = ?, type_subscription = ?, duration_subscription = ?, price = ? WHERE id_subscription = ?");
            ps.setInt(1, newPriceList.getIdProgramm());
            ps.setString(2, newPriceList.getTypeSubscription());
            ps.setString(3, newPriceList.getDurationSubscription());
            ps.setInt(4, newPriceList.getPrice());
            ps.setInt(5, newObject.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PriceListDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, null);
        }
    }

    @Override
    public void delete(int id_subscription) {
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("DELETE FROM price_list WHERE id_subscription = ?");
            ps.setInt(1, id_subscription);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(PriceListDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(PriceListDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List getPriceListByIdProgramm(int id) {
        PriceList priceList = null;
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List priceLists = new ArrayList();
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT * FROM price_list WHERE id_programm = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                priceList = new PriceList(rs.getInt("id_subscription"));
                priceList.setIdProgramm(rs.getInt("id_programm"));
                priceList.setTypeSubscription(rs.getString("type_subscription"));
                priceList.setDurationSubscription(rs.getString("duration_subscription"));
                priceList.setPrice(rs.getInt("price"));
                priceLists.add(priceList);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PriceListDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return priceLists;
    }

}
