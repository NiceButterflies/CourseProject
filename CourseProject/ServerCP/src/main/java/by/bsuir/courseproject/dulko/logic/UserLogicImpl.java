/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.courseproject.dulko.logic;

import by.bsuir.courseproject.dulko.database.DAO.UserDAO;
import by.bsuir.courseproject.dulko.database.DAO.UserDAOImpl;
import by.bsuir.courseproject.dulko.database.model.User;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Евгения
 */
public class UserLogicImpl implements UserLogic {

    @Override
    public List getAllUsers() {
        UserDAO bdao = new UserDAOImpl();
        return bdao.getUsers();
    }

    @Override
    public void deleteUser(User user) {
        UserDAO bdao = new UserDAOImpl();
        bdao.delete(user.getId());
    }

    @Override
    public String getLogin(int id) {
        UserDAO sdao = new UserDAOImpl();
        User user = (User) sdao.read(id);
        Logger.getLogger(ChangeUserLogicImpl.class.getName()).log(Level.SEVERE, "\u041e\u0442\u043f\u0440\u0430\u0432\u043a\u0430 \u0438\u043c\u0435\u043d\u0438 \u043f\u0440\u043e\u0434\u0430\u0432\u0446\u0430{0}");
        return user.getLogin();
    }

    @Override
    public int getUserId(String name) {
        UserDAO sdao = new UserDAOImpl();
        User seller = (User) sdao.getUserByLogin(name);
        Logger.getLogger(ChangeUserLogicImpl.class.getName()).log(Level.SEVERE, "Отправка ID продавца");
        return seller.getId();
    }

}
