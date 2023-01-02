package com.jason.algs4ex.ch2_3;
/*
2.3.8 Quick.sort()在处理N个全部重复的元素时大约需要多少次比较？
*/

import edu.princeton.cs.algs4.StdOut;

public class Ex2_3_8 {
    public static void main(String[] args) {
        int N = 10;
        Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++) {
            a[i] = 1;
        }
        Ex2_3_7.QuickSort.sort(a);

        StdOut.println(Ex2_3_7.QuickSort.getCompareCount());
    }

}
