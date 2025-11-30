package prac9;

import java.util.Comparator;

public class SortingStudentsByGPA implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        return Double.compare(s2.getGPA(), s1.getGPA()); // Убывающий порядок
    }

    public void quickSort(Student[] list, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(list, low, high);
            quickSort(list, low, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, high);
        }
    }

    private int partition(Student[] list, int low, int high) {
        Student pivot = list[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (compare(list[j], pivot) > 0) {
                i++;
                swap(list, i, j);
            }
        }
        swap(list, i + 1, high);
        return i + 1;
    }

    private void swap(Student[] list, int i, int j) {
        Student temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    public static void main(String[] args) {
        Student[] students = {
                new Student(103, "Alice", 3.8),
                new Student(101, "Bob", 3.5),
                new Student(102, "Charlie", 4.0),
                new Student(100, "David", 3.9)
        };

        System.out.println("До сортировки по GPA:");
        for (Student student : students) {
            System.out.println(student);
        }

        SortingStudentsByGPA sorter = new SortingStudentsByGPA();
        sorter.quickSort(students, 0, students.length - 1);

        System.out.println("\nПосле быстрой сортировки по GPA:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
