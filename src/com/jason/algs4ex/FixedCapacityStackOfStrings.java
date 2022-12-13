package com.jason.algs4ex;

import edu.princeton.cs.algs4.StdOut;

public class FixedCapacityStackOfStrings {

    private final String[] stack;
    private int number;

    public FixedCapacityStackOfStrings(int cap) {
        this.stack = new String[cap];
        this.number = 0;
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

    public void push(String s) {
        if (isFull()) {
            StdOut.println("Stack is full");
        } else {
            this.stack[number++] = s;
        }
    }

    public String pop() {
        String s = stack[--number];
        stack[number] = null;
        return s;
    }
}