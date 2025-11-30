package prac14;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Prices {
    public static void extractCurrencies(String text) {
        if (text == null || text.trim().isEmpty()) {
            System.out.println("Ошибка. Текст пуст.");
            return;
        }


        String regex = "\\b((?:[1-9]\\d*|0)(?:\\.\\d{1,2})?)\\s*(USD|RUB|EU)\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        boolean found = false;
        while (matcher.find()) {
            System.out.println("Найдена цена: " + matcher.group(1) + " " + matcher.group(2));
            found = true;
        }

        if (!found) {
            System.out.println("Цены не найдены");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите текст для извлечения цен: ");
        String text = scanner.nextLine();
        extractCurrencies(text);
        scanner.close();
    }
}
