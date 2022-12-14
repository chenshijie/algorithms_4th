package com.jason.algs4ex.chapter1;

import com.jason.algs4ex.LinkedList;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
1.3.19 Give a code fragment that removes the last node in a linked list whose first node
is first.
 */
public class Ex1_3_19 {
    public static void main(String[] args) {
        LinkedList<String> l = new LinkedList<>();
        while (!StdIn.isEmpty()) {
            l.addLast(StdIn.readString());
        }
        StdOut.println(l);
        l.removeLast();
        StdOut.println(l);
    }
}