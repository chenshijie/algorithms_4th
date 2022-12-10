package com.jason.algs4ex.chapter1;

import com.jason.algs4ex.Accumulator;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/*
1.2.17 Robust implementation of rational numbers. Use assertions to develop an implementation
of Rational (see Exercise 1.2.16) that is immune to overflow..
 */
public class Ex1_2_18 {
    public static void main(String[] args) {
        int T = StdIn.readInt();
        Accumulator a = new Accumulator();
        for (int i = 0; i < T; i++) {
            a.addDataValue(StdRandom.uniformDouble());
        }
        StdOut.println(a);
        StdOut.println(a.var());
        StdOut.println(a.stddev());
    }
}
