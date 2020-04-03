/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.VideoClub.Model;

import io.VideoClub.Model.Enums.ProductsTypes;
import io.VideoClub.Model.Enums.GameCategory;
import java.util.Objects;

/**
 *
 * @author ANDREA
 */
public class Game extends Product implements Cloneable, Comparable<Item>{

 
    private GameCategory category;
    private int minAge;

    public Game(String name, String description, double prize, Status status, GameCategory category) {
        super(name, description, prize, status, ProductsTypes.Juegos);
        this.category = category;
    }

    public Game(GameCategory category, int minAge, String name, String description, double prize, Status status, ProductsTypes type) {
        super(name, description, prize, status, type);
        this.category = category;
        this.minAge = minAge;
    }

    public Game(GameCategory category, String key, Status status, ProductsTypes type, String name, String description, double prize, int minAge) {
        super(key, status, type, name, description, prize);
        this.category = category;
        this.minAge = minAge;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public GameCategory getCategory() {
        return category;
    }

    public void setCategory(GameCategory category) {
        this.category = category;
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
        return "Game{" + "category=" + category + ", minAge=" + minAge + '}';
    }



    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Game other = (Game) obj;
        if (this.minAge != other.minAge) {
            return false;
        }
        if (!Objects.equals(this.category, other.category)) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

     @Override
    public int compareTo(Item o) {

        if (o == this) {
            return 0;
        }
        if (o instanceof Movie) {
            return ((Movie) o).getKey().compareTo(this.getKey());
        }
        return -1;
    }
}
