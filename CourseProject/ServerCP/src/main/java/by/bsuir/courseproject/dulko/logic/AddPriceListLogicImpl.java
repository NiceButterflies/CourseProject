/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.courseproject.dulko.logic;

import by.bsuir.courseproject.dulko.database.DAO.PriceListDAO;
import by.bsuir.courseproject.dulko.database.DAO.PriceListDAOImpl;
import by.bsuir.courseproject.dulko.database.model.PriceList;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Евгения
 */
public class AddPriceListLogicImpl implements AddPriceListLogic {

    @Override
    public List getAllPriceLists() {
        PriceListDAO sdao = new PriceListDAOImpl();
        return sdao.getPriceList();
    }

    @Override
    public synchronized void savePriceList(PriceList priceList) {
        PriceListDAO bdao = new PriceListDAOImpl();
        if (priceList.getId() == 0) {
            Logger.getLogger(AddPriceListLogicImpl.class.getName()).log(Level.SEVERE, "\u0421\u043e\u0445\u0440\u0430\u043d\u0435\u043d\u0438\u0435 \u043d\u043e\u0432\u043e\u0433\u043e \u0442\u043e\u0432\u0430\u0440\u0430{0}", priceList.toString());
            bdao.create(priceList);
        } else {
            Logger.getLogger(AddPriceListLogicImpl.class.getName()).log(Level.SEVERE, "Обновление данных об услугах");
            bdao.update(priceList);
        }
    }

}
