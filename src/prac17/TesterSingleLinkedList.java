package prac17;

import java.util.Scanner;

public class TesterSingleLinkedList {
    private static Scanner scanner = new Scanner(System.in);
    private static SingleLinkedList singleList = new SingleLinkedList();

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            System.out.println("\nОдносвязный список");
            System.out.println("1. Добавить элемент");
            System.out.println("2. Удалить элемент");
            System.out.println("3. Вывести все элементы");
            System.out.println("4. Очистить список");
            System.out.println("5. Проверить на пустоту");
            System.out.println("6. Выход");
            System.out.println("Выберите опцию: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Node newNode = new Node("", 0);
                    newNode.inputFromConsole();
                    singleList.add(newNode);
                    break;
                case 2:
                    System.out.print("Введите имя для удаления: ");
                    String nameToRemove = scanner.nextLine();
                    singleList.remove(nameToRemove);
                    break;
                case 3:
                    singleList.display();
                    break;
                case 4:
                    singleList.clear();
                    break;
                case 5:
                    System.out.println("Список " + (singleList.isEmpty() ? "пуст" : "не пуст"));
                    break;
                case 6:
                    exit = true;
                    System.out.println("Выход из программы");
                    break;
                default:
                    System.out.println("Неверный выбор");
            }
        }
    }
}
