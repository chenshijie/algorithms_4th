package com.jason.algs4ex.ch2_1;

import com.jason.algs4ex.BaseSort;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/*
2.1.12 令希尔排序打印出递增序列的每个元素所带来的比较次数和数组大小的比值。编写一个测试用例对随机Double数组进行希尔排序，
验证该值是一个小常数，数组大小按照10的幂次递增，不小于100。
*/
public class Ex2_1_12 {
    public static void main(String[] args) {
        int length = 100;
        for (int i = 0; i < 5; i++) {
            Double[] a = new Double[length];
            for (int j = 0; j < length; j++) {
                a[j] = StdRandom.uniformDouble();
            }

            Shell.sort(a);
            StdOut.printf("Compare Times: %8d Array Length: %8d Ratio: %f\n", Shell.getCompareCnt(), length, (double) Shell.getCompareCnt() / length);
            length *= 10;
        }
    }

    public static class Shell extends BaseSort {
        private static int compareCnt = 0;

        protected static boolean less(Comparable v, Comparable w) {
            compareCnt++;
            return v.compareTo(w) < 0;
        }

        public static void resetCompareCnt() {
            Shell.compareCnt = 0;
        }

        public static int getCompareCnt() {
            return compareCnt;
        }

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
            resetCompareCnt();
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
