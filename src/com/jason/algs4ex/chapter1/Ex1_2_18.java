package com.jason.algs4ex.chapter1;

import com.jason.algs4ex.Accumulator;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/*
1.2.18 Variance for accumulator. Validate that the following code, which adds the
methods var() and stddev() to Accumulator, computes both the mean and variance
of the numbers presented as arguments to addDataValue():
public class Accumulator
{
private double m;
private double s;
private int N;
public void addDataValue(double x)
{
N++;
s = s + 1.0 * (N-1) / N * (x - m) * (x - m);
m = m + (x - m) / N;
}
public double mean()
{ return m; }
public double var()
{ return s/(N - 1); }
public double stddev()
{ return Math.sqrt(this.var()); }
}
This implementation is less susceptible to roundoff error than the straightforward implementation
based on saving the sum of the squares of the numbers.
 */
public class Ex1_2_18 {
    public static void main(String[] args) {
        int T = Integer.parseInt(args[0]);
        Accumulator a = new Accumulator();
        for (int i = 0; i < T; i++) {
            a.addDataValue(StdRandom.uniformDouble());
        }
        StdOut.println(a);
        StdOut.println(a.var());
        StdOut.println(a.stddev());
    }
}
