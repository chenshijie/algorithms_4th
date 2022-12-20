package com.jason.algs4ex.ch1_4;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/*
1.4.23 Binary search for a fraction. Devise a method that uses a logarithmic number of
queries of the form Is the number less than x? to find a rational number p/q such that 0
< p < q < N. Hint : Two fractions with denominators less than N cannot differ by more
than 1/N 2.

1.4.23 分数的二分查找。设计一个算法，使用对数级别的比较次数找出有理数p/q，其中0＜p＜q＜N，比较形式为给定的数是否小于x？
提示：两个分母均小于N的有理数之差不小于1/N^2。

题目里面的N不是数组长度，比如判断1/3和1/4是否相等，应该看1/3与1/4只差是不是小于1/25，这里的N取值至少应该是5。此题将BinarySearch中rank方法的
判断两数相等的条件是两数之差等于0，改成两数之差的绝对值小于小于1/N^2即可认为两数相等
*/
public class Ex1_4_23 {

    public static void main(String[] args) {
        int N = 10000;
        double[] array = new double[10];
        for (int i = 0; i < 10; i++) {
            int p = StdRandom.uniformInt(1, N);
            int q = StdRandom.uniformInt(1, N);
            if (p == q) {
                q = StdRandom.uniformInt(1, N);
            }
            array[i] = Math.min(p, q) / (double) Math.max(p, q);
        }
        Arrays.sort(array);
        StdOut.println(Arrays.toString(array));
        double key = StdIn.readDouble();
        int index = rank4DoubleArray(key, array, N);
        if (index > -1) {
            StdOut.printf("find %.11f which index is %d\n", key, index);
        } else {
            StdOut.printf("%.11f is not in array\n", key);
        }

    }

    public static int rank4DoubleArray(double key, double[] a, int N) {
        // Array must be sorted.
        int lo = 0;
        int hi = a.length - 1;
        double threshold = 1.0 / ((long) N * N);
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if (a[mid] - key > threshold) {
                hi = mid - 1;
            } else if (key - a[mid] > threshold) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
