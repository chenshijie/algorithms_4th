package com.jason.algs4ex;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Quick {
    public static <T extends Comparable<T>> void sort(T[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static <T extends Comparable<T>> void sort(T[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static <T extends Comparable<T>> boolean less(T a, T b) {
        return a.compareTo(b) < 0;
    }

    private static <T extends Comparable<T>> void exchange(T[] a, int x, int y) {
        T t = a[x];
        a[x] = a[y];
        a[y] = t;
    }

    public static <T extends Comparable<T>> int partition(T[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        T v = a[lo];
        while (true) {
            while (less(a[++i], v)) {
                if (i == hi) {
                    break;
                }
            }
            while (less(v, a[--j])) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exchange(a, i, j);
        }
        exchange(a, lo, j);
        return j;
    }

    public static void main(String[] args) {
        String s = "QUICKSORTEXAMPLE";
        String[] a = s.split("");
        Quick.sort(a);
        StdOut.print(Arrays.toString(a));
    }
}
