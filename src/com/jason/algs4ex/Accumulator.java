package com.jason.algs4ex;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Accumulator {
    protected int count = 0;
    protected double total = 0;

    public static void main(String[] args) {
        int T = StdIn.readInt();
        Accumulator a = new Accumulator();
        for (int i = 0; i < T; i++) {
            a.addDataValue(StdRandom.uniformDouble());
        }
        StdOut.println(a);
    }

    double mean() {
        return this.total / this.count;
    }

    @Override
    public String toString() {
        return String.format("Mean (%d values): %7.5f", count, mean());
    }

    public void addDataValue(double val) {
        count++;
        total += val;
    }
}
