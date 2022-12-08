package com.jason.algs4ex;

public class Counter implements Comparable<Counter> {

    private final String name;

    private int count = 0;

    public Counter(String id) {
        this.name = id;
    }

    public static void main(String[] args) {

    }

    public void increment() {
        count++;
    }

    public String toString() {
        return count + " " + name;
    }

    public int tally() {
        return count;
    }

    @Override
    public int compareTo(Counter o) {
        if (this.count < o.count) {
            return -1;
        } else if (this.count > o.count) {
            return 1;
        }
        return 0;
    }
}
