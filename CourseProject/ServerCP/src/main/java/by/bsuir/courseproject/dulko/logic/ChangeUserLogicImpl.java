/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.courseproject.dulko.logic;

import by.bsuir.courseproject.dulko.database.DAO.UserDAO;
import by.bsuir.courseproject.dulko.database.DAO.UserDAOImpl;
import by.bsuir.courseproject.dulko.database.model.DBObject;
import by.bsuir.courseproject.dulko.database.model.User;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Евгения
 */
public class ChangeUserLogicImpl implements ChangeUserLogic {

    @Override
    public List getAllUsers() {
        UserDAO sdao = new UserDAOImpl();
        return sdao.getUsers();
    }

    @Override
    public void saveUser(User user) {
        UserDAO bdao = new UserDAOImpl();
        if (user.getId() == 0) {
            Logger.getLogger(ChangeUserLogicImpl.class.getName()).log(Level.SEVERE, "\u0421\u043e\u0445\u0440\u0430\u043d\u0435\u043d\u0438\u0435 \u043d\u043e\u0432\u043e\u0433\u043e \u0442\u043e\u0432\u0430\u0440\u0430{0}", user.toString());
            bdao.create(user);
        } else {
            Logger.getLogger(ChangeUserLogicImpl.class.getName()).log(Level.SEVERE, "Обновление данных о скидках");
            bdao.update(user);
        }
    }

    @Override
    public boolean chekPassword(String password) {

        UserDAO bdao = new UserDAOImpl();
        return bdao.chekPassword(password);
    }

}
