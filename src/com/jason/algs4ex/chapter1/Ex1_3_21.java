package com.jason.algs4ex.chapter1;

import com.jason.algs4ex.LinkedList;
import edu.princeton.cs.algs4.StdOut;

/*
1.3.21 Write a method find() that takes a linked list and a string key as arguments
and returns true if some node in the list has key as its item field, false otherwise.
 */
public class Ex1_3_21 {
    public static void main(String[] args) {
        LinkedList<String> l = new LinkedList<>();
        //init
        for (int i = 0; i < 10; i++) {
            l.addFirst(String.valueOf(i));
        }
        StdOut.println("after init: " + l);

        StdOut.println("l.find(\"4\"): " + l.find("4"));
        StdOut.println("l.find(\"0\"): " + l.find("0"));
        StdOut.println("l.find(\"9\"): " + l.find("9"));
        StdOut.println("l.find(\"44\"): " + l.find("44"));
    }
}