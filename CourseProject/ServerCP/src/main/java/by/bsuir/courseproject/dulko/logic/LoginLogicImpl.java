/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.courseproject.dulko.logic;

import by.bsuir.courseproject.dulko.database.DAO.UserDAO;
import by.bsuir.courseproject.dulko.database.DAO.UserDAOImpl;
import by.bsuir.courseproject.dulko.database.model.User;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Евгения
 */
public class LoginLogicImpl implements LoginLogic {

    @Override
    public boolean login(String login, char[] pass) {
        UserDAO udao = new UserDAOImpl();
        User user = (User) udao.getUserByLogin(login);
        if (user != null) {
            String password = new String(pass);
            if (password.equals(user.getPass())) {
                Logger.getLogger("Аутификация пройдена пользователем: " + login);
                return true;
            }
        }
        Logger.getLogger(LoginLogicImpl.class.getName()).log(Level.SEVERE, "Аутификация не пройдена");
        return false;
    }

}
