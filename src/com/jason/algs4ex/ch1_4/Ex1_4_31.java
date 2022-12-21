package com.jason.algs4ex.ch1_4;

import com.jason.algs4ex.Stack;
import edu.princeton.cs.algs4.StdOut;

/*
1.4.31 Deque with three stacks. Implement a deque with three stacks so that each
deque operation takes a constant amortized number of stack operations.

1.4.31 三个栈实现的双向队列。使用三个栈实现一个双向队列，使得双向队列的每个操作所需的栈操作均摊后为一个常数。
*/
public class Ex1_4_31 {

    public static void main(String[] args) {
        DequeWith3Stacks<Integer> dq = new DequeWith3Stacks<>();
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

    public static class DequeWith3Stacks<Item> {
        private final Stack<Item> left;
        private final Stack<Item> middle;
        private final Stack<Item> right;

        public DequeWith3Stacks() {
            left = new Stack<>();
            middle = new Stack<>();
            right = new Stack<>();
        }

        public void pushLeft(Item item) {
            left.push(item);
        }

        public Item popLeft() {
            if (left.isEmpty()) {
                move(right, left);
            }
            return left.pop();
        }

        public void pushRight(Item item) {
            right.push(item);
        }

        public Item popRight() {
            if (right.isEmpty()) {
                move(left, right);
            }
            return right.pop();
        }

        public void move(Stack<Item> s, Stack<Item> d) {
            int n = s.size();
            for (int i = 0; i < n / 2; i++) {
                middle.push(s.pop());
            }
            while (!s.isEmpty()) {
                d.push(s.pop());
            }
            while (!middle.isEmpty()) {
                s.push(middle.pop());
            }
        }

        public int size() {
            return left.size() + middle.size() + right.size();
        }

        public boolean isEmpty() {
            return left.isEmpty() && middle.isEmpty() && right.isEmpty();
        }

        @Override
        public String toString() {
            return left.toString() + middle + right;
        }
    }

}
