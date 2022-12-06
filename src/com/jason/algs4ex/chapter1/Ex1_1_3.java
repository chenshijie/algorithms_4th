package com.jason.algs4ex.chapter1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
1.1.3 Write a program that takes three integer command-line arguments and prints
 * equal if all three are equal, and not equal otherwise.
 */
public class Ex1_1_3 {
    public static void main(String[] args) {
        StdOut.println("Ex1_1_3");
        StdOut.println("Please input three integer numbers:");
        int num1 = StdIn.readInt();
        int num2 = StdIn.readInt();
        int num3 = StdIn.readInt();
        if(num1 == num2 && num2 == num3) {
            StdOut.println("equal");
        } else {
            StdOut.println("not equal");
        }
    }
}
