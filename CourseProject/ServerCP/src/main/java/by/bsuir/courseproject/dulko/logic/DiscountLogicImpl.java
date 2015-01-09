/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.courseproject.dulko.logic;

import by.bsuir.courseproject.dulko.database.DAO.DiscountDAO;
import by.bsuir.courseproject.dulko.database.DAO.DiscountDAOImpl;
import by.bsuir.courseproject.dulko.database.model.Discount;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Евгения
 */
public class DiscountLogicImpl implements DiscountLogic {

    @Override
    public String getClientCategory(int id) {
        DiscountDAO sdao = new DiscountDAOImpl();
        Discount discount = (Discount) sdao.read(id);
        Logger.getLogger(DiscountLogicImpl.class.getName()).log(Level.SEVERE, "\u041e\u0442\u043f\u0440\u0430\u0432\u043a\u0430 \u0438\u043c\u0435\u043d\u0438 \u043f\u0440\u043e\u0434\u0430\u0432\u0446\u0430{0}");
        return discount.getClientCategory();
    }

    @Override
    public List getAllDiscounts() {
        DiscountDAO bdao = new DiscountDAOImpl();
        return bdao.getDiscounts();
    }

    @Override
    public void deleteDiscount(Discount discount) {
        DiscountDAO bdao = new DiscountDAOImpl();
        bdao.delete(discount.getId());
    }

    @Override
    public int getNumDiscount(int id) {
        DiscountDAO sdao = new DiscountDAOImpl();
        Discount discount = (Discount) sdao.read(id);
        Logger.getLogger(DiscountLogicImpl.class.getName()).log(Level.SEVERE, "\u041e\u0442\u043f\u0440\u0430\u0432\u043a\u0430 \u0438\u043c\u0435\u043d\u0438 \u043f\u0440\u043e\u0434\u0430\u0432\u0446\u0430{0}");
        return discount.getNumDiscount();
    }

    @Override
    public int getDiscountId(String name) {
        DiscountDAO sdao = new DiscountDAOImpl();
        Discount discount = (Discount) sdao.getDiscountByClientCategory(name);
        Logger.getLogger(AddDiscountLogicImpl.class.getName()).log(Level.SEVERE, "Отправка ID продавца");
        return discount.getId();
    }
}
