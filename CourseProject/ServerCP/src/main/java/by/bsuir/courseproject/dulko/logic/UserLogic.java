/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.courseproject.dulko.logic;

import by.bsuir.courseproject.dulko.database.model.User;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Евгения
 */
public interface UserLogic extends Serializable {

    public List getAllUsers();

    public String getLogin(int id);

    public void deleteUser(User user);

    public int getUserId(String name);

}
