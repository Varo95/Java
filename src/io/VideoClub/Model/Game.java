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
public class Game extends Product implements Cloneable {

    public Game() {
    }

    public Game(String name, String description, double prize) {
        super(name, description, prize);
    }
    
}
