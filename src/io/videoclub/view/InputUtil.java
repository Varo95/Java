package io.videoclub.view;


import io.videoclub.model.interfaces.IEnum;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class InputUtil {
    private static final Scanner keyboard = new Scanner(System.in);

    public static String getString() {
        String result;
        do {
            try {
                result = keyboard.nextLine().replace("\n", "");
            }catch (Exception ex){
                if(ex instanceof IllegalStateException){
                    System.out.println("Error in keyboard. Please, try it again: ");
                } else {
                    System.out.println("Error unknown. Please, try it again: ");
                }
                result = "";
            }
        } while (result.isEmpty());
        return result;
    }

    public static char getChar() {
        return getString().charAt(0);
    }

    public static int getInt() {
        int result;
        try{
            result = Integer.parseInt(getString());
        }catch (final Exception e){
            if(e instanceof NumberFormatException){
                System.out.println("Error reading integer type. Please, try it again: ");
            }else{
                System.out.println("Error unknown. Please, try it again: ");
            }
            result = getInt();
        }
        return result;
    }

    public static double getDouble() {
        double result;
        try{
            result = Double.parseDouble(getString());
        }catch (final Exception e){
            if(e instanceof NumberFormatException){
                System.out.println("Error reading integer type. Please, try it again: ");
            }else{
                System.out.println("Error unknown. Please, try it again: ");
            }
            result = getDouble();
        }
        return result;
    }

    public static void clearScreen() {
        System.out.print("\n\n\n\n\n\n\n\n\n\n");
        System.out.flush();
    }

    public static LocalDateTime getDate() {
        LocalDateTime result;
        do{
            try {
                result = LocalDateTime.parse(getString() + " 00:00", DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
            } catch (final Exception ex) {
                System.out.println("Fecha no correcta");
                result = getDate();
            }
        }
        while (result == null);
        return result;
    }

    public static <T extends IEnum> T getEnumOption(Class<T> enumClass) {
        int opt;
        T type = null;
        T[] enumConstants = enumClass.getEnumConstants();
        do {
            for (int i = 0; i < enumConstants.length; i++) {
                System.out.println((i + 1) + ". " + enumConstants[i].getDisplayName());
            }
            opt = getInt();
            if (opt >= 1 && opt <= enumConstants.length) {
                type = enumConstants[opt - 1];
            } else {
                System.out.println("Opcion incorrecta");
            }
        } while (opt <= 0 || opt > enumConstants.length);

        return type;
    }

}
