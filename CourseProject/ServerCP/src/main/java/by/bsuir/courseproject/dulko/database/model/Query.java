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
public class Query extends DBObject implements Serializable {

    private int idClient;
    private int idProgramm;
    private int idSubscription;
    private int idSchedule;
    private String status;

    public Query() {
    }

    public Query(int id) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + this.getId();
        hash = 43 * hash + this.idClient;
        hash = 43 * hash + this.idProgramm;
        hash = 43 * hash + this.idSubscription;
        hash = 43 * hash + this.idSchedule;
        hash = 43 * hash + Objects.hashCode(this.status);
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
        final Query other = (Query) obj;
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
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Query{" + "id=" + getId() + ", idClient=" + idClient + ", idProgramm=" + idProgramm + ", idSubscription=" + idSubscription + ", idSchedule=" + idSchedule + ", status=" + status + '}';
    }

}
