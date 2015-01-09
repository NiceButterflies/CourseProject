/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.courseproject.dulko.logic;

import by.bsuir.courseproject.dulko.database.model.Schedule;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Евгения
 */
public interface ScheduleLogic extends Serializable {

    public String getWeekday(int id);

    public String getTime(int id);

    public int getIdInstructor(int id);

    public List getAllScheduls();

    public List getScheduleByIdProgramm(int id);

    public void deleteSchedule(Schedule schedule);

    public Schedule getSchedule(int id);

}
