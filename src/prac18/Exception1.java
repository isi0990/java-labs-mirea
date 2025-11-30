package prac18;

public class Exception1 {
    public static void main(String[] args) {
        //System.out.println(2 / 0);
        //System.out.println(2.0 / 0.0);

        try {
            System.out.println(2 / 0);
        } catch (ArithmeticException e) {
            System.out.println("Attempted division by zero");
        }
    }
}
