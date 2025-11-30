package prac17;

import java.util.Scanner;

public class DoubleNode {
    private String name;
    private int age;
    private DoubleNode next;
    private DoubleNode prev;

    public DoubleNode(String name, int age) {
        this.name = name;
        this.age = age;
        this.next = null;
        this.prev = null;
    }

    public void inputFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("введите имя: ");
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
    public DoubleNode getNext() {return next;}
    public void setNext(DoubleNode next) {this.next = next;}
    public DoubleNode getPrev() {return prev;}
    public void setPrev(DoubleNode prev) {this.prev = prev;}
}
