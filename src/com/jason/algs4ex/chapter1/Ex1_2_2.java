package com.jason.algs4ex.chapter1;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
1.2.2 Write an Interval1D client that takes an int value N as command-line argument,
reads N intervals (each defined by a pair of double values) from standard input,
and prints all pairs that intersect.
 */
public class Ex1_2_2 {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);

        Interval1D[] intervals = new Interval1D[N];
        StdOut.println("Please int 2 double values:");
        for (int i = 0; i < N; i++) {

            double x1 = StdIn.readDouble();
            double x2 = StdIn.readDouble();
            intervals[i] = new Interval1D(Math.min(x1, x2), Math.max(x1, x2));
            StdOut.println(N - 1 - i + " intervals left, continue please.");
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (intervals[i].intersects(intervals[j])) {
                    StdOut.println(intervals[i] + " and " + intervals[j] + " intersect.");
                }
            }
        }
    }
}
