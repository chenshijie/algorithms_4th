package com.jason.algs4ex.ch1_1;

import edu.princeton.cs.algs4.StdOut;

/*
1.1.20 Write a recursive static method that computes the value of ln (N !)
 */
public class Ex1_1_20 {
    public static double ln(int N) {
        if (N > 0) {
            return Math.log(N) + ln(N - 1);
        } else {
            return 0;
        }
    }

    public static double factorial(int N) {
        if (N <= 1)
            return 1;
        else
            return N * (factorial(N - 1));
    }

    public static void main(String[] args) {

        StdOut.println("Ex1_1_20");

        StdOut.println(ln(10));
        StdOut.println(Math.log(factorial(10)));

    }
}
