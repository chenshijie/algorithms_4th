package com.jason.algs4ex.ch2_2;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/*
2.2.12 次线性的额外空间。用大小M将数组分为N/M块（简单起见，设M是N的约数）。实现一个归并方法，使之所需的额外空间减少到max（M, N/M）:
（i）可以先将一个块看做一个元素，将块的第一个元素作为块的主键，用选择排序将块排序；
（ii）遍历数组，将第一块和第二块归并，完成后将第二块和第三块归并，等等。

2.2.12 Sublinear extra space.
Develop a merge implementation that reduces the extra space requirement to max(M, N/M), based on the following idea:
Divide the array into N/M blocks of size M (for simplicity in this description, assume that N is a multiple of M).
Then, (i) considering the blocks as items with their first key as the sort key, sort them using selection sort;
and (ii) run through the array merging the first block with the second, then the second block with the third, and so forth.
*/
public class Ex2_2_12 {

    public static void main(String[] args) {
        int N = 13;
        Integer[] a = new Integer[N];

        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniformInt(0, N * N);
        }

        StdOut.println(Arrays.toString(a));
        MergeSublinearSpace.sort(a);
        StdOut.println(Arrays.toString(a));
    }

    public static class MergeSublinearSpace {

        private static final int SubArrayLength = 5;

        private static <T> boolean less(Comparable<T> v, Comparable<T> w) {
            return v.compareTo((T) w) < 0;
        }

        public static <T> void sort(Comparable<T>[] a) {
            Comparable[] aux = new Comparable[SubArrayLength];
            int length = a.length / SubArrayLength;
            if (a.length % SubArrayLength != 0) {
                length++;
            }
            StdOut.println("length=" + length);
            for (int i = 0; i < length; i++) {
                int lo = i * SubArrayLength;
                int hi = (i + 1) * SubArrayLength - 1;
                if (i == length - 1) {
                    hi = a.length - 1;
                }

                selectionSort(a, lo, hi);
                StdOut.println("selectionSort lo=" + lo + " hi=" + hi);
                StdOut.println(Arrays.toString(a));
                StdOut.println();
                if (i >= 1) {
                    if (i == length - 1) {
                        merge(a, aux, 0, i * SubArrayLength - 1, hi);
                    } else {
                        merge(a, aux, 0, hi - SubArrayLength, hi);
                    }

                }
            }
        }

        public static <T> void selectionSort(Comparable<T>[] a, int start, int end) {
            for (int i = start; i < end; i++) {
                int min = i;
                for (int j = i + 1; j <= end; j++) {
                    if (less(a[j], a[min])) {
                        min = j;
                    }
                }
                exchange(a, i, min);
            }
        }

        private static <T> void exchange(T[] a, int i, int j) {
            T swap = a[i];
            a[i] = a[j];
            a[j] = swap;
        }

        private static <T> void merge(Comparable<T>[] a, Comparable<T>[] aux, int lo, int mid, int hi) {
            //copy right half of array a to aux
            int rightLength = hi - mid;
            for (int i = 0; i < rightLength; i++)
                aux[i] = a[mid + 1 + i];
            //merge from array aux with left half  of a to  a
            int auxTop = rightLength - 1;
            int aTop = mid;
            for (int k = hi; k >= lo; k--) {
                if (auxTop < 0) a[k] = a[aTop--];
                else if (aTop < lo) a[k] = aux[auxTop--];
                else if (less(aux[auxTop], a[aTop])) a[k] = a[aTop--];
                else a[k] = aux[auxTop--];
            }
        }


    }
}