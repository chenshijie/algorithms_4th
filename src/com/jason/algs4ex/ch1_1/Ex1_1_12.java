package com.jason.algs4ex.ch1_1;

import edu.princeton.cs.algs4.StdOut;

/*
1.1.12 What does the following code fragment print?
int[] a = new int[10];
for (int i = 0; i < 10; i++)
 a[i] = 9 - i;
for (int i = 0; i < 10; i++)
 a[i] = a[a[i]];
for (int i = 0; i < 10; i++)
 System.out.println(a[i]);
 */
public class Ex1_1_12 {
    public static void main(String[] args) {
        StdOut.println("Ex1_1_12");
        int[] a = new int[10];
        for (int i = 0; i < 10; i++)
            a[i] = 9 - i;

        displayArray(a);

        for (int i = 0; i < 10; i++)
            a[i] = a[a[i]];

        displayArray(a);
    }

    public static void displayArray(int[] array) {
        for (int i : array) System.out.printf("%2d", i);
        System.out.println();
    }
}
