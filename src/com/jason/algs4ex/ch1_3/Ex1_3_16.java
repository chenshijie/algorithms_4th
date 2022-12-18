package com.jason.algs4ex.ch1_3;

import com.jason.algs4ex.Date;
import com.jason.algs4ex.Queue;
import edu.princeton.cs.algs4.In;

import java.util.Arrays;

/*
1.3.16 Using readInts() on page 126 as a model, write a static method readDates() for
Date that reads dates from standard input in the format specified in the table on page 119
and returns an array containing them.
 */
public class Ex1_3_16 {
    public static void main(String[] args) {
        Date[] a = readDates("./data/dates.txt");
        System.out.println(Arrays.toString(a));
    }

    public static Date[] readDates(String name) {
        In in = new In(name);
        Queue<Date> q = new Queue<>();
        while (!in.isEmpty())
            q.enqueue(new Date(in.readString()));
        int N = q.size();
        Date[] a = new Date[N];
        for (int i = 0; i < N; i++)
            a[i] = q.dequeue();
        return a;
    }
}