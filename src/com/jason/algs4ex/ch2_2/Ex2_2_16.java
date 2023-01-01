package com.jason.algs4ex.ch2_2;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/*
2.2.16 自然的归并排序。编写一个自底向上的归并排序，当需要将两个子数组排序时能够利用数组中已经有序的部分。
首先找到一个有序的子数组（移动指针直到当前元素比上一个元素小为止），然后再找出另一个并将它们归并。
根据数组大小和数组中递增子数组的最大长度分析算法的运行时间。

2.2.16 Natural mergesort. Write a version of bottom-up mergesort that takes advantage
of order in the array by proceeding as follows each time it needs to find two arrays
to merge: find a sorted subarray (by incrementing a pointer until finding an entry that
is smaller than its predecessor in the array), then find the next, then merge them. Analyze
the running time of this algorithm in terms of the array size and the number of
maximal increasing sequences in the array.
*/
public class Ex2_2_16 {

    public static void main(String[] args) {
        int N = 20;
        Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniformInt(0, 2 * N);
        }

        NatureMergeSort.show(a);
        NatureMergeSort.debugMode(true);
        NatureMergeSort.sort(a);
        NatureMergeSort.show(a);

    }

    public static class NatureMergeSort {

        private static boolean debugMode = false;

        public static void debugMode(boolean b) {
            debugMode = b;
        }

        private static <T> void merge(Comparable<T>[] a, int lo, int mid, int hi) {
            Comparable<T>[] aux = new Comparable[hi - mid];
            System.arraycopy(a, mid + 1, aux, 0, hi - mid);

            int auxTop = aux.length - 1;

            for (int k = hi; k >= lo; k--) {
                if (auxTop < 0) a[k] = a[mid--];
                else if (mid < lo) a[k] = aux[auxTop--];
                else if (less(aux[auxTop], a[mid])) a[k] = a[mid--];
                else a[k] = aux[auxTop--];
            }
        }

        private static <T> boolean less(Comparable<T> v, Comparable<T> w) {
            return v.compareTo((T) w) < 0;
        }

        public static <T> void sort(Comparable<T>[] a) {
            int mid, hi = 0;
            mid = findNext(a, -1);
            while (mid < a.length - 1 && hi < a.length) {
                hi = findNext(a, mid);
                if (debugMode) {
                    showSortTrace(a, 0, mid, hi);
                }
                merge(a, 0, mid, hi);
                mid = hi;
            }
        }

        private static <T> int findNext(Comparable<T>[] a, int start) {
            int i = start + 1;
            for (; i < a.length - 1; i++) {
                if (!less(a[i], a[i + 1])) {
                    return i;
                }
            }
            return i;
        }

        public static <T> void showSortTrace(Comparable<T>[] a, int lo, int mid, int hi) {
            //参与归并的左侧率色，右侧红色，不参与归并的灰色
            for (int i = 0; i < a.length; i++) {
                if (i < lo) {
                    StdOut.print(String.format("\033[%d;%dm%-4s\033[0m", 37, 2, a[i]));
                } else if (i <= mid) {
                    StdOut.print(String.format("\033[%d;%dm%-4s\033[0m", 32, 2, a[i]));
                } else if (i <= hi) {
                    StdOut.print(String.format("\033[%d;%dm%-4s\033[0m", 31, 2, a[i]));
                } else {
                    StdOut.print(String.format("\033[%d;%dm%-4s\033[0m", 37, 2, a[i]));
                }
            }
            StdOut.println();
        }

        public static <T> void show(Comparable<T>[] a) {
            for (Comparable<T> c : a) {
                StdOut.print(String.format("%-4s", c));
            }
            StdOut.println();
        }
    }
}