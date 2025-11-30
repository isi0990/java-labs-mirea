package prac11;

import java.util.*;
import java.text.*;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Год: ");
            int year = scanner.nextInt();
            System.out.print("Месяц (1-12): ");
            int month = scanner.nextInt();
            System.out.print("Число: ");
            int day = scanner.nextInt();
            System.out.print("Часы: ");
            int hours = scanner.nextInt();
            System.out.print("Минуты: ");
            int minutes = scanner.nextInt();

            // Проверка корректности
            if (month < 1 || month > 12 || day < 1 || day > 31 ||
                    hours < 0 || hours > 23 || minutes < 0 || minutes > 59) {
                throw new IllegalArgumentException("Некорректные данные");
            }

            Calendar cal = Calendar.getInstance();
            cal.set(year, month-1, day, hours, minutes);
            Date date = cal.getTime();

            System.out.println("Calendar: " + cal.getTime());
            System.out.println("Date: " + date);

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        scanner.close();
    }
}