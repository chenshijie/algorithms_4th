package com.jason.algs4ex.ch1_1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
1.1.14 Write a static method lg() that takes an int value N as argument and returns
the largest int not larger than the base-2 logarithm of N. Do not use Math
 */
public class Ex1_1_14 {
    public static void main(String[] args) {
        StdOut.println("Ex1_1_14");
        StdOut.println("Please input a positive integer:");
        int num = StdIn.readInt();

        int n1 = lg(num);
        StdOut.printf("The largest int not larger than the base-2 logarithm of %d is: %d\n", num, n1);
        int n2 = log(num, 2);
        StdOut.printf("The largest int not larger than the base-2 logarithm of %d is: %d\n", num, n2);

    }

    public static int lg(int num) {
        int mask = 1, i = 0, pos = 31;
        while (i < 32) {
            if ((mask & num) >= 1) {
                pos = 31 - i;
            }
            mask = mask << 1;
            i++;
        }
        return 32 - pos - 1;
    }

    public static int log(int N, int base) {
        int num = 0;
        while (N >= base) {
            N /= base;
            num++;
        }
        return num;
    }
}
