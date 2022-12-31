package com.jason.algs4ex.ch2_2;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/*
2.2.6 编写一个程序来计算自顶向下和自底向上的归并排序访问数组的准确次数。使用这个程序将N=1至512的结果绘成曲线图，并将其和上限6NlgN比较。
*/
public class Ex2_2_6 {

    public static Integer[] genIntegerArray(int n) {
        Integer[] r = new Integer[n];
        for (int i = n - 1; i >= 0; i--) {
            r[i] = i;
        }
        return r;
    }

    public static void main(String[] args) {
        int[] m = new int[512 + 1];
        int[] mbu = new int[512 + 1];
        int[] lg = new int[512 + 1];
        for (int i = 1; i < 513; i++) {
            Integer[] r = genIntegerArray(i);
            Merge.sort(r);
            m[i] = Merge.visitCnt();
            Merge.visitCnt(0);
            MergeBU.sort(r);
            mbu[i] = MergeBU.visitCnt();
            Merge.visitCnt(0);
            //6NlgN
            lg[i] = (int) (Math.log(i) / Math.log(2) * i * 6);
        }

        StdOut.println(Arrays.toString(m));
        StdOut.println(Arrays.toString(mbu));
        StdOut.println(Arrays.toString(lg));

        StdDraw.setXscale(0, 513);
        StdDraw.setYscale(0, lg[512] * 1.1);

        for (int i = 1; i < 513; i++) {
            StdDraw.setPenColor(StdDraw.GRAY);
            StdDraw.point(i, m[i]);
            StdDraw.setPenColor(StdDraw.BOOK_BLUE);
            StdDraw.point(i, mbu[i]);
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.point(i, lg[i]);
        }
    }

    public static class BaseSort {

        protected static int visitCnt = 0;

        protected static boolean less(Comparable v, Comparable w) {
            visitCnt += 2;
            return v.compareTo(w) < 0;
        }

        public static int visitCnt() {
            return visitCnt;
        }

        public static int visitCnt(int c) {
            return visitCnt = c;
        }
    }

    public static class Merge extends BaseSort {
        protected static Comparable[] aux;

        public static void sort(Comparable[] a) {
            aux = new Comparable[a.length];    // 一次性分配空间
            sort(a, 0, a.length - 1);
        }

        private static void sort(Comparable[] a, int lo, int hi) {  // 将数组a[lo..hi]排序
            if (hi <= lo) return;
            int mid = lo + (hi - lo) / 2;
            sort(a, lo, mid);        // 将左半边排序
            sort(a, mid + 1, hi);      // 将右半边排序
            merge(a, lo, mid, hi);  // 归并结果（代码见“原地归并的抽象方法”）
        }

        public static void merge(Comparable[] a, int lo, int mid, int hi) {  // 将a[lo..mid] 和a[mid+1..hi] 归并
            int i = lo, j = mid + 1;
            for (int k = lo; k <= hi; k++) {
                aux[k] = a[k];
                visitCnt += 2;
            }
            for (int k = lo; k <= hi; k++) { // 归并回到a[lo..hi]
                if (i > mid) {
                    a[k] = aux[j++];
                    visitCnt += 2;
                } else if (j > hi) {
                    a[k] = aux[i++];
                    visitCnt += 2;
                } else if (less(aux[j], aux[i])) {
                    a[k] = aux[j++];
                    visitCnt += 2;
                } else {
                    a[k] = aux[i++];
                    visitCnt += 2;
                }
            }
        }


    }

    public class MergeBU extends Merge {
        public static void sort(Comparable[] a) {  //  进行lgN次两两归并
            int N = a.length;
            Merge.aux = new Comparable[N];
            for (int sz = 1; sz < N; sz = sz + sz)         // sz子数组大小
                for (int lo = 0; lo < N - sz; lo += sz + sz) // lo：子数组索引
                    merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
        }
    }
}