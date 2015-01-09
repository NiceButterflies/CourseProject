/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.courseproject.dulko.logic;

import by.bsuir.courseproject.dulko.database.DAO.PriceListDAO;
import by.bsuir.courseproject.dulko.database.DAO.PriceListDAOImpl;
import by.bsuir.courseproject.dulko.database.model.PriceList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Евгения
 */
public class PriceListLogicImpl implements PriceListLogic {

    @Override
    public List getAllPriceLists() {
        PriceListDAO bdao = new PriceListDAOImpl();
        return bdao.getPriceList();
    }

    @Override
    public void deletePriceList(PriceList priceList) {
        PriceListDAO bdao = new PriceListDAOImpl();
        bdao.delete(priceList.getId());
    }

    @Override
    public List getSubscriptionByIdProgramm(int id) {
        PriceListDAO sdao = new PriceListDAOImpl();
        return sdao.getPriceListByIdProgramm(id);
    }

    @Override
    public int getIdProgrammByIdSubscription(int id) {
        PriceListDAO sdao = new PriceListDAOImpl();
        PriceList priceList = (PriceList) sdao.read(id);
        Logger.getLogger(AddPriceListLogicImpl.class.getName()).log(Level.SEVERE, "");
        return priceList.getIdProgramm();
    }

    @Override
    public PriceList getPriceList(int id) {
        PriceListDAO bdao = new PriceListDAOImpl();
        return (PriceList) bdao.read(id);
    }

}
