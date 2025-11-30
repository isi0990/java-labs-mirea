package prac9;

import java.util.Comparator;


public class InsertionSortTest {

    public static void insertionSort(Comparable[] list) {
        for (int i = 1; i < list.length; i++) {
            Comparable key = list[i];
            int j = i - 1;
            while (j >= 0 && list[j].compareTo(key) > 0) {
                list[j + 1] = list[j];
                j--;
            }
            list[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Student[] students = {
                new Student(103, "Alice", 3.8),
                new Student(101, "Bob", 3.5),
                new Student(102, "Charlie", 4.0),
                new Student(100, "David", 3.9)
        };

        System.out.println("До сортировки:");
        for (Student student : students) {
            System.out.println(student);
        }

        insertionSort(students);

        System.out.println("\nПосле сортировки вставками по iDNumber:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
