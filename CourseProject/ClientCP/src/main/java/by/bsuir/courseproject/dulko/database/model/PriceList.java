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
public class PriceList extends DBObject implements Serializable {

    private int idProgramm;
    private String typeSubscription;
    private String durationSubscription;
    private int price;

    public PriceList() {
    }

    public PriceList(int id) {
        this.setId(id);
    }

    public int getIdProgramm() {
        return idProgramm;
    }

    public void setIdProgramm(int idProgramm) {
        this.idProgramm = idProgramm;
    }

    public String getTypeSubscription() {
        return typeSubscription;
    }

    public void setTypeSubscription(String typeSubscription) {
        this.typeSubscription = typeSubscription;
    }

    public String getDurationSubscription() {
        return durationSubscription;
    }

    public void setDurationSubscription(String durationSubscription) {
        this.durationSubscription = durationSubscription;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.getId();
        hash = 79 * hash + this.idProgramm;
        hash = 79 * hash + Objects.hashCode(this.typeSubscription);
        hash = 79 * hash + Objects.hashCode(this.durationSubscription);
        hash = 79 * hash + this.price;
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
        final PriceList other = (PriceList) obj;
        if (this.getId() != other.getId()) {
            return false;
        }
        if (this.idProgramm != other.idProgramm) {
            return false;
        }
        if (!Objects.equals(this.typeSubscription, other.typeSubscription)) {
            return false;
        }
        if (!Objects.equals(this.durationSubscription, other.durationSubscription)) {
            return false;
        }
        if (this.price != other.price) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PriceList{" + "id=" + getId() + ", nameSubscription=" + idProgramm + ", typeSubscription=" + typeSubscription + ", durationSubscription=" + durationSubscription + ", price=" + price + '}';
    }

}
