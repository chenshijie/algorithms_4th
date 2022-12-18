package com.jason.algs4ex.ch1_3;

import com.jason.algs4ex.Queue;
import edu.princeton.cs.algs4.StdOut;

/*
1.3.47 Catenable queues, stacks, or steques. Add an extra operation catenation that (destructively)
concatenates two queues, stacks, or steques (see Exercise 1.3.32). Hint : Use
a circular linked list, maintaining a pointer to the last item.
 */
public class Ex1_3_47 {

    public static void main(String[] args) {
        Queue<Integer> q1 = new Queue<>();
        Queue<Integer> q2 = new Queue<>();
        for (int i = 0; i < 10; i++) {
            q1.enqueue(i);
            q2.enqueue(i + 10);
        }

        StdOut.println(q1);
        StdOut.println(q2);
        q1.catenate(q2);
        StdOut.println(q1);
        StdOut.println(q2);

    }
}