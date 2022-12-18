package com.jason.algs4ex.ch1_3;

import com.jason.algs4ex.RandomQueue;
import edu.princeton.cs.algs4.StdOut;

/*
1.3.36 Random iterator. Write an iterator for RandomQueue<Item> from the previous
exercise that returns the items in random order.
 */
public class Ex1_3_36 {
    public static void main(String[] args) {
        RandomQueue<Integer> rq = new RandomQueue<>();
        for (int i = 0; i < 10; i++) {
            rq.enqueue(i);
        }

        for (int n = 0; n < 5; n++) {
            for (int i : rq) {
                StdOut.print(i + " ");
            }
            StdOut.println();
        }
    }
}