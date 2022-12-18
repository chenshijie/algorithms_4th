package com.jason.algs4ex.ch1_3;

import com.jason.algs4ex.ResizingArrayQueueOfStrings;
import edu.princeton.cs.algs4.StdOut;

/*
1.3.14 Develop a class ResizingArrayQueueOfStrings that implements the queue
abstraction with a fixed-size array, and then extend your implementation to use array
resizing to remove the size restriction.
 */
public class Ex1_3_14 {
    public static void main(String[] args) {
        ResizingArrayQueueOfStrings q = new ResizingArrayQueueOfStrings();
        StdOut.println(q.info());
        for (int i = 0; i < 10; i++) {
            q.enqueue(String.valueOf(i));
            StdOut.println(q.info());
        }

        for (int i = 0; i < 10; i++) {
            q.dequeue();
            StdOut.println(q.info());
        }
    }
}