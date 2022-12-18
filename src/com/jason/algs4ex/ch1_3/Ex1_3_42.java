package com.jason.algs4ex.ch1_3;

import com.jason.algs4ex.LinkedListStack;
import edu.princeton.cs.algs4.StdOut;

/*
1.3.42 Copy a stack. Create a new constructor for the linked-list implementation of
Stack so that
Stack<Item> t = new Stack<Item>(s);
makes t a reference to a new and independent copy of the stack s.
 */
public class Ex1_3_42 {
    public static void main(String[] args) {
        LinkedListStack<String> s = new LinkedListStack<>();
        for (int i = 0; i < 10; i++) {
            s.push(String.valueOf(i));
        }

        LinkedListStack<String> t = new LinkedListStack<>(s);
        StdOut.println("s:" + s);
        StdOut.println("t:" + t);

        s.pop();
        t.push("10");
        StdOut.println("s:" + s);
        StdOut.println("t:" + t);
    }
}