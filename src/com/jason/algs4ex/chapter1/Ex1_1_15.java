package com.jason.algs4ex.chapter1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/*
1.1.15 Write a static method histogram() that takes an array a[] of int values and
an integer M as arguments and returns an array of length M whose ith entry is the number of times the integer i appeared in the argument array. If the values in a[] are all
between 0 and M–1, the sum of the values in the returned array should be equal to
a.length
 */
public class Ex1_1_15 {
    public static void main(String[] args) {
        StdOut.println("Ex1_1_15");
        int M = 20;
        int L = 100;

        int[] array = initIntArray(L, M);

        int[] a = histogram(array, M);

        int sum = 0;
        for (int i : a) {
            sum += i;
        }

        StdOut.printf("L=%d, M=%d, sum=%d, sum==L=%b", L, M, sum, sum == L);

    }

    public static int[] initIntArray(int length, int bound) {
        int[] a = new int[length];
        //Random random = new Random();
        for (int i = 0; i < length; i++) {
            //a[i] = random.nextInt(0, bound);
            a[i] = StdRandom.uniformInt(0, bound);
        }
        return a;
    }

    public static int[] histogram(int[] array, int M) {
        int[] a = new int[M];
        for (int i : array) {
            a[i]++;
        }
        return a;
    }
}
