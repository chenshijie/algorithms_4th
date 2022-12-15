package com.jason.algs4ex.chapter1;

import com.jason.algs4ex.LinkedList;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/*
1.3.28 Develop a recursive solution to the previous question.
 */
public class Ex1_3_28 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        //init
        for (int i = 0; i < 10; i++) {
            list.addLast(StdRandom.uniformInt(1, 999));
        }

        StdOut.println("After init: ");
        StdOut.println(list);
        StdOut.println("The max value in list is: " + LinkedList.maxByRecursion(list));
    }
}