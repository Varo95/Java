package io.videoclub.model.products;

import io.videoclub.model.interfaces.AProduct;
import io.videoclub.model.interfaces.IEnum;

public class Game extends AProduct {

    public enum GameCategory implements IEnum {
        Adventures,
        Cars,
        Shooter;

        @Override
        public String getDisplayName() {
            return this.name();
        }
    }

    private GameCategory category;
    private int minAge;

    public Game(){
        super(Game.class);
    }

    public Game(final String name, final String description, final double prize, final Status status, final GameCategory category, final int minAge) {
        this();
        this.name = name;
        this.description = description;
        this.prize = prize;
        this.status = status;
        this.category = category;
        this.minAge = minAge;
    }

    public GameCategory getCategory() {
        return this.category;
    }

    public int getMinAge() {
        return this.minAge;
    }

    public void setCategory(final GameCategory category) {
        this.category = category;
    }

    public void setMinAge(final int minAge) {
        this.minAge = minAge;
    }

    @Override
    public Object clone() {
        return new Game(this.name, this.description, this.prize, this.status, this.category, this.minAge);
    }

    @Override
    public String toString() {
        return "Game{" +
                "name=" + this.name +
                ", description=" + this.description +
                ", prize=" + this.prize +
                ", status=" + this.status +
                ", minAge=" + this.minAge +
                ", category=" + this.category +
                "} ";
    }
}