package com.jason.algs4ex.ch2_4;

import com.jason.algs4ex.LinkedList;
import edu.princeton.cs.algs4.StdOut;

/*
2.4.3 用以下数据结构实现优先队列，支持插入元素和删除最大元素的操作：无序数组、有序数组、无序链表和链表。
将你的4种实现中每种操作在最坏情况下的运行时间上下限制成一张表格。
 */
public class Ex2_4_3 {
    public static void main(String[] args) {
        UnorderedArrayMaxPQ<String> pq1 = new UnorderedArrayMaxPQ<>(15);
        OrderedArrayMaxPQ<String> pq2 = new OrderedArrayMaxPQ<>(15);
        UnorderedLinkedListMaxPQ<String> pq3 = new UnorderedLinkedListMaxPQ<>();
        OrderedLinkedListMaxPQ<String> pq4 = new OrderedLinkedListMaxPQ<>();
        String[] a = "EX2.4.3TEST".split("");
        for (String s : a) {
            pq1.insert(s);
            pq2.insert(s);
            pq3.insert(s);
            pq4.insert(s);
        }
        while (!pq1.isEmpty()) {
            StdOut.print(pq1.delMax() + " ");
        }
        StdOut.println();

        while (!pq2.isEmpty()) {
            StdOut.print(pq2.delMax() + " ");
        }
        StdOut.println();

        while (!pq3.isEmpty()) {
            StdOut.print(pq3.delMax() + " ");
        }
        StdOut.println();

        while (!pq4.isEmpty()) {
            StdOut.print(pq4.delMax() + " ");
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

    public abstract static class LinkedListMaxPQ<T extends Comparable<T>> {
        protected LinkedList<T> list;

        public LinkedListMaxPQ() {
            list = new LinkedList<>();
        }

        protected boolean less(T v, T w) {
            return v.compareTo(w) < 0;
        }

        public boolean isEmpty() {
            return list.isEmpty();
        }

        public int size() {
            return list.size();
        }

        public abstract void insert(T x);

        public abstract T delMax();

    }

    public static class UnorderedLinkedListMaxPQ<T extends Comparable<T>> extends LinkedListMaxPQ<T> {
        public UnorderedLinkedListMaxPQ() {
            super();
        }

        @Override
        public void insert(T x) {
            this.list.addFirst(x);
        }

        @Override
        public T delMax() {
            return list.delete(LinkedList.maxNode(list));
        }
    }

    public static class OrderedLinkedListMaxPQ<T extends Comparable<T>> extends LinkedListMaxPQ<T> {
        public OrderedLinkedListMaxPQ() {
            super();
        }

        @Override
        public void insert(T x) {
            int i = list.size() - 1;
            while (i >= 0) {
                T t = list.getItemByIndex(i);
                if (less(x, t)) {
                    i--;
                } else {
                    break;
                }
            }
            StdOut.println(x);
            StdOut.println(i);
            StdOut.println();
            if (i < 0) {
                list.addFirst(x);
                return;
            }
            list.insertAfter(list.findNode(i), list.generateNode(x));
        }

        @Override
        public T delMax() {
            return list.removeLast();
        }
    }

}
