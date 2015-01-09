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
public class Discount extends DBObject implements Serializable {

    private String clientCategory;
    private int numDiscount;

    public Discount() {
    }

    public Discount(int id) {
        this.setId(id);
    }

    public String getClientCategory() {
        return clientCategory;
    }

    public void setClientCategory(String clientCategory) {
        this.clientCategory = clientCategory;
    }

    public int getNumDiscount() {
        return numDiscount;
    }

    public void setNumDiscount(int numDiscount) {
        this.numDiscount = numDiscount;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.getId();
        hash = 59 * hash + Objects.hashCode(this.clientCategory);
        hash = 59 * hash + this.numDiscount;
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
        final Discount other = (Discount) obj;
        if (this.getId() != other.getId()) {
            return false;
        }
        if (!Objects.equals(this.clientCategory, other.clientCategory)) {
            return false;
        }
        if (this.numDiscount != other.numDiscount) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Discount{" + "id=" + getId() + ", clientCategory=" + clientCategory + ", numDiscount=" + numDiscount + '}';
    }

}
