package com.jason.algs4ex.ch1_4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/*
1.4.18 数组的局部最小元素。编写一个程序，给定一个含有N个不同整数的数组，找到一个局部最小元素：
满足a[i]＜a[i-1]，且a[i]＜a[i+1]的索引i。程序在最坏情况下所需的比较次数为～2lgN。
*/
public class Ex1_4_18 {
    public static int localMin(int[] x) {
        if (x == null || x.length == 0) {
            return -1;
        }
        if (x.length == 1 || x[0] < x[1]) {
            return 0;
        }
        if (x[x.length - 1] < x[x.length - 2]) {
            return x.length - 1;
        }

        int mid = 0;
        int low = 1;
        int right = x.length - 2;
        while (low < right) {
            mid = (low + right) / 2;
            if (x[mid - 1] < x[mid]) {
                right = mid - 1;
            } else if (x[mid + 1] < x[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int N = 10;
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = i;
        }
        StdRandom.shuffle(a);
        StdOut.println(Arrays.toString(a));
        int index = localMin(a);
        if (index != -1)
            StdOut.printf("find a[%d]:%d\n", index, a[index]);
    }
}
