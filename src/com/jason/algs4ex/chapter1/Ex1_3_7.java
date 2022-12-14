package com.jason.algs4ex.chapter1;

import com.jason.algs4ex.Stack;
import edu.princeton.cs.algs4.StdOut;

/*
1.3.7 Add a method peek() to Stack that returns the most recently inserted item on
the stack (without popping it).
 */
public class Ex1_3_7 {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(10);
        for (int i = 0; i < 9; i++) {
            stack.push(i);
        }
        StdOut.println("stack: " + stack);
        int p = stack.pop();
        StdOut.println(p + " has been popped from stack");
        StdOut.println("stack after pop " + stack);
        int p1 = stack.peek();
        StdOut.println(p1 + " has been peeked from stack");
        StdOut.println("stack after peek " + stack);
    }
}
