package com.jason.algs4ex.chapter1;

import edu.princeton.cs.algs4.StdOut;

/*
1.1.16 Give the value of exR1(6):
public static String exR1(int n)
{
 if (n <= 0) return "";
 return exR1(n-3) + n + exR1(n-2) + n;
}
 */
public class Ex1_1_16 {
    public static void main(String[] args) {
        StdOut.println("Ex1_1_16");
        StdOut.println(exR1(6));
    }

    public static String exR1(int n) {
        if (n <= 0) return "";
        return exR1(n - 3) + n + exR1(n - 2) + n;
    }
}
