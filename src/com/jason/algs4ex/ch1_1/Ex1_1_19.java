package com.jason.algs4ex.ch1_1;

import edu.princeton.cs.algs4.StdOut;

/*
1.1.19 Run the following program on your computer:
public class Fibonacci
{
 public static long F(int N)
 {
 if (N == 0) return 0;
 if (N == 1) return 1;
 return F(N-1) + F(N-2);
 }
 public static void main(String[] args)
 {
 for (int N = 0; N < 100; N++)
 StdOut.println(N + " " + F(N));
 }
}

What is the largest value of N for which this program takes less 1 hour to compute the
value of F(N)? Develop a better implementation of F(N) that saves computed values in
an array
 */
public class Ex1_1_19 {
    public static long F(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        return F(N - 1) + F(N - 2);
    }

    public static void main(String[] args) {
        //递归方式实现fibonacci数列，Ex1_1_6 另一种方式
        StdOut.println("Ex1_1_19");
        for (int N = 0; N < 100; N++)
            StdOut.println(N + " " + F(N));
    }
}
