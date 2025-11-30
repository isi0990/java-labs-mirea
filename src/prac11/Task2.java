package prac11;

import java.util.*;
import java.text.*;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        sdf.setLenient(false); //unstroguvvod

        Date currentDate = new Date();

        while (true) {
            System.out.print("Введите дату в формате дд.мм.гггг: ");
            String input = scanner.nextLine();

            try {
                Date userDate = sdf.parse(input);

                //не должна быть в будущем
                Date today = new Date();
                if (userDate.after(today)) {
                    System.out.println("Ошибка: введенная дата находится в будущем!");
                    continue;
                }

                System.out.println("Текущая дата: " + sdf.format(currentDate));
                System.out.println("Введенная дата: " + sdf.format(userDate));

                if (userDate.before(currentDate)) {
                    System.out.println("Введенная дата РАНЬШЕ текущей");
                } else if (userDate.after(currentDate)) {
                    System.out.println("Введенная дата ПОЗЖЕ текущей");
                } else {
                    System.out.println("Даты совпадают");
                }
                break;

            } catch (ParseException e) {
                System.out.println("Ошибка! Некорректная дата.");
                System.out.println("Пожалуйста, введите дату еще раз.\n");
            }
        }
        scanner.close();
    }
}