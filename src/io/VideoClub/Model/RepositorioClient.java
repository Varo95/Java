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
public class RepositorioClient extends HashSet<Client> {
    private static RepositorioClient instance;
    private RepositorioClient(){};
    
    public static RepositorioClient getInstance(){
        if(instance==null){
            instance=new RepositorioClient();
        }
        return instance;
    
    }
     @Override
    public String toString() {
        String result= "-----REPOSITORIO-----\n";
        for(Client c:instance){
            result+="> "+c+"\n";
                    
        }
        return result;
    }
    
    public List<Client> filter(String regularEspression){
        List<Client> clients=new ArrayList<>();
        return clients;
        
    }
    
    public void save(){
        List<Client> l=new ArrayList<>();
        l.addAll(this);
        //XMLManager.writeList_into_XML(l, "games.XML");
    }
    
    public boolean load(){
        this.clear();
        return this.addAll(/*XMLManager.readXML_into_List(games.XML)*/);
    }
            
}
