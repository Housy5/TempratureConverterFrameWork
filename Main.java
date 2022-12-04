
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
    
    private static Scanner scanner;
    
    private static int promptMenu(String message, String... options) {
        System.out.println(message);
        for (int i = 0; i < options.length; i++) {
            System.out.printf("%d) %s\n", i + 1, options[i]);
        }
        System.out.print("Enter your option: ");
        String input = scanner.nextLine();
        return toInt(input);
    }
    
    private static int toInt(String data) {
        char[] charArray = data.toCharArray();
        int result = 0;
        for (char c : charArray) {
            result = result * 10 + (c - '0');
        }
        return result;
    }
    
    private static double toDouble(String data) {
        try {
            return Double.parseDouble(data);
        } catch (NumberFormatException e) {
            return (double) toInt(data);
        }
    }
    
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            int opt = promptMenu("Main Menu", "Celsius to Fahrenheit", "Fahrenheit to Celsius", "Show last Result", "Exit");
            switch (opt) {
                case 1 -> {celsiusToFahrenheit();}
                case 2 -> {fahrenheitToCelsius();}
                case 3 -> {}
                case 4 -> {
                    running = false;
                }
            }
        }
    }
    
    private static void celsiusToFahrenheit() {
        throw new UnsupportedOperationException("Not supported yet.");
        //example: saveResult("36 Celsius -> +-100 Fahrenheit");
    }

    private static void fahrenheitToCelsius() {
        throw new UnsupportedOperationException("Not supported yet.");
        //saveResult(result);
    }
    
    private static void showLastResult() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    private static String loadLastResult() {
        try {
            Path path = Paths.get("result.txt");
            return Files.readString(path);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            return "There are no previous results.";
        }
    }
    
    private static boolean saveResult(String result) {
        try {
            Path path = Paths.get("result.txt");
            Files.writeString(path, result);
            return true;
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
