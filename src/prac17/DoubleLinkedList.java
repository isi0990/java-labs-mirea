package prac17;

public class DoubleLinkedList {
    private DoubleNode head;
    private DoubleNode tail;

    public DoubleLinkedList() {
        head = null;
        tail = null;
    }

    public void add(DoubleNode newNode) {
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
        System.out.println("Элемент добавлен в список");
    }

    public void remove(String name) {
        if (head == null) {
            System.out.println("список пуст");
            return;
        }

        DoubleNode current = head;
        while (current != null && !current.getName().equals(name)) {
            current = current.getNext();
        }

        if (current == null) {
            System.out.println("Элемент не найден");
        }

        if (current == head) {
            head = head.getNext();
            if (head != null) {
                head.setPrev(null);
            } else {
                tail = null;
            }
        } else if (current == tail) {
            tail = tail.getPrev();
            if (tail != null) {
                tail.setNext(null);
            } else {
                head = null;
            }
        } else {
            current.getPrev().setNext(current.getNext());
            current.getNext().setPrev(current.getPrev());
        }
        System.out.println("Элемент удален");
    }

    public void display() {
        if (head == null) {
            System.out.println("Список пуст");
            return;
        }

        DoubleNode current = head;
        int index = 1;
        while (current != null) {
            System.out.print(index + ". ");
            current.display();
            current = current.getNext();
            index++;
        }
    }

    public void clear() {
        head = null;
        tail = null;
        System.out.println("Список очищен");
    }

    public boolean isEmpty() {
        return head == null;
    }
}
