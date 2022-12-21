package com.jason.algs4ex.ch1_4;

import com.jason.algs4ex.Stack;
import edu.princeton.cs.algs4.StdOut;

/*
1.4.29 Steque with two stacks. Implement a steque with two stacks so that each steque
operation (see Exercise 1.3.32) takes a constant amortized number of stack operations.

1.4.29 两个栈实现的steque。用两个栈实现一个steque（请见练习1.3.32），使得每个steque操作所需的栈操均摊后为一个常数。
*/
public class Ex1_4_29 {

    public static void main(String[] args) {
        StequeWith2Stacks<Integer> steque = new StequeWith2Stacks<>();
        for (int i = 0; i < 10; i++) {
            steque.push(i);
        }

        StdOut.println(steque.dequeue());
        StdOut.println(steque.dequeue());

        StdOut.println(steque.pop());
        StdOut.println(steque.pop());

        StdOut.println(steque.size());
    }

    public static class StequeWith2Stacks<Item> {
        private final Stack<Item> leftStack;
        private final Stack<Item> rightStack;

        public StequeWith2Stacks() {
            leftStack = new Stack<>();
            rightStack = new Stack<>();
        }

        public int size() {
            return leftStack.size() + rightStack.size();
        }

        public void push(Item item) {
            rightStack.push(item);
        }

        public Item pop() {
            if (rightStack.size() > 0) {
                return rightStack.pop();
            } else {
                if (leftStack.size() > 0) {
                    while (leftStack.size() > 0) {
                        rightStack.push(leftStack.pop());
                    }
                    return rightStack.pop();
                } else {
                    return null;
                }
            }
        }

        public Item dequeue() {
            if (leftStack.size() > 0) {
                return leftStack.pop();
            } else {
                if (rightStack.size() > 0) {
                    while (rightStack.size() > 0) {
                        leftStack.push(rightStack.pop());
                    }
                    return leftStack.pop();
                } else {
                    return null;
                }
            }
        }
    }

}
