package com.jason.algs4ex.ch1_3;

import com.jason.algs4ex.Stack;
import edu.princeton.cs.algs4.StdOut;

/*
1.3.5 What does the following code fragment print when N is 50? Give a high-level
description of what it does when presented with a positive integer N.
Stack<Integer> stack = new Stack<Integer>();
while (N > 0)
{
stack.push(N % 2);
N = N / 2;
}
for (int d : stack) StdOut.print(d);
StdOut.println();
Answer : Prints the binary representation of N (110010 when N is 50).
 */
public class Ex1_3_5 {

    public static void main(String[] args) {
        int N = 50;
        Stack<Integer> stack = new Stack<>(10);
        while (N > 0) {
            stack.push(N % 2);
            N = N / 2;
        }
        for (int d : stack) StdOut.print(d);
        StdOut.println();
    }
}
