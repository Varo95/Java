package io.videoclub.controller;

import io.videoclub.model.Client;
import io.videoclub.model.Reservation;
import io.videoclub.model.interfaces.AProduct;
import io.videoclub.model.interfaces.IClient;
import io.videoclub.model.products.Game;
import io.videoclub.model.products.Movie;
import io.videoclub.model.products.Other;
import io.videoclub.repository.Repository;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class AppController implements IAppController {
    private static Repository<AProduct> productRepository;
    private static Repository<IClient> clientRepository;
    private static Repository<Reservation> reservationRepository;

    private static AppController instance;

    private AppController() {

    }

    public static AppController getInstance(){
        if(instance == null){
            instance = new AppController();
            productRepository = new Repository<>(AProduct.class);
            clientRepository = new Repository<>(IClient.class);
            reservationRepository = new Repository<>(Reservation.class);
            loadProductsAndClientsFromReservations();
        }
        return instance;
    }

    //This method loads the products and clients from the reservations to avoid duplication
    private static void loadProductsAndClientsFromReservations(){
        final Set<Reservation> reservations = reservationRepository.getItems();
        for(final Reservation res : reservations){
            final AProduct pro = instance.getProductById(res.getPro().getId());
            final IClient cli = instance.getClientById(res.getCli().getId());
            if(pro != null && cli != null){
                res.setPro(pro);
                res.setCli(cli);
            }
        }
    }

    @Override
    public Set<IClient> getAllClients() {
        return clientRepository.getItems();
    }

    @Override
    public Set<AProduct> getAllProducts() {
        return productRepository.getItems();
    }

    @Override
    public Set<Reservation> getAllReservations() {
        return reservationRepository.getItems();
    }

    @Override
    public IClient getClientById(final String id) {
        return clientRepository.getById(id);
    }

    @Override
    public AProduct getProductById(final String id) {
        return productRepository.getById(id);
    }

    @Override
    public Set<Reservation> getReservationsByClient(final IClient client){
        final Set<Reservation> allReservations = reservationRepository.getItems();
        final Set<Reservation> clientReservations = new HashSet<>();
        for(final Reservation res : allReservations){
            if(res.getCli().getId().equals(client.getId())){
                clientReservations.add(res);
            }
        }
        return clientReservations;
    }

    @Override
    public Reservation getReservationByProductId(final String productId) {
        final Set<Reservation> allReservations = reservationRepository.getItems();
        for (final Reservation res : allReservations) {
            if (res.getPro().getId().equals(productId)) {
                return res;
            }
        }
        return null;
    }

    @Override
    public void createClient(final String name, final String phone, final LocalDateTime bornDate) {
        final IClient client = new Client();
        client.setName(name);
        client.setPhone(phone);
        client.setTime(bornDate);
        clientRepository.add(client);
    }

    @Override
    public void editClient(final IClient client, final String name, final String phone, final LocalDateTime bornDate){
        client.setName(name);
        client.setPhone(phone);
        client.setTime(bornDate);
        clientRepository.update(client);
    }

    @Override
    public void deleteClient(final IClient client) {
        client.setName("DELETED");
        clientRepository.update(client);
    }

    @Override
    public void createProduct(final Class<? extends AProduct> clazz, final Object... params) {
        final AProduct product = switch (clazz.getSimpleName()){
            case "Game" -> new Game();
            case "Movie" -> new Movie();
            case "Other" -> new Other();
            default -> null;
        };

        if (product != null && params.length > 0) {
            // Set properties based on params
            if (params.length >= 4) {
                product.setName(params[0].toString());
                product.setDescription(params[1].toString());
                product.setPrize(Double.parseDouble(params[2].toString()));
                product.setStatus(AProduct.Status.valueOf(params[3].toString()));

                // Set specific properties for Game and Movie
                if (product instanceof Game g && params.length >= 6) {
                    g.setCategory(Game.GameCategory.valueOf(params[4].toString()));
                    g.setMinAge(Integer.parseInt(params[5].toString()));
                } else if (product instanceof Movie m && params.length >= 6) {
                    m.setCategory(Movie.MovieCategory.valueOf(params[4].toString()));
                    m.setMinAge(Integer.parseInt(params[5].toString()));
                }
            }
            productRepository.add(product);
        }
    }

    @Override
    public void editProduct(final String id, final String name, final String description, final double prize, final AProduct.Status status) {
        final AProduct product = productRepository.getById(id);
        if (product != null) {
            product.setName(name);
            product.setDescription(description);
            product.setPrize(prize);
            product.setStatus(status);
            productRepository.update(product);
        }
    }

    @Override
    public void deleteProduct(final AProduct product) {
        product.setName("DELETED");
        productRepository.update(product);
    }

    @Override
    public void createReservation(final IClient client, final AProduct product) {
        final Reservation reservation = new Reservation(product, client);
        reservationRepository.add(reservation);
        product.setStatus(AProduct.Status.RESERVED);
        productRepository.update(product);
    }

    @Override
    public void editReservation(final Reservation reservation, final LocalDateTime returnDate) {
        reservation.setFinished(returnDate.toLocalDate());
        reservationRepository.update(reservation);
        final AProduct product = reservation.getPro();
        product.setStatus(AProduct.Status.AVAILABLE);
        productRepository.update(product);
    }

    @Override
    public void deleteReservation(final Reservation reservation) {
        final AProduct product = reservation.getPro();
        product.setStatus(AProduct.Status.AVAILABLE);
        productRepository.update(product);
        reservationRepository.delete(reservation);
    }

    @Override
    public double getTotalEarnings() {
        final Set<Reservation> allReservations = reservationRepository.getItems();
        double total = 0.0;
        for (final Reservation res : allReservations) {
            if (res.getFinished() != null) {
                total += res.getPro().getPrize();
            }
        }
        return total;
    }

    @Override
    public double getEarningsBetweenDates(final LocalDateTime startDate, final LocalDateTime endDate) {
        final Set<Reservation> allReservations = reservationRepository.getItems();
        double total = 0.0;
        for (final Reservation res : allReservations) {
            final java.time.LocalDate finishedDate = res.getFinished();
            if (finishedDate != null && !finishedDate.isBefore(startDate.toLocalDate()) && !finishedDate.isAfter(endDate.toLocalDate())) {
                total += res.getPro().getPrize();
            }
        }
        return total;
    }

    @Override
    public void saveData() {
        productRepository.saveDatFile();
        clientRepository.saveDatFile();
        reservationRepository.saveDatFile();
    }
}
