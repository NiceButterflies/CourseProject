/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.courseproject.dulko.database.DAO;

import by.bsuir.courseproject.dulko.database.model.DBObject;
import java.io.Serializable;

/**
 *
 * @author Евгения
 */
public interface DAO extends Serializable {

    public int create(DBObject object);

    public DBObject read(int id);

    public void update(DBObject newObject);

    public void delete(int id);

}
