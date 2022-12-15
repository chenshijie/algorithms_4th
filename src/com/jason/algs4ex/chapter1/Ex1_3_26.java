package com.jason.algs4ex.chapter1;

import com.jason.algs4ex.LinkedList;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/*
1.3.26 Write a method remove() that takes a linked list and a string key as arguments
and removes all of the nodes in the list that have key as its item field.
 */
public class Ex1_3_26 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        //init
        for (int i = 0; i < 10; i++) {
            list.addLast(String.valueOf(StdRandom.uniformInt(1, 5)));
        }

        StdOut.println("After init: ");
        StdOut.println(list);
        list.remove("2");
        StdOut.println("After remove(\"2\"): ");
        StdOut.println(list);
    }
}