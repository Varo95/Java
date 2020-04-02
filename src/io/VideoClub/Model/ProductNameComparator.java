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
public class ProductNameComparator implements Comparator<Product>{
      
    @Override
    public int compare(Product p1, Product p2) {
        return p1.getName().compareTo(p2.getName());
    }
}
