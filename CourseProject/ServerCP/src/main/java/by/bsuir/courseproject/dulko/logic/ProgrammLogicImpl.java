/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.courseproject.dulko.logic;

import by.bsuir.courseproject.dulko.database.DAO.ProgrammDAO;
import by.bsuir.courseproject.dulko.database.DAO.ProgrammDAOImpl;
import by.bsuir.courseproject.dulko.database.model.Programm;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Евгения
 */
public class ProgrammLogicImpl implements ProgrammLogic {

    @Override
    public String getNameProgramm(int id) {
        ProgrammDAO sdao = new ProgrammDAOImpl();
        Programm programm = (Programm) sdao.read(id);
        Logger.getLogger(AddProgrammLogicImpl.class.getName()).log(Level.SEVERE, "\u041e\u0442\u043f\u0440\u0430\u0432\u043a\u0430 \u0438\u043c\u0435\u043d\u0438 \u043f\u0440\u043e\u0434\u0430\u0432\u0446\u0430{0}");
        return programm.getNameProgramm();
    }

    @Override
    public List getAllProgramms() {
        ProgrammDAO bdao = new ProgrammDAOImpl();
        return bdao.getProgramms();
    }

    @Override
    public void deleteProgramm(Programm programm) {
        ProgrammDAO bdao = new ProgrammDAOImpl();
        bdao.delete(programm.getId());
    }

    @Override
    public int getProgrammId(String name) {
        ProgrammDAO sdao = new ProgrammDAOImpl();
        Programm programm = (Programm) sdao.getProgrammByNameProgramm(name);
        Logger.getLogger(AddProgrammLogicImpl.class.getName()).log(Level.SEVERE, "Отправка ID клиента");
        return programm.getId();
    }

}
