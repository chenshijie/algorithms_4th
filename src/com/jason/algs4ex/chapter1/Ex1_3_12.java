package com.jason.algs4ex.chapter1;

import com.jason.algs4ex.Stack;
import edu.princeton.cs.algs4.StdOut;

/*
1.3.12 Write an iterable Stack client that has a static method copy() that takes a stack
of strings as argument and returns a copy of the stack. Note : This ability is a prime
example of the value of having an iterator, because it allows development of such functionality
without changing the basic API.
 */
public class Ex1_3_12 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("ABC");
        stack.push("123");
        String s = "QWERTY";
        stack.push(s);

        StdOut.println(stack);
        Stack<String> stack2 = Stack.copy(stack);
        StdOut.println(stack2);
    }
}