package com.jason.algs4ex;

import java.util.Arrays;
import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
    private Item[] stack;
    private int number;

    public Stack(int cap) {
        this.stack = (Item[]) new Object[cap];
        this.number = 0;
    }

    public Stack() {
        this(10);
    }

    public boolean isEmpty() {
        return this.number == 0;
    }

    public boolean isFull() {
        return stack.length == number;
    }

    public int size() {
        return this.number;
    }

    public void push(Item item) {
        if (isFull()) {
            resize(2 * stack.length);
        }
        this.stack[number++] = item;
    }

    public Item pop() {
        Item item = stack[--number];
        stack[number] = null;
        if (number > 0 && number == stack.length / 4) {
            resize(stack.length / 2);
        }
        return item;
    }

    public Item peek() {
        return stack[number - 1];
    }

    public void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        if (number >= 0) System.arraycopy(stack, 0, temp, 0, number);
        stack = temp;
    }

    public String toString() {
        return Arrays.toString(Arrays.copyOf(stack, number));
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    public class ReverseArrayIterator implements Iterator<Item> {
        private int i = number;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return stack[--i];
        }

        @Override
        public void remove() {

        }
    }
}