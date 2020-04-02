    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.VideoClub.View;

import io.VideoClub.Model.IClient;
import io.VideoClub.Model.Product;
import io.VideoClub.Model.Reservation;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author FRANCISCO MARTIN
 */
public class GUIData {
      public static void ItemToScreen(Collection<Product> s) {
        s.forEach((item) -> {
            GUIItem.Show(item);
        });
    }

    public static void clientToScreen(Set<IClient> s) {
        s.forEach((client) -> {
            GUIClient.showClient(client);
        });
    }
    public static void ReservationToScreen(Set<Reservation> s) {
        s.forEach((reservation) -> {
            GUIReservation.Show(reservation);
        });
    }
    
    public static void ItemToScreen(Map<Product, Integer> s){
        System.out.println(""+ s);
    }
    
   }
