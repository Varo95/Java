package io.videoclub.repository;

import io.videoclub.model.interfaces.IStorage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

public final class Repository<T extends IStorage<T>> {

    private final Set<T> items = new ConcurrentSkipListSet<>();
    private final String filePath;

    public Repository(final Class<T> type) {
        this.filePath = switch (type.getSimpleName()) {
            case "AProduct" -> "./catalog.dat";
            case "IClient" -> "./clients.dat";
            case "Reservation" -> "./reservations.dat";
            default -> throw new IllegalArgumentException("Unsupported type: " + type.getSimpleName());
        };
        this.loadDatFile();
    }

    @SuppressWarnings("unchecked")
    private void loadDatFile() {
        try (final ObjectInputStream ois = new ObjectInputStream(new FileInputStream(this.filePath))) {
            this.items.addAll((Set<T>) ois.readObject());
        } catch (final ClassNotFoundException | IOException e) {
            System.out.println("No se encontró el archivo " + this.filePath + " o hubo un error al leerlo. Se creará uno nuevo al salir de la aplicación.");
        }
    }

    public Set<T> getItems() {
        return this.items;
    }

    public T getById(final String id) {
        for (final T item : this.items) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    public void add(final T item) {
        this.items.add(item);
    }

    public void update(final T item) {
        this.items.remove(item);
        this.items.add(item);
    }

    public void delete(final T item) {
        this.items.remove(item);
    }

    public void saveDatFile(){
        try (final ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(this.filePath))) {
            oos.writeObject(this.items);
        } catch (final IOException e) {
            System.err.println(Arrays.toString(e.getStackTrace()));
        }
    }

}
