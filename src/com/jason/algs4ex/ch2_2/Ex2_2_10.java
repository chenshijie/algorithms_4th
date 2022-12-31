package com.jason.algs4ex.ch2_2;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/*
2.2.10 快速归并。实现一个merge()方法，按降序将a[]的后半部分复制到aux[]，然后将其归并回a[]中。这样就可以去掉内循环中检测某半边是否用尽的代码。
注意：这样的排序产生的结果是不稳定的（请见2.5.1.8节）
*/
public class Ex2_2_10 {
    public static void main(String[] args) {
        int N = 20;
        Integer[] a = new Integer[N];
        Integer[] aux = new Integer[N];

        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniformInt(0, N * N);
        }

        StdOut.println(Arrays.toString(a));
        Merge.sort(a, aux);
        StdOut.println(Arrays.toString(a));

    }

    public static class Merge {
        private static <T> boolean less(Comparable<T> v, Comparable<T> w) {
            return v.compareTo((T) w) < 0;
        }

        public static <T> void sort(Comparable<T>[] a, Comparable<T>[] aux) {
            sort(a, aux, 0, a.length - 1);
        }

        private static <T> void sort(Comparable<T>[] a, Comparable<T>[] aux, int lo, int hi) {
            if (hi <= lo) {
                return;
            }
            int mid = lo + (hi - lo) / 2;
            sort(a, aux, lo, mid);
            sort(a, aux, mid + 1, hi);
            merge(a, aux, lo, mid, hi);
        }

        private static <T> void merge(Comparable<T>[] a, Comparable<T>[] aux, int lo, int mid, int hi) {
            if (mid + 1 - lo >= 0) {
                System.arraycopy(a, lo, aux, lo, mid + 1 - lo);
            }

            for (int j = mid + 1; j <= hi; j++)
                aux[j] = a[hi - j + mid + 1];

            int i = lo, j = hi;
            for (int k = lo; k <= hi; k++)
                if (less(aux[j], aux[i])) {
                    a[k] = aux[j--];
                } else {
                    a[k] = aux[i++];
                }
        }
    }
}