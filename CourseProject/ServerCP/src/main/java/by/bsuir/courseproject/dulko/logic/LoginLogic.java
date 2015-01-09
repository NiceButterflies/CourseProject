/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.courseproject.dulko.logic;

import java.io.Serializable;

/**
 *
 * @author Евгения
 */
public interface LoginLogic extends Serializable {

    public boolean login(String login, char[] pass);
}
