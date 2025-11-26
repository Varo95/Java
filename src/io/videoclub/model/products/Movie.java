package io.videoclub.model.products;

import io.videoclub.model.interfaces.AProduct;
import io.videoclub.model.interfaces.IEnum;

public class Movie extends AProduct {

    public enum MovieCategory implements IEnum {
        Horror,
        Love,
        Action,
        SciFi;

        @Override
        public String getDisplayName() {
            return this.name();
        }
    }

    private MovieCategory category;
    private int minAge;

    public Movie(){
        super(Movie.class);
    }

    public Movie(final String name, final String description, final double prize, final Status status, final MovieCategory category, final int minAge) {
        this();
        this.name = name;
        this.description = description;
        this.prize = prize;
        this.status = status;
        this.category = category;
        this.minAge = minAge;
    }

    public MovieCategory getCategory() {
        return this.category;
    }

    public int getMinAge() {
        return this.minAge;
    }

    public void setCategory(final MovieCategory category) {
        this.category = category;
    }

    public void setMinAge(final int minAge) {
        this.minAge = minAge;
    }

    @Override
    public Object clone() {
        return new Movie(this.name, this.description, this.prize, this.status, this.category, this.minAge);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name=" + this.name +
                ", description=" + this.description +
                ", prize=" + this.prize +
                ", status=" + this.status +
                ", minAge=" + this.minAge +
                ", category=" + this.category +
                "} ";
    }
}
