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

/**
 *
 * @author Евгения
 */
public class ScheduleLogicImpl implements ScheduleLogic {

    @Override
    public List getAllScheduls() {
        ScheduleDAO bdao = new ScheduleDAOImpl();
        return bdao.getScheduls();
    }

    @Override
    public void deleteSchedule(Schedule schedule) {
        ScheduleDAO bdao = new ScheduleDAOImpl();
        bdao.delete(schedule.getId());
    }

    @Override
    public String getWeekday(int id) {
        ScheduleDAO sdao = new ScheduleDAOImpl();
        Schedule schedule = (Schedule) sdao.getSchedule(id);
        return schedule.getWeekday();
    }

    @Override
    public String getTime(int id) {
        ScheduleDAO sdao = new ScheduleDAOImpl();
        Schedule schedule = (Schedule) sdao.getSchedule(id);
        return schedule.getTime();
    }

    @Override
    public int getIdInstructor(int id) {
        ScheduleDAO sdao = new ScheduleDAOImpl();
        Schedule schedule = (Schedule) sdao.getSchedule(id);
        return schedule.getIdInstructor();
    }

    @Override
    public List getScheduleByIdProgramm(int id) {
        ScheduleDAO bdao = new ScheduleDAOImpl();
        return bdao.getScheduleByIdProgramm(id);
    }

    @Override
    public Schedule getSchedule(int id) {
        ScheduleDAO bdao = new ScheduleDAOImpl();
        return bdao.getSchedule(id);
    }

}
