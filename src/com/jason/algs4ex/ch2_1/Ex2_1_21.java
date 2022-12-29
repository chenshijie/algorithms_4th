package com.jason.algs4ex.ch2_1;

import com.jason.algs4ex.Insertion;
import com.jason.algs4ex.Transaction;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
2.1.21 可比较的交易。用我们的Date类（请见2.1.1.4节）
作为模板扩展你的Transaction类（请见练习1.2.13），实现Comparable接口，使交易能够按照金额排序。 */
public class Ex2_1_21 {

    public static void main(String[] args) {
        String[] lines = StdIn.readAllLines();
        Transaction[] transactions = new Transaction[lines.length];
        for (int i = 0; i < lines.length; i++) {
            transactions[i] = new Transaction(lines[i]);
        }
        for (Transaction t : transactions) {
            StdOut.println(t);
        }

        Insertion.sort(transactions);
        StdOut.println();
        for (Transaction t : transactions) {
            StdOut.println(t);
        }
    }
}