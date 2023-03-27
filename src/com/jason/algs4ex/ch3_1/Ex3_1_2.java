package com.jason.algs4ex.ch3_1;

/*
3.1.2 开发一个符号表的实现ArrayST，使用（无序）数组来实现我们的基本API
 */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Iterator;

class ArrayST<Key extends Comparable<Key>, Value> implements Iterable<Key> {

    private Key[] keys;
    private Value[] values;

    private int n = 0;

    public ArrayST() {
        this(20);
    }

    public ArrayST(int initCapacity) {
        keys = (Key[]) new Comparable[initCapacity];
        values = (Value[]) new Object[initCapacity];
    }

    public void put(Key key, Value val) {
        if (key == null) {
            throw new IllegalArgumentException("calls put() with null key");
        }
        if (val == null) {
            delete(key);
        } else {
            for (int i = 0; i < n; i++) {
                if (keys[i].equals(key)) {
                    values[i] = val;
                    return;
                }
            }
            keys[n] = key;
            values[n] = val;
            n++;
        }
    }

    public Value get(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("calls get() with null key");
        }
        for (int i = 0; i < n; i++) {
            if (keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    public void delete(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("calls delete() with null key");
        }

        for (int i = 0; i < n; i++) {
            if (keys[i].equals(key)) {
                for (int j = i; j < n - 1; j++) {
                    keys[j] = keys[j + 1];
                    values[j] = values[j + 1];
                }
                n--;
                return;
            }
        }
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return n;
    }

    public Iterable<Key> keys() {
        return Arrays.asList(keys).subList(0, n);
    }

    @Override
    public Iterator<Key> iterator() {
        return keys().iterator();
    }
}

public class Ex3_1_2 {
    public static void main(String[] args) {
        ArrayST<String, Integer> st;
        st = new ArrayST<>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }

        for (String s : st.keys()) {
            StdOut.println(s + " " + st.get(s));
        }
    }
}