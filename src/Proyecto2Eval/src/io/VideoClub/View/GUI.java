package io.VideoClub.View;

import io.VideoClub.Controller.AppController;
import io.VideoClub.Model.Enums.GameCategory;
import io.VideoClub.Model.Enums.MovieCategory;
import io.VideoClub.Model.Enums.ProductsTypes;
import io.VideoClub.Model.Product;
import io.VideoClub.Model.Reservation;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import utils.UIUtilities;

public class GUI {

    static AppController a = new AppController();

    public static void principal() {
        UIUtilities.P("Bienvennido a tu videoclub");
        //Aqui cargar xml
        UIUtilities.P("1 para ver las opciones con productos");
        UIUtilities.P("2 para ver las opciones con clientes");
        UIUtilities.P("3 para ver las opciones con reservas");
        UIUtilities.P("4 para añadir, quitar o editar productos o clientes");
        UIUtilities.p("5 para cerrar el programa");
        subMenu(UIUtilities.getInt());

    }

    public static void subMenu(int o) {
        switch (o) {
            case 1:
                UIUtilities.P("1 opciones para todos los productos");
                UIUtilities.P("2 opciones para listar por nombre");
                UIUtilities.P("3 listarlos por tipo");
                UIUtilities.P("4 listarlos por estado");
                UIUtilities.P("5 opciones con productos distintos");
                subMenu(UIUtilities.getInt(), o);
                break;
            case 2:
                UIUtilities.P("1 listar todos los clientes");
                UIUtilities.P("2 listar todos los clientes comparandolos");
                UIUtilities.P("3 listar clientes con reservas no acabadas");
                subMenu(UIUtilities.getInt(), o);
                break;
            case 3:
                UIUtilities.P("1 listar todas las reservas");
                UIUtilities.P("2 listar todas las reservas comparadas");
                UIUtilities.P("3 listar reservas segun su estado");
                UIUtilities.P("4 opciones de las entradas de reservas");
                UIUtilities.P("5 reservar, cerrar reserva o consulta de disponibilidad");
                subMenu(UIUtilities.getInt(), o);
                break;
            case 4:
                UIUtilities.P("1 opciones de creación");
                UIUtilities.P("2 opciones de edición");
                UIUtilities.P("3 opciones de borrado");
                subMenu(UIUtilities.getInt(), o);
                break;
            case 5:
                UIUtilities.P("Cerrando la aplicación...");
                UIUtilities.P("Gracias por confiar en nosotros");
                //Aqui guardar en xml todos los datos  
                break;
            default:
                break;
        }
    }

    public static void subMenu(int o, int c) {
        int aux = 0;
        switch (c) {
            case 1:
                switch (o) {
                    case 1:
                        UIUtilities.P("1 listar todos los productos");
                        UIUtilities.P("2 listar todos los productos comparandolos");
                        subMenu(UIUtilities.getInt(), c, o);
                        break;
                    case 2:
                        UIUtilities.P("1 para listar todos por nombre");
                        UIUtilities.P("2 para listar todos por nombre y tipo");
                        subMenu(UIUtilities.getInt(), c, o);
                        break;
                    case 3:
                        aux = UIUtilities.getInt("Dime el tipo de producto que busca 1 para peliculas,"
                                + " 2 para juegos y cualquier otro para no clasificados");
                        switch (aux) {
                            case 1:
                                a.listAllByType(ProductsTypes.Peliculas);
                                break;
                            case 2:
                                a.listAllByType(ProductsTypes.Juegos);
                                break;
                            default:
                                a.listAllByType(ProductsTypes.Otros);
                                break;
                        }
                        break;
                    case 4:
                        aux = UIUtilities.getInt("Pulse 0 para mostrar disponibles o 1 para mostrar reservas");
                        if (aux == 0) {
                            a.listAllByStatus(Product.Status.AVAILABLE);
                        } else {
                            a.listAllByStatus(Product.Status.RESERVED);
                        }

                        break;
                    case 5:
                        UIUtilities.P("1 listar productos por diferentes tipos");
                        UIUtilities.P("2 listar todas las peliculas distitas");
                        UIUtilities.P("3 listar todos los juegos distitos");
                        subMenu(UIUtilities.getInt(), c, o);
                        break;
                }
                break;
            case 2:
                switch (o) {
                    case 1:
                        a.listAllClients();
                        break;
                    case 2:
                        UIUtilities.P("Deshabilitado temporalmente");
                        //listAllClients(Comparator c);
                        break;
                    case 3:
                        a.listAllClientsWithReservationsNotFinished();
                        break;
                }
                break;
            case 3:
                switch (o) {
                    case 1:
                        a.listAllReservations();
                        break;
                    case 2:
                        UIUtilities.P("Deshabilitado temporalmente");
                        //listAllReservations(Comparator c);
                        break;
                    case 3:
                        aux = UIUtilities.getInt("Pulse 0 para ordenar por reserva activa,"
                                + " 1 para mostrar reservas acabadas o cualqier número para ordenar por pendientes");
                        if (aux == 0) {
                            a.listAllReservations(Reservation.StatusReserve.ACTIVE);
                        } else if (aux == 1) {
                            a.listAllReservations(Reservation.StatusReserve.FINISHED);
                        } else {
                            a.listAllReservations(Reservation.StatusReserve.PENDING);
                        }
                        break;
                    case 4:
                        UIUtilities.P("1 ver todas las entradas");
                        UIUtilities.P("2 ver entradas desde una fecha concreta");
                        UIUtilities.P("3 ver entradas desde una fecha concreta hasta otra fecha");
                        UIUtilities.P("4 ver todas las entradas de un cliente concreto");
                        subMenu(UIUtilities.getInt(), c, o);
                        break;
                    case 5:
                        UIUtilities.P("1 comprobar disponibilidad de un producto");
                        UIUtilities.P("2 para reservar un producto");
                        UIUtilities.P("3 para cerrar reserva de un producto");
                        subMenu(UIUtilities.getInt(), c, o);
                        break;

                }
                break;
            case 4:
                switch (o) {
                    case 1:
                        UIUtilities.P("1 para crear un nuevo cliente");
                        UIUtilities.P("2 para crear un nuevo producto");
                        UIUtilities.P("3 para crear un nuevo pelicula");
                        UIUtilities.P("4 para crear un nuevo juego");
                        subMenu(UIUtilities.getInt(), c, o);
                        break;
                    case 2:
                        UIUtilities.P("1 para editar un cliente");
                        UIUtilities.P("2 para editar un producto");
                        subMenu(UIUtilities.getInt(), c, o);
                        break;
                    case 3:
                        UIUtilities.P("1 borrar un cliente");
                        UIUtilities.P("2 borrar un producto");
                        subMenu(UIUtilities.getInt(), c, o);
                        break;
                }
                break;
        }
    }

    public static void subMenu(int o, int c, int c2) {
        String name = "";
        switch (c) {
            case 1:
                switch (c2) {
                    case 1:
                        switch (o) {
                            case 1:
                                a.listAllProducts();
                                break;
                            case 2:
                                UIUtilities.P("Deshabilitado temporalmente");
                                //listAllProducts(Comparator c);
                                break;
                        }
                        break;
                    case 2:
                        switch (o) {
                            case 1:
                                a.listAllByName(UIUtilities.getString("Dime el nombre de los artículos a buscar"));
                                break;
                            case 2:
                                name = UIUtilities.getString("Dime el nombre de los artículos a buscar");
                                int aux = UIUtilities.getInt("Dime el tipo de producto que busca 1 para peliculas,"
                                        + " 2 para juegos y cualquier otro para no clasificados");
                                switch (aux) {
                                    case 1:
                                        a.listAllByName(UIUtilities.getString("Dime el nombre de los artículos a buscar"),
                                                ProductsTypes.Peliculas);
                                        break;
                                    case 2:
                                        a.listAllByName(UIUtilities.getString("Dime el nombre de los artículos a buscar"),
                                                ProductsTypes.Juegos);
                                        break;
                                    default:
                                        a.listAllByName(UIUtilities.getString("Dime el nombre de los artículos a buscar"),
                                                ProductsTypes.Otros);
                                        break;
                                }
                                break;

                        }
                        break;
                    case 5:
                        switch (o) {
                            case 1:
                                a.listAllDifferentProducts();
                                break;
                            case 2:
                                a.listAllDifferentMovies();
                                break;
                            case 3:
                                a.listAllDifferentGames();
                                break;
                        }
                        break;
                }
                break;
            case 3:
                switch (c2) {
                    case 4:
                        switch (o) {
                            case 1:
                                a.getIncommings();
                                break;
                            case 2:
                                a.getIncommings(createDate());
                                break;
                            case 3:
                                a.getIncommings(createDate(), createDate());
                                break;
                            case 4:
                                a.resumeAllIncomingsByClient();
                                break;
                        }
                        break;
                    case 5:
                        switch (o) {
                            case 1:
                                a.isAvailableProduct(UIUtilities.getString("Dime el nombre del producto a consulatr"));
                                break;
                            case 2:
                                UIUtilities.P("Deshabilitado temporalmente");
                                break;
                            case 3:
                                a.closeReservation();
                                break;
                        }
                        break;
                }
                break;
            case 4:
                switch (c2) {
                    case 1:
                        switch (o) {
                            case 1:
                                a.createClient(UIUtilities.getString("Dime id del cliente a crear"),
                                        UIUtilities.getString("Dime el nombre del cliente"),
                                        UIUtilities.getString("Dime el teléfono del cliente"), LocalDateTime.now());
                                break;
                            case 2:
                                a.createProduct(UIUtilities.getString("Dime el nombre del producto"),
                                        UIUtilities.getString("Dime una descripción"), UIUtilities.getFloat("Dime el precio"));
                                break;
                            case 3:
                                int aux = UIUtilities.getInt("Pulse 1 para añadir pelicula de horror, 2 para añadir"
                                        + " pelicula de amor, 3 para pelicula de acción y cualquier otro para pelicula"
                                        + "de ciencia ficción");
                                switch (aux) {
                                    case 1:
                                        a.createMovie(ProductsTypes.Peliculas, UIUtilities.getString("Dime el nombre de la pelicula"),
                                                UIUtilities.getString("Dime la descripción"),
                                                MovieCategory.Horror, UIUtilities.getInt("Dime la edad mínima"));
                                        break;
                                    case 2:
                                        a.createMovie(ProductsTypes.Peliculas, UIUtilities.getString("Dime el nombre de la pelicula"),
                                                UIUtilities.getString("Dime la descripción"),
                                                MovieCategory.Love, UIUtilities.getInt("Dime la edad mínima"));
                                        break;
                                    case 3:
                                        a.createMovie(ProductsTypes.Peliculas, UIUtilities.getString("Dime el nombre de la pelicula"),
                                                UIUtilities.getString("Dime la descripción"),
                                                MovieCategory.Action, UIUtilities.getInt("Dime la edad mínima"));
                                        break;
                                    case 4:
                                        a.createMovie(ProductsTypes.Peliculas, UIUtilities.getString("Dime el nombre de la pelicula"),
                                                UIUtilities.getString("Dime la descripción"),
                                                MovieCategory.SciFi, UIUtilities.getInt("Dime la edad mínima"));
                                        break;
                                }

                                break;
                            case 4:
                                aux = UIUtilities.getInt("Pulsa 1 para añadir un juego de aventuras,"
                                        + " 2 para añadir un juego de coches y cualquier otro para añadir un"
                                        + " juego de disparos");
                                switch (aux) {
                                    case 1:
                                        a.createGame(ProductsTypes.Juegos, UIUtilities.getString("Dime el nombre del juego"),
                                                UIUtilities.getString("Dime una descripción del juego"),
                                                GameCategory.Adeventures, UIUtilities.getInt("Dime la edad mínima del juego"));
                                        break;
                                    case 2:
                                        a.createGame(ProductsTypes.Juegos, UIUtilities.getString("Dime el nombre del juego"),
                                                UIUtilities.getString("Dime una descripción del juego"),
                                                GameCategory.Cars, UIUtilities.getInt("Dime la edad mínima del juego"));
                                        break;
                                    case 3:
                                        a.createGame(ProductsTypes.Juegos, UIUtilities.getString("Dime el nombre del juego"),
                                                UIUtilities.getString("Dime una descripción del juego"),
                                                GameCategory.Shooter, UIUtilities.getInt("Dime la edad mínima del juego"));
                                        break;
                                }
                                break;
                        }
                        break;
                    case 2:
                        switch (o) {
                            case 1:

                                UIUtilities.P("Deshabilitado temporalmente");
                                //editClient(IClient e);
                                break;
                            case 2:
                                Product newP = new Product(UIUtilities.getString("Dime el nombre"),
                                        UIUtilities.getString("Dime la descripción"), UIUtilities.getFloat("Dime el precio")) {};
                                a.editProduct(UIUtilities.getString("Dime el identificador del producto"), newP);
                                break;
                        }
                        break;
                    case 3:
                        switch (o) {
                            case 1:
                                a.removeClient(UIUtilities.getString("Dime el id del cliente a borrar"));
                                break;
                            case 2:
                                a.removeProduct(UIUtilities.getString("Dime el nombre del producto a borrar"));
                                break;
                        }
                        break;
                }
                break;
        }
    }

    public static LocalDate createDate() {
        int year = UIUtilities.getInt("Dime el año desde que mostrar");
        int month = UIUtilities.getInt("Dime el número de mes desde que mostrar");
        int day = UIUtilities.getInt("Dime el dia desde que mostrar");
        LocalDate from = null;
        switch (month) {
            case 1:
                from = LocalDate.of(year, Month.JANUARY, day);
                break;
            case 2:
                from = LocalDate.of(year, Month.FEBRUARY, day);
                break;
            case 3:
                from = LocalDate.of(year, Month.MARCH, day);
                break;
            case 4:
                from = LocalDate.of(year, Month.APRIL, day);
                break;
            case 5:
                from = LocalDate.of(year, Month.MAY, day);
                break;
            case 6:
                from = LocalDate.of(year, Month.JUNE, day);
                break;
            case 7:
                from = LocalDate.of(year, Month.JULY, day);
                break;
            case 8:
                from = LocalDate.of(year, Month.AUGUST, day);
                break;
            case 9:
                from = LocalDate.of(year, Month.SEPTEMBER, day);
                break;
            case 10:
                from = LocalDate.of(year, Month.OCTOBER, day);
                break;
            case 11:
                from = LocalDate.of(year, Month.NOVEMBER, day);
                break;
            case 12:
                from = LocalDate.of(year, Month.DECEMBER, day);
                break;
        }
        return from;
    }

}
