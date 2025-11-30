package prac9;

public class MergeSortStudents {

    public static Student[] mergeSort(Student[] array) {
        if (array.length <= 1) {
            return array;
        }

        int mid = array.length / 2;
        Student[] left = new Student[mid];
        Student[] right = new Student[array.length - mid];

        System.arraycopy(array, 0, left, 0, left.length);
        System.arraycopy(array, mid, right, 0, right.length);

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    private static Student[] merge(Student[] left, Student[] right) {
        Student[] merged = new Student[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) <= 0) {
                merged[k++] = left[i++];
            } else {
                merged[k++] = right[j++];
            }
        }

        while (i < left.length) {
            merged[k++] = left[i++];
        }

        while (j < right.length) {
            merged[k++] = right[j++];
        }

        return merged;
    }

    public static Student[] mergeTwoLists(Student[] list1, Student[] list2) {
        Student[] combined = new Student[list1.length + list2.length];
        System.arraycopy(list1, 0, combined, 0, list1.length);
        System.arraycopy(list2, 0, combined, list1.length, list2.length);

        return mergeSort(combined);
    }

    public static void main(String[] args) {
        Student[] list1 = {
                new Student(101, "Alice", 3.8),
                new Student(103, "Charlie", 4.0)
        };

        Student[] list2 = {
                new Student(102, "Bob", 3.5),
                new Student(104, "David", 3.9),
                new Student(100, "Eve", 3.7)
        };

        System.out.println("Первый список:");
        for (Student student : list1) {
            System.out.println(student);
        }

        System.out.println("\nВторой список:");
        for (Student student : list2) {
            System.out.println(student);
        }

        Student[] merged = mergeTwoLists(list1, list2);

        System.out.println("\nОбъединенный отсортированный список:");
        for (Student student : merged) {
            System.out.println(student);
        }
    }
}
