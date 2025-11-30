package prac10;

import java.util.*;

public class SortingStudentsByGPA {
    private List<Student> iDNumber;
    private Comparator<Student> comparator;

    public SortingStudentsByGPA() {
        iDNumber = new ArrayList<>();
        comparator = new GPAComparator();
    }

    // Заполнение массива
    public void setArray(List<Student> students) {
        iDNumber.clear();
        iDNumber.addAll(students);
    }

    // Быстрая сортировка
    public void quicksort() {
        quicksort(0, iDNumber.size() - 1);
    }

    private void quicksort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);
            quicksort(low, pi - 1);
            quicksort(pi + 1, high);
        }
    }

    private int partition(int low, int high) {
        Student pivot = iDNumber.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (comparator.compare(iDNumber.get(j), pivot) <= 0) {
                i++;
                Collections.swap(iDNumber, i, j);
            }
        }

        Collections.swap(iDNumber, i + 1, high);
        return i + 1;
    }

    // Сортировка слиянием
    public void mergeSort() {
        MergeSort.sort(iDNumber, comparator);
    }

    // Вывод массива
    public void outArray() {
        for (Student student : iDNumber) {
            System.out.println(student);
        }
    }

    // Сортировка по другому полю (по имени)
    public void sortByFirstName() {
        iDNumber.sort(Comparator.comparing(Student::getFirstName));
    }

    // Объединение двух списков
    public void mergeLists(List<Student> list1, List<Student> list2) {
        iDNumber.clear();
        iDNumber.addAll(list1);
        iDNumber.addAll(list2);
        mergeSort();
    }

    public static void main(String[] args) {
        SortingStudentsByGPA sorter = new SortingStudentsByGPA();

        // Создание первого списка
        List<Student> list1 = Arrays.asList(
                new Student("Иван", "Иванов", "Информатика", 2, "ИС-21", 4.5),
                new Student("Петр", "Петров", "Математика", 1, "МАТ-11", 3.8),
                new Student("Анна", "Сидорова", "Физика", 3, "ФИЗ-31", 4.2)
        );

        // Создание второго списка
        List<Student> list2 = Arrays.asList(
                new Student("Мария", "Васильева", "Химия", 2, "ХИМ-22", 4.8),
                new Student("Алексей", "Николаев", "Биология", 1, "БИО-11", 3.9)
        );

        // Тестирование быстрой сортировки
        System.out.println("=== Быстрая сортировка по среднему баллу (убывание) ===");
        sorter.setArray(new ArrayList<>(list1));
        sorter.quicksort();
        sorter.outArray();

        // Тестирование сортировки слиянием
        System.out.println("\n=== Сортировка слиянием по среднему баллу (убывание) ===");
        sorter.setArray(new ArrayList<>(list2));
        sorter.mergeSort();
        sorter.outArray();

        // Тестирование сортировки по имени
        System.out.println("\n=== Сортировка по имени ===");
        sorter.setArray(new ArrayList<>(list1));
        sorter.sortByFirstName();
        sorter.outArray();

        // Объединение списков
        System.out.println("\n=== Объединенный отсортированный список ===");
        sorter.mergeLists(list1, list2);
        sorter.outArray();
    }
}