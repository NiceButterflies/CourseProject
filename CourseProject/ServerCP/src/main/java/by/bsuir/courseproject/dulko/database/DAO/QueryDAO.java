/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.courseproject.dulko.database.DAO;

import java.util.List;

/**
 *
 * @author Евгения
 */
public interface QueryDAO extends DAO {

    public List getQuerys(String status);

    public List getQuerysByIdClient(int id);

    public List getQuerysByIdProgramm(int id);

    public List getQuerysByIdSudscription(int id);

    public List getQuerysByIdSchedule(int id);

    public List getQuerysByClientProgramSubscription(int idC, int idP, int idS, String status);
    
    public List getQuerysByClientProgramSubscription(int idC, int idP, int idS);

}
