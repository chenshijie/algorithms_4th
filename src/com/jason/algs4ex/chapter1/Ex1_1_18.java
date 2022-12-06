package com.jason.algs4ex.chapter1;

import edu.princeton.cs.algs4.StdOut;

/*
1.1.18 Consider the following recursive function:
public static int mystery(int a, int b)
{
 if (b == 0) return 0;
 if (b % 2 == 0) return mystery(a+a, b/2);
 return mystery(a+a, b/2) + a;
}
What are the values of mystery(2, 25) and mystery(3, 11)? Given positive integers
a and b, describe what value mystery(a, b) computes. Answer the same question, but
replace + with * and replace return 0 with return 1
 */
public class Ex1_1_18 {
    public static void main(String[] args) {
        StdOut.println("Ex1_1_17");
        StdOut.println(mystery(2, 25));

        StdOut.println(mystery2(2, 5));
    }

    //multiply
    public static int mystery(int a, int b) {
        if (b == 0) return 0;
        if (b % 2 == 0) return mystery(a + a, b / 2);
        return mystery(a + a, b / 2) + a;
    }

    //Math.pow
    public static int mystery2(int a, int b) {
        if (b == 0) return 1;
        if (b % 2 == 0) return mystery2(a * a, b / 2);
        return mystery2(a * a, b / 2) * a;
    }
}
