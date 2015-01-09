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
public interface AddScheduleLogic extends Serializable {

    public List getAllScheduls();

    public void saveSchedule(Schedule schedule);
}
