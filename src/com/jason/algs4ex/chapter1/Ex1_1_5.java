package com.jason.algs4ex.chapter1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
1.1.5 Write a code fragment that prints true if the double variables x and y are both
strictly between 0 and 1 and false otherwise
 */
public class Ex1_1_5 {
    public static void main(String[] args) {
        String[] fullClassName = Thread.currentThread().getStackTrace()[1].getClassName().split("\\.");
        int length = fullClassName.length;
        StdOut.println(fullClassName[length-1]);

        StdOut.println("Please input 2 numbers:");
        double d1 = StdIn.readDouble();
        double d2 = StdIn.readDouble();

        if (d1 > 0 & d1 < 1 && d2 > 0 && d2 < 1) {
            StdOut.println("true");
        } else {
            StdOut.println("false");
        }
    }
}
