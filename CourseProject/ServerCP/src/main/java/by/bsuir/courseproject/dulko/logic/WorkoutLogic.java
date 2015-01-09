/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.courseproject.dulko.logic;

import by.bsuir.courseproject.dulko.database.model.Workout;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Евгения
 */
public interface WorkoutLogic extends Serializable {

    public int getIdClient(int id);

    public int getIdProgramm(int id);

    public int getIdSchedule(int id);

    public int getIdSubscription(int id);

    public List getAllWorkouts();

    public void deleteWorkout(Workout workout);

    public List getWorkoutsIdByClient(int id);

    public void saveWorkout(Workout workout);
    
    public List getWorkoutsIdByProgramm(int id);
    
    public List getWorkoutsIdByProgrammByIdClient(int idP, int idC);

//    
//    public List getWorkoutsIdBySubscription(int id);
}
