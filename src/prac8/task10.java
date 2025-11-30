package prac8;

import java.util.Scanner;

// Задача 10: Разворот числа
public class task10 {
    public static int reverseNumber(int n, int reversed) {
        // Базовый случай: когда исходное число стало 0
        if (n == 0) return reversed;

        // Рекурсивный шаг: добавляем последнюю цифру к перевернутому числу
        return reverseNumber(n / 10, reversed * 10 + n % 10);
    }

    public static int reverseNumber(int n) {
        return reverseNumber(n, 0);
    }

    // Простая проверка на наличие нулей в числе
    public static boolean hasZero(int n) {
        while (n > 0) {
            if (n % 10 == 0) return true;
            n /= 10;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Введите число (без нулей): ");

            try {
                String input = scanner.nextLine();
                n = Integer.parseInt(input);

                if (n <= 0) {
                    System.out.println("Ошибка: число должно быть положительным! Попробуйте снова.");
                    continue;
                }

                if (hasZero(n)) {
                    System.out.println("Ошибка: число содержит нули! Попробуйте снова.");
                } else {
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите корректное целое число! Попробуйте снова.");
            }
        }

        System.out.println("Перевернутое число: " + reverseNumber(n));
    }
}