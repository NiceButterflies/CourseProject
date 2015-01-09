/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.courseproject.dulko.logic;

import by.bsuir.courseproject.dulko.database.DAO.ScheduleDAO;
import by.bsuir.courseproject.dulko.database.DAO.ScheduleDAOImpl;
import by.bsuir.courseproject.dulko.database.model.Schedule;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Евгения
 */
public class AddScheduleLogicImpl implements AddScheduleLogic {

    @Override
    public List getAllScheduls() {
        ScheduleDAO sdao = new ScheduleDAOImpl();
        return sdao.getScheduls();
    }

    @Override
    public void saveSchedule(Schedule schedule) {
        ScheduleDAO bdao = new ScheduleDAOImpl();
        if (schedule.getId() == 0) {
            Logger.getLogger(AddScheduleLogicImpl.class.getName()).log(Level.SEVERE, "\u0421\u043e\u0445\u0440\u0430\u043d\u0435\u043d\u0438\u0435 \u043d\u043e\u0432\u043e\u0433\u043e \u0442\u043e\u0432\u0430\u0440\u0430{0}", schedule.toString());
            bdao.create(schedule);
        } else {
            Logger.getLogger(AddScheduleLogicImpl.class.getName()).log(Level.SEVERE, "Обновление данных о скидках");
            bdao.update(schedule);
        }
    }

}
