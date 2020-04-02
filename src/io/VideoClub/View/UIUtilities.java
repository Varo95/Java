/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.VideoClub.View;

import io.VideoClub.Model.Enums.GameCategory;
import io.VideoClub.Model.Enums.MovieCategory;
import io.VideoClub.Model.Enums.ProductsTypes;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import io.VideoClub.Model.Product;
/**
 *
 * @author FRANCISCO MARTIN
 */
public class UIUtilities {
    
    private static Scanner keyboard = new Scanner(System.in);
    public static final String defaultDateParsed = "yyyy/MM/dd";

    public static int getInt() {
        int result = 0;
        boolean valid = false;
        do {
            try {
                result = Integer.parseInt(keyboard.nextLine());
                valid = true;

            } catch (IllegalStateException ex) {
                keyboard = new Scanner(System.in);
                System.out.println("Error in keyboard. Please, try it again: ");
            } catch (NumberFormatException ex) {
                System.out.println("Error reading integer type. Please, try it again: ");
            } catch (Exception ex) {
                System.out.println("Error unknown. Please, try it again: ");
            }
        } while (!valid);
        return result;
    }

    public static int getInt(String f) {
        System.out.print(f + " ");
        return UIUtilities.getInt();
    }

    public static float getFloat() {
        float result = 0;
        boolean valid = false;
        do {
            try {
                result = Float.parseFloat(keyboard.nextLine());
                valid = true;

            } catch (IllegalStateException ex) {
                keyboard = new Scanner(System.in);
                System.out.println("Error in keyboard. Please, try it again: ");
            } catch (NumberFormatException ex) {
                System.out.println("Error reading decimal number. Please, try it again: ");
            } catch (Exception ex) {
                System.out.println("Error unknown. Please, try it again: ");
            }
        } while (!valid);
        return result;
    }

    public static float getFloat(String f) {
        System.out.print(f + " ");
        return UIUtilities.getFloat();
    }

    public static String getString() {
        String result = "";
        boolean valid = false;
        do {
            try {
                result = keyboard.nextLine();
                valid = true;

            } catch (Exception ex) {
                System.out.println("Error unknown. Please, try it again: ");
            }
        } while (!valid);
        return result;
    }

    public static String getString(String f) {
        System.out.print(f + " ");
        return UIUtilities.getString();
    }

    public static char getChar(String f) {

        String s;
        do {
            System.out.print(f + " ");
            s = UIUtilities.getString();
            if (s.length() != 1) {
                System.out.println("No válido");
            }
        } while (s.length() != 1);

        return s.charAt(0);

    }
        
        
    public static void clearScreen() {
        System.out.print("\n\n\n\n\n\n\n\n\n\n");
        System.out.flush();
    }

    public static LocalDateTime getDate(String s, String parsed) {
        boolean result = false;
        LocalDateTime time = null;

        while (!result) {
            try {
                String fecha = UIUtilities.getString(s + " [" + parsed + "]") + " 00:00";
                DateTimeFormatter format = DateTimeFormatter.ofPattern(parsed + " HH:mm");
                time = LocalDateTime.parse(fecha, format);
                result = true;
            } catch (Exception ex) {
                System.out.println("Fecha no correcta");
            }
        }
        return time;
    }

    
    public static MovieCategory getMovieCategory() {
        int opt;
        MovieCategory type = null;
        do {
            System.out.println("1. Horror"
                    + "\n2. Love"
                    + "\n3. Action"
                    + "\n4. SciFi");

            opt = UIUtilities.getInt("Categoria");
            switch (opt) {
                case 1:
                    type = MovieCategory.Horror;
                    break;
                case 2:
                    type = MovieCategory.Love;
                    break;
                case 3:
                    type = MovieCategory.Action;
                    break;
                case 4:
                    type = MovieCategory.SciFi;
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }
        } while (opt <= 0 || opt > 4);

        return type;

    }


    public static GameCategory getGameCategory() {
        int opt;
        GameCategory type = null;
        do {
            System.out.println("1. Adventures"
                    + "\n2. Cars"
                    + "\n3. Shooter");

            opt = UIUtilities.getInt("Categoria");
            switch (opt) {
                case 1:
                    type = GameCategory.Adventures;
                    break;
                case 2:
                    type = GameCategory.Cars;
                    break;
                case 3:
                    type = GameCategory.Shooter;
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }
        } while (opt <= 0 || opt > 3);

        return type;

    }
 
    public static ProductsTypes getType() {
        int opt;
        ProductsTypes type = null;
        do {
            System.out.println("1. Juegos"
                    + "\n2. Peliculas"
                    + "\n3. Otros");

            opt = UIUtilities.getInt("Categoria");
            switch (opt) {
                case 1:
                    type = ProductsTypes.Juegos;
                    break;
                case 2:
                    type = ProductsTypes.Peliculas;
                    break;
                case 3:
                    type = ProductsTypes.Otros;
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }
        } while (opt <= 0 || opt > 3);

        return type;

    }

    public static Product.Status getStatus() {
        int opt;
        Product.Status type = null;
        do {
            System.out.println("1. Reservados"
                    + "\n2. Disponibles");

            opt = UIUtilities.getInt("Opcion");
            switch (opt) {
                case 1:
                    type = Product.Status.RESERVED;
                    break;
                case 2:
                    type = Product.Status.AVAILABLE;
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }
        } while (opt <= 0 || opt > 2);

        return type;

    }
}
