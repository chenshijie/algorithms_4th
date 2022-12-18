package com.jason.algs4ex.ch1_3;

import com.jason.algs4ex.Deque;
import edu.princeton.cs.algs4.StdOut;

/*
1.3.48 Two stacks with a deque. Implement two stacks with a single deque so that each
operation takes a constant number of deque operations (see Exercise 1.3.33).
 */
public class Ex1_3_48 {

    public static void main(String[] args) {
        DoubleStack<Integer> stack = new DoubleStack<>();
        stack.pushLeft(1);
        stack.pushLeft(2);
        StdOut.println("popLeft:" + stack.popLeft());
        StdOut.println("sizeLeft:" + stack.sizeLeft());

        stack.pushRight(11);
        stack.pushRight(12);
        stack.pushRight(13);
        StdOut.println("popRight:" + stack.popRight());
        StdOut.println("sizeRight:" + stack.sizeRight());
    }

    public static class DoubleStack<Item> {
        private final Deque<Item> deque;
        private int leftItemCount;
        private int rightItemCount;

        public DoubleStack() {
            this.deque = new Deque<>();
        }

        public boolean isLeftEmpty() {
            return leftItemCount == 0;
        }

        public boolean isRightEmpty() {
            return rightItemCount == 0;
        }

        public void pushLeft(Item item) {
            deque.pushLeft(item);
            leftItemCount++;
        }

        public void pushRight(Item item) {
            deque.pushRight(item);
            rightItemCount++;
        }

        public Item popLeft() {
            if (isLeftEmpty()) {
                return null;
            }
            Item item = deque.popLeft();
            leftItemCount--;
            return item;
        }

        public Item popRight() {
            if (isRightEmpty()) {
                return null;
            }
            Item item = deque.popRight();
            rightItemCount--;
            return item;
        }

        public int sizeLeft() {
            return leftItemCount;
        }

        public int sizeRight() {
            return rightItemCount;
        }

    }
}