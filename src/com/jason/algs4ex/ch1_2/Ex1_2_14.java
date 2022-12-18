package com.jason.algs4ex.ch1_2;

import com.jason.algs4ex.Transaction;
import edu.princeton.cs.algs4.StdOut;

/*
1.2.14 Using our implementation of equals() in Date as a model (page 103), develop
implementations of equals() for Transaction.
 */
public class Ex1_2_14 {
    public static void main(String[] args) {
        Transaction t1 = new Transaction("Turing   6/17/1990  644.08");
        Transaction t2 = new Transaction("Tarjan   3/26/2002 4121.85");
        Transaction t3 = new Transaction("Turing   6/17/1990  644.08");

        StdOut.println("t1.equals(t2):" + t1.equals(t2));
        StdOut.println("t1.equals(t3):" + t1.equals(t3));
    }
}
