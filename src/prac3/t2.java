package prac3;

import java.util.Random;
import java.util.Scanner;

public class t2{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;

        // Ввод с проверкой
        while (true) {
            System.out.print("Введите натуральное число больше 0: ");
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                if (n > 0) {
                    break;
                }
            }
            System.out.println("Неверный ввод! Попробуйте снова.");
            scanner.nextLine(); // очистка буфера
        }

        // Создание и заполнение первого массива
        int[] firstArray = new int[n];
        Random rand = new Random();

        System.out.print("Первый массив: ");
        for (int i = 0; i < n; i++) {
            firstArray[i] = rand.nextInt(n + 1); // числа от 0 до n
            System.out.print(firstArray[i] + " ");
        }

        // Подсчет четных элементов
        int evenCount = 0;
        for (int num : firstArray) {
            if (num % 2 == 0) {
                evenCount++;
            }
        }

        // Создание второго массива
        if (evenCount > 0) {
            int[] secondArray = new int[evenCount];
            int index = 0;
            for (int num : firstArray) {
                if (num % 2 == 0) {
                    secondArray[index++] = num;
                }
            }

            System.out.print("\nВторой массив (четные элементы): ");
            for (int num : secondArray) {
                System.out.print(num + " ");
            }
        } else {
            System.out.println("\nВ первом массиве нет четных элементов");
        }
    }
}