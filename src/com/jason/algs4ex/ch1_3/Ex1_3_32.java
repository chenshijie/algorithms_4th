package com.jason.algs4ex.ch1_3;

import com.jason.algs4ex.Steque;
import edu.princeton.cs.algs4.StdOut;

/*
1.3.32 Steque. A stack-ended queue or steque is a data type that supports push, pop, and
enqueue. Articulate an API for this ADT. Develop a linked-list-based implementation.
 */
public class Ex1_3_32 {

    public static void main(String[] args) {
        Steque<Integer> sq = new Steque<>();
        for (int i = 0; i < 10; i++) {
            sq.enqueue(i);
        }

        for (int i : sq) {
            StdOut.print(i + " ");
        }
        StdOut.println();

        StdOut.println("sq.dequeue(): " + sq.dequeue());
        StdOut.println("sq: " + sq);

        sq.push(99);
        StdOut.println("sq.push(99)");
        StdOut.println("sq: " + sq);

        StdOut.println("sq.pop(): " + sq.pop());
        StdOut.println("sq: " + sq);
    }
}