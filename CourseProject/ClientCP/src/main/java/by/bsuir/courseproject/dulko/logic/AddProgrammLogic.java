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
public interface AddProgrammLogic extends Serializable {

    public List getAllProgramms();

    public void saveProgramm(Programm programm);

}
