package com.jason.algs4ex.chapter1;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/*
1.2.8 Suppose that a[] and b[] are each integer arrays consisting of millions of integers.
What does the follow code do? Is it reasonably efficient?
int[] t = a; a = b; b = t;
Answer. It swaps them. It could hardly be more efficient because it does so by copying
references, so that it is not necessary to copy millions of elements.
 */
public class Ex1_2_8 {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {6, 7, 8, 9, 0};

        StdOut.println("array a: " + a + " elements:" + Arrays.toString(a));
        StdOut.println("array b: " + b + " elements:" + Arrays.toString(b));

        int[] t = a;
        a = b;
        b = t;

        StdOut.println("array t: " + a + " elements:" + Arrays.toString(t));

        StdOut.println("array a: " + a + " elements:" + Arrays.toString(a));
        StdOut.println("array b: " + b + " elements:" + Arrays.toString(b));
    }
}
