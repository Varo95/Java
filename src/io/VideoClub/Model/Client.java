/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.VideoClub.Model;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 *
 * @author Alvaro
 */
public class Client implements IClient {

    private String ID;
    private String name;
    private String phone;
    private LocalDateTime time;

    public Client(String name, String phone) {
        this.name = name;
        this.phone = phone;
        this.ID = GenerateId();
        this.time = LocalDateTime.now();
    }

    public Client(String ID, String name, String phone, LocalDateTime time) {
        this.ID = ID;
        this.name = name;
        this.phone = phone;
        this.time = time;
    }

    private Client() {
    }

    public String GenerateId() {
        String IdResult = (String) UUID.randomUUID().toString().subSequence(0, 16);
        return IdResult;
    }

    @Override
    public String getID() {
        return this.ID;
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
    public void setTime(LocalDateTime t) {
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

    public void setRemoved() {
        this.ID = "DELETED";
        this.name = "DELETED";
        this.phone = "";
        this.time = LocalDateTime.MIN;
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
        final Client other = (Client) obj;
        if (!Objects.equals(this.ID, other.ID)) {
            return false;
        }
        return true;
    }

    public int compareTo(IClient o){
        return this.getID().compareTo(o.getID());
    }

    @Override
    public String toString() {
        return "iD=" + ID + " name=" + name + " phone=" + phone + " fecha de nacimiento=" + time.getYear() + "/" + time.getMonthValue() + "/" + time.getDayOfMonth();
    }

}
