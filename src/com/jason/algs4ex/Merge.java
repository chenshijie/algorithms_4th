package com.jason.algs4ex;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Merge extends BaseSort {
    private static Comparable[] aux;       // 归并所需的辅助数组

    private static boolean showTrace = false;

    public static void showTrace(boolean showTrace) {
        Merge.showTrace = showTrace;
    }

    public static void sort(Comparable[] a) {
        if (showTrace) {
            printHeader(a);
        }
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

    private static void printTrace(Comparable[] a, int lo, int mid, int hi) {
        int maxRecursiveLevel = (int) (Math.log(a.length) / Math.log(2));
        int currentRecursiveLevel = (int) (Math.log(hi - lo) / Math.log(2));
        int t = maxRecursiveLevel - currentRecursiveLevel;
        for (int i = 0; i < t; i++) {
            StdOut.print("  ");
        }
        StdOut.printf("merge(a,%2d,%2d,%2d)", lo, mid, hi);
        for (int i = 0; i < 30 - 17 - t * 2; i++) {
            StdOut.print(" ");
        }
        for (int i = 0; i < a.length; i++) {
            if (i >= lo && i <= hi) {
                StdOut.print(String.format("\033[%d;%dm%3s\033[0m", 31, 2, a[i]));
            } else {
                StdOut.print(String.format("\033[%d;%dm%3s\033[0m", 37, 2, a[i]));
            }

        }
        StdOut.println();
    }

    private static void printHeader(Comparable[] a) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < 30; i++) {
            sb1.append(" ");
            sb2.append(" ");
        }
        for (int i = 0; i < a.length; i++) {
            sb1.append(String.format(" %2d", i));
            sb2.append(String.format("%3s", a[i]));
        }
        StdOut.println(sb1);
        StdOut.println(sb2);
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {  // 将a[lo..mid] 和a[mid+1..hi] 归并
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++)  // 将a[lo..hi]复制到aux[lo..hi]
            aux[k] = a[k];
        for (int k = lo; k <= hi; k++) { // 归并回到a[lo..hi]
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
        if (showTrace) {
            printTrace(a, lo, mid, hi);
        }
    }

    public static void main(String[] args) {
        String s = "MERGESORTEXAMPLE";
        String[] a = s.split("");
        sort(a);
        StdOut.println(Arrays.toString(a));
    }
}
