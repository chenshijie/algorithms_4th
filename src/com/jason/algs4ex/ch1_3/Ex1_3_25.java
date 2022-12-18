package com.jason.algs4ex.ch1_3;

import com.jason.algs4ex.LinkedList;
import edu.princeton.cs.algs4.StdOut;

/*
1.3.25 Write a method insertAfter() that takes two linked-list Node arguments and
inserts the second after the first on its list (and does nothing if either argument is null).
 */
public class Ex1_3_25 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        //init
        for (int i = 0; i < 10; i++) {
            list.addLast(String.valueOf(i));
        }

        StdOut.println("After init: " + list);
        list.insertAfter(list.findNode(3), list.generateNode("3.1"));
        StdOut.println("After insertAfter the node which index is 3: " + list);
    }
}