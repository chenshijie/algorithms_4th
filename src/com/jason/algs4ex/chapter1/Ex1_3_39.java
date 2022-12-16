package com.jason.algs4ex.chapter1;

import com.jason.algs4ex.GeneralizedQueue;
import com.jason.algs4ex.Queue;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/*
1.3.39 Ring buffer.
A ring buffer, or circular queue, is a FIFO data structure of a fixed
size N. It is useful for transferring data between asynchronous processes or for storing
log files. When the buffer is empty, the consumer waits until data is deposited; when the
buffer is full, the producer waits to deposit data. Develop an API for a RingBuffer and
an implementation that uses an array representation (with circular wrap-around).
 */
public class Ex1_3_39 {
    public static void main(String[] args) {
        StdOut.println("Example for GeneralizedQueue that uses an array implementation");
        GeneralizedQueue<Integer> queue = new GeneralizedQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.insert(i);
        }
        StdOut.println(queue);

        while (!queue.isEmpty()) {
            int k = StdRandom.uniformInt(1, queue.size() + 1);
            StdOut.println("delete(" + k + "):" + queue.delete(k));
            StdOut.println(queue);
            StdOut.println();
        }

        StdOut.println("Example for GeneralizedQueue which uses a linked-list implementation");
        Queue<Integer> q = new Queue<>();
        for (int i = 0; i < 10; i++) {
            q.enqueue(i);
        }
        for (int i : q) {
            StdOut.print(i + " ");
        }
        StdOut.println();
        while (!q.isEmpty()) {
            int k = StdRandom.uniformInt(1, q.size() + 1);
            StdOut.println("delete(" + k + "):" + q.delete(k));
            for (int i : q) {
                StdOut.print(i + " ");
            }
            StdOut.println();
        }

    }
}