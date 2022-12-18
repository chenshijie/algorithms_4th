package com.jason.algs4ex.ch1_3;

import com.jason.algs4ex.GeneralizedQueue;
import com.jason.algs4ex.Queue;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/*
1.3.38 Delete kth element. Implement a class that supports the following API:

public class GeneralizedQueue<Item>
GeneralizedQueue() create an empty queue
boolean isEmpty() is the queue empty?
void insert(Item x) add an item
Item delete(int k) delete and return the kth least recently inserted item
API for a generic generalized queue

First, develop an implementation that uses an array implementation, and then develop
one that uses a linked-list implementation. Note : the algorithms and data structures
that we introduce in Chapter 3 make it possible to develop an implementation that
can guarantee that both insert() and delete() take time prortional to the logarithm
of the number of items in the queue—see Exercise 3.5.27.
 */
public class Ex1_3_38 {
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