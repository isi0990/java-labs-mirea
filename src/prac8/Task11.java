package prac8;

import java.util.Scanner;

public class Task11 {
    private static Scanner scanner = new Scanner(System.in);

    public static int countOnes() {
        int number = scanner.nextInt();

        if (number == 0) {
            int nextNumber = scanner.nextInt();
            if (nextNumber == 0) {
                return 0;
            } else {
                return (nextNumber == 1 ? 1 : 0) + countOnes();
            }
        } else {
            return (number == 1 ? 1 : 0) + countOnes();
        }
    }

    public static void main(String[] args) {
        System.out.println("Введите последовательность чисел (завершите двумя нулями подряд):");
        int result = countOnes();
        System.out.println("Количество единиц в последовательности: " + result);
    }
}