package prac2;

import java.util.ArrayList;

class Shop {
    private ArrayList<String> computers = new ArrayList<>();

    public void addComputer(String computer) {
        computers.add(computer);
        System.out.println("Компьютер '" + computer + "' добавлен в магазин");
    }

    public void removeComputer(String computer) {
        if (computers.remove(computer)) {
            System.out.println("Компьютер '" + computer + "' удален из магазина");
        } else {
            System.out.println("Компьютер '" + computer + "' не найден в магазине");
        }
    }

    public void findComputer(String computer) {
        if (computers.contains(computer)) {
            System.out.println("Компьютер '" + computer + "' найден в магазине");
        } else {
            System.out.println("Компьютер '" + computer + "' не найден в магазине");
        }
    }

    public void showComputers() {
        if (computers.isEmpty()) {
            System.out.println("Магазин пуст");
        } else {
            System.out.println("Компьютеры в магазине:");
            for (String computer : computers) {
                System.out.println("- " + computer);
            }
        }
    }
}