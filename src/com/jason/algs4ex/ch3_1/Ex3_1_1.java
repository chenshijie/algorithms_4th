package com.jason.algs4ex.ch3_1;

/*
3.1.1 编写一段程序，创建一张符号表并建立字母成绩和数值分数的对应关系，如下表所示。从标准输入读取一系列字母成绩，计算并打印GPA（字母成绩对应的分数的平均值）。
A+   A    A-   B+   B    B-   C+   C    C-   D    F
4.33 4.00 3.67 3.33 3.00 2.67 2.33 2.00 1.67 1.00 0.00
 */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TreeMap;

class ST<Key extends Comparable<Key>, Value> implements Iterable<Key> {

    private TreeMap<Key, Value> st;

    public ST() {
        this.st = new TreeMap<>();
    }

    public Value get(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("calls get() with null key");
        }
        return st.get(key);
    }

    public void put(Key key, Value value) {
        if (key == null) {
            throw new IllegalArgumentException("calls put() with null key");
        }
        if (value == null) {
            st.remove(key);
        } else {
            st.put(key, value);
        }
    }

    public void delete(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("calls delete() with null key");
        }
        st.remove(key);
    }

    public boolean contains(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("calls contains() with null key");
        }
        return st.containsKey(key);
    }

    public int size() {
        return st.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Iterable<Key> keys() {
        return st.keySet();
    }

    public Key min() {
        if (isEmpty()) {
            throw new NoSuchElementException("calls min() with empty symbol table");
        }
        return st.firstKey();
    }

    public Key max() {
        if (isEmpty()) {
            throw new NoSuchElementException("calls max() with empty symbol table");
        }
        return st.lastKey();
    }

    public Key ceiling(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to ceiling() is null");
        }
        Key k = st.ceilingKey(key);
        if (k == null) {
            throw new NoSuchElementException("argument to ceiling() is too large");
        }
        return k;
    }

    public Key floor(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to floor() is null");
        }
        Key k = st.floorKey(key);
        if (k == null) {
            throw new NoSuchElementException("argument to floor() is too small");
        }
        return k;
    }

    @Override
    public Iterator<Key> iterator() {
        return st.keySet().iterator();
    }
}

public class Ex3_1_1 {
    public static void main(String[] args) {
        ST<String, Double> grades = new ST<>();
        grades.put("A", 4.00);
        grades.put("B", 3.00);
        grades.put("C", 2.00);
        grades.put("D", 1.00);
        grades.put("F", 0.00);
        grades.put("A+", 4.33);
        grades.put("B+", 3.33);
        grades.put("C+", 2.33);
        grades.put("A-", 3.67);
        grades.put("B-", 2.67);

        int n = 0;
        double total = 0.0;
        for (n = 0; !StdIn.isEmpty(); n++) {
            String grade = StdIn.readString();
            double value = grades.get(grade);
            total += value;
        }
        double gpa = total / n;
        StdOut.println("GPA = " + gpa);
    }
}