package prac10;

import java.util.Comparator;
import java.util.List;

public class MergeSort {
    public static void sort(List<Student> students, Comparator<Student> comp) {
        if (students.size() <= 1) return;

        int mid = students.size() / 2;
        List<Student> left = new java.util.ArrayList<>(students.subList(0, mid));
        List<Student> right = new java.util.ArrayList<>(students.subList(mid, students.size()));

        sort(left, comp);
        sort(right, comp);

        merge(students, left, right, comp);
    }

    private static void merge(List<Student> students, List<Student> left, List<Student> right, Comparator<Student> comp) {
        int i = 0, j = 0, k = 0;

        while (i < left.size() && j < right.size()) {
            if (comp.compare(left.get(i), right.get(j)) <= 0) {
                students.set(k++, left.get(i++));
            } else {
                students.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) {
            students.set(k++, left.get(i++));
        }

        while (j < right.size()) {
            students.set(k++, right.get(j++));
        }
    }
}