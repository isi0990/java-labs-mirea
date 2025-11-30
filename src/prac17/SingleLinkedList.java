package prac17;

public class SingleLinkedList {
    private Node head;

    public SingleLinkedList() {
        head = null;
    }

    public void add(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        System.out.println("Элемент добавлен в список");
    }

    public void remove(String name) {
        if (head == null) {
            System.out.println("Список пуст");
            return;
        }

        if (head.getName().equals(name)) {
            head = head.getNext();
            System.out.println("Элемент удален");
            return;
        }

        Node current = head;
        while (current.getNext() != null && !current.getNext().getName().equals(name)) {
            current = current.getNext();
        }

        if (current.getNext() != null) {
            current.setNext(current.getNext().getNext());
            System.out.println("Элемент удален");
        } else {
            System.out.println("Элемент не найден");
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("Список пуст");
            return;
        }

        Node current = head;
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
        System.out.println("Список очищен");
    }

    public boolean isEmpty() {
        return head == null;
    }
}
