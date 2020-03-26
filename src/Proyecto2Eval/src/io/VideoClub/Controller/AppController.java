/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.VideoClub.Controller;

import io.VideoClub.Model.Enums.GameCategory;
import io.VideoClub.Model.Enums.MovieCategory;
import io.VideoClub.Model.Enums.ProductsTypes;
import io.VideoClub.Model.IClient;
import io.VideoClub.Model.Product;
import io.VideoClub.Model.Reservation;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Alvaro
 */
public class AppController implements IAppController {
    List<Product> product;
    List<IClient> client;
    
    @Override
    public boolean createProduct(String name, String description, double prize) {
        Scanner keyboard = new Scanner(System.in);
        boolean exist = false;
        for (int i = 0; i < product.size(); i++) {
            if (product.get(i).getName().equals(name)) {
                System.out.println("Este producto ya existe");
                exist = true;
            } else {
                System.out.print("Introduzca nombre del producto: ");
                name = keyboard.next();
                System.out.print("Introduzca descripción del producto: ");
                description = keyboard.next();
                System.out.print("Introduzca precio del producto: ");
                prize = keyboard.nextDouble();
                exist = true;
            }
        }
        return exist;
    }

    @Override
    public boolean createMovie(ProductsTypes type, String name, String description, MovieCategory cat, int minAge) {
        Scanner keyboard = new Scanner(System.in);
        boolean exist = false;
        for (int i = 0; i < product.size(); i++) {
            if (product.get(i).getName().equals(name)) {
                System.out.println("Este producto ya existe");
                exist = true;
            } else {
                System.out.print("Introduzca nombre del producto: ");
                name = keyboard.next();
                System.out.print("Introduzca descripción del prodycto: ");
                description = keyboard.next();
                System.out.print("Introduzca categoría de la película: ");
                //Falta añadir categoría
                System.out.print("Introduzca edad mínima: ");
                minAge = keyboard.nextInt();
                exist = true;
            }
        }
        return exist;
    }

    @Override
    public boolean createGame(ProductsTypes type, String name, String description, GameCategory cat, int minAge) {
        Scanner keyboard = new Scanner(System.in);
        boolean exist = false;
        for (int i = 0; i < product.size(); i++) {
            if (product.get(i).getName().equals(name)) {
                System.out.println("Este producto ya existe");
                exist = true;
            } else {
                System.out.print("Introduzca nombre del producto: ");
                name = keyboard.next();
                System.out.print("Introduzca descripción del prodycto: ");
                description = keyboard.next();
                System.out.print("Introduzca categoría del videojuego: ");
                //Falta añadir categoría
                System.out.print("Introduzca edad mínima: ");
                minAge = keyboard.nextInt();
                exist = true;
            }
        }
        return exist;
    }

    @Override
    public boolean createClient(String id, String name, String phone, LocalDateTime time) {
        Scanner keyboard = new Scanner(System.in);
        boolean exist = false;
        for (int i = 0; i < client.size(); i++) {
            if (client.get(i).getID().equals(id)) {
                id = client.get(i).getID();
                exist = false;
            } else {
                System.out.print("Introduzca su nombre: ");
                name = keyboard.next();
                System.out.print("Introduzca su teléfono: ");
                phone = keyboard.next();
                System.out.println("Fecha de Registro");
                time = client.get(i).getTime();
                exist = true;
            }
        }
        return exist;
    }

    @Override
    public boolean removeClient(String id) {
        Scanner keyboard = new Scanner(System.in);
        boolean removed = false;
        System.out.print("Introduzca ID de cliente ha borrar: ");
        id = keyboard.next();
        if (client.isEmpty()) {
            System.out.println("No hay ningún cliente");
            return false;
        }
        if (client.contains(id)) {
            client.remove(id);
            removed = true;
        }
        return removed;
    }

    @Override
    public boolean editClient(IClient e) {
        Scanner keyboard = new Scanner(System.in);
        boolean edited = false;
        int op = 0;
        System.out.println("Seleccione el apartado que desea modificar");
        System.out.println("1.) Nombre");
        System.out.println("2.) Teléfono");
        System.out.println("3.) Salir");
        switch (op) {
            case 1:
                String name;
                name = keyboard.next();
                e.setName(name);
                break;
            case 2:
                String phone = keyboard.next();
                e.setPhone(phone);
                break;
            case 3:
                break;
        }

        return edited;
    }

    @Override
    public boolean addProduct(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public boolean removeProduct(String name) {
        Scanner keyboard = new Scanner(System.in);
        boolean removed = false;
        System.out.println("Indique el producto a eliminar: ");
        name = keyboard.next();
        for (int i = 0; i < product.size(); i++) {
            if (product.get(i).getName().equals(name)) {
                product.remove(i);
            }
        }
        return removed;
    }

    @Override
    public Set<Product> listAllProducts() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Product> listAllProducts(Comparator c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Product> listAllByType(ProductsTypes type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Product> listAllByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Product> listAllByName(String name, ProductsTypes type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Product> listAllByStatus(Product.Status status) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Product> listAllDifferentProducts() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Product> listAllDifferentMovies() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Product> listAllDifferentGames() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<Product, Integer> listAllAmountOfProducts(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<Product, Integer> listAllAmountOfProducts(ProductsTypes type, String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<IClient> listAllClients() {
        
    }

    @Override
    public Set<IClient> listAllClients(Comparator c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<IClient> listAllClientsWithReservationsNotFinished() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Reservation> listAllReservations() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Reservation> listAllReservations(Comparator c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Reservation> listAllReservations(Reservation.StatusReserve status) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getIncommings() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getIncommings(LocalDate from) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getIncommings(LocalDate from, LocalDate to) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<IClient, Double> resumeAllIncomingsByClient() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editProduct(String key, Product newP) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product isAvailableProduct(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean reserveProduct(Product prod, IClient client) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double closeReservation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean loadCatalogFromDDBB() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean loadClientsFromDDBB() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean loadReservationsFromDDBB() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean loadAllDDBB() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean saveCatalogFromDDBB() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean saveClientsFromDDBB() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean saveReservationsFromDDBB() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean saveAllDDBB() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
