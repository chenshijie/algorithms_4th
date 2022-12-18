package com.jason.algs4ex.ch1_1;

import edu.princeton.cs.algs4.StdOut;

/*
English-language description:

Compute the greatest common divisor of
two nonnegative integers p and q as follows:
If q is 0, the answer is p. If not, divide p by q
and take the remainder r. The answer is the
greatest common divisor of q and r.

Java-language description:
public static int gcd(int p, int q)
{
 if (q == 0) return p;
 int r = p % q;
 return gcd(q, r);
}
Euclid’s algorithm

1.1.24 Give the sequence of values of p and q that are computed when Euclid’s algorithm
is used to compute the greatest common divisor of 105 and 24. Extend the code
given on page 4 to develop a program Euclid that takes two integers from the command
line and computes their greatest common divisor, printing out the two arguments for
each call on the recursive method. Use your program to compute the greatest common
divisor or 1111111 and 1234567
 */
public class Ex1_1_24 {
    public static int gcd(int p, int q) {
        StdOut.println("p=" + p + ", q=" + q);
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }

    public static void main(String[] args) {
        StdOut.println("Ex1_1_24");
        int p = Integer.parseInt(args[0]);
        int q = Integer.parseInt(args[1]);
        int gcdValue = gcd(p, q);
        StdOut.printf("the greatest common divisor of %d and %d is %d\n", p, q, gcdValue);
    }
}
