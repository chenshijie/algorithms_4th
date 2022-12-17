package com.jason.algs4ex;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int N;

    public Queue() {
        first = new Node();
        first.next = null;
        first = last;
        N = 0;
    }

    public Queue(Queue<Item> queue) {
        for (Item item : queue) {
            enqueue(item);
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        N++;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        N--;
        return item;
    }

    public Item delete(int k) {
        if (k < 1 && k > N) {
            throw new NoSuchElementException();
        }
        if (k == 1) {
            return dequeue();
        } else {
            Node prev = first;
            Node current = first.next;

            for (int i = 1; i < N; i++) {
                if (i == k - 1) {
                    break;
                }
                prev = current;
                current = current.next;
            }

            if (last == current) {
                last = prev;
            }
            Item item = current.item;
            prev.next = current.next;

            current.item = null;
            current.next = null;
            N--;
            return item;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Item item : this) {
            sb.append(item).append(" ");
        }
        return sb.toString();
    }

    public int size() {
        return N;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    class Node {
        Item item;
        Node next;
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
        }
    }
}