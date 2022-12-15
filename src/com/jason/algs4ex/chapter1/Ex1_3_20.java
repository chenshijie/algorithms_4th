package com.jason.algs4ex.chapter1;

import com.jason.algs4ex.LinkedList;
import edu.princeton.cs.algs4.StdOut;

/*
1.3.20 Write a method delete() that takes an int argument k and deletes the kth element
in a linked list, if it exists.
 */
public class Ex1_3_20 {
    public static void main(String[] args) {
        LinkedList<String> l = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            l.addLast(String.valueOf(i));
        }

        StdOut.println("after init: " + l);
        StdOut.println(l.delete(1) + " has been deleted");
        StdOut.println("after delete(0): " + l);

        int pos = l.size();
        StdOut.println(l.delete(pos) + " has been deleted");
        StdOut.println("after delete(" + pos + "): " + l);

        StdOut.println(l.delete(4) + " has been deleted");
        StdOut.println("after delete(" + 4 + "): " + l);
    }
}