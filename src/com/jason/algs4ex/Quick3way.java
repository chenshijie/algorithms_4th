package com.jason.algs4ex;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Quick3way extends Quick {
    public static <T extends Comparable<T>> void sort(T[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    protected static <T extends Comparable<T>> void sort(T[] a, int lo, int hi) {
        if (hi <= lo) return;
        int lt = lo, i = lo + 1, gt = hi;
        T v = a[lo];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) exchange(a, lt++, i++);
            else if (cmp > 0) exchange(a, i, gt--);
            else i++;
        }  // 现在a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi]成立
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    public static void main(String[] args) {
        String s = "QUICKSORTEXAMPLEAABBEEEDDEXXXXSSSSSSS";
        String[] a = s.split("");
        Quick3way.sort(a);
        StdOut.print(Arrays.toString(a));
    }
}
