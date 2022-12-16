package com.jason.algs4ex.chapter1;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
1.3.32 Steque. A stack-ended queue or steque is a data type that supports push, pop, and
enqueue. Articulate an API for this ADT. Develop a linked-list-based implementation.
 */
public class Ex1_3_32 {

    public static void main(String[] args) {
        Steque<Integer> sq = new Steque<>();
        for (int i = 0; i < 10; i++) {
            sq.enqueue(i);
        }

        for (int i : sq) {
            StdOut.print(i + " ");
        }
        StdOut.println();

        StdOut.println("sq.dequeue(): " + sq.dequeue());
        StdOut.println("sq: " + sq);

        sq.push(99);
        StdOut.println("sq.push(99)");
        StdOut.println("sq: " + sq);

        StdOut.println("sq.pop(): " + sq.pop());
        StdOut.println("sq: " + sq);
    }
}

class Steque<Item> implements Iterable<Item> {
    private Node<Item> first;
    private Node<Item> last;
    private int N;

    public Steque() {
        first = null;
        last = null;
        N = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(Item item) {
        enqueue(item);
    }

    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException();
        Node<Item> oldLast = last;
        Item element = oldLast.item;
        last = oldLast.prev;
        last.next = null;
        oldLast.setNull();
        return element;
    }

    public void enqueue(Item item) {
        Node<Item> oldLast = last;
        last = new Node<>(oldLast, item, null);
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        N++;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node<Item> f = first;
        Item item = f.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }

        f.setNull(); //help gc

        N--;
        return item;
    }

    public int size() {
        return N;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<Item> node = first;
        while (node != null) {
            sb.append(node.item).append(" ");
            node = node.next;
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
        return new ListIterator();
    }

    static class Node<Item> {
        Item item;
        Node<Item> next;
        Node<Item> prev;

        public Node(Node<Item> prev, Item item, Node<Item> next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }

        public void setNull() {
            item = null;
            next = null;
            prev = null;
        }
    }

    private class ListIterator implements Iterator<Item> {
        private Node<Item> current = first;

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