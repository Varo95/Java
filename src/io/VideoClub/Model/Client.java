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
        this.ID = generateID();
        this.name = name;
        this.phone = phone;
        this.time = LocalDateTime.now();
    }

    public String generateID() {
        String UID = UUID.randomUUID().toString();
        return UID;
    }

    @Override
    public String getID() {
        return ID;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String n) {
        this.name = n;
    }

    @Override
    public LocalDateTime getTime() {
        return time;
    }

    @Override
    public void setTime(LocalDateTime t) {
        this.time = t;
    }

    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public void setPhone(String p) {
        this.phone = p;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else {
            if (obj == null) {
                return false;
            } else if (obj instanceof Client) {
                final Client other = (Client) obj;
                if (!Objects.equals(this.ID, other.ID)) {
                    return false;
                }
            }
        }

        return true;
    }

}
