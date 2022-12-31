package com.jason.algs4ex.ch2_2;

import com.jason.algs4ex.Merge;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/*
2.2.5 当输入数组的大小N=39时，给出自顶向下和自底向上的归并排序中各次归并子数组的大小及顺序。
*/
public class Ex2_2_5 {
    public static void main(String[] args) {
        String[] a = new String[39];

        for (int i = 0; i < a.length; i++) {
            a[i] = String.valueOf(i);
        }
        StdOut.println(Arrays.toString(a));
        MergeBU.showTrace(true);
        MergeBU.sort(a);
        Merge.showTrace(true);
        Merge.sort(a);
    }

    public class MergeBU extends Merge {
        private static Comparable[] aux;       // 归并所需的辅助数组

        public static void sort(Comparable[] a) {  //  进行lgN次两两归并
            int N = a.length;
            Merge.aux = new Comparable[N];
            for (int sz = 1; sz < N; sz = sz + sz)         // sz子数组大小
                for (int lo = 0; lo < N - sz; lo += sz + sz) // lo：子数组索引
                    merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
        }
    }
}