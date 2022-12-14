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
        this.last = first;
        size = 1;
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

    public Iterator<Item> iterator() {
        return new LinkedIterator(first);
    }

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;

        public Node(Item item, Node<Item> next) {
            this.item = item;
            this.next = next;
        }

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
