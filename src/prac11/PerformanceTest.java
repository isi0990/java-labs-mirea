package prac11;

import java.util.*;

public class PerformanceTest {
    public static void main(String[] args) {
        int size = 100000;

        // Создаем коллекции
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        System.out.println("Сравнение производительности ArrayList vs LinkedList");
        System.out.println("Размер теста: " + size + " элементов\n");


        System.out.println("1. Добавление в конец:");
        long startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            arrayList.add(i);
        }
        long arrayListTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            linkedList.add(i);
        }
        long linkedListTime = System.nanoTime() - startTime;
        printResults("Добавление в конец", arrayListTime, linkedListTime);


        System.out.println("\n2. Вставка в начало:");
        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            arrayList.add(0, i);
        }
        arrayListTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            linkedList.add(0, i);
        }
        linkedListTime = System.nanoTime() - startTime;
        printResults("Вставка в начало", arrayListTime, linkedListTime);

        System.out.println("\n3. Вставка в середину:");
        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            arrayList.add(arrayList.size()/2, i);
        }
        arrayListTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            linkedList.add(linkedList.size()/2, i);
        }
        linkedListTime = System.nanoTime() - startTime;
        printResults("Вставка в середину", arrayListTime, linkedListTime);

        System.out.println("\n4. Удаление из начала:");
        List<Integer> arrayListCopy1 = new ArrayList<>(arrayList);
        List<Integer> linkedListCopy1 = new LinkedList<>(linkedList);

        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            arrayListCopy1.remove(0);
        }
        arrayListTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            linkedListCopy1.remove(0);
        }
        linkedListTime = System.nanoTime() - startTime;
        printResults("Удаление из начала", arrayListTime, linkedListTime);

        // Тест удаления из конца
        System.out.println("\n5. Удаление из конца:");
        List<Integer> arrayListCopy2 = new ArrayList<>(arrayList);
        List<Integer> linkedListCopy2 = new LinkedList<>(linkedList);

        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            arrayListCopy2.remove(arrayListCopy2.size()-1);
        }
        arrayListTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            linkedListCopy2.remove(linkedListCopy2.size()-1);
        }
        linkedListTime = System.nanoTime() - startTime;
        printResults("Удаление из конца", arrayListTime, linkedListTime);

        // Тест поиска по индексу
        System.out.println("\n6. Поиск по индексу (доступ по индексу):");
        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            arrayList.get(i);
        }
        arrayListTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            linkedList.get(i);
        }
        linkedListTime = System.nanoTime() - startTime;
        printResults("Поиск по индексу", arrayListTime, linkedListTime);

        // Тест поиска по значению
        System.out.println("\n7. Поиск по значению:");
        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            arrayList.contains(i);
        }
        arrayListTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            linkedList.contains(i);
        }
        linkedListTime = System.nanoTime() - startTime;
        printResults("Поиск по значению", arrayListTime, linkedListTime);
    }

    private static void printResults(String operation, long arrayListTime, long linkedListTime) {
        System.out.println(operation + ":");
        System.out.printf("  ArrayList:  %10d ns\n", arrayListTime);
        System.out.printf("  LinkedList: %10d ns\n", linkedListTime);

        if (arrayListTime < linkedListTime) {
            double faster = (double) linkedListTime / arrayListTime;
            System.out.printf("  ArrayList быстрее в %.2f раз\n", faster);
        } else {
            double faster = (double) arrayListTime / linkedListTime;
            System.out.printf("  LinkedList быстрее в %.2f раз\n", faster);
        }
    }
}