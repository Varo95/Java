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
public class RepositorioMovie extends HashSet<Movie> {
    private static RepositorioMovie instance=null;
    List<Movie> movies;
    private RepositorioMovie(){
        movies = new ArrayList<>();
    };
    
    public static RepositorioMovie getInstance(){
        if(instance==null){
            instance=new RepositorioMovie();
        }
        return instance;
    
    }

    @Override
    public String toString() {
        String result= "-----REPOSITORIO-----\n";
        for(Movie m:instance){
            result+="> "+m+"\n";
                    
        }
        return result;
    }
    
    public List<Movie> filter(String regularEspression){
        List<Movie> movies=new ArrayList<>();
        return movies;
        
    }
    
    public void save(){
        List<Movie> l=new ArrayList<>();
        l.addAll(this);
        //XMLManager.writeList_into_XML(l, "games.XML");
    }
    
    public boolean load(){
        this.clear();
        return this.addAll(/*XMLManager.readXML_into_List(games.XML)*/);
    }
}
