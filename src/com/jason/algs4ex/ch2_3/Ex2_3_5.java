package com.jason.algs4ex.ch2_3;
/*
2.3.5 给出一段代码将已知只有两种主键值的数组排序。
initial shuffle).
 */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Ex2_3_5 {
    private static <T> void exchange(T[] a, int x, int y) {
        T t = a[x];
        a[x] = a[y];
        a[y] = t;
    }

    public static <T extends Comparable<T>> void sort(T[] a) {
        int lt = 0, gt = a.length - 1;
        int i = 0;
        while (i <= gt) {
            int cmp = a[i].compareTo(a[lt]);
            if (cmp < 0) {
                exchange(a, lt++, i++);
            } else if (cmp > 0) {
                exchange(a, i, gt--);
            } else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int N = 20;
        Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++) {
            if (StdRandom.bernoulli(0.5)) {
                a[i] = 1;
            } else {
                a[i] = 2;
            }
        }
        StdOut.println(Arrays.toString(a));
        sort(a);
        StdOut.println(Arrays.toString(a));
    }
}
