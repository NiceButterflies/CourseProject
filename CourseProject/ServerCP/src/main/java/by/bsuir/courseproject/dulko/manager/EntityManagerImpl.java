/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.courseproject.dulko.manager;

//import by.bsuir.courseproject.server.logic.AddLogic;
//import by.bsuir.courseproject.server.logic.AddLogicImpl;
import by.bsuir.courseproject.dulko.logic.AddClientLogic;
import by.bsuir.courseproject.dulko.logic.AddClientLogicImpl;
import by.bsuir.courseproject.dulko.logic.AddDiscountLogic;
import by.bsuir.courseproject.dulko.logic.AddDiscountLogicImpl;
import by.bsuir.courseproject.dulko.logic.AddInstructorLogic;
import by.bsuir.courseproject.dulko.logic.AddInstructorLogicImpl;
import by.bsuir.courseproject.dulko.logic.AddPriceListLogic;
import by.bsuir.courseproject.dulko.logic.AddPriceListLogicImpl;
import by.bsuir.courseproject.dulko.logic.AddProgrammLogic;
import by.bsuir.courseproject.dulko.logic.AddProgrammLogicImpl;
import by.bsuir.courseproject.dulko.logic.AddQueryLogic;
import by.bsuir.courseproject.dulko.logic.AddQueryLogicImpl;
import by.bsuir.courseproject.dulko.logic.AddScheduleLogic;
import by.bsuir.courseproject.dulko.logic.AddScheduleLogicImpl;
import by.bsuir.courseproject.dulko.logic.ChangeUserLogic;
import by.bsuir.courseproject.dulko.logic.ChangeUserLogicImpl;
import by.bsuir.courseproject.dulko.logic.ClientLogic;
import by.bsuir.courseproject.dulko.logic.ClientLogicImpl;
import by.bsuir.courseproject.dulko.logic.CongestionInstructorsLogic;
import by.bsuir.courseproject.dulko.logic.CongestionInstructorsLogicImpl;
import by.bsuir.courseproject.dulko.logic.LoginLogic;
import by.bsuir.courseproject.dulko.logic.LoginLogicImpl;
import by.bsuir.courseproject.dulko.logic.DiscountLogic;
import by.bsuir.courseproject.dulko.logic.DiscountLogicImpl;
import by.bsuir.courseproject.dulko.logic.InstructorLogic;
import by.bsuir.courseproject.dulko.logic.InstructorLogicImpl;
import by.bsuir.courseproject.dulko.logic.PriceListLogic;
import by.bsuir.courseproject.dulko.logic.PriceListLogicImpl;
import by.bsuir.courseproject.dulko.logic.ProgrammLogic;
import by.bsuir.courseproject.dulko.logic.ProgrammLogicImpl;
import by.bsuir.courseproject.dulko.logic.ScheduleLogic;
import by.bsuir.courseproject.dulko.logic.ScheduleLogicImpl;
import by.bsuir.courseproject.dulko.logic.UserLogic;
import by.bsuir.courseproject.dulko.logic.UserLogicImpl;
import by.bsuir.courseproject.dulko.logic.WorkoutLogic;
import by.bsuir.courseproject.dulko.logic.WorkoutLogicImpl;
import java.rmi.RemoteException;

/**
 *
 * @author Евгения
 */
public class EntityManagerImpl implements EntityManager {

    @Override
    public synchronized LoginLogic getLoginManager() throws RemoteException {
        return new LoginLogicImpl();
    }

    @Override
    public synchronized DiscountLogic getDiscountManager() throws RemoteException {
        return new DiscountLogicImpl();
    }

    @Override
    public AddDiscountLogic getAddDiscountManager() throws RemoteException {
        return new AddDiscountLogicImpl();
    }

    @Override
    public PriceListLogic getPriceListManager() {
        return new PriceListLogicImpl();
    }

    @Override
    public AddPriceListLogic getAddPriceListManager() {
        return new AddPriceListLogicImpl();
    }

    @Override
    public ClientLogic getClientManager() throws RemoteException {
        return new ClientLogicImpl();
    }

    @Override
    public AddClientLogic getAddClientManager() throws RemoteException {
        return new AddClientLogicImpl();
    }

    @Override
    public InstructorLogic getInstructorManager() throws RemoteException {
        return new InstructorLogicImpl();
    }

    @Override
    public AddInstructorLogic getAddInstructorManager() throws RemoteException {
        return new AddInstructorLogicImpl();
    }

    @Override
    public ScheduleLogic getScheduleManager() throws RemoteException {
        return new ScheduleLogicImpl();
    }

    @Override
    public AddScheduleLogic getAddScheduleManager() throws RemoteException {
        return new AddScheduleLogicImpl();
    }

    @Override
    public UserLogic getUserManager() throws RemoteException {
        return new UserLogicImpl();
    }

    @Override
    public ChangeUserLogic getChangeUserManager() throws RemoteException {
        return new ChangeUserLogicImpl();
    }

    @Override
    public ProgrammLogic getProgrammManager() throws RemoteException {
        return new ProgrammLogicImpl();
    }

    @Override
    public AddProgrammLogic getAddProgrammManager() throws RemoteException {
        return new AddProgrammLogicImpl();
    }

    @Override
    public WorkoutLogic getWorkoutManager() throws RemoteException {
        return new WorkoutLogicImpl();
    }

    @Override
    public AddQueryLogic getAddQueryManager() throws RemoteException {
        return new AddQueryLogicImpl();
    }

    @Override
    public CongestionInstructorsLogic getCongestionInstructorsManager() throws RemoteException {
        return new CongestionInstructorsLogicImpl();
    }

}
