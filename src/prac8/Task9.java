package prac8;

import java.util.Scanner;

public class Task9 {
    public static int countSequences(int a, int b) {
        // Базовые случаи
        if (a == 0 && b == 0) return 1;
        if (a < 0 || b < 0) return 0;

        // Рекурсивные случаи
        if (a == 0) return 1;
        if (b == 0) return 0;

        // Ставим 1 или 0 (если после него идет 1)
        return countSequences(a, b - 1) + countSequences(a - 1, b - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите a (количество нулей): ");
        int a = scanner.nextInt();
        System.out.print("Введите b (количество единиц): ");
        int b = scanner.nextInt();

        System.out.println("Количество последовательностей: " + countSequences(a, b));
    }
}
