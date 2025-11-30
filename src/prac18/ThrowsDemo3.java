package prac18;

import java.util.Scanner;

public class ThrowsDemo3 {
    public void getKey() {
        try {
            Scanner myScanner = new Scanner( System.in );
            System.out.print("Введите ключ: ");
            String key = myScanner.next();
            printDetails(key);
        } catch (Exception e) {
            System.out.println("Ошибка обработки в getKey: " + e.getMessage());
        }
    }

    public void printDetails(String key) throws Exception {
        String message = getDetails(key);
        System.out.println( message );
    }

    private String getDetails(String key) throws Exception {
        if(key == "") {
            throw new Exception( "Key set to empty string" );
        }
        return "data for " + key;
    }

    public static void main(String[] args) {
        ThrowsDemo3 demo = new ThrowsDemo3();
        demo.getKey();
    }
}
