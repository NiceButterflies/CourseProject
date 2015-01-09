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
public class Schedule extends DBObject implements Serializable {

    private String weekday;
    private String time;
    private int idProgramm;
    private int idInstructor;

    public Schedule() {
    }

    public Schedule(int id) {
        this.setId(id);
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getIdProgramm() {
        return idProgramm;
    }

    public void setIdProgramm(int idProgramm) {
        this.idProgramm = idProgramm;
    }

    public int getIdInstructor() {
        return idInstructor;
    }

    public void setIdInstructor(int idInstructor) {
        this.idInstructor = idInstructor;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.getId();
        hash = 61 * hash + Objects.hashCode(this.weekday);
        hash = 61 * hash + Objects.hashCode(this.time);
        hash = 61 * hash + this.idProgramm;
        hash = 61 * hash + this.idInstructor;
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
        final Schedule other = (Schedule) obj;
        if (this.getId() != other.getId()) {
            return false;
        }
        if (!Objects.equals(this.weekday, other.weekday)) {
            return false;
        }
        if (!Objects.equals(this.time, other.time)) {
            return false;
        }
        if (this.idProgramm != other.idProgramm) {
            return false;
        }
        if (this.idInstructor != other.idInstructor) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Schedule{" + "id=" + getId() + ", weekday=" + weekday + ", time=" + time + ", nameProgramm=" + idProgramm + ", idInstructor=" + idInstructor + '}';
    }

}
