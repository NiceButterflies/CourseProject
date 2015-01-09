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
public interface AddPriceListLogic extends Serializable {

    public List getAllPriceLists();

    public void savePriceList(PriceList priceList);

}
