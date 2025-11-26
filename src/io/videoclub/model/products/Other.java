package io.videoclub.model.products;

import io.videoclub.model.interfaces.AProduct;

public class Other extends AProduct {

    public Other(){
        super(Other.class);
    }

    public Other(final String name, final String description, final double prize, final Status status){
        this();
        this.name = name;
        this.description = description;
        this.prize = prize;
        this.status = status;
    }

    @Override
    public Object clone() {
        return new Other(this.name, this.description, this.prize, this.status);
    }

    @Override
    public String toString() {
        return "Other{" +
                "name=" + this.name +
                ", description=" + this.description +
                ", prize=" + this.prize +
                ", status=" + this.status +
                "} ";
    }

}
