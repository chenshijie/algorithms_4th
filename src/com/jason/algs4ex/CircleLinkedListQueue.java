package com.jason.algs4ex;

import java.util.Iterator;

public class CircleLinkedListQueue<Item> implements Iterable<Item> {
    private Node<Item> last;
    private int N;

    public CircleLinkedListQueue() {
        last = null;
        N = 0;
    }

    public boolean isEmpty() {
        return last == null;
    }

    public void enqueue(Item item) {
        Node<Item> newNode = new Node<>();
        newNode.item = item;

        if (isEmpty()) {
            last = newNode;
            last.next = last;
        } else {
            Node<Item> oldLast = last;
            last = newNode;
            last.next = oldLast.next;
            oldLast.next = last;
        }
        N++;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        Node<Item> first = last.next;

        Item item = first.item;
        if (last == last.next) {
            last = null;
        } else {
            last.next = first.next;
        }

        N--;
        return item;
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
        return new CircleLinkedListIterator();
    }

    static class Node<Item> {
        Item item;
        Node<Item> next;
    }

    private class CircleLinkedListIterator implements Iterator<Item> {
        private Node<Item> current = last;
        private boolean loopEnd = false;

        @Override
        public boolean hasNext() {
            return last != null && (!loopEnd || current != last);
        }

        @Override
        public Item next() {
            Item item = current.next.item;
            current = current.next;
            if (current == last && !loopEnd) {
                loopEnd = true;
            }
            return item;
        }

        @Override
        public void remove() {
        }
    }
}