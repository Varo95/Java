/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.VideoClub.Model;

import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author FRANCISCO MARTÍN
 */
public class Data {
        
    private static final Data INSTANCE = new Data();
    protected Set<Product> products;
    protected Set<IClient> clients;
    protected Set<Reservation> reservations;

    private Data() {
        this.clients = new TreeSet<>();
        this.products = new TreeSet<>();
        this.reservations = new TreeSet<>();
    }
    
    public static Data getInstance(){
        return Data.INSTANCE;
    }
    

    public Set<Product> getProducts() {
        return products;
    }

    public Set<IClient> getClients() {
        return clients;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }
    
}
