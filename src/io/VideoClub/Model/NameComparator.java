/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.VideoClub.Model;

import java.util.Comparator;

/**
 *
 * @author FRANCISCO MARTÍN
 */
public class NameComparator implements Comparator<Client> {
     
    @Override
    public int compare(Client o1, Client o2) {
        return o1.getName().compareTo(o2.getName());
    }
 
}
