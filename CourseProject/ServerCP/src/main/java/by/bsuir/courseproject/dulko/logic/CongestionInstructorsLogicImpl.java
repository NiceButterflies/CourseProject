/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.courseproject.dulko.logic;

import by.bsuir.courseproject.dulko.database.DAO.WorkoutDAO;
import by.bsuir.courseproject.dulko.database.DAO.WorkoutDAOImpl;
import by.bsuir.courseproject.dulko.database.model.Schedule;

/**
 *
 * @author Евгения
 */
public class CongestionInstructorsLogicImpl implements CongestionInstructorsLogic {

    @Override
    public int getCongestionInstructors(Schedule schedule) {
        WorkoutDAO sdao = new WorkoutDAOImpl();
        return sdao.getCongestionTrainers(schedule);
    }

}
