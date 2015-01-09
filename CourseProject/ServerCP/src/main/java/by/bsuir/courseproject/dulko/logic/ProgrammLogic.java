/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.courseproject.dulko.logic;

import by.bsuir.courseproject.dulko.database.model.Programm;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Евгения
 */
public interface ProgrammLogic extends Serializable {

    public String getNameProgramm(int id);

    public List getAllProgramms();

    public void deleteProgramm(Programm programm);

    public int getProgrammId(String name);
}
