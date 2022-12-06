package com.jason.algs4ex.chapter1;

import edu.princeton.cs.algs4.StdOut;

/*
1.1.17 Criticize the following recursive function:
public static String exR2(int n)
{
 String s = exR2(n-3) + n + exR2(n-2) + n;
 if (n <= 0) return "";
 return s;
}
Answer : The base case will never be reached. A call to exR2(3) will result in calls to
exR2(0), exR2(-3), exR3(-6), and so forth until a StackOverflowError occurs.
 */
public class Ex1_1_17 {
    public static void main(String[] args) {
        StdOut.println("Ex1_1_17");
        StdOut.println(exR1(6));
    }

    public static String exR1(int n) {
        if (n <= 0) return "";
        return exR1(n - 3) + n + exR1(n - 2) + n;
    }
}
