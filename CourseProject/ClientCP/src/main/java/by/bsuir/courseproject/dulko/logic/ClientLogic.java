/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.courseproject.dulko.logic;

import by.bsuir.courseproject.dulko.database.model.Client;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Евгения
 */
public interface ClientLogic extends Serializable {

    public String getSurname(int id);

    public String getName(int id);

    public String getLastname(int id);

    public List getAllClients();

    public Client getClientWhereLogin(String login);

    public void deleteClient(Client client);
}
