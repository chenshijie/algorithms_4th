package com.jason.algs4ex.ch2_5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/*
2.5.4 实现一个方法String[] dedup(String[] a)，返回一个有序的a[]，并删去其中的重复元素。
 */
public class Ex2_5_4 {
    public static String[] dedup(String[] a) {
        if (a.length == 0) {
            return a;
        }
        String[] copy = new String[a.length];
        System.arraycopy(a, 0, copy, 0, a.length);
        Arrays.sort(copy);
        String[] r2 = new String[a.length];

        r2[0] = copy[0];
        int k = 0;
        for (int i = 1; i < copy.length; i++) {
            if (r2[k].compareTo(copy[i]) != 0) {
                r2[++k] = copy[i];
            }
        }
        String[] result = new String[k + 1];
        System.arraycopy(r2, 0, result, 0, k + 1);
        return result;
    }

    public static void main(String[] args) {
        String[] a = StdIn.readLine().split("\\s+");
        StdOut.println(Arrays.toString(dedup(a)));
    }
}
