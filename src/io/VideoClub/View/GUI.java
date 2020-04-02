package io.VideoClub.View;

import io.VideoClub.Controller.AppController;
import io.VideoClub.Model.Client;
import io.VideoClub.Model.Enums.ProductsTypes;
import io.VideoClub.Model.NameComparator;
import io.VideoClub.Model.Reservation;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
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
       
    
    public static void registrarCliente() {
        String name = UIUtilities.getString("introduzca nombre");
        String phone = UIUtilities.getString("introduzca telefono");
        LocalDateTime born = UIUtilities.getDate("Introduzca fecha de nacimiento", UIUtilities.defaultDateParsed);

        controlador.createClient(name, phone, born);
    }

    public static void editCliente() {
        Client e = controlador.SearchClient(UIUtilities.getString("introduzca id"));
        if (e != null) {
            Client newC = new Client(UIUtilities.getString("Nuevo nombre"), UIUtilities.getString("Nuevo Telefono"));
            newC.setTime(UIUtilities.getDate("Fecha de nacimiento", UIUtilities.defaultDateParsed));
            controlador.editClient(e, newC);
        } else {
            System.out.println("-> Id erronea");
        }
    }

    public static void eliminarcliente() {
        Client e = controlador.SearchClient(UIUtilities.getString("introduzca id"));
        String pantalla;
        if (e != null) {
            boolean removed = controlador.removeClient(e.getID());
            if (removed) {
                pantalla = "Eliminado";
            } else {
                pantalla = "No se ha podido borrar";
            }
        } else {
            pantalla = "-> Id erronea o tiene una reserva no acabada";
        }
        System.out.println(pantalla);
    }

    public static void listarcliente() {
        int opciones3;
        System.out.println("1.- listar clientes");
        System.out.println("2.- listar por nombre");
        System.out.println("3.- Listar clientes con reservas no finalizadas");

        System.out.println("4.- atras");

        opciones3 = UIUtilities.getInt();

        switch (opciones3) {

            case 1:
                UIUtilities.clearScreen();
                GUIData.clientToScreen(controlador.listAllClients());
                break;

            case 2:
                UIUtilities.clearScreen();
                Comparator c = new NameComparator();
                GUIData.clientToScreen(controlador.listAllClients(c));
                break;

            case 3:
                UIUtilities.clearScreen();
                GUIData.clientToScreen(controlador.listAllClientsWithReservationsNotFinished());
                break;
            case 4:
                break;
            default:
                System.out.println("opcion erronea, vuelva a intentarlo");

        }

    }

    public static void buscarclient() {
        Client e = controlador.SearchClient(UIUtilities.getString("introduzca id"));
        if (e != null) {
            System.out.println(e);
        } else {
            System.out.println("-> Id erronea");
        }
    }

    public static void historialclient() {
        Client e = controlador.SearchClient(UIUtilities.getString("introduzca id"));
        if (e != null) {
            GUIClient.showClient(e);
            GUIData.ReservationToScreen(controlador.listAllReservations(e.getID()));
        } else {
            System.out.println("-> Id incorrecta");
        }
    }

    public static void dardealtaproduct() {
        int opt;
        boolean add;
        do {
            System.out.println("---------------------------------"
                    + "\n1. Nuevo producto de una familia\n"
                    + "2. Nueva familia de productos");
            opt = UIUtilities.getInt("Opcion");

            switch (opt) {
                case 1:
                    add = controlador.addProduct(UIUtilities.getString("Nombre de la familia"));
                    if (!add) {
                        System.out.println("Nombre erroneo");
                    }
                    break;
                case 2:
                    anyadirProducto();
                    break;
                default:
                    System.out.println("Opcion erronea");
            }

        } while (opt != 1 && opt != 2);
    }

    private static void anyadirProducto() {
        boolean add;
        int tipo;
        do {
            System.out.println("\n1. Pelicula"
                    + "\n2. Juego"
                    + "\n3. Otros");
            tipo = UIUtilities.getInt("Tipo");
            switch (tipo) {
                case 1:

                    add = controlador.createMovie(ProductsTypes.Peliculas, UIUtilities.getString("Inserte nombre"), UIUtilities.getString("Descripcion:"),
                            UIUtilities.getMovieCategory(), UIUtilities.getInt("Edad minima recomendada"), UIUtilities.getFloat("Precio"));
                    if (!add) {
                        System.out.println("Error de creacion, pruebe de nuevo ...");
                    }
                    break;
                case 2:

                    add = controlador.createGame(ProductsTypes.Juegos, UIUtilities.getString("Inserte nombre"), UIUtilities.getString("Descripcion:"),
                            UIUtilities.getGameCategory(), UIUtilities.getInt("Edad minima recomendada"), UIUtilities.getFloat("Precio"));
                    if (!add) {
                        System.out.println("Error de creacion, pruebe de nuevo ...");
                    }
                    break;
                case 3:
                    add = controlador.createProduct(UIUtilities.getString("Inserte nombre"), UIUtilities.getString("Descripcion:"), UIUtilities.getFloat("Precio"));
                    if (!add) {
                        System.out.println("Error de creacion, pruebe de nuevo ...");
                    }
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }
        } while (tipo <= 0 || tipo > 3);
    }
    

    public static void eliminarproducto() {
        int opt;
        do {
            System.out.println("1. Eliminar un producto"
                    + "\n2. Eliminar familia de productos");
            opt = UIUtilities.getInt("Opcion");
            switch (opt) {
                case 1:
                    if (!controlador.removeUniqueProduct(UIUtilities.getString("Id del producto"))) {
                        System.out.println("-> Id erronea o tiene una reserva no acabada");
                    } else {
                        System.out.println("Eliminado");
                    }
                    break;
                case 2:
                    if (!controlador.removeProduct(UIUtilities.getString("Nombre de la familia"))) {
                        System.out.println("-> Nombre erroneo o reservas no acabadas");
                    } else {
                        System.out.println("Familia eliminada");
                    }
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }
        } while (opt != 1 && opt != 2);
    }

    public static void newReservation() {
        boolean reserved = false;
        do {
            Client c = controlador.SearchClient(UIUtilities.getString("Id del cliente: "));
            io.VideoClub.Model.Product p = controlador.SearchProduct(UIUtilities.getString("Id de producto: "));
            if (p != null && c != null) {
                reserved = controlador.reserveProduct(p, c);
                if (!controlador.isAged(p, c)) {
                    System.out.println("No tiene edad para alquilar el producto");
                }
                if (reserved) {
                    GUIReservation.Show(controlador.searchReservation(LocalDate.now(), p.getKey(), c.getID()));
                    System.out.println("Reserva completada");
                }
            }
            if (!reserved) {
                System.out.println("Fallo en la reserva");
                char ok = UIUtilities.getChar("¿Desea volver a intentar? [y/n]");
                switch (ok) {
                    case 'y':
                        reserved = false;
                        break;
                    case 'n':
                        reserved = true;
                        break;
                    default:
                        reserved = false;
                }

            }
        } while (!reserved);

    }

    public static void editReservation() {
        int opt;
        do {
            System.out.println("1. Añadir dias"
                    + "\n2. Eliminar reserva"
                    + "\n3. Finalizar reserva"
                    + "\n4. Atras");
            opt = UIUtilities.getInt("Opcion");
            switch (opt) {
                case 1:
                    if (controlador.addDaysToReservation(controlador.searchReservationNotFinished(UIUtilities.getString("Id producto: "),
                            UIUtilities.getString("Id cliente: ")), UIUtilities.getInt("Dias a añadir: "))) {
                        System.out.println("Dias agregados\n");
                    } else {
                        System.out.println("Reserva no encontrada\n");
                    }
                    break;
                case 2:
                    if (controlador.removeReservation(controlador.searchReservation(UIUtilities.getDate("Fecha de inicio de la reserva", UIUtilities.defaultDateParsed).toLocalDate(), UIUtilities.getString("Id producto: "),
                            UIUtilities.getString("Id cliente: ")))) {
                        System.out.println("Borrada\n");
                    } else {
                        System.out.println("Reserva no encontrada\n");
                    }
                    break;
                case 3:

                    double income = controlador.closeReservation(controlador.searchReservationNotFinished(UIUtilities.getString("Id producto: "),
                            UIUtilities.getString("Id cliente: ")));

                    if (income == 0) {
                        System.out.println("Reserva no encontrada");
                    } else {
                        System.out.println("--------------------------------\n\t--->El cliente tiene que pagar " + income + "€\n\n--------------------------------");
                    }

                default:
                    

            }
        } while (opt < 1 || opt > 4);

    }

    public static void listarreserva() {
        int opt;
        do {
            System.out.println("1. Listar todas las reservas"
                    + "\n2. Listar todas las reservas acababas"
                    + "\n3. Listar reservas activas"
                    + "\n4. Listar reservas pendientes"
                    + "\n5. Atras");
            opt = UIUtilities.getInt("Opcion");
            switch (opt) {
                case 1:
                    GUIData.ReservationToScreen(controlador.listAllReservations());
                    break;
                case 2:
                    GUIData.ReservationToScreen(controlador.listAllReservations(Reservation.StatusReserve.FINISHED));
                    break;
                case 3:
                    GUIData.ReservationToScreen(controlador.listAllReservations(Reservation.StatusReserve.ACTIVE));
                    break;
                case 4:
                    GUIData.ReservationToScreen(controlador.listAllReservations(Reservation.StatusReserve.PENDING));
                    break;
                default:

            }
            UIUtilities.clearScreen();
        } while (opt < 1 || opt > 5);
    }

    public static void historialReservas() {
        GUIData.ReservationToScreen(controlador.listAllReservations(UIUtilities.getString("Id cliente: ")));

    }

}   
