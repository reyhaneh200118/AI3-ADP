package aufgabe2.dll;

import java.util.*;

public class DoublyLinkedList<T> extends AbstractList<T> {
    private class Node {
        T t;
        Node prev;
        Node next;
    }

    private final Node head;
    private final Node tail;
    private int size;

    public DoublyLinkedList() {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public DoublyLinkedList(Collection<? extends T> collection) {
        this();
        this.addAll(collection);
    }

    @Override
    public T get(int index) {
        checkIndex(index, size - 1);
        Node current = getNode(index);
        return current.t;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(int index, T t) {
        if (t == null) throw new NullPointerException();
        checkIndex(index, size);
        Node newNode = new Node();
        newNode.t = t;
        Node current = getNode(index);
        newNode.next = current;
        newNode.prev = current.prev;
        current.prev.next = newNode;
        current.prev = newNode;
        size++;
    }

    @Override
    public T remove(int index) {
        if (size == 0) throw new NoSuchElementException("List is empty.");
        checkIndex(index, size - 1);
        Node current = getNode(index);
        current.prev.next = current.next;
        current.next.prev = current.prev;
        size--;
        return current.t;
    }

    @Override
    public T set(int index, T t) {
        if (t == null) throw new NullPointerException();
        checkIndex(index, size - 1);
        Node current = getNode(index);
        T old = current.t;
        current.t = t;
        return old;
    }

    private Node getNode(int index) {
        Node current;
        if (index > size / 2) {
            current = tail.prev;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        } else {
            current = head.next;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        }

        return current;
    }

    private void checkIndex(int index, int max) {
        if (index < 0 || index > max) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new DllIterator();
    }

    private class DllIterator implements Iterator<T> {
        private Node current = head.next;
        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            Node lastReturned = current;
            current = current.next;
            cursor++;
            return lastReturned.t;
        }
    }


    public static void main(String[] args) {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();

        // a.
        // am Ende der Liste
        list.add("second");
        list.add(1, "last");
        // am Anfang der Liste
        list.add(0, "first");
        // in der Mitte der Liste
        list.add(2, "something");
        list.add(2, "something");
        list.add(2, "something");
        list.add(list.size() / 2, "middle");
        System.out.println(list);

        // b.
        list.set(3, "modified");
        System.out.println(list);

        // c.
        list.remove(0);
        list.remove(list.size() - 1);
        list.remove(list.size() / 2);
        System.out.println(list);

        // e. -> wird hier explizit nach Iterator gefragt?
        for (String s : list) {
            System.out.println(s);
        }
//        while (list.iterator().hasNext()) {
//            System.out.println(list.iterator().next());
//        }

        // f. -> kann it .forEach() vereinfacht werden (seit Java 19)
        list.forEach(System.out::println);

        // g.
        System.out.println(Arrays.toString(list.toArray()));

        // d.
        list.clear();
        System.out.println(list);

        // h.
        Set<String> set = new HashSet<>();
        set.add("first");
        set.add("second");
        set.add("third");

        DoublyLinkedList<String> list2 = new DoublyLinkedList<>(set);
        System.out.println(list2);

        List<String> arrayList = new ArrayList<>();
        arrayList.add("first");
        arrayList.add("second");
        arrayList.add("third");

        DoublyLinkedList<String> list3 = new DoublyLinkedList<>(arrayList);
        System.out.println(list3);
    }

}
