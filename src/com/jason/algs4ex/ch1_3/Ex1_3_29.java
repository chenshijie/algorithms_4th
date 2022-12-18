package com.jason.algs4ex.ch1_3;

import com.jason.algs4ex.CircleLinkedListQueue;
import edu.princeton.cs.algs4.StdOut;

/*
1.3.29 Write a Queue implementation that uses a circular linked list, which is the same
as a linked list except that no links are null and the value of last.next is first whenever
the list is not empty. Keep only one Node instance variable (last).
 */
public class Ex1_3_29 {
    public static void main(String[] args) {
        CircleLinkedListQueue<Integer> q = new CircleLinkedListQueue<>();
        //init
        for (int i = 0; i < 10; i++) {
            q.enqueue(i);
        }
        for (Integer i : q) {
            StdOut.print(i + " ");
        }
        StdOut.println();
        for (int i = 0; i < 4; i++) {
            StdOut.println("dequeue: " + q.dequeue() + " ,queue size: " + q.size());
        }
        for (Integer i : q) {
            StdOut.print(i + " ");
        }
        StdOut.println();
    }
}