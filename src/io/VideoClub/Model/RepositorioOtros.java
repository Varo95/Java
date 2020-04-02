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
public class RepositorioOtros extends HashSet<Other> {
    private static RepositorioOtros instance;
    private RepositorioOtros(){};
    
    public static RepositorioOtros getInstance(){
        if(instance==null){
            instance=new RepositorioOtros();
        }
        return instance;
    
    }

    @Override
    public String toString() {
        String result= "-----REPOSITORIO-----\n";
        for(Other o:instance){
            result+="> "+o+"\n";
                    
        }
        return result;
    }
    
    public List<Other> filter(String regularEspression){
        List<Other> otros=new ArrayList<>();
        return otros;
        
    }
    
    public void save(){
        List<Other> l=new ArrayList<>();
        l.addAll(this);
        //XMLManager.writeList_into_XML(l, "games.XML");
    }
    
    public boolean load(){
        this.clear();
        return this.addAll(/*XMLManager.readXML_into_List(games.XML)*/);
    }
}
