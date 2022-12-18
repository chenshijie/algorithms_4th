package com.jason.algs4ex.ch1_3;

import com.jason.algs4ex.LinkedList;
import edu.princeton.cs.algs4.StdOut;

/*
1.3.24 Write a method removeAfter() that takes a linked-list Node as argument and
removes the node following the given one (and does nothing if the argument or the next
field in the argument node is null).
 */
public class Ex1_3_24 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        //init
        for (int i = 0; i < 10; i++) {
            list.addLast(String.valueOf(i));
        }
        StdOut.println("After init: " + list);
        list.removeAfter(list.findNode(3));
        StdOut.println("After removeAfter the node which index is 3: " + list);
    }
}