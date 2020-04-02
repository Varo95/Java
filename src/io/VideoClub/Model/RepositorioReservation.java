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
public class RepositorioReservation extends HashSet<Reservation> {
     private static RepositorioReservation instance;
    private RepositorioReservation(){};
    
    public static RepositorioReservation getInstance(){
        if(instance==null){
            instance=new RepositorioReservation();
        }
        return instance;
    
    }
     @Override
    public String toString() {
        String result= "-----REPOSITORIO-----\n";
        for(Reservation r:instance){
            result+="> "+r+"\n";
                    
        }
        return result;
    }
    
    public List<Reservation> filter(String regularEspression){
        List<Reservation> reservations=new ArrayList<>();
        return reservations;
        
    }
    
    public void save(){
        List<Reservation> l=new ArrayList<>();
        l.addAll(this);
        //XMLManager.writeList_into_XML(l, "games.XML");
    }
    
    public boolean load(){
        this.clear();
        return this.addAll(/*XMLManager.readXML_into_List(games.XML)*/);
    }
}
