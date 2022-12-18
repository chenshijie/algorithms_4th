package com.jason.algs4ex.ch1_3;

import com.jason.algs4ex.Stack;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/*
1.3.50 Fail-fast iterator. Modify the iterator code in Stack to immediately throw a
java.util.ConcurrentModificationException if the client modifies the collection
(via push() or pop()) during iteration? b).
Solution: Maintain a counter that counts the number of push() and pop() operations.
When creating an iterator, store this value as an Iterator instance variable. Before
each call to hasNext() and next(), check that this value has not changed since construction
of the iterator; if it has, throw the exception.
 */
public class Ex1_3_50 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 10; i > 0; i--) {
            stack.push(i);
        }

        for (Integer integer : stack) {
            StdOut.print(integer + " ");
        }
        StdOut.println();

        Iterator<Integer> iterator2 = stack.iterator();
        int n = 0;
        while (iterator2.hasNext()) {
            if (n == 5) {
                stack.push(9999);
            }
            n++;
            StdOut.print(iterator2.next() + " ");
        }
        StdOut.println();
    }
}