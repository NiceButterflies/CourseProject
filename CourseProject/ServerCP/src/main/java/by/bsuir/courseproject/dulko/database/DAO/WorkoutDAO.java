/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.courseproject.dulko.database.DAO;

import by.bsuir.courseproject.dulko.database.model.Schedule;
import java.util.List;

/**
 *
 * @author Евгения
 */
public interface WorkoutDAO extends DAO {

    public List getWorkouts();

    public List getWorkoutsByIdClient(int id);

    public List getWorkoutsByIdProgramm(int id);

    public List getWorkoutsByIdSudscription(int id);

    public List getWorkoutsByIdSchedule(int id);

    public int getCongestionTrainers(Schedule schedule);
    
    public List getWorkoutsByIdScheduleByIdClient(int idP, int idC);
}
