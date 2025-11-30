package prac17;

import java.util.Scanner;

public class Node {
    private String name;
    private int age;
    private Node next;

    public Node(String name, int age) {
        this.name = name;
        this.age = age;
        this.next = null;
    }

    public void inputFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя: ");
        this.name = scanner.nextLine();
        System.out.print("Введите возраст: ");
        this.age = scanner.nextInt();
        scanner.nextLine();
    }

    public void display() {
        System.out.println("Имя: " + name + ", Возраст: " + age);
    }

    public String getName() {return name;}
    public int getAge() {return age;}
    public Node getNext() {return next;}
    public void setNext(Node next) {this.next = next;}
}
