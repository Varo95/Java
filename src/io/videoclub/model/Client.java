package io.videoclub.model;

import io.videoclub.model.interfaces.IClient;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Client implements IClient {
    private final String id;
    private String name;
    private String phone;
    private LocalDateTime time;

    public Client() {
        this.id = this.generateId();
    }

    public String generateId() {
        return UUID.randomUUID().toString().subSequence(0, 16).toString();
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String n) {
        this.name = n;
    }

    @Override
    public LocalDateTime getTime() {
        return this.time;
    }

    @Override
    public void setTime(final LocalDateTime t) {
        this.time = t;
    }

    @Override
    public String getPhone() {
        return this.phone;
    }

    @Override
    public void setPhone(String p) {
        this.phone = p;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && Objects.equals(this.id, ((Client) obj).id);
    }

    @Override
    public String toString() {
        return "Client{" +
                "name=" + name +
                ", phone=" + phone +
                '}';
    }

    @Override
    public int compareTo(final IClient o) {
        return this.getName().compareTo(o.getName());
    }

}
