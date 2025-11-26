package io.videoclub.model.interfaces;

import java.util.UUID;

public abstract class AProduct implements IStorage<AProduct>, Cloneable {
    public enum Status implements IEnum {
        AVAILABLE,
        RESERVED,
        REMOVED;
        @Override
        public String getDisplayName() {
            return this.name();
        }
    }
    public enum ProductsTypes implements IEnum {
        Films,
        Games,
        Other;

        @Override
        public String getDisplayName() {
            return this.name();
        }
    }
    protected final String id;
    protected String name;
    protected String description;
    protected double prize;
    protected Status status;
    protected ProductsTypes type;

    public AProduct(final String id, final Class<? extends AProduct> clazz) {
        this.id = id;
        switch (clazz.getSimpleName()) {
            case "Movie" -> this.type = ProductsTypes.Films;
            case "Game" -> this.type = ProductsTypes.Games;
            case "Other" -> this.type = ProductsTypes.Other;
            default -> throw new IllegalArgumentException("Unknown product type: " + clazz.getSimpleName());
        }
    }

    public AProduct(final Class<? extends AProduct> clazz) {
        this(UUID.randomUUID().toString().subSequence(0, 16).toString(), clazz);
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public double getPrize() {
        return this.prize;
    }

    public String getId() {
        return this.id;
    }

    public Status getStatus() {
        return this.status;
    }

    public ProductsTypes getType() {
        return this.type;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setPrize(final double prize) {
        this.prize = prize;
    }

    public void setStatus(final Status status) {
        this.status = status;
    }

    public void setType(final ProductsTypes type) {
        this.type = type;
    }

    public boolean setRemoved() {
        boolean removed = false;
        if (this.status != Status.RESERVED) {
            this.status = Status.REMOVED;
            removed = true;
        }
        return removed;
    }

    @Override
    public boolean equals(final Object o) {
        return o == this || o instanceof AProduct other && this.id.equals(other.id);
    }

    @Override
    public abstract Object clone();

    @Override
    public int compareTo(final AProduct o) {
        return this.getName().compareTo(o.getName());
    }
}
