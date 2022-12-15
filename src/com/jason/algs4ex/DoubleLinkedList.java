package com.jason.algs4ex;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedList<E> implements Iterable<E> {

    private Node<E> first;
    private Node<E> last;
    private transient int size = 0;

    public DoubleLinkedList() {
    }

    public static <E> void addFirst(DoubleLinkedList<E> list, E e) {
        Node<E> f = list.first;
        Node<E> newNode = new Node<>(null, e, list.first);
        list.first = newNode;
        if (f == null) {
            list.last = newNode;
        } else {
            f.prev = newNode;
        }
        list.size++;
    }

    public static <E> void addLast(DoubleLinkedList<E> list, E e) {
        Node<E> l = list.last;
        Node<E> newNode = new Node<>(l, e, null);
        list.last = newNode;
        if (l == null) {
            list.first = newNode;
        } else {
            l.next = newNode;
        }
        list.size++;
    }

    public static <E> E removeFirst(DoubleLinkedList<E> list) {
        Node<E> f = list.first;

        if (f == null) {
            throw new NoSuchElementException();
        }

        E element = f.item;
        Node<E> next = f.next;

        f.item = null;
        f.next = null;
        list.first = next;
        if (next == null) {
            list.last = null;
        } else {
            next.prev = null;
        }
        list.size--;
        return element;
    }

    public static <E> E removeLast(DoubleLinkedList<E> list) {
        final Node<E> l = list.last;
        if (l == null) {
            throw new NoSuchElementException();
        }
        E element = l.item;
        Node<E> prev = l.prev;
        l.item = null;
        l.prev = null; // help GC
        list.last = prev;
        if (prev == null)
            list.first = null;
        else
            prev.next = null;
        list.size--;
        return element;
    }

    public static <E> void addBefore(DoubleLinkedList<E> list, E e, Node<E> node) {
        Node<E> pred = node.prev;
        Node<E> newNode = new Node<>(pred, e, node);
        node.prev = newNode;
        if (pred == null)
            list.first = newNode;
        else
            pred.next = newNode;
        list.size++;
    }

    public static <E> void addAfter(DoubleLinkedList<E> list, E e, Node<E> node) {
        Node<E> next = node.next;
        Node<E> newNode = new Node<>(node, e, next);
        node.next = newNode;
        if (next == null)
            list.last = newNode;
        else
            next.prev = newNode;
        list.size++;
    }

    public static <E> E remove(DoubleLinkedList<E> list, Node<E> e) {
        // assert x != null;
        E element = e.item;
        Node<E> next = e.next;
        Node<E> prev = e.prev;

        if (prev == null) {
            list.first = next;
        } else {
            prev.next = next;
            e.prev = null;
        }

        if (next == null) {
            list.last = prev;
        } else {
            next.prev = prev;
            e.next = null;
        }

        e.item = null;
        list.size--;
        return element;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public Node<E> node(int index) {
        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new DoubleLinkedIterator(first);
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private class DoubleLinkedIterator implements Iterator<E> {
        private Node<E> current;

        public DoubleLinkedIterator(Node<E> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            E item = current.item;
            current = current.next;
            return item;
        }
    }
}
