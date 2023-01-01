package com.jason.algs4ex.ch2_2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
2.2.19 倒置。编写一个线性对数级别的算法统计给定数组中的“倒置”数量（即插入排序所需的交换次数，请见2.1节）。
这个数量和Kendall tau距离有关，请见2.5节。

*/
public class Ex2_2_19 {

    public static void main(String[] args) {
        int[] a = StdIn.readAllInts();
        int n = a.length;
        Integer[] b = new Integer[n];
        for (int i = 0; i < n; i++)
            b[i] = a[i];
        StdOut.println(Inversions.count(a));
        StdOut.println(Inversions.count(b));

    }

    public static class Inversions {
        private static long merge(int[] a, int[] aux, int lo, int mid, int hi) {
            long inversions = 0;

            for (int k = lo; k <= hi; k++) {
                aux[k] = a[k];
            }

            int i = lo, j = mid + 1;
            for (int k = lo; k <= hi; k++) {
                if (i > mid) a[k] = aux[j++];
                else if (j > hi) a[k] = aux[i++];
                else if (aux[j] < aux[i]) {
                    a[k] = aux[j++];
                    inversions += (mid - i + 1);
                } else a[k] = aux[i++];
            }
            return inversions;
        }

        private static long count(int[] a, int[] b, int[] aux, int lo, int hi) {
            long inversions = 0;
            if (hi <= lo) return 0;
            int mid = lo + (hi - lo) / 2;
            inversions += count(a, b, aux, lo, mid);
            inversions += count(a, b, aux, mid + 1, hi);
            inversions += merge(b, aux, lo, mid, hi);
            assert inversions == brute(a, lo, hi);
            return inversions;
        }

        public static long count(int[] a) {
            int[] b = new int[a.length];
            int[] aux = new int[a.length];
            for (int i = 0; i < a.length; i++)
                b[i] = a[i];
            long inversions = count(a, b, aux, 0, a.length - 1);
            return inversions;
        }

        private static <T extends Comparable<T>> long merge(T[] a, T[] aux, int lo, int mid, int hi) {
            long inversions = 0;

            for (int k = lo; k <= hi; k++) {
                aux[k] = a[k];
            }

            int i = lo, j = mid + 1;
            for (int k = lo; k <= hi; k++) {
                if (i > mid) a[k] = aux[j++];
                else if (j > hi) a[k] = aux[i++];
                else if (less(aux[j], aux[i])) {
                    a[k] = aux[j++];
                    inversions += (mid - i + 1);
                } else a[k] = aux[i++];
            }
            return inversions;
        }

        private static <T extends Comparable<T>> long count(T[] a, T[] b, T[] aux, int lo, int hi) {
            long inversions = 0;
            if (hi <= lo) return 0;
            int mid = lo + (hi - lo) / 2;
            inversions += count(a, b, aux, lo, mid);
            inversions += count(a, b, aux, mid + 1, hi);
            inversions += merge(b, aux, lo, mid, hi);
            assert inversions == brute(a, lo, hi);
            return inversions;
        }

        public static <T extends Comparable<T>> long count(T[] a) {
            T[] b = a.clone();
            T[] aux = a.clone();
            long inversions = count(a, b, aux, 0, a.length - 1);
            return inversions;
        }


        // is v < w ?
        private static <T extends Comparable<T>> boolean less(T v, T w) {
            return (v.compareTo(w) < 0);
        }

        private static <T extends Comparable<T>> long brute(T[] a, int lo, int hi) {
            long inversions = 0;
            for (int i = lo; i <= hi; i++)
                for (int j = i + 1; j <= hi; j++)
                    if (less(a[j], a[i])) inversions++;
            return inversions;
        }

        private static long brute(int[] a, int lo, int hi) {
            long inversions = 0;
            for (int i = lo; i <= hi; i++)
                for (int j = i + 1; j <= hi; j++)
                    if (a[j] < a[i]) inversions++;
            return inversions;
        }
    }
}