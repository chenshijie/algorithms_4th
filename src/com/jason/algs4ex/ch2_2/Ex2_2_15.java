package com.jason.algs4ex.ch2_2;

import com.jason.algs4ex.Queue;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/*
2.2.15 自底向上的有序队列归并排序。用下面的方法编写一个自底向上的归并排序：给定N个元素，创建N个队列，每个队列包含其中一个元素。
创建一个由这N个队列组成的队列，然后不断用练习2.2.14中的方法将队列的头两个元素归并，并将结果重新加入到队列结尾，直到队列的队列只剩下一个元素为止。

2.2.15 Bottom-up queue mergesort. Develop a bottom-up mergesort implementation
based on the following approach: Given N items, create N queues, each containing one
of the items. Create a queue of the N queues. Then repeatedly apply the merging operation
of Exercise 2.2.14 to the first two queues and reinsert the merged queue at the end.
Repeat until the queue of queues contains only one queue.
*/
public class Ex2_2_15 {

    public static void main(String[] args) {
        Queue<Queue<Comparable<Integer>>> q = new Queue<>();

        int N1 = 10;
        for (int i = 0; i < N1; i++) {
            Queue<Comparable<Integer>> temp = new Queue<>();
            temp.enqueue(StdRandom.uniformInt(0, N1));
            q.enqueue(temp);
        }

        while (q.size() > 1) {
            q.enqueue(Ex2_2_14.mergeSortedQueue(q.dequeue(), q.dequeue()));
        }
        StdOut.println(q.peek());
    }
}