/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.courseproject.dulko.database.DAO;

import by.bsuir.courseproject.dulko.database.model.DBObject;
import java.util.List;

/**
 *
 * @author Евгения
 */
public interface PriceListDAO extends DAO {

    public List getPriceList();

    public List getPriceListByIdProgramm(int id);
}
