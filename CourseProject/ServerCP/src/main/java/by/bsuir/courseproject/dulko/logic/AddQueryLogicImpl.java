/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.courseproject.dulko.logic;

import by.bsuir.courseproject.dulko.database.DAO.QueryDAO;
import by.bsuir.courseproject.dulko.database.DAO.QueryDAOImpl;
import by.bsuir.courseproject.dulko.database.model.Query;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Евгения
 */
public class AddQueryLogicImpl implements AddQueryLogic {

    @Override
    public List getAllQuerys(String status) {
        QueryDAO sdao = new QueryDAOImpl();
        return sdao.getQuerys(status);
    }

    @Override
    public synchronized void saveQuery(Query query) {
        QueryDAO bdao = new QueryDAOImpl();
        if (query.getId() == 0) {
            Logger.getLogger(AddQueryLogicImpl.class.getName()).log(Level.SEVERE, "", query.toString());
            bdao.create(query);
        } else {
            Logger.getLogger(AddQueryLogicImpl.class.getName()).log(Level.SEVERE, "Обновление данных о запросах");
            bdao.update(query);
        }
    }

    @Override
    public List getQuerysByClientProgrammSubscription(int idC, int idP, int idS, String status) {
        QueryDAO sdao = new QueryDAOImpl();
        return sdao.getQuerysByClientProgramSubscription(idC, idP, idS, status);
    }

    @Override
    public void deleteQuery(Query query) {
        QueryDAO qdao = new QueryDAOImpl();
        qdao.delete(query.getId());
    }

    @Override
    public List getQuerysByClient(int id) {
        QueryDAO sdao = new QueryDAOImpl();
        return sdao.getQuerysByIdClient(id);
    }

    @Override
    public List getQuerysByClientProgrammSubscription(int idC, int idP, int idS) {
        QueryDAO sdao = new QueryDAOImpl();
        return sdao.getQuerysByClientProgramSubscription(idC, idP, idS);
    }

}
