package com.jason.algs4ex.chapter1;

import edu.princeton.cs.algs4.StdOut;

/*
1.1.7 Give the value printed by each of the following code fragments:
a. double t = 9.0;
 while (Math.abs(t - 9.0/t) > .001)
 t = (9.0/t + t) / 2.0;
 StdOut.printf("%.5f\n", t);
b. int sum = 0;
 for (int i = 1; i < 1000; i++)
 for (int j = 0; j < i; j++)
 sum++;
 StdOut.println(sum);
c. int sum = 0;
 for (int i = 1; i < 1000; i *= 2)
 for (int j = 0; j < N; j++)
 sum++;
 StdOut.println(sum);
 */
public class Ex1_1_7 {
    public static void main(String[] args) {
        StdOut.println("Ex1_1_7");

        double t = 9.0;
        while (Math.abs(t - 9.0 / t) > .001)
            t = (9.0 / t + t) / 2.0;
        StdOut.printf("%.5f\n", t);

        int sum = 0;
        for (int i = 1; i < 1000; i++)
            for (int j = 0; j < i; j++)
                sum++;
        StdOut.println(sum);

        int sum1 = 0;
        int N = 5;
        for (int i = 1; i < 1000; i *= 2)
            for (int j = 0; j < N; j++)
                sum1++;
        StdOut.println(sum1);
    }
}
