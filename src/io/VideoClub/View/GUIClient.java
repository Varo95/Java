/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.VideoClub.View;

import io.VideoClub.Model.IClient;

/**
 *
 * @author FRANCISCO MARTIN
 */
public class GUIClient {
    
   static public void showClient(IClient o){
        System.out.println(o);
    }
   static public void showByName(IClient o){
        System.out.println(o.getName()+o.getID()+o.getPhone()+o.getTime()); 
        
    }
    
   static public void showByPhone(IClient o){
        System.out.println(o.getPhone()+o.getID()+o.getName()+o.getTime());
    } 
}
