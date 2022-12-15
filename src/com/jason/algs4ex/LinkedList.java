package com.jason.algs4ex;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<Item> implements Iterable<Item> {
    private Node<Item> first;
    private Node<Item> last;
    private transient int size;

    public LinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    public LinkedList(Node<Item> first) {
        this.first = first;
        refresh();
    }

    public static int maxByRecursion(LinkedList<Integer> list) {

        if (list.first == null)
            return 0;

        LinkedList<Integer> newList = new LinkedList<>(list.first.next);
        int max = maxByRecursion(newList);

        if (list.getFirst() > max)
            return list.getFirst();
        else
            return max;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void addFirst(Item item) {
        this.first = new Node<>(item, this.first);
        size++;
    }

    public void addLast(Item item) {
        Node<Item> newNode = new Node<>(item, null);
        if (last == null) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        size++;
    }

    public Item getFirst() {
        final Node<Item> f = first;
        if (f == null) {
            throw new NoSuchElementException();
        }
        return f.item;
    }

    public Item getLast() {
        final Node<Item> l = last;
        if (l == null) {
            throw new NoSuchElementException();
        }
        return l.item;
    }

    public Item removeFirst() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        Node<Item> oldFirst = first;
        Item element = oldFirst.item;

        first = oldFirst.next;
        oldFirst.item = null;
        oldFirst.next = null;
        if (first == null) {
            last = null;
        }

        size--;
        return element;
    }

    public Item removeLast() {
        if (last == null) {
            throw new NoSuchElementException();
        }
        Item element = last.item;

        Node<Item> nodeBeforeLast = findNodeBeforeLast();
        if (nodeBeforeLast == first) {
            first = null;
            last = null;
        } else {
            last = nodeBeforeLast;
            last.next = null;
        }

        size--;
        return element;
    }

    public Item delete(int position) {
        int index = position - 1;
        if (isInvalidIndex(index)) {
            throw new NoSuchElementException();
        }
        if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        }

        Node<Item> x = findNode(index - 1);
        Node<Item> deleteNode = x.next;
        Item element = deleteNode.item;
        x.next = deleteNode.next;

        deleteNode.item = null;
        deleteNode.next = null;

        size--;
        return element;
    }

    public void removeAfter(Node<Item> itemNode) {
        if (itemNode == null || itemNode.next == null) {
            return;
        }
        Node<Item> current = itemNode.next;
        itemNode.next = null;

        while (current != null) {
            Node<Item> temp = current.next;
            current.next = null;
            current.item = null;
            current = temp;
        }
    }

    public void remove(Item item) {
        if (first == null) {
            return;
        }
        Node<Item> current = first;
        Node<Item> pre = first;
        while (current != null) {
            if (current.item.equals(item)) {
                if (current == first) {
                    removeFirst();
                    pre = first;
                    current = first;
                } else {
                    Node<Item> next = current.next;
                    current.next = null;
                    current.item = null;
                    pre.next = next;
                    current = next;
                    size--;
                }
            } else {
                pre = current;
                current = current.next;
            }
        }
    }

    public static int max(LinkedList<Integer> list) {
        if (list.isEmpty()) {
            return 0;
        }
        int max = list.getFirst();
        for (int e : list) {
            if (max < e) {
                max = e;
            }
        }
        return max;
    }

    private void refresh() {
        if (first == null) {
            this.size = 0;
            this.last = null;
            return;
        }
        int size = 0;
        Node<Item> current = first;
        while (current.next != null) {
            size++;
            current = current.next;
        }
        last = current;
        this.size = size;
    }

    public void insertAfter(Node<Item> itemNode, Node<Item> newNode) {
        if (itemNode == null || newNode == null) {
            return;
        }
        newNode.next = itemNode.next;
        itemNode.next = newNode;
    }

    public Node<Item> findNode(int index) {
        if (isInvalidIndex(index)) {
            throw new NoSuchElementException();
        }
        Node<Item> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public boolean find(Item item) {

        Node<Item> current = first;
        while (current != null) {
            if (current.item.equals(item)) {
                return true;
            }
            if (current == last) {
                return false;
            }
            current = current.next;
        }
        return false;
    }

    public boolean isInvalidIndex(int index) {
        return index < 0 || index >= size;
    }


    public Node<Item> findNodeBeforeLast() {
        Node<Item> current = first;

        while (current.next != null && current.next.next != null) {
            current = current.next;
        }

        return current;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<Item> temp = first;
        while (temp != null) {
            Item item = temp.item;
            sb.append(item).append(" ");
            temp = temp.next;
        }

        return sb.toString();
    }

    public int size() {
        return size;
    }

    public Node<Item> generateNode(Item item) {
        return new Node<>(item, null);
    }

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;

        public Node(Item item, Node<Item> next) {
            this.item = item;
            this.next = next;
        }

    }

    public Iterator<Item> iterator() {
        return new LinkedIterator(first);
    }

    private class LinkedIterator implements Iterator<Item> {
        private Node<Item> current;

        public LinkedIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

}
