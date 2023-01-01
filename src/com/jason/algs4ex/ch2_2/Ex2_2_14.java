package com.jason.algs4ex.ch2_2;

import com.jason.algs4ex.Queue;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/*
2.2.14 归并有序的队列。编写一个静态方法，将两个有序的队列作为参数，返回一个归并后的有序队列。

2.2.14 Merging sorted queues. Develop a static method that takes two queues of sorted
items as arguments and returns a queue that results from merging the queues into
sorted order.
*/
public class Ex2_2_14 {

    public static <T> Queue<Comparable<T>> mergeSortedQueue(Queue<Comparable<T>> q1, Queue<Comparable<T>> q2) {
        Queue<Comparable<T>> q = new Queue<>();
        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (q1.peek().compareTo((T) q2.peek()) < 0) {
                q.enqueue(q1.dequeue());
            } else {
                q.enqueue(q2.dequeue());
            }
        }
        while (!q1.isEmpty()) {
            q.enqueue(q1.dequeue());
        }
        while (!q2.isEmpty()) {
            q.enqueue(q2.dequeue());
        }
        return q;
    }

    public static void main(String[] args) {
        Queue<Comparable<Integer>> q1 = new Queue<>();
        Queue<Comparable<Integer>> q2 = new Queue<>();

        int N1 = 10;
        int N2 = 20;
        for (int i = 0; i < N1; i++) {
            q1.enqueue(StdRandom.uniformInt(i * 5, (i + 1) * 5));
        }
        for (int i = 0; i < N2; i++) {
            q2.enqueue(StdRandom.uniformInt(i * 3, (i + 1) * 3));
        }

        StdOut.println(q1);
        StdOut.println(q2);

        StdOut.println(mergeSortedQueue(q1, q2));
    }
}