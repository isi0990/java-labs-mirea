package prac18;

import java.util.Scanner;

public class Exception2 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        String intString = myScanner.next();
        try {
            int i = Integer.parseInt(intString);
            System.out.println(2 / i);
//        } catch (Exception e) {
//            System.out.println("General exception caught. ");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input: not an integer");
        } catch (ArithmeticException e) {
            System.out.println("Division by zero");
        } finally {
            System.out.println("Finally block executed.");
        }
    }
}
