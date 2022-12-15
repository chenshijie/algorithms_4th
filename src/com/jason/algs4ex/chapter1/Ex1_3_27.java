package com.jason.algs4ex.chapter1;

import com.jason.algs4ex.LinkedList;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/*
1.3.27 Write a method max() that takes a reference to the first node in a linked list as
argument and returns the value of the maximum key in the list. Assume that all keys are
positive integers, and return 0 if the list is empty.
 */
public class Ex1_3_27 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        //init
        for (int i = 0; i < 10; i++) {
            list.addLast(StdRandom.uniformInt(1, 999));
        }

        StdOut.println("After init: ");
        StdOut.println(list);
        StdOut.println("The max value in list is: " + LinkedList.max(list));
    }
}