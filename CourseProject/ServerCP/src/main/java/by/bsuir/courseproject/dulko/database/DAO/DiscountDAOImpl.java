/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.courseproject.dulko.database.DAO;

import by.bsuir.courseproject.dulko.database.DBConnection;
import by.bsuir.courseproject.dulko.database.model.Discount;
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
public class DiscountDAOImpl implements DiscountDAO {

    @Override
    public List getDiscounts() {
        Discount discount = null;
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List discounts = new ArrayList();
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT * FROM discount");
            rs = ps.executeQuery();
            while (rs.next()) {
                discount = new Discount(rs.getInt("id_discount"));
                discount.setClientCategory(rs.getString("client_category"));
                discount.setNumDiscount(rs.getInt("num_discount"));
                discounts.add(discount);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DiscountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return discounts;
    }

    @Override
    public int create(DBObject object) {
        Discount discount = (Discount) object;
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("INSERT INTO discount (client_category, num_discount) VALUES (?,?)");
            ps.setString(1, discount.getClientCategory());
            ps.setInt(2, discount.getNumDiscount());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DiscountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, null);
        }
        return 0;
    }

    @Override
    public DBObject read(int id_discount) {
        Discount discount = new Discount(id_discount);
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT client_category, num_discount FROM discount WHERE id_discount = ?");
            ps.setInt(1, id_discount);
            rs = ps.executeQuery();
            rs.next();
            discount.setClientCategory(rs.getString("client_category"));
            discount.setNumDiscount(rs.getInt("num_discount"));
        } catch (SQLException ex) {
            Logger.getLogger(DiscountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return discount;
    }

    @Override
    public void update(DBObject newObject) {
        Discount newDiscount = (Discount) newObject;
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("UPDATE discount SET client_category = ?, num_discount = ? WHERE id_discount = ?");
            ps.setString(1, newDiscount.getClientCategory());
            ps.setInt(2, newDiscount.getNumDiscount());
            ps.setInt(3, newObject.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DiscountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, null);
        }
    }

    @Override
    public void delete(int id_discount) {
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("DELETE FROM discount WHERE id_discount = ?");
            ps.setInt(1, id_discount);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DiscountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(DiscountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public DBObject getDiscountByClientCategory(String name) {
        Discount discount = null;
        Connection connection = null;
        DBConnection dbcp = DBConnection.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT id_discount, client_category FROM discount WHERE client_category = ?");
            ps.setString(1, name);
            rs = ps.executeQuery();
            rs.next();
            discount = new Discount(rs.getInt("id_discount"));
            discount.setClientCategory(rs.getString("client_category"));
        } catch (SQLException ex) {
            Logger.getLogger(DiscountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return discount;
    }
}
