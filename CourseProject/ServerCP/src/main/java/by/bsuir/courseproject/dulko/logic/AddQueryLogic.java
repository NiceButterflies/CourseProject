/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.courseproject.dulko.logic;

import by.bsuir.courseproject.dulko.database.model.Query;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Евгения
 */
public interface AddQueryLogic extends Serializable {

    public List getAllQuerys(String status);

    public void saveQuery(Query query);

    public void deleteQuery(Query query);

    public List getQuerysByClientProgrammSubscription(int idC, int idP, int idS, String status);
    
    public List getQuerysByClientProgrammSubscription(int idC, int idP, int idS);
    
    public List getQuerysByClient(int id);
}
