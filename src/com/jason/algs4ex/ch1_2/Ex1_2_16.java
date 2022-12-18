package com.jason.algs4ex.ch1_2;

import com.jason.algs4ex.Rational;
import edu.princeton.cs.algs4.StdOut;

/*
1.2.16 Rational numbers. Implement an immutable data type Rational for rational
numbers that supports addition, subtraction, multiplication, and division.
public class Rational
Rational(int numerator. int denominator)
Rational plus(Rational b) sum of this number and b
Rational minus(Rational b) difference of this number and b
Rational times(Rational b) product of this number and b
Rational divides(Rational b) quotient of this number and b
boolean equals(Rational that) is this number equal to that ?
String toString() string representation
You do not have to worry about testing for overflow (see Exercise 1.2.17), but use as
instance variables two long values that represent the numerator and denominator to
limit the possibility of overflow. Use Euclid’s algorithm (see page 4) to ensure that the
numerator and denominator never have any common factors. Include a test client that
exercises all of your methods.
 */
public class Ex1_2_16 {
    public static void main(String[] args) {
        Rational r1 = new Rational(1);
        Rational r2 = new Rational(1, 2);
        Rational r3 = new Rational(4, 8);

        StdOut.println("r2.equals(r3):" + r2.equals(r3));
        StdOut.println("r1.plus(r2):" + r1.plus(r2));
        StdOut.println("r1.minus(r2):" + r1.minus(r2));
        StdOut.println("r1.times(r2):" + r1.times(r2));
        StdOut.println("r1.divides(r2):" + r1.divides(r2));

        long a = 10;
        Rational r4 = new Rational(a);
        StdOut.println(r4);
        Rational r5 = new Rational(1, a);
        StdOut.println(r5);
        Rational r6 = new Rational(9);
        StdOut.println(r6);

    }
}
