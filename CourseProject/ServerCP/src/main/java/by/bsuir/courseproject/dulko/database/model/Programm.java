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
public class Programm extends DBObject implements Serializable {

    private String nameProgramm;

    public Programm() {
    }

    public Programm(int id) {
        this.setId(id);
    }

    public String getNameProgramm() {
        return nameProgramm;
    }

    public void setNameProgramm(String nameProgramm) {
        this.nameProgramm = nameProgramm;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.getId();
        hash = 29 * hash + Objects.hashCode(this.nameProgramm);
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
        final Programm other = (Programm) obj;
        if (this.getId() != other.getId()) {
            return false;
        }
        if (!Objects.equals(this.nameProgramm, other.nameProgramm)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Programm{" + "id=" + getId() + ", nameProgramm=" + nameProgramm + '}';
    }
}
