/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.courseproject.dulko.logic;

import by.bsuir.courseproject.dulko.database.DAO.WorkoutDAO;
import by.bsuir.courseproject.dulko.database.DAO.WorkoutDAOImpl;
import by.bsuir.courseproject.dulko.database.model.Workout;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Евгения
 */
public class WorkoutLogicImpl implements WorkoutLogic {

    @Override
    public int getIdClient(int id) {
        WorkoutDAO sdao = new WorkoutDAOImpl();
        Workout workout = (Workout) sdao.read(id);
        Logger.getLogger(WorkoutLogicImpl.class.getName()).log(Level.SEVERE, "");
        return workout.getIdClient();
    }

    @Override
    public int getIdProgramm(int id) {
        WorkoutDAO sdao = new WorkoutDAOImpl();
        Workout workout = (Workout) sdao.read(id);
        Logger.getLogger(WorkoutLogicImpl.class.getName()).log(Level.SEVERE, "");
        return workout.getIdProgramm();
    }

    @Override
    public int getIdSchedule(int id) {
        WorkoutDAO sdao = new WorkoutDAOImpl();
        Workout workout = (Workout) sdao.read(id);
        Logger.getLogger(WorkoutLogicImpl.class.getName()).log(Level.SEVERE, "");
        return workout.getIdSchedule();
    }

    @Override
    public int getIdSubscription(int id) {
        WorkoutDAO sdao = new WorkoutDAOImpl();
        Workout workout = (Workout) sdao.read(id);
        Logger.getLogger(WorkoutLogicImpl.class.getName()).log(Level.SEVERE, "");
        return workout.getIdSubscription();
    }

    @Override
    public List getAllWorkouts() {
        WorkoutDAO bdao = new WorkoutDAOImpl();
        return bdao.getWorkouts();
    }

    @Override
    public void deleteWorkout(Workout workout) {
        WorkoutDAO bdao = new WorkoutDAOImpl();
        bdao.delete(workout.getId());
    }

    @Override
    public List getWorkoutsIdByClient(int id) {
        WorkoutDAO sdao = new WorkoutDAOImpl();
        Logger.getLogger(WorkoutLogicImpl.class.getName()).log(Level.SEVERE, "");
        return sdao.getWorkoutsByIdClient(id);
    }

    @Override
    public List getWorkoutsIdByProgramm(int id) {
        WorkoutDAO sdao = new WorkoutDAOImpl();
        Logger.getLogger(WorkoutLogicImpl.class.getName()).log(Level.SEVERE, "");
        return sdao.getWorkoutsByIdProgramm(id);
    }

    @Override
    public List getWorkoutsIdByProgrammByIdClient(int idP, int idC) {
        WorkoutDAO sdao = new WorkoutDAOImpl();
        Logger.getLogger(WorkoutLogicImpl.class.getName()).log(Level.SEVERE, "");
        return sdao.getWorkoutsByIdScheduleByIdClient(idP, idC);
    }
//
//    @Override
//    public List getWorkoutsIdBySubscription(int id) {
//        WorkoutDAO sdao = new WorkoutDAOImpl();
//        Logger.getLogger(WorkoutLogicImpl.class.getName()).log(Level.SEVERE, "");
//        return sdao.getWorkoutsByIdSudscription(id);
//    }

    @Override
    public void saveWorkout(Workout workout) {
        WorkoutDAO bdao = new WorkoutDAOImpl();
        if (workout.getId() == 0) {
            Logger.getLogger(WorkoutLogicImpl.class.getName()).log(Level.SEVERE, "\u0421\u043e\u0445\u0440\u0430\u043d\u0435\u043d\u0438\u0435 \u043d\u043e\u0432\u043e\u0433\u043e \u0442\u043e\u0432\u0430\u0440\u0430{0}", workout.toString());
            bdao.create(workout);
        } else {
            Logger.getLogger(WorkoutLogicImpl.class.getName()).log(Level.SEVERE, "Обновление данных о скидках");
            bdao.update(workout);
        }
    }

}
