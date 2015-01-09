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
public class AddProgrammLogicImpl implements AddProgrammLogic {

    @Override
    public List getAllProgramms() {
        ProgrammDAO sdao = new ProgrammDAOImpl();
        return sdao.getProgramms();
    }

    @Override
    public void saveProgramm(Programm programm) {
        ProgrammDAO bdao = new ProgrammDAOImpl();
        if (programm.getId() == 0) {
            Logger.getLogger(AddProgrammLogicImpl.class.getName()).log(Level.SEVERE, "\u0421\u043e\u0445\u0440\u0430\u043d\u0435\u043d\u0438\u0435 \u043d\u043e\u0432\u043e\u0433\u043e \u0442\u043e\u0432\u0430\u0440\u0430{0}", programm.toString());
            bdao.create(programm);
        } else {
            Logger.getLogger(AddProgrammLogicImpl.class.getName()).log(Level.SEVERE, "Обновление данных о скидках");
            bdao.update(programm);
        }
    }

}
