/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.courseproject.dulko.logic;

import by.bsuir.courseproject.dulko.database.DAO.DiscountDAO;
import by.bsuir.courseproject.dulko.database.DAO.DiscountDAOImpl;
import by.bsuir.courseproject.dulko.database.model.Discount;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Евгения
 */
public class AddDiscountLogicImpl implements AddDiscountLogic {

    @Override
    public List getAllDiscounts() {
        DiscountDAO sdao = new DiscountDAOImpl();
        return sdao.getDiscounts();
    }

    @Override
    public synchronized void saveDiscount(Discount discount) {
        DiscountDAO bdao = new DiscountDAOImpl();
        if (discount.getId() == 0) {
            Logger.getLogger(AddDiscountLogicImpl.class.getName()).log(Level.SEVERE, "\u0421\u043e\u0445\u0440\u0430\u043d\u0435\u043d\u0438\u0435 \u043d\u043e\u0432\u043e\u0433\u043e \u0442\u043e\u0432\u0430\u0440\u0430{0}", discount.toString());
            bdao.create(discount);
        } else {
            Logger.getLogger(AddDiscountLogicImpl.class.getName()).log(Level.SEVERE, "Обновление данных о скидках");
            bdao.update(discount);
        }
    }

}
