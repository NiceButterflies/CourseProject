/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.courseproject.dulko.logic;

import by.bsuir.courseproject.dulko.database.DAO.InstructorDAO;
import by.bsuir.courseproject.dulko.database.DAO.InstructorDAOImpl;
import by.bsuir.courseproject.dulko.database.model.DBObject;
import by.bsuir.courseproject.dulko.database.model.Instructor;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Евгения
 */
public class InstructorLogicImpl implements InstructorLogic {

    @Override
    public List getAllInstructors() {
        InstructorDAO bdao = new InstructorDAOImpl();
        return bdao.getInstructors();
    }

    @Override
    public void deleteInstructor(Instructor instructor) {
        InstructorDAO bdao = new InstructorDAOImpl();
        bdao.delete(instructor.getId());
    }

    @Override
    public String getSurname(int id) {
        InstructorDAO sdao = new InstructorDAOImpl();
        Instructor instructor = (Instructor) sdao.read(id);
        Logger.getLogger(AddInstructorLogicImpl.class.getName()).log(Level.SEVERE, "\u041e\u0442\u043f\u0440\u0430\u0432\u043a\u0430 \u0438\u043c\u0435\u043d\u0438 \u043f\u0440\u043e\u0434\u0430\u0432\u0446\u0430{0}");
        return instructor.getSurname();
    }

    @Override
    public int getInstructorId(String name) {
        InstructorDAO sdao = new InstructorDAOImpl();
        Instructor seller = (Instructor) sdao.getInstructorBySurname(name);
        Logger.getLogger(AddInstructorLogicImpl.class.getName()).log(Level.SEVERE, "Отправка ID клиента");
        return seller.getId();
    }

    @Override
    public DBObject getInstructorById(int id) {
        InstructorDAO sdao = new InstructorDAOImpl();
        return sdao.read(id);
    }

}
