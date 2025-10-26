package prac2;

import java.util.Scanner;

public class TestShop {
    public static void main(String[] args) {
        Shop shop = new Shop();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== МЕНЮ МАГАЗИНА ===");
            System.out.println("1. Добавить компьютер");
            System.out.println("2. Удалить компьютер");
            System.out.println("3. Найти компьютер");
            System.out.println("4. Показать все компьютеры");
            System.out.println("5. Выход");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введите название компьютера: ");
                    String computerToAdd = scanner.nextLine();
                    shop.addComputer(computerToAdd);
                    break;
                case 2:
                    System.out.print("Введите название компьютера для удаления: ");
                    String computerToRemove = scanner.nextLine();
                    shop.removeComputer(computerToRemove);
                    break;
                case 3:
                    System.out.print("Введите название компьютера для поиска: ");
                    String computerToFind = scanner.nextLine();
                    shop.findComputer(computerToFind);
                    break;
                case 4:
                    shop.showComputers();
                    break;
                case 5:
                    System.out.println("Выход из программы");
                    return;
                default:
                    System.out.println("Неверный выбор!");
            }
        }
    }
}