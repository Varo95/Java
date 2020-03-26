/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.VideoClub.Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author ANDREA
 */
public class RepositorioProduct extends HashSet<Product> {
    private static RepositorioProduct instance;
    private RepositorioProduct(){};
    
    public static RepositorioProduct getInstance(){
        if(instance==null){
            instance=new RepositorioProduct();
        }
        return instance;
    
    }

    @Override
    public String toString() {
        String result= "-----REPOSITORIO-----\n";
        for(Product p:instance){
            result+="> "+p+"\n";
                    
        }
        return result;
    }
    
    public List<Product> filter(String regularEspression){
        List<Product> products=new ArrayList<>();
        return products;
        
    }
    
    public void save(){
        List<Product> l=new ArrayList<>();
        l.addAll(this);
        //XMLManager.writeList_into_XML(l, "games.XML");
    }
    
    public boolean load(){
        this.clear();
        return this.addAll(/*XMLManager.readXML_into_List(games.XML)*/);
    }
}
