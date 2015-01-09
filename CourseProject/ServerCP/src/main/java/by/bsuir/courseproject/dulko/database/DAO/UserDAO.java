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
public interface UserDAO extends DAO {

    public List getUsers();

    public DBObject getUserByLogin(String name);

    public boolean chekPassword(String password);
}
