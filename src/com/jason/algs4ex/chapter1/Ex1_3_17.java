package com.jason.algs4ex.chapter1;

import com.jason.algs4ex.Queue;
import com.jason.algs4ex.Transaction;
import edu.princeton.cs.algs4.In;

import java.util.Arrays;

/*
1.3.17 Do Exercise 1.3.16 for Transaction.
 */
public class Ex1_3_17 {
    public static void main(String[] args) {
        Transaction[] a = readTransactions("./data/tinyBatch.txt");
        System.out.println(Arrays.toString(a));
    }

    public static Transaction[] readTransactions(String name) {
        In in = new In(name);
        Queue<Transaction> q = new Queue<>();
        while (!in.isEmpty())
            q.enqueue(new Transaction(in.readLine()));
        int N = q.size();
        Transaction[] a = new Transaction[N];
        for (int i = 0; i < N; i++)
            a[i] = q.dequeue();
        return a;
    }
}