package com.jason.algs4ex.ch1_2;

import com.jason.algs4ex.Rational;
import edu.princeton.cs.algs4.StdOut;

/*
1.2.17 Robust implementation of rational numbers. Use assertions to develop an implementation
of Rational (see Exercise 1.2.16) that is immune to overflow..
 */
public class Ex1_2_17 {
    public static void main(String[] args) {
        Rational r = new Rational(1, 0);
        StdOut.println(r);

        Rational r1 = new Rational(1, 110);
        StdOut.println(r1);

        StdOut.println(r1.plus(r));
    }
}
