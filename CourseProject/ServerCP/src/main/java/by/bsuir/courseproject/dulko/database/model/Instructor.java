/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.courseproject.dulko.database.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Евгения
 */
public class Instructor extends DBObject implements Serializable {

    private String surname;
    private String name;
    private String lastname;
    private String phoneNumber;
    private String instructorCategory;
    private String nameProgramm;

    public Instructor() {
    }

    public Instructor(int id) {
        this.setId(id);
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getInstructorCategory() {
        return instructorCategory;
    }

    public void setInstructorCategory(String instructorCategory) {
        this.instructorCategory = instructorCategory;
    }

    public String getNameProgramm() {
        return nameProgramm;
    }

    public void setNameProgramm(String nameProgramm) {
        this.nameProgramm = nameProgramm;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.getId();
        hash = 23 * hash + Objects.hashCode(this.surname);
        hash = 23 * hash + Objects.hashCode(this.name);
        hash = 23 * hash + Objects.hashCode(this.lastname);
        hash = 23 * hash + Objects.hashCode(this.phoneNumber);
        hash = 23 * hash + Objects.hashCode(this.instructorCategory);
        hash = 23 * hash + Objects.hashCode(this.nameProgramm);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Instructor other = (Instructor) obj;
        if (this.getId() != other.getId()) {
            return false;
        }
        if (!Objects.equals(this.surname, other.surname)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.lastname, other.lastname)) {
            return false;
        }
        if (!Objects.equals(this.phoneNumber, other.phoneNumber)) {
            return false;
        }
        if (!Objects.equals(this.instructorCategory, other.instructorCategory)) {
            return false;
        }
        if (!Objects.equals(this.nameProgramm, other.nameProgramm)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Instructor{" + "id=" + getId() + ", surname=" + surname + ", name=" + name + ", lastname=" + lastname + ", phoneNumber=" + phoneNumber + ", instructorCategory=" + instructorCategory + ", nameProgramm=" + nameProgramm + '}';
    }

}
