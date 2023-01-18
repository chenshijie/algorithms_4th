package com.jason.algs4ex.ch2_5;

import com.jason.algs4ex.Selection;
import com.jason.algs4ex.Transaction;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/*
2.5.5 说明为何选择排序是不稳定的。
 */
public class Ex2_5_5 {
    public static void main(String[] args) {
        //定义:所有相等的数经过某种排序方法后，仍能保持它们在排序之前的相对次序，我们就说这种排序方法是稳定的。反之，就是非稳定的。
        Transaction[] transactions = new Transaction[3];
        transactions[0] = new Transaction("Turing   6/17/2001  644.08");
        transactions[1] = new Transaction("Tom   6/17/1998  2644.08");
        transactions[2] = new Transaction("Jack   6/17/1998  244.08");
        StdOut.println(Arrays.toString(transactions));
        Transaction.WhenComparator comparator = new Transaction.WhenComparator();
        Selection.sort(transactions, comparator);
        StdOut.println(Arrays.toString(transactions));
    }
}
