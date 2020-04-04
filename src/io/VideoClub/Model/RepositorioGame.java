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
public class RepositorioGame extends HashSet<Game> {
    private static RepositorioGame instance = null;
    List<Game> games;
    private RepositorioGame(){
        games=new ArrayList<>();
    };
    
    public static RepositorioGame getInstance(){
        if(instance==null){
            instance=new RepositorioGame();
        }
        return instance;
    
    }

    @Override
    public String toString() {
        String result= "-----REPOSITORIO-----\n";
        for(Game g:instance){
            result+="> "+g+"\n";
                    
        }
        return result;
    }
    
    public List<Game> filter(String regularEspression){
        List<Game> games=new ArrayList<>();
        return games;
        
    }
    
    public void save(){
        List<Game> l=new ArrayList<>();
        l.addAll(this);
        //XMLManager.writeList_into_XML(l, "games.XML");
    }
    
    public boolean load(){
        this.clear();
        return this.addAll(/*XMLManager.readXML_into_List(games.XML)*/);
    }
            
    
    
}
