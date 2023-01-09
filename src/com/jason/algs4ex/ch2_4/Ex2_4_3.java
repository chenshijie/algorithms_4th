package com.jason.algs4ex.ch2_4;

import edu.princeton.cs.algs4.StdOut;

/*
2.4.3 用以下数据结构实现优先队列，支持插入元素和删除最大元素的操作：无序数组、有序数组、无序链表和链表。
将你的4种实现中每种操作在最坏情况下的运行时间上下限制成一张表格。
 */
public class Ex2_4_3 {
    public static void main(String[] args) {
        UnorderedArrayMaxPQ<String> pq = new UnorderedArrayMaxPQ<>(15);
        String[] a = "EX2.4.3TEST".split("");
        for (String s : a) {
            pq.insert(s);
        }
        while (!pq.isEmpty()) {
            StdOut.print(pq.delMax() + " ");
        }
        StdOut.println();
    }

    public static class UnorderedArrayMaxPQ<T extends Comparable<T>> {
        private T[] pq;
        private int n;         // number of elements

        public UnorderedArrayMaxPQ(int initCapacity) {
            pq = (T[]) new Comparable[initCapacity];
            n = 0;
        }

        public boolean isEmpty() {
            return n == 0;
        }

        public int size() {
            return n;
        }

        public void insert(T x) {
            pq[n++] = x;
        }

        public T delMax() {
            int max = 0;
            for (int i = 1; i < n; i++)
                if (less(max, i)) max = i;
            exch(max, n - 1);

            return pq[--n];
        }

        private boolean less(int i, int j) {
            return pq[i].compareTo(pq[j]) < 0;
        }

        private void exch(int i, int j) {
            T swap = pq[i];
            pq[i] = pq[j];
            pq[j] = swap;
        }
    }
}
