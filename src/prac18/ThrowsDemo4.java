package prac18;

import java.util.Scanner;

public class ThrowsDemo4 {
    public void getKey() {
        Scanner myScanner = new Scanner(System.in);
        while (true) {
            try {
                String key = myScanner.next();
                printDetails(key);
                break;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage() + ". Try again.");
            }
        }
    }

    public void printDetails(String key) throws Exception {
        String message = getDetails(key);
        System.out.println(message);
    }

    private String getDetails(String key) throws Exception {
        if (key.equals("")) {
            throw new Exception("Key set to empty string");
        }
        return "data for " + key;
    }

    public static void main(String[] args) {
        ThrowsDemo4 demo = new ThrowsDemo4();
        demo.getKey();
    }
}
