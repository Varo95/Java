package io.videoclub.view;

import io.videoclub.controller.AppController;
import io.videoclub.model.Reservation;
import io.videoclub.model.interfaces.AProduct;
import io.videoclub.model.interfaces.IClient;
import io.videoclub.model.products.Game;
import io.videoclub.model.products.Movie;
import io.videoclub.model.products.Other;

import java.time.LocalDateTime;

public class Main {

    private static final AppController appController = AppController.getInstance();

    public static void init() {
        int option;
        do {
            System.out.println("Bienvenido al menú del videoclub");
            System.out.println("--------------------------------");
            System.out.println("| 1) Gestionar los clientes    |");
            System.out.println("| 2) Gestionar los productos   |");
            System.out.println("| 3) Gestionar las reservas    |");
            System.out.println("| 4) Consultar ganancias       |");
            System.out.println("| 5) Salir de la aplicación    |");
            System.out.println("--------------------------------");

            option = InputUtil.getInt();
            switch (option) {
                case 1:
                    genericManagement(1);
                    break;
                case 2:
                    genericManagement(2);
                    break;
                case 3:
                    genericManagement(3);
                    break;
                case 4:
                    genericManagement(4);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    appController.saveData();
                    System.out.println("Gracias por su confianza");
                    break;
                default:
                    System.out.println("Inserte una opción válida, gracias");
            }
        } while (option != 5);
    }

    private static void genericManagement(final int option) {
        int maxOptions;
        int selectedOption;
        do {
            maxOptions = switch (option) {
                case 1 -> OutputUtil.showMenuAndGetNumberOfActions("IClient");
                case 2 -> OutputUtil.showMenuAndGetNumberOfActions("AProduct");
                case 3 -> OutputUtil.showMenuAndGetNumberOfActions("Reservation");
                case 4 -> OutputUtil.showMenuAndGetNumberOfActions("Earnings");
                default -> 0;
            };
            System.out.println("Seleccione una opción (1-" + maxOptions + "): ");
            selectedOption = InputUtil.getInt();
            switch (option) {
                case 1 -> {
                    switch (selectedOption) {
                        case 1 -> registerClient();
                        case 2 -> editClient();
                        case 3 -> deleteClient();
                        case 4 -> searchClient();
                        case 5 -> listClients();
                        case 6 -> historicalClient();
                        case 7 -> System.out.println("Volviendo al menú principal...");
                        default -> System.out.println("Inserte una opción válida, gracias");
                    }
                }
                case 2 -> {
                    switch (selectedOption) {
                        case 1 -> registerProduct();
                        case 2 -> editProduct();
                        case 3 -> deleteProduct();
                        case 4 -> searchProduct();
                        case 5 -> listProducts();
                        case 6 -> System.out.println("Volviendo al menú principal...");
                        default -> System.out.println("Inserte una opción válida, gracias");
                    }
                }
                case 3 -> {
                    switch (selectedOption) {
                        case 1 -> registerReservation();
                        case 2 -> editReservation();
                        case 3 -> deleteReservation();
                        case 4 -> searchReservation();
                        case 5 -> listReservations();
                        case 6 -> System.out.println("Volviendo al menú principal...");
                        default -> System.out.println("Inserte una opción válida, gracias");
                    }
                }
                case 4 -> {
                    switch (selectedOption) {
                        case 1-> {
                            final double totalEarnings = appController.getTotalEarnings();
                            System.out.printf("Las ganancias totales son: %.2f\n", totalEarnings);
                            System.out.println("Volviendo al menú principal...");
                        }
                        case 2-> {
                            System.out.print("Introduzca la fecha de inicio (dd-mm-yyyy): ");
                            final LocalDateTime startDate = InputUtil.getDate();
                            System.out.print("Introduzca la fecha de fin (dd-mm-yyyy): ");
                            final LocalDateTime endDate = InputUtil.getDate();
                            final double earningsBetweenDates = appController.getEarningsBetweenDates(startDate, endDate);
                            System.out.printf("Las ganancias entre las fechas son: %.2f\n", earningsBetweenDates);
                            System.out.println("Volviendo al menú principal...");
                        }
                        case 3 -> System.out.println("Volviendo al menú principal...");
                        default -> System.out.println("Inserte una opción válida, gracias");
                    }
                }
            }
        } while (selectedOption < 1 || selectedOption > maxOptions);
    }

    private static void registerClient() {
        System.out.print("Introduzca el nombre del cliente: ");
        final String name = InputUtil.getString();
        System.out.print("Introduzca el teléfono del cliente: ");
        final String phone = InputUtil.getString();
        System.out.print("Introduce la fecha de nacimiento del cliente (dd-mm-yyyy): ");
        final LocalDateTime birthDate = InputUtil.getDate();
        appController.createClient(name, phone, birthDate);
        System.out.println("Cliente registrado correctamente.");
        System.out.println("Volviendo al menú principal...");
    }

    private static void editClient() {
        System.out.print("Introduzca el ID del cliente a editar: ");
        final String id = InputUtil.getString();
        final IClient client = appController.getClientById(id);
        if (client != null) {
            OutputUtil.showItem(client);
            System.out.print("Introduzca el nuevo nombre del cliente: ");
            final String name = InputUtil.getString();
            System.out.print("Introduzca el nuevo teléfono del cliente: ");
            final String phone = InputUtil.getString();
            System.out.print("Introduce la nueva fecha de nacimiento del cliente (dd-mm-yyyy): ");
            final LocalDateTime birthDate = InputUtil.getDate();
            appController.editClient(client, name, phone, birthDate);
            System.out.println("Cliente editado correctamente.");
        } else {
            System.out.println("Cliente no encontrado.");
        }
        System.out.println("Volviendo al menú principal...");
    }

    private static void deleteClient() {
        System.out.print("Introduzca el ID del cliente a eliminar: ");
        final String id = InputUtil.getString();
        final IClient client = appController.getClientById(id);
        if (client != null) {
            appController.deleteClient(client);
            System.out.println("Cliente eliminado correctamente.");
        } else {
            System.out.println("Cliente no encontrado.");
        }
        System.out.println("Volviendo al menú principal...");
    }

    private static void searchClient() {
        System.out.print("Introduzca el ID del cliente a buscar: ");
        final String id = InputUtil.getString();
        final IClient client = appController.getClientById(id);
        if (client != null) {
            OutputUtil.showItem(client);
        } else {
            System.out.println("Cliente no encontrado.");
        }
        System.out.println("Volviendo al menú principal...");
    }

    private static void listClients() {
        OutputUtil.showListItems(appController.getAllClients());
        System.out.println("Volviendo al menú principal...");
    }

    private static void historicalClient() {
        System.out.print("Introduzca el ID del cliente para ver su historial de reservas: ");
        final String id = InputUtil.getString();
        final IClient client = appController.getClientById(id);
        if (client != null) {
            OutputUtil.showListItems(appController.getReservationsByClient(client));
        } else {
            System.out.println("Cliente no encontrado.");
        }
        System.out.println("Volviendo al menú principal...");
    }

    private static void registerProduct() {
        System.out.println("Seleccione el tipo de producto a añadir: ");
        final AProduct.ProductsTypes option = InputUtil.getEnumOption(AProduct.ProductsTypes.class);
        switch (option) {
            case Games -> {
                System.out.print("Introduzca el nombre del juego: ");
                final String name = InputUtil.getString();
                System.out.print("Introduzca la descripción del juego: ");
                final String description = InputUtil.getString();
                System.out.print("Introduzca el precio del juego: ");
                final double prize = InputUtil.getDouble();
                System.out.println("Introduzca el estado del juego: ");
                final AProduct.Status status = InputUtil.getEnumOption(AProduct.Status.class);
                System.out.println("Seleccione la categoría del juego: ");
                final Game.GameCategory category = InputUtil.getEnumOption(Game.GameCategory.class);
                System.out.print("Introduzca la edad mínima para el juego: ");
                final int minAge = InputUtil.getInt();
                appController.createProduct(Game.class, name, description, prize, status, category, minAge);
                System.out.println("Juego registrado correctamente.");
            }
            case Films -> {
                System.out.print("Introduzca el nombre de la película: ");
                final String name = InputUtil.getString();
                System.out.print("Introduzca la descripción de la película: ");
                final String description = InputUtil.getString();
                System.out.print("Introduzca el precio de la película: ");
                final double prize = InputUtil.getDouble();
                System.out.println("Introduzca el estado de la película: ");
                final AProduct.Status status = InputUtil.getEnumOption(AProduct.Status.class);
                System.out.println("Seleccione la categoría de la película: ");
                final Movie.MovieCategory category = InputUtil.getEnumOption(Movie.MovieCategory.class);
                System.out.print("Introduzca la edad mínima para la película: ");
                final int minAge = InputUtil.getInt();
                appController.createProduct(Movie.class, name, description, prize, status, category, minAge);
                System.out.println("Película registrada correctamente.");
            }
            case Other -> {
                System.out.print("Introduzca el nombre del producto: ");
                final String name = InputUtil.getString();
                System.out.print("Introduzca la descripción del producto: ");
                final String description = InputUtil.getString();
                System.out.print("Introduzca el precio del producto: ");
                final double prize = InputUtil.getDouble();
                System.out.println("Introduzca el estado del producto: ");
                final AProduct.Status status = InputUtil.getEnumOption(AProduct.Status.class);
                appController.createProduct(Other.class, name, description, prize, status);
                System.out.println("Producto registrado correctamente.");
            }
        }
        System.out.println("Volviendo al menú principal...");
    }

    private static void editProduct(){
        System.out.print("Introduzca la clave del producto a editar: ");
        final String id = InputUtil.getString();
        final AProduct product = appController.getProductById(id);
        if (product != null) {
            OutputUtil.showItem(product);
            System.out.print("Introduzca el nuevo nombre del producto: ");
            final String name = InputUtil.getString();
            System.out.print("Introduzca la nueva descripción del producto: ");
            final String description = InputUtil.getString();
            System.out.print("Introduzca el nuevo precio del producto: ");
            final double prize = InputUtil.getDouble();
            System.out.print("Introduzca el nuevo estado del producto: ");
            final AProduct.Status status = InputUtil.getEnumOption(AProduct.Status.class);
            appController.editProduct(id, name, description, prize, status);
            System.out.println("Producto editado correctamente.");
        } else {
            System.out.println("Producto no encontrado.");
        }
        System.out.println("Volviendo al menú principal...");
    }

    private static void deleteProduct(){
        System.out.print("Introduzca la clave del producto a eliminar: ");
        final String id = InputUtil.getString();
        final AProduct product = appController.getProductById(id);
        if (product != null) {
            appController.deleteProduct(product);
            System.out.println("Producto eliminado correctamente.");
        } else {
            System.out.println("Producto no encontrado.");
        }
        System.out.println("Volviendo al menú principal...");
    }

    private static void searchProduct(){
        System.out.print("Introduzca la clave del producto a buscar: ");
        final String id = InputUtil.getString();
        final AProduct product = appController.getProductById(id);
        if (product != null) {
            OutputUtil.showItem(product);
        } else {
            System.out.println("Producto no encontrado.");
        }
        System.out.println("Volviendo al menú principal...");
    }

    private static void listProducts(){
        OutputUtil.showListItems(appController.getAllProducts());
        System.out.println("Volviendo al menú principal...");
    }

    private static void registerReservation() {
        System.out.print("Introduzca el ID del cliente para la reserva: ");
        final String clientId = InputUtil.getString();
        final IClient client = appController.getClientById(clientId);
        if (client != null) {
            System.out.print("Introduzca la clave del producto para la reserva: ");
            final String productId = InputUtil.getString();
            final AProduct product = appController.getProductById(productId);
            if (product != null) {
                appController.createReservation(client, product);
                System.out.println("Reserva registrada correctamente.");
            } else {
                System.out.println("Producto no encontrado.");
            }
        } else {
            System.out.println("Cliente no encontrado.");
        }
        System.out.println("Volviendo al menú principal...");
    }

    private static void editReservation(){
        System.out.print("Introduzca el ID del producto de la reserva a editar: ");
        final String id = InputUtil.getString();
        final Reservation reservation = appController.getReservationByProductId(id);
        if (reservation != null) {
            OutputUtil.showItem(reservation);
            System.out.print("Introduzca la nueva fecha de devolución (dd-mm-yyyy): ");
            final LocalDateTime returnDate = InputUtil.getDate();
            appController.editReservation(reservation, returnDate);
            System.out.println("Reserva editada correctamente.");
        } else {
            System.out.println("Reserva no encontrada.");
        }
        System.out.println("Volviendo al menú principal...");
    }

    private static void deleteReservation(){
        System.out.print("Introduzca el ID del producto de la reserva a eliminar: ");
        final String id = InputUtil.getString();
        final Reservation reservation = appController.getReservationByProductId(id);
        if (reservation != null) {
            appController.deleteReservation(reservation);
            System.out.println("Reserva eliminada correctamente.");
        } else {
            System.out.println("Reserva no encontrada.");
        }
        System.out.println("Volviendo al menú principal...");
    }

    private static void searchReservation(){
        System.out.println("Introduzca el ID de producto: ");
        final String productId = InputUtil.getString();
        final Reservation reservation = appController.getReservationByProductId(productId);
        if (reservation != null) {
            OutputUtil.showItem(reservation);
        } else {
            System.out.println("Reserva no encontrada.");
        }
        System.out.println("Volviendo al menú principal...");
    }

    private static void listReservations(){
        OutputUtil.showListItems(appController.getAllReservations());
        System.out.println("Volviendo al menú principal...");
    }
}
