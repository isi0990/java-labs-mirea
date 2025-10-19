import java.util.Scanner;

public class task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int n = scanner.nextInt();
        int[] array = new int[n];
        int i = 0;
        do {
            System.out.print("Введите элемент " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
            i++;
        } while (i < n);

        int sum = 0, max = array[0], min = array[0];
        i = 0;
        while (i < n) {
            sum += array[i];
            if (array[i] > max) max = array[i];
            if (array[i] < min) min = array[i];
            i++;
        }
        System.out.println("Сумма: " + sum);
        System.out.println("Максимум: " + max);
        System.out.println("Минимум: " + min);
    }
}