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
public class ClientLogicImpl implements ClientLogic {

    @Override
    public List getAllClients() {
        ClientDAO bdao = new ClientDAOImpl();
        return bdao.getClients();
    }

    @Override
    public void deleteClient(Client client) {
        ClientDAO bdao = new ClientDAOImpl();
        bdao.delete(client.getId());
    }

    @Override
    public Client getClientWhereLogin(String login) {
        ClientDAO bdao = new ClientDAOImpl();
        return bdao.getClientWhereLogin(login);
    }

    @Override
    public String getSurname(int id) {
        ClientDAO sdao = new ClientDAOImpl();
        Client client = (Client) sdao.read(id);
        Logger.getLogger(ClientLogicImpl.class.getName()).log(Level.SEVERE, "\u041e\u0442\u043f\u0440\u0430\u0432\u043a\u0430 \u0438\u043c\u0435\u043d\u0438 \u043f\u0440\u043e\u0434\u0430\u0432\u0446\u0430{0}");
        return client.getSurname();
    }

    @Override
    public String getName(int id) {
        ClientDAO sdao = new ClientDAOImpl();
        Client client = (Client) sdao.read(id);
        Logger.getLogger(AddClientLogicImpl.class.getName()).log(Level.SEVERE, "\u041e\u0442\u043f\u0440\u0430\u0432\u043a\u0430 \u0438\u043c\u0435\u043d\u0438 \u043f\u0440\u043e\u0434\u0430\u0432\u0446\u0430{0}");
        return client.getName();
    }

    @Override
    public String getLastname(int id) {
        ClientDAO sdao = new ClientDAOImpl();
        Client client = (Client) sdao.read(id);
        Logger.getLogger(AddClientLogicImpl.class.getName()).log(Level.SEVERE, "\u041e\u0442\u043f\u0440\u0430\u0432\u043a\u0430 \u0438\u043c\u0435\u043d\u0438 \u043f\u0440\u043e\u0434\u0430\u0432\u0446\u0430{0}");
        return client.getLastname();
    }
}
