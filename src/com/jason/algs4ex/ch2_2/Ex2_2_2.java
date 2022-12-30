package com.jason.algs4ex.ch2_2;

import com.jason.algs4ex.Merge;

/*
2.2.2 按照算法2.4所示轨迹的格式给出自顶向下的归并排序是如何将数组E A S Y Q U E S T I O N排序的。
*/
public class Ex2_2_2 {
    public static void main(String[] args) {
        String s = "E A S Y Q U E S T I O N";
        String[] a = s.split("\\s");
        MergeBU.showTrace(true);
        MergeBU.sort(a);
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