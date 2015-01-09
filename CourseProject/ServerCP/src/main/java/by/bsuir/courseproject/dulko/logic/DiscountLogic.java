/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.courseproject.dulko.logic;

import by.bsuir.courseproject.dulko.database.model.Discount;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Евгения
 */
public interface DiscountLogic extends Serializable {

    public int getNumDiscount(int id);

    public String getClientCategory(int id);

    public List getAllDiscounts();

    public void deleteDiscount(Discount discount);

    public int getDiscountId(String name);
}
