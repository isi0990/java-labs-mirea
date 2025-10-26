package prac3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class o{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();

        // Способ 1: используя Math.random()
        double[] array1 = new double[size];
        System.out.println("\nМассив сгенерированный Math.random():");
        for (int i = 0; i < size; i++) {
            array1[i] = Math.random() * 100; // числа от 0 до 100
        }
        printArray(array1);

        Arrays.sort(array1);
        System.out.println("Отсортированный массив:");
        printArray(array1);

        // Способ 2: используя класс Random
        double[] array2 = new double[size];
        Random rand = new Random();
        System.out.println("\nМассив сгенерированный классом Random:");
        for (int i = 0; i < size; i++) {
            array2[i] = rand.nextDouble() * 100;
        }
        printArray(array2);

        Arrays.sort(array2);
        System.out.println("Отсортированный массив:");
        printArray(array2);
    }

    public static void printArray(double[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%.2f ", array[i]);
        }
        System.out.println();
    }
}