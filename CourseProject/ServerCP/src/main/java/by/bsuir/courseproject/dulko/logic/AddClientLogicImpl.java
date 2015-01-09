/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.courseproject.dulko.logic;

import by.bsuir.courseproject.dulko.database.DAO.ClientDAO;
import by.bsuir.courseproject.dulko.database.DAO.ClientDAOImpl;
import by.bsuir.courseproject.dulko.database.model.Client;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Евгения
 */
public class AddClientLogicImpl implements AddClientLogic {

    @Override
    public List getAllClients() {
        ClientDAO sdao = new ClientDAOImpl();
        return sdao.getClients();
    }

    @Override
    public synchronized void saveClient(Client client) {
        ClientDAO bdao = new ClientDAOImpl();
        if (client.getId() == 0) {
            Logger.getLogger(AddClientLogicImpl.class.getName()).log(Level.SEVERE, "\u0421\u043e\u0445\u0440\u0430\u043d\u0435\u043d\u0438\u0435 \u043d\u043e\u0432\u043e\u0433\u043e \u0442\u043e\u0432\u0430\u0440\u0430{0}", client.toString());
            bdao.create(client);
        } else {
            Logger.getLogger(AddClientLogicImpl.class.getName()).log(Level.SEVERE, "Обновление данных о клиентах");
            bdao.update(client);
        }
    }

    @Override
    public int getClientId(String name) {
        ClientDAO sdao = new ClientDAOImpl();
        Client seller = (Client) sdao.getClientBySurname(name);
        Logger.getLogger(AddClientLogicImpl.class.getName()).log(Level.SEVERE, "Отправка ID клиента");
        return seller.getId();
    }
}
