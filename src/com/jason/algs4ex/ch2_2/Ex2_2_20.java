package com.jason.algs4ex.ch2_2;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/*
Ex2_2_19

*/
public class Ex2_2_20 {

    public static void main(String[] args) {
        int N = 20;
        Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniformInt(0, 100 * N);
        }

        StdOut.println(Arrays.toString(a));
        int[] index = IndexMergeSort.sort(a);
        StdOut.println(Arrays.toString(Arrays.stream(index).map(i -> a[i]).toArray()));
        for (int i : index) {
            StdOut.print(a[i] + " ");
        }
    }

    public static class IndexMergeSort {
        public static <T extends Comparable<T>> int[] sort(T[] a) {
            int n = a.length;
            int[] index = new int[n];
            for (int i = 0; i < n; i++)
                index[i] = i;

            int[] aux = new int[n];
            sort(a, index, aux, 0, n - 1);
            return index;
        }

        private static <T extends Comparable<T>> void sort(T[] a, int[] index, int[] aux, int lo, int hi) {
            if (hi <= lo) return;
            int mid = lo + (hi - lo) / 2;
            sort(a, index, aux, lo, mid);
            sort(a, index, aux, mid + 1, hi);
            merge(a, index, aux, lo, mid, hi);
        }

        private static <T extends Comparable<T>> void merge(T[] a, int[] index, int[] aux, int lo, int mid, int hi) {

            // copy to aux[]
            for (int k = lo; k <= hi; k++) {
                aux[k] = index[k];
            }

            // merge back to a[]
            int i = lo, j = mid + 1;
            for (int k = lo; k <= hi; k++) {
                if (i > mid) index[k] = aux[j++];
                else if (j > hi) index[k] = aux[i++];
                else if (less(a[aux[j]], a[aux[i]])) index[k] = aux[j++];
                else index[k] = aux[i++];
            }
        }

        private static <T extends Comparable<T>> boolean less(T v, T w) {
            return v.compareTo(w) < 0;
        }
    }
}