/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.courseproject.dulko.manager;

//import by.bsuir.courseproject.server.logic.AddLogic;
import by.bsuir.courseproject.dulko.logic.AddClientLogic;
import by.bsuir.courseproject.dulko.logic.AddDiscountLogic;
import by.bsuir.courseproject.dulko.logic.AddInstructorLogic;
import by.bsuir.courseproject.dulko.logic.AddPriceListLogic;
import by.bsuir.courseproject.dulko.logic.AddProgrammLogic;
import by.bsuir.courseproject.dulko.logic.AddQueryLogic;
import by.bsuir.courseproject.dulko.logic.AddScheduleLogic;
import by.bsuir.courseproject.dulko.logic.ChangeUserLogic;
import by.bsuir.courseproject.dulko.logic.ClientLogic;
import by.bsuir.courseproject.dulko.logic.CongestionInstructorsLogic;
import by.bsuir.courseproject.dulko.logic.LoginLogic;
import by.bsuir.courseproject.dulko.logic.DiscountLogic;
import by.bsuir.courseproject.dulko.logic.InstructorLogic;
import by.bsuir.courseproject.dulko.logic.PriceListLogic;
import by.bsuir.courseproject.dulko.logic.ProgrammLogic;
import by.bsuir.courseproject.dulko.logic.ScheduleLogic;
import by.bsuir.courseproject.dulko.logic.UserLogic;
import by.bsuir.courseproject.dulko.logic.WorkoutLogic;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Евгения
 */
public interface EntityManager extends Remote {

    public LoginLogic getLoginManager() throws RemoteException;

    public DiscountLogic getDiscountManager() throws RemoteException;

    public AddDiscountLogic getAddDiscountManager() throws RemoteException;

    public PriceListLogic getPriceListManager() throws RemoteException;

    public AddPriceListLogic getAddPriceListManager() throws RemoteException;

    public ClientLogic getClientManager() throws RemoteException;

    public AddClientLogic getAddClientManager() throws RemoteException;

    public InstructorLogic getInstructorManager() throws RemoteException;

    public AddInstructorLogic getAddInstructorManager() throws RemoteException;

    public ScheduleLogic getScheduleManager() throws RemoteException;

    public AddScheduleLogic getAddScheduleManager() throws RemoteException;

    public UserLogic getUserManager() throws RemoteException;

    public ChangeUserLogic getChangeUserManager() throws RemoteException;

    public ProgrammLogic getProgrammManager() throws RemoteException;

    public AddProgrammLogic getAddProgrammManager() throws RemoteException;

    public WorkoutLogic getWorkoutManager() throws RemoteException;

    public AddQueryLogic getAddQueryManager() throws RemoteException;

    public CongestionInstructorsLogic getCongestionInstructorsManager() throws RemoteException;
}
