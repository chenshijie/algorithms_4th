package com.jason.algs4ex.ch2_1;

import com.jason.algs4ex.BaseSort;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/*
2.1.11 将希尔排序中实时计算递增序列改为预先计算并存储在一个数组中。
 */
public class Ex2_1_11 {
    public static void main(String[] args) {
        String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        Shell.sort(a);
        StdOut.println(Arrays.toString(a));
    }

    public static class Shell extends BaseSort {

        public static int[] generateGap(int n) {
            int[] sequence = new int[5];
            int gap = 3;
            sequence[0] = 1;
            int i = 1;
            while (sequence[i - 1] * gap + 1 < n) {
                if (i == sequence.length) {
                    int[] temp = new int[sequence.length * 2];
                    System.arraycopy(sequence, 0, temp, 0, i);
                    sequence = temp;
                }
                sequence[i] = sequence[i - 1] * gap + 1;
                i++;

            }
            int[] result = new int[i];
            System.arraycopy(sequence, 0, result, 0, i);
            return result;
        }

        public static void sort(Comparable[] a) {
            int n = a.length;
            int[] sequence = generateGap(n);

            for (int k = sequence.length - 1; k >= 0; k--) {
                // h-sort the array
                int h = sequence[k];
                for (int i = h; i < n; i++) {
                    for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                        exch(a, j, j - h);
                    }
                }
            }
            assert isSorted(a);
        }
    }
}
