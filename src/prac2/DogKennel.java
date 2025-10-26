package prac2;

import java.util.ArrayList;

public class DogKennel {
    private ArrayList<Dog> dogs = new ArrayList<>();

    public void addDog(Dog dog) {
        dogs.add(dog);
        System.out.println("Собака добавлена: " + dog.getName());
    }

    public void showAllDogs() {
        if (dogs.isEmpty()) {
            System.out.println("В питомнике нет собак");
        } else {
            System.out.println("\n=== СОБАКИ В ПИТОМНИКЕ ===");
            for (Dog dog : dogs) {
                System.out.println(dog);
            }
        }
    }

    public void findDogByName(String name) {
        for (Dog dog : dogs) {
            if (dog.getName().equalsIgnoreCase(name)) {
                System.out.println("Найдена: " + dog);
                return;
            }
        }
        System.out.println("Собака с именем '" + name + "' не найдена");
    }

    public static void main(String[] args) {
        DogKennel kennel = new DogKennel();

        kennel.addDog(new Dog("Бобик", 3));
        kennel.addDog(new Dog("Шарик", 5));
        kennel.addDog(new Dog("Мухтар", 2));

        kennel.showAllDogs();
        kennel.findDogByName("Шарик");
    }
}