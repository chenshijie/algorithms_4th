package com.jason.algs4ex;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node<Item> first = null;
    private Node<Item> last = null;
    private transient int size = 0;

    public Deque() {
    }

    public void pushLeft(Item item) {
        Node<Item> f = first;
        Node<Item> newNode = new Node<>(null, item, first);
        first = newNode;
        if (f == null) {
            last = newNode;
        } else {
            f.prev = newNode;
        }
        size++;
    }

    public void pushRight(Item item) {
        Node<Item> l = last;
        Node<Item> newNode = new Node<>(l, item, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    public Item popLeft() {
        Node<Item> f = first;

        if (f == null) {
            throw new NoSuchElementException();
        }

        Item element = f.item;
        Node<Item> next = f.next;

        f.item = null;
        f.next = null;
        first = next;
        if (next == null) {
            last = null;
        } else {
            next.prev = null;
        }
        size--;
        return element;
    }

    public Item popRight() {
        final Node<Item> l = last;
        if (l == null) {
            throw new NoSuchElementException();
        }
        Item element = l.item;
        Node<Item> prev = l.prev;
        l.item = null;
        l.prev = null; // help GC
        last = prev;
        if (prev == null)
            first = null;
        else
            prev.next = null;
        size--;
        return element;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Item i : this) {
            sb.append(i).append(" ");
        }
        return sb.toString();
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Item> iterator() {
        return new DoubleLinkedIterator(first);
    }

    private static class Node<Item> {
        Item item;
        Node<Item> next;
        Node<Item> prev;

        Node(Node<Item> prev, Item item, Node<Item> next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    private class DoubleLinkedIterator implements Iterator<Item> {
        private Node<Item> current;

        public DoubleLinkedIterator(Node<Item> first) {
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
