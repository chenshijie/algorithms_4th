package com.jason.algs4ex.chapter1;

import com.jason.algs4ex.Queue;
import edu.princeton.cs.algs4.StdOut;

/*
1.3.37 Josephus problem. In the Josephus problem from antiquity, N people are in dire
straits and agree to the following strategy to reduce the population. They arrange themselves
in a circle (at positions numbered from 0 to N–1) and proceed around the circle,
eliminating every Mth person until only one person is left. Legend has it that Josephus
figured out where to sit to avoid being eliminated. Write a Queue client Josephus that
takes N and M from the command line and prints out the order in which people are
eliminated (and thus would show Josephus where to sit in the circle).
% java Josephus 7 2
1 3 5 0 4 2 6
 */
public class Ex1_3_37 {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int M = Integer.parseInt(args[1]);
        if (N <= 1) {
            StdOut.println("N should greater than 1");
        }

        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < N; i++) {
            queue.enqueue(i);
        }

        while (!queue.isEmpty()) {
            for (int i = 1; i < M; i++) {
                queue.enqueue(queue.dequeue());
            }
            StdOut.print(queue.dequeue() + " ");
        }
    }
}