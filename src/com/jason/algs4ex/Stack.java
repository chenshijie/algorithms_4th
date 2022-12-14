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

    public int arraySize() {
        return stack.length;
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

    public static Stack<String> copy(Stack<String> stack) {
        Stack<String> result = new Stack<>(stack.size());
        for (String s : stack) {
            result.push(s);
        }
        return result;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    public class ArrayIterator implements Iterator<Item> {
        private int i = 0;

        @Override
        public boolean hasNext() {
            return i < number;
        }

        @Override
        public Item next() {
            return stack[i++];
        }

        @Override
        public void remove() {

        }
    }
}