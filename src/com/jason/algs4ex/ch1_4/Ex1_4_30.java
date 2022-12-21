package com.jason.algs4ex.ch1_4;

import com.jason.algs4ex.Stack;
import com.jason.algs4ex.Steque;
import edu.princeton.cs.algs4.StdOut;

/*
1.4.30 Deque with a stack and a steque. Implement a deque with a stack and a steque
(see Exercise 1.3.32) so that each deque operation takes a constant amortized number
of stack and steque operations.

1.4.30 一个栈和一个steque实现的双向队列。使用一个栈和steque实现一个双向队列（请见练习1.3.32），
使得双向队列的每个操作所需的栈和steque操作均摊后为一个常数。
*/
public class Ex1_4_30 {

    public static void main(String[] args) {
        DequeWithStacksAndSteque<Integer> dq = new DequeWithStacksAndSteque<>();
        for (int i = 0; i < 5; i++) {
            dq.pushLeft(i);
        }
        StdOut.println(dq);
        StdOut.println(dq.popLeft());
        StdOut.println(dq);
        StdOut.println(dq.popRight());
        StdOut.println(dq);
        dq.pushRight(11);
        dq.pushRight(12);
        StdOut.println(dq);
    }

    public static class DequeWithStacksAndSteque<Item> {
        private final Stack<Item> stack;
        private final Steque<Item> steque;

        public DequeWithStacksAndSteque() {
            stack = new Stack<>();
            steque = new Steque<>();
        }

        public void pushLeft(Item item) {
            steque.push(item);
        }

        public Item popLeft() {
            if (this.steque.isEmpty()) {
                stack2Steque();
            }
            return steque.pop();
        }

        public void pushRight(Item item) {
            if (stack.isEmpty()) {
                steque.enqueue(item);
            } else {
                stack.push(item);
            }
        }

        public Item popRight() {
            if (stack.isEmpty()) {
                steque2Stack();
            }
            return stack.pop();
        }

        public int size() {
            return stack.size() + steque.size();
        }

        public boolean isEmpty() {
            return stack.isEmpty() && steque.isEmpty();
        }

        private void stack2Steque() {
            while (stack.size() > 0) {
                steque.push(stack.pop());
            }
        }

        private void steque2Stack() {
            while (steque.size() > 0) {
                stack.push(steque.pop());
            }
        }

        @Override
        public String toString() {
            return (steque.isEmpty() ? "" : steque) + stack.toString();
        }
    }

}
