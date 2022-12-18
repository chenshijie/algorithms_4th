package com.jason.algs4ex.ch1_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/*
1.1.22 Write a version of BinarySearch that uses the recursive rank() given on page
25 and traces the method calls. Each time the recursive method is called, print the argument values lo and hi,
indented by the depth of the recursion. Hint: Add an argument
to the recursive method that keeps track of the depth.
 */
public class Ex1_1_22 {
    public static int rank2(int key, int[] a, int lo, int hi) {
        // Array must be sorted.
        if (lo > hi) {
            return -1;
        }
        int mid = lo + (hi - lo) / 2;
        displayCursors(lo, mid, hi);
        if (key < a[mid]) {
            return rank2(key, a, lo, mid - 1);
        } else if (key > a[mid]) {
            return rank2(key, a, mid + 1, hi);
        } else {
            return mid;
        }
    }

    public static int rank2(int key, int[] a) {
        return rank2(key, a, 0, a.length - 1);
    }

    public static int rank(int key, int[] a) {
        return rank(key, a, 0, a.length - 1, 0);
    }

    public static int rank(int key, int[] a, int lower, int high, int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("\t");
        }
        StdOut.println("lo=" + lower + ", hi=" + high);
        if (lower > high) {
            return -1;
        }
        int mid = lower + (high - lower) / 2;
        if (key < a[mid]) {
            return rank(key, a, lower, mid - 1, depth + 1);
        } else if (key > a[mid]) {
            return rank(key, a, mid + 1, high, depth + 1);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        StdOut.println("Ex1_1_22");
        int[] whitelist = In.readInts(args[0]);
        while (!StdIn.isEmpty()) {
            // Read key, print if not in whitelist.
            int key = StdIn.readInt();
            int pos = rank(key, whitelist);

            if (pos < 0) {
                StdOut.printf("Not found %d\n", key);
            } else {
                StdOut.printf("Find %d at pos:%d\n", key, pos);
            }
            displayIntArray(whitelist);
            pos = rank2(key, whitelist);

        }
    }

    public static void displayIntArray(int[] a) {
        Arrays.sort(a);
        Arrays.stream(a).forEach(i -> System.out.printf("%2d\t", i));
        System.out.println();
    }

    public static void displayCursors(int l, int m, int h) {
        for (int i = 0; i < l; i++) {
            StdOut.print("\t");
        }
        if (l == m && m == h) {
            StdOut.printf("lmh:%d\n", l);
            return;
        }
        StdOut.printf("l:%d\t", l);
        for (int i = 0; i < m - l - 1; i++) {
            StdOut.print("\t");
        }
        StdOut.printf("m:%d\t", m);
        for (int i = 0; i < h - m - 1; i++) {
            StdOut.print("\t");
        }
        StdOut.printf("h:%d\n", h);
    }
}
