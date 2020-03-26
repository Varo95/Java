package io.VideoClub.View;

import io.VideoClub.Controller.AppController;
import utils.UIUtilities;

public class GUI {

    static AppController controlador = new AppController();

    public static void principal() {
        int option;
        do{
        System.out.println("Bienvenido al menú del videoclub");
        System.out.println("--------------------------------");
        System.out.println("| 1) Gestionar los clientes    |");
        System.out.println("| 2) Gestionar los productos   |");
        System.out.println("| 3) Gestionar las reservas    |");
        System.out.println("| 4) Salir de la aplicación    |");
        System.out.println("--------------------------------");
        
            option = UIUtilities.getInt();
            switch(option){
                case 1:
                    GClients();
                    break;
                case 2:
                    GProducts();
                    break;
                case 3:
                    GReservations();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    System.out.println("Gracias por su confianza");
                    break;
                default:
                    System.out.println("Inserte una opción válida, gracias");
            }
        }while(option!=4);
    }
    
    public static void GClients(){
        int optionGC;
        do{
        System.out.println("Bienvenido al menú de gestion de clientes");
        System.out.println("-----------------------------------------");
        System.out.println("| 1) Añadir nuevo cliente               |");
        System.out.println("| 2) Editar cliente existente           |");
        System.out.println("| 3) Eliminar un cliente                |");
        System.out.println("| 4) Buscar un cliente                  |");
        System.out.println("| 5) Listar clientes                    |");
        System.out.println("| 6) Historial de reservas de clientes  |");
        System.out.println("| 7) volver al menú de inicio           |");
        System.out.println("-----------------------------------------");
        optionGC=UIUtilities.getInt();
        switch(optionGC){
            case 1:
                
                break;
            case 2:
                
                break;
            case 3:
                
                break;
            case 4:
                
                break;
            case 5:
                
                break;
            case 6:
                
                break;
            case 7:
                break;
            default:
                System.out.println("Inserte una opción válida, gracias");
        }
        }while(optionGC!=7);
    }
    
    public static void GProducts(){
        int optionGP;
        do{
            System.out.println("Bienvenido al menu de gestión de productos");
            System.out.println("------------------------------------------");
            System.out.println("| 1) Registrar un producto               |");
            System.out.println("| 2) Ver catalogo de productos           |");
            System.out.println("| 3) Eliminar un producto existente      |");
            System.out.println("|4) volver al menú de inicio             |");
            System.out.println("------------------------------------------");
            optionGP=UIUtilities.getInt();
            switch(optionGP){
                case 1:
                    
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Inserte una opción válida, gracias");
            }
        }while(optionGP!=4);
    }
    
    public static void GReservations(){
        int optionGR;
        do{
            System.out.println("Bienvenido al menu de gestión de reservas");
            System.out.println("-----------------------------------------");
            System.out.println("| 1) Listar las reservas                |");
            System.out.println("| 2) Historial de reservas de clientes  |");
            System.out.println("| 3) Hacer una reserva                  |");
            System.out.println("| 4) Editar reserva existente           |");
            System.out.println("| 5) volver al menú de inicio           |");
            System.out.println("-----------------------------------------");
            optionGR=UIUtilities.getInt();
            switch(optionGR){
                case 1:
                    
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Inserte una opción válida, gracias");
            }
        }while(optionGR!=5);
    }
        
}   
