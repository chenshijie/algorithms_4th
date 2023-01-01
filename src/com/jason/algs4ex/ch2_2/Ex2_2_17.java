package com.jason.algs4ex.ch2_2;

import com.jason.algs4ex.LinkedList;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/*
2.2.17 链表排序。实现对链表的自然排序（这是将链表排序的最佳方法，因为它不需要额外的空间，且运行时间是线性对数级别的）。

2.2.17 Linked-list sort. Implement a natural mergesort for linked lists. (This is the
method of choice for sorting linked lists because it uses no extra space and is guaranteed
to be linearithmic.)
*/
public class Ex2_2_17 {

    public static void main(String[] args) {
        int N = 20;
        LinkedList<Comparable<Integer>> list = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            list.addFirst(StdRandom.uniformInt(0, 100 * N));
        }

        StdOut.println(list);
        LinkedList.sort(list);
        StdOut.println(list);

    }
}