package com.jason.algs4ex.ch2_5;

import com.jason.algs4ex.Quick;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
2.5.6 用递归实现select()。
 */
public class Ex2_5_6 {
    public static <Key extends Comparable<Key>> Key select(Key[] a, int k, int lo, int hi) {
        if (k < 0 || k >= a.length) {
            throw new IndexOutOfBoundsException("Selected element out of bounds");
        }
        if (lo >= hi)
            return a[lo];
        int i = Quick.partition(a, lo, hi);
        if (i > k) {
            return select(a, k, lo, i - 1);
        } else if (i < k) {
            return select(a, k, i + 1, hi);
        } else {
            return a[i];
        }
    }

    public static void main(String[] args) {
        String[] a = StdIn.readLine().split("\\s+");
        for (int i = 0; i < a.length; i++) {
            String ith = select(a, i, 0, a.length - 1);
            StdOut.println(ith);
        }
    }
}
