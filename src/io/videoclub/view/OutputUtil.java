package io.videoclub.view;

import java.util.ArrayList;
import java.util.List;

public class OutputUtil {

    public static <T> void showItem(final T item) {
        System.out.println(item.toString());
    }

    public static <T> void showListItems(final Iterable<T> items) {
        for (final T item : items) {
            showItem(item);
        }
    }

    public static int showMenuAndGetNumberOfActions(final String type) {
        // Caso especial: Earnings
        if (type.equals("Earnings")) {
            printMenu(
                    "gestión de ganancias",
                    new String[]{
                            "Ver ganancias totales",
                            "Ver ganancias entre fechas",
                            "Volver al menú de inicio"
                    }
            );
            return 3;
        }
        // Determinar el título de forma limpia
        final String title = switch (type) {
            case "IClient" -> "Cliente";
            case "AProduct" -> "Producto";
            case "Reservation" -> "Reserva";
            default -> "Elemento";
        };
        // Opciones base
        final List<String> options = new ArrayList<>(List.of(
                "Añadir nuevo " + title,
                "Editar " + title + " existente",
                "Eliminar un " + title,
                "Buscar un " + title,
                "Listar " + title + "s"
        ));
        // Caso especial para IClient
        if (type.equals("IClient")) {
            options.add("Historial de reservas de " + title + "s");
        }
        options.add("Volver al menú de inicio");
        printMenu("gestión de " + title + "s", options.toArray(String[]::new));
        return options.size();
    }


    private static void printMenu(final String title, final String[] options) {
        System.out.println("Bienvenido al menú de " + title);
        System.out.println("-----------------------------------------");

        for (int i = 0; i < options.length; i++) {
            System.out.printf("| %d) %-35s |\n", i + 1, options[i]);
        }

        System.out.println("-----------------------------------------");
    }

}
