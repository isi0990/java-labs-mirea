package prac3;

import java.util.Random;

public class t{
    public static void main(String[] args) {
        int[] array = new int[4];
        Random rand = new Random();

        // Заполнение массива случайными числами от 10 до 99
        System.out.print("Массив: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(90) + 10; // 10-99
            System.out.print(array[i] + " ");
        }

        // Проверка на строгую возрастающую последовательность
        boolean isIncreasing = true;
        for (int i = 1; i < array.length; i++) {
            if (array[i] <= array[i - 1]) {
                isIncreasing = false;
                break;
            }
        }

        System.out.println("\nМассив " + (isIncreasing ? "является" : "не является") +
                " строго возрастающей последовательностью");
    }
}