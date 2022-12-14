package com.jason.algs4ex.chapter1;

import com.jason.algs4ex.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
1.3.15 Write a Queue client that takes a command-line argument k and prints the kth
from the last string found on standard input (assuming that standard input has k or
more strings).
 */
public class Ex1_3_15 {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        Queue<String> q = new Queue<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            StdOut.println(s);
            q.enqueue(s);
        }

        int i = 0;
        for (String s : q) {
            if (i == q.size() - k) {
                StdOut.println("The kth from the last :" + s);
            }
            i++;
        }
    }
}