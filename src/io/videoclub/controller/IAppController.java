package io.videoclub.controller;

import io.videoclub.model.Reservation;
import io.videoclub.model.interfaces.AProduct;
import io.videoclub.model.interfaces.IClient;

import java.time.LocalDateTime;
import java.util.Set;

public interface IAppController {
    Set<IClient> getAllClients();
    Set<AProduct> getAllProducts();
    Set<Reservation> getAllReservations();
    Set<Reservation> getReservationsByClient(final IClient client);
    IClient getClientById(final String id);
    AProduct getProductById(final String id);
    Reservation getReservationByProductId(final String productId);
    void createClient(final String name, final String phone, final LocalDateTime bornDate);
    void editClient(final IClient client, final String name, final String phone, final LocalDateTime bornDate);
    void deleteClient(final IClient client);
    void createProduct(final Class<? extends AProduct> clazz, final Object... params);
    void editProduct(final String id, final String name, final String description, final double prize, final AProduct.Status status);
    void deleteProduct(final AProduct product);
    void createReservation(final IClient client, final AProduct product);
    void editReservation(final Reservation reservation, final LocalDateTime returnDate);
    void deleteReservation(final Reservation reservation);
    double getTotalEarnings();
    double getEarningsBetweenDates(final LocalDateTime startDate, final LocalDateTime endDate);
    void saveData();
}
