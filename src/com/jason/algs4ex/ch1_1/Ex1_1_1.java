package com.jason.algs4ex.ch1_1;

import edu.princeton.cs.algs4.StdOut;

/*
1.1.1 Give the value of each of the following expressions:
a. ( 0 + 15 ) / 2
b. 2.0e-6 * 100000000.1
c. true && false || true && true
 */
public class Ex1_1_1 {
    public static void main(String[] args) {
        StdOut.println("1.1.1 答案：");
        StdOut.println((0 + 15) / 2); //7
        StdOut.println(2.0e-6 * 100000000.1); //200.0000002
        StdOut.println(true && false || true && true); //true
    }
}
