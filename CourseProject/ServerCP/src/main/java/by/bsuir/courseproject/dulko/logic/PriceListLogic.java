/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.courseproject.dulko.logic;

import by.bsuir.courseproject.dulko.database.model.PriceList;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Евгения
 */
public interface PriceListLogic extends Serializable {

    public int getIdProgrammByIdSubscription(int id);

    public List getAllPriceLists();

    public void deletePriceList(PriceList priceList);

    public List getSubscriptionByIdProgramm(int id);

    public PriceList getPriceList(int id);

}
