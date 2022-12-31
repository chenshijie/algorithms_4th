package com.jason.algs4ex.ch2_2;

import com.jason.algs4ex.MergeSort;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/*
2.2.11 改进。实现2.2.2节所述的对归并排序的三项改进：加快小数组的排序速度，检测数组是否已经有序以及通过在递归中交换参数来避免数组复制。
*/
public class Ex2_2_11 {
    public static void main(String[] args) {
        int N = 20;
        Integer[] a = new Integer[N];

        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniformInt(0, N * N);
        }

        StdOut.println(Arrays.toString(a));
        MergeSort.sort(a);
        StdOut.println(Arrays.toString(a));
    }
}