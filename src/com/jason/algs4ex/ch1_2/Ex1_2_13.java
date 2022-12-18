package com.jason.algs4ex.ch1_2;

import com.jason.algs4ex.Transaction;
import edu.princeton.cs.algs4.StdOut;

/*
1.2.13 Using our implementation of Date as a model (page 91), develop an implementation
of Transaction.
 */
public class Ex1_2_13 {
    public static void main(String[] args) {
        Transaction t1 = new Transaction("Turing   6/17/1990  644.08");
        Transaction t2 = new Transaction("Tarjan   3/26/2002 4121.85");

        StdOut.println(t1.compareTo(t2));

        StdOut.println(t2);
        StdOut.println(t1.hashCode());
    }
}
