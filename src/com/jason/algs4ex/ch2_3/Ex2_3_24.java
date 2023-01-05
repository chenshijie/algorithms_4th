package com.jason.algs4ex.ch2_3;
/*
2.3.24 取样排序。（W. Frazer, A. McKellar）实现一个快速排序，取样大小为2k-1。首先将取样得到的元素排序，然后在递归函数中使用样品的中位数切分。
分为两部分的其余样品元素无需再次排序并可以分别应用于原数组的两个子数组。
这种算法被称为取样排序。
*/

import com.jason.algs4ex.Quick;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Ex2_3_24 {

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        SampleSort.sort(a);
        StdOut.println(Arrays.toString(a));
    }

    public static class SampleSort extends Quick {
        public static int K = 4;

        private static <T> void exch(T[] a, int i, int j) {
            T swap = a[i];
            a[i] = a[j];
            a[j] = swap;
        }

        public static <T extends Comparable<T>> void sort(T[] a) {
            if (a.length < Math.pow(2, K + 1)) {
                // 小于 2^(k+1) 的数组直接进行快排
                Quick.sort(a);
                return;
            }

            StdRandom.shuffle(a);
            int samplehi = (int) Math.pow(2, K) - 2;
            // 利用快速排序对取样数组进行排序
            Quick.sort(a, 0, samplehi);
            // 找到取样数组的中位数
            int sampleMedian = samplehi / 2;
            // 将取样数组后半部分放到数组末尾
            int i = samplehi, j = a.length - 1;
            while (i != sampleMedian && i >= 0)
                exch(a, i--, j--);
            // 根据取样数组进行排序
            SampleSort.sort(a, 0, sampleMedian, j, a.length - 1);
        }

        private static <T extends Comparable<T>> void sort(T[] a, int samplelo, int lo, int hi, int samplehi) {
            if (hi <= lo)                   // 别越界
                return;

            int j = partition(a, lo, hi);
            // 将前部的有序取样数组取半，后半部分放在枢轴前面。
            if (lo - samplelo > 1) {
                // p 应该始终指向有序部分的最后一项
                // v 应该始终指向有序部分的前面一项
                int p = lo - 1, v = j - 1;
                for (int i = 0; i < (lo - samplelo) / 2; i++) {
                    exch(a, p--, v--);
                }
                sort(a, samplelo, p, v, j - 1);
            } else {
                // 取样数组已经用完，退化为普通 Quicksort
                Quick.sort(a, samplelo, j - 1);
            }

            // 将尾部有序取样数组取半，前半部分放在枢轴后面。
            if (samplehi - hi > 1) {
                // p 应该始终指向有序部分的前面一项
                // v 应该始终指向有序部分的最后一项
                int p = hi, v = j;
                for (int i = 0; i < (samplehi - hi) / 2; i++) {
                    exch(a, ++p, ++v);
                }
                sort(a, j + 1, v, p, samplehi);
            } else {
                // 取样数组已用完，退化为普通 Quicksort
                Quick.sort(a, j + 1, samplehi);
            }
        }

        public int getK() {
            return K;
        }

        public void setK(int k) {
            K = k;
        }
    }
}
