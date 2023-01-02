package com.jason.algs4ex.ch2_3;
/*
2.3.7 在使用快速排序将N个不重复的元素排序时，计算大小为0、1和2的子数组的数量。如果你喜欢数学，请推导；如果你不喜欢，请做一些实验并提出猜想。
 */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Ex2_3_7 {
    public static void main(String[] args) {
        int N = 1000;
        Integer[] a = new Integer[1000];
        for (int i = 0; i < N; i++) {
            a[i] = i;
        }
        QuickSort.sort(a);

        StdOut.println(QuickSort.getSubArrayWithLength0Count());
        StdOut.println(QuickSort.getSubArrayWithLength1Count());
        StdOut.println(QuickSort.getSubArrayWithLength2Count());
    }

    public static class QuickSort {

        private static int subArrayWithLength0Count = 0;
        private static int subArrayWithLength1Count = 0;
        private static int subArrayWithLength2Count = 0;

        public static int getSubArrayWithLength0Count() {
            return subArrayWithLength0Count;
        }

        public static int getSubArrayWithLength1Count() {
            return subArrayWithLength1Count;
        }

        public static int getSubArrayWithLength2Count() {
            return subArrayWithLength2Count;
        }

        public static <T extends Comparable<T>> void sort(T[] a) {
            StdRandom.shuffle(a);

            sort(a, 0, a.length - 1);
        }

        protected static <T extends Comparable<T>> void sort(T[] a, int lo, int hi) {
            switch (hi - lo) {
                case 0 -> subArrayWithLength0Count++;
                case 1 -> subArrayWithLength1Count++;
                case 2 -> subArrayWithLength2Count++;
            }
            if (hi <= lo) {
                return;
            }
            int j = partition(a, lo, hi);
            sort(a, lo, j - 1);
            sort(a, j + 1, hi);
        }

        protected static <T extends Comparable<T>> boolean less(T a, T b) {
            return a.compareTo(b) < 0;
        }

        protected static <T extends Comparable<T>> void exchange(T[] a, int x, int y) {
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
    }
}
