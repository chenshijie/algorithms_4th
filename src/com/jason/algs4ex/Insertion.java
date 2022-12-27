package com.jason.algs4ex;

import edu.princeton.cs.algs4.StdIn;

public class Insertion extends BaseSort {
    public static void sort(Comparable[] a) {  // 将a[]按升序排列
        int N = a.length;
        for (int i = 1; i < N; i++) {  // 将a[i] 插入到a[i-1]、a[i-2]、a[i-3]..．之中
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--)
                exch(a, j, j - 1);
        }
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
