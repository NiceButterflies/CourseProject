/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.courseproject.dulko.logic;

import by.bsuir.courseproject.dulko.database.model.DBObject;
import by.bsuir.courseproject.dulko.database.model.Instructor;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Евгения
 */
public interface InstructorLogic extends Serializable {

    public String getSurname(int id);

    public List getAllInstructors();

    public void deleteInstructor(Instructor instructor);

    public int getInstructorId(String name);

    public DBObject getInstructorById(int id);
}
