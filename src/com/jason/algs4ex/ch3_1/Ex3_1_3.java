package com.jason.algs4ex.ch3_1;

/*
3.1.3 开发一个符号表的实现OrderedSequentialSearchST，使用有序链表来实现我们的有序符号表API。
 */

import com.jason.algs4ex.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

class OrderedSequentialSearchST<Key extends Comparable<Key>, Value> {
    private int n;
    private Node first;

    public OrderedSequentialSearchST() {
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key))
                return x.val;
        }
        return null;
    }

    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if (val == null) {
            delete(key);
            return;
        }

        if (first == null) {
            first = new Node(key, val, null, null);
            n++;
        } else if (key.compareTo(first.key) < 0) {
            first = new Node(key, val, first, null);
            first.next.pre = first;
            n++;
        } else {
            for (Node x = first; x != null; x = x.next) {
                if (key.equals(x.key)) {
                    x.val = val;
                    return;
                } else {
                    if (x.key.compareTo(key) > 0) {
                        x.pre = x.pre.next = new Node(key, val, x, x.pre);
                        n++;
                        return;
                    }
                }
                if (x.next == null) {
                    x.next = new Node(key, val, null, x);
                    n++;
                    return;
                }
            }

        }


    }

    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        first = delete(first, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;
        if (key.equals(x.key)) {
            n--;
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<>();
        for (Node x = first; x != null; x = x.next)
            queue.enqueue(x.key);
        return queue;
    }

    private class Node {
        private final Key key;
        private Value val;
        private Node next;

        private Node pre;

        public Node(Key key, Value val, Node next, Node pre) {
            this.key = key;
            this.val = val;
            this.next = next;
            this.pre = pre;
        }
    }
}

public class Ex3_1_3 {
    public static void main(String[] args) {
        //S E A R C H E X A M P L E
        OrderedSequentialSearchST<String, Integer> st;
        st = new OrderedSequentialSearchST<>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }

        for (String s : st.keys()) {
            StdOut.println(s + " " + st.get(s));
        }
    }
}