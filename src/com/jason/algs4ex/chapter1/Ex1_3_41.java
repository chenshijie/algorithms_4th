package com.jason.algs4ex.chapter1;

import com.jason.algs4ex.Queue;
import edu.princeton.cs.algs4.StdOut;

/*
1.3.41 Copy a queue. Create a new constructor so that
Queue<Item> r = new Queue<Item>(q);
makes r a reference to a new and independent copy of the queue q. You should be able
to push and pop from either q or r without influencing the other. Hint : Delete all of the
elements from q and add these elements to both q and r.
 */
public class Ex1_3_41 {
    public static void main(String[] args) {
        Queue<String> queue1 = new Queue<>();
        for (int i = 0; i < 10; i++) {
            queue1.enqueue(String.valueOf(i));
        }

        Queue<String> queue2 = new Queue<>(queue1);

        StdOut.println("queue1:" + queue1);
        StdOut.println("queue2:" + queue2);

        queue1.dequeue();
        queue2.enqueue("11");
        StdOut.println("queue1:" + queue1);
        StdOut.println("queue2:" + queue2);
    }
}