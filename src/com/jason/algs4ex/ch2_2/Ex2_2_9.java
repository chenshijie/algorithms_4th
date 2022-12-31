package com.jason.algs4ex.ch2_2;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/*
2.2.9 在库函数中使用aux[]这样的静态数组是不妥当的，因为可能会有多个程序同时使用这个类。
实现一个不用静态数组的Merge类，但也不要将aux[]变为merge()的局部变量（请见本节的答疑部分）。
提示：可以将辅助数组作为参数传递给递归的sort()方法。
*/
public class Ex2_2_9 {
    public static void main(String[] args) {
        int N = 20;
        Integer[] a = new Integer[N];
        Integer[] aux = new Integer[N];

        for (int i = 0; i < 20; i++) {
            a[i] = StdRandom.uniformInt(0, N * N);
        }

        StdOut.println(Arrays.toString(a));
        Merge.sort(a, aux);
        StdOut.println(Arrays.toString(a));

    }

    public static class Merge {
        private static boolean less(Comparable v, Comparable w) {
            return v.compareTo(w) < 0;
        }

        public static void sort(Comparable[] a, Comparable[] aux) {
            sort(a, aux, 0, a.length - 1);
        }

        private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
            if (hi <= lo) return;
            int mid = lo + (hi - lo) / 2;
            sort(a, aux, lo, mid);
            sort(a, aux, mid + 1, hi);
            merge(a, aux, lo, mid, hi);
        }

        private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
            int i = lo, j = mid + 1;
            for (int k = lo; k <= hi; k++) {
                aux[k] = a[k];
            }
            for (int k = lo; k <= hi; k++) {
                if (i > mid) {
                    a[k] = aux[j++];
                } else if (j > hi) {
                    a[k] = aux[i++];
                } else if (less(aux[j], aux[i])) {
                    a[k] = aux[j++];
                } else {
                    a[k] = aux[i++];
                }
            }
        }
    }
}