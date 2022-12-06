package com.jason.algs4ex.chapter1;

import edu.princeton.cs.algs4.StdOut;

/*
1.1.10 What is wrong with the following code fragment?
    int[] a;
    for (int i = 0; i < 10; i++)
        a[i] = i * i;
 */
public class Ex1_1_10 {
    public static void main(String[] args) {
        StdOut.println("Ex1_1_10");
        StdOut.println("数组在使用前必须初始化");
        int[] a = new int[10];
        for (int i = 0; i < 10; i++)
            a[i] = i * i;

        for (int i = 0; i < 10; i++)
            StdOut.println(a[i]);
    }
}
