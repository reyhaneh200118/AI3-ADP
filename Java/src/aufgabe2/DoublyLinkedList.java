package aufgabe2;

import java.util.*;

public class DoublyLinkedList<T> extends AbstractList<T> {
    private class Node {
        T t;
        Node prev;
        Node next;
    }

    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public DoublyLinkedList(Collection<T> collection) {
        this();
        this.addAll(collection);
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        Node current = head.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.t;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(int index, T t) {
        if (t == null) throw new NullPointerException();
        checkIndex(index);
        Node newNode = new Node();
        newNode.t = t;
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        newNode.prev = current;
        current.next.prev = newNode;
        current.next = newNode;
        size++;
    }

    @Override
    public T remove(int index) {
        if (size == 0) throw new NoSuchElementException("List is empty.");
        checkIndex(index);
        Node current = head.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.prev.next = current.next;
        current.next.prev = current.prev;
        size--;
        return current.t;
    }

    @Override
    public T set(int index, T t) {
        if (t == null) throw new NullPointerException();
        checkIndex(index);
        Node current = head.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        T old = current.t;
        current.t = t;
        return old;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public ListIterator<T> listIterator() {
        return new DllIterator();

    }

    private class DllIterator implements ListIterator<T> {
        private Node lastReturned = null;
        private Node current = head;
        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            lastReturned = current;
            current = current.next;
            cursor++;
            return lastReturned.t;
        }

        @Override
        public boolean hasPrevious() {
            return cursor > 0;
        }

        @Override
        public T previous() {
            if (!hasPrevious()) throw new NoSuchElementException();
            lastReturned = current;
            current = current.prev;
            cursor--;
            return lastReturned.t;
        }

        @Override
        public int nextIndex() {
            return cursor;
        }

        @Override
        public int previousIndex() {
            return cursor - 1;
        }

        @Override
        public void remove() {
            if (lastReturned == null) throw new IllegalStateException();
            Node lastNext = lastReturned.next;
            lastReturned.prev.next = lastNext;
            lastNext.prev = lastReturned.prev;
            size--;
            cursor--;
            lastReturned = null;
        }

        @Override
        public void set(T t) {
            if (lastReturned == null) throw new IllegalStateException();
            lastReturned.t = t;
        }

        @Override
        public void add(T t) {
            Node newNode = new Node();
            newNode.t = t;
            newNode.next = current;
            newNode.prev = current.prev;
            current.prev.next = newNode;
            current.prev = newNode;
            size++;
            cursor++;
            lastReturned = null;
        }
    }


    public static void main(String[] args) {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();

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
        list.stream().forEach(System.out::println);

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
