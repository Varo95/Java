/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.VideoClub.Model;

/**
 *
 * @author ANDREA
 */
public class Movie extends Product implements Cloneable {

    public Movie() {
    }

    public Movie(String name, String description, double prize) {
        super(name, description, prize);
    }
    
}
