package com.jason.algs4ex.ch2_4;

import edu.princeton.cs.algs4.StdOut;

/*
2.4.3 用以下数据结构实现优先队列，支持插入元素和删除最大元素的操作：无序数组、有序数组、无序链表和链表。
将你的4种实现中每种操作在最坏情况下的运行时间上下限制成一张表格。
 */
public class Ex2_4_3 {
    public static void main(String[] args) {
        UnorderedArrayMaxPQ<String> pq = new UnorderedArrayMaxPQ<>(15);
        OrderedArrayMaxPQ<String> pq2 = new OrderedArrayMaxPQ<>(15);
        String[] a = "EX2.4.3TEST".split("");
        for (String s : a) {
            pq.insert(s);
            pq2.insert(s);
        }
        while (!pq.isEmpty()) {
            StdOut.print(pq.delMax() + " ");
        }
        StdOut.println();

        while (!pq2.isEmpty()) {
            StdOut.print(pq2.delMax() + " ");
        }
        StdOut.println();
    }

    public abstract static class ArrayMaxPQ<T extends Comparable<T>> {
        protected T[] pq;
        protected int n;

        public ArrayMaxPQ(int initCapacity) {
            pq = (T[]) new Comparable[initCapacity];
            n = 0;
        }

        protected boolean less(T v, T w) {
            return v.compareTo(w) < 0;
        }

        protected void exch(int i, int j) {
            T swap = pq[i];
            pq[i] = pq[j];
            pq[j] = swap;
        }

        public boolean isEmpty() {
            return n == 0;
        }

        public int size() {
            return n;
        }

        public abstract void insert(T x);

        public abstract T delMax();

    }

    public static class OrderedArrayMaxPQ<T extends Comparable<T>> extends ArrayMaxPQ<T> {
        public OrderedArrayMaxPQ(int initCapacity) {
            super(initCapacity);
        }

        public void insert(T x) {
            int i = n - 1;
            while (i >= 0 && less(x, pq[i])) {
                pq[i + 1] = pq[i];
                i--;
            }
            pq[i + 1] = x;
            n++;
        }

        public T delMax() {


            return pq[--n];
        }
    }

    public static class UnorderedArrayMaxPQ<T extends Comparable<T>> extends ArrayMaxPQ<T> {
        public UnorderedArrayMaxPQ(int initCapacity) {
            super(initCapacity);
        }

        public void insert(T x) {
            pq[n++] = x;
        }

        public T delMax() {
            int max = 0;
            for (int i = 1; i < n; i++)
                if (less(pq[max], pq[i])) max = i;
            exch(max, n - 1);

            return pq[--n];
        }
    }
}
