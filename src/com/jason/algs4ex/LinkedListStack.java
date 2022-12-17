package com.jason.algs4ex;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListStack<Item> implements Iterable<Item> {
    private Node<Item> first;
    private Node<Item> last;
    private transient int size;

    public LinkedListStack() {
        first = null;
        last = null;
        size = 0;
    }

    public LinkedListStack(Node<Item> first) {
        this.first = first;
        refresh();
    }

    public LinkedListStack(LinkedListStack<Item> stack) {
        for (Item item : stack) {
            push(item);
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(Item item) {
        Node<Item> newNode = new Node<>(item, null);
        if (last == null) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        size++;
    }

    public Item pop() {
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
