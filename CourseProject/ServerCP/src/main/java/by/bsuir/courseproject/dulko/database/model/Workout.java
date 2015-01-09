/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.courseproject.dulko.database.model;

import java.io.Serializable;

/**
 *
 * @author Евгения
 */
public class Workout extends DBObject implements Serializable {

    private int idClient;
    private int idProgramm;
    private int idSubscription;
    private int idSchedule;

    public Workout() {
    }

    public Workout(int id) {
        this.setId(id);
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdProgramm() {
        return idProgramm;
    }

    public void setIdProgramm(int idProgramm) {
        this.idProgramm = idProgramm;
    }

    public int getIdSubscription() {
        return idSubscription;
    }

    public void setIdSubscription(int idSubscription) {
        this.idSubscription = idSubscription;
    }

    public int getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(int idSchedule) {
        this.idSchedule = idSchedule;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.getId();
        hash = 59 * hash + this.idClient;
        hash = 59 * hash + this.idProgramm;
        hash = 59 * hash + this.idSubscription;
        hash = 59 * hash + this.idSchedule;
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
        final Workout other = (Workout) obj;
        if (this.getId() != other.getId()) {
            return false;
        }
        if (this.idClient != other.idClient) {
            return false;
        }
        if (this.idProgramm != other.idProgramm) {
            return false;
        }
        if (this.idSubscription != other.idSubscription) {
            return false;
        }
        if (this.idSchedule != other.idSchedule) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Workout{" + "id=" + getId() + ", idClient=" + idClient + ", idProgramm=" + idProgramm + ", idSubscription=" + idSubscription + ", idSchedule=" + idSchedule + '}';
    }
}
