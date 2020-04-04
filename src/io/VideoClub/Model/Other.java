/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.VideoClub.Model;

import io.VideoClub.Model.Enums.ProductsTypes;

/**
 *
 * @author FRANCISCO MARTÍN
 */
public class Other extends Product implements Cloneable{

    public Other(String name, String description, double prize, Status status) {
        super(name, description, prize, status, ProductsTypes.Otros);
    }

    public Other(String key, Status status, ProductsTypes type, String name, String description, double prize) {
        super(key, status, type, name, description, prize);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public double getPrize() {
        return prize;
    }

    @Override
    public void setPrize(double prize) {
        this.prize = prize;
    }

    @Override
    public String toString() {
        return "Otros| " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if (o != null) {
            if (this == o) {
                result = true;
            } else {

                if (o instanceof Other) {
                    if (super.equals(o)) {
                        result = true;
                    }
                }

            }
        }

        return result;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public int compareTo(Product o) {

        if (o == this) {
            return 0;
        }
        if (o instanceof Other) {
            return ((Other) o).getKey().compareTo(this.getKey());
        }
        return -1;
    }
}
