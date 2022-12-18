package com.jason.algs4ex.ch1_3;

import com.jason.algs4ex.Queue;
import com.jason.algs4ex.Stack;
import edu.princeton.cs.algs4.StdOut;

/*
1.3.6 What does the following code fragment do to the queue q?
Stack<String> stack = new Stack<String>();
while (!q.isEmpty())
stack.push(q.dequeue());
while (!stack.isEmpty())
q.enqueue(stack.pop());
 */
public class Ex1_3_6 {

    public static void main(String[] args) {
        //String[] args1 = {"1","2","3"};
        Queue<String> queue = new Queue<>();
        for (String arg : args) {
            queue.enqueue(arg);
        }

        StdOut.print("queue:");
        for (String s : queue) {
            StdOut.print(s + " ");
        }
        StdOut.println();
        Stack<String> stack = new Stack<>();
        while (!queue.isEmpty())
            stack.push(queue.dequeue());
        StdOut.print("stack:");
        for (String s : stack) {
            StdOut.print(s + " ");
        }
        StdOut.println();
        while (!stack.isEmpty())
            queue.enqueue(stack.pop());

        StdOut.print("queue:");
        for (String s : queue) {
            StdOut.print(s + " ");
        }
        StdOut.println();
    }
}
