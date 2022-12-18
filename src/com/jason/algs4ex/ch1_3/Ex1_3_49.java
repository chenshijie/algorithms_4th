package com.jason.algs4ex.ch1_3;

import com.jason.algs4ex.Stack;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/*
1.3.49 Queue with three stacks. Implement a queue with three stacks so that each
queue operation takes a constant (worst-case) number of stack operations. Warning :
high degree of difficulty.

1.3.49 栈与队列。用有限个栈实现一个队列，保证每个队列操作（在最坏的情况下）都只需要常数次的栈操作。
https://www.cnblogs.com/dacc123/p/10574939.html
https://www.cnblogs.com/ikesnowy/p/7157813.html
 */
public class Ex1_3_49 {

    public static void main(String[] args) {

        StackQueue<Integer> q = new StackQueue<>();
        int n = 0;
        for (int i = 0; i < 10; i++) {
            q.enqueue(n++);
        }
        for (int i = 0; i < 5; i++) {
            StdOut.println(q.dequeue());
        }
        for (int i = 0; i < 100; i++) {
            if (StdRandom.bernoulli(0.5)) {
                q.enqueue(n++);
            } else {
                StdOut.println(q.dequeue());
            }
        }
    }

    public static class StackQueue<Item> {
        Stack<Item> H;
        Stack<Item> T;
        Stack<Item> h;
        Stack<Item> HH;
        Stack<Item> TT;
        Stack<Item> Hr;

        boolean isRecopying;
        int nowCopying;

        public StackQueue() {
            this.isRecopying = false;
            this.nowCopying = 0;

            this.H = new Stack<>();
            this.T = new Stack<>();
            this.h = new Stack<>();
            this.HH = new Stack<>();
            this.TT = new Stack<>();
            this.Hr = new Stack<>();
        }

        public Item peek() {
            if (this.isRecopying) {
                return h.peek();
            } else {
                return H.peek();
            }
        }

        public void enqueue(Item item) {
            if (!this.isRecopying && lengthDiff() > 0) {
                this.nowCopying = 0;
                this.T.push(item);
            } else if (!this.isRecopying && lengthDiff() == 0) {
                this.T.push(item);
                this.isRecopying = true;
                this.h = this.H.copy();
                OneStep(OneStep(this));
            } else if (this.isRecopying) {
                this.TT.push(item);
                OneStep(OneStep(this));
            }
        }

        public int lengthDiff() {
            return this.H.size() - this.T.size();
        }

        public Item dequeue() {
            if (!this.isRecopying && lengthDiff() > 0) {
                return this.H.pop();
            } else if (!this.isRecopying && lengthDiff() == 0) {
                Item temp = this.H.pop();
                this.h = this.H.copy();
                this.isRecopying = true;
                OneStep(OneStep(this));
                return temp;
            } else {
                Item temp = this.h.pop();
                this.nowCopying--;
                OneStep(OneStep(this));
                return temp;
            }
        }

        private StackQueue<Item> OneStep(StackQueue<Item> q) {
            if (q.isRecopying && !q.H.isEmpty() && !q.T.isEmpty()) {
                q.nowCopying++;
                q.HH.push(q.T.pop());
                q.Hr.push(q.H.pop());
            } else if (q.isRecopying && q.H.isEmpty() && !q.T.isEmpty()) {
                q.isRecopying = true;
                q.HH.push(q.T.pop());
            } else if (q.isRecopying && q.H.isEmpty() && q.T.isEmpty() && q.nowCopying > 1) {
                q.isRecopying = true;
                q.nowCopying--;
                q.HH.push(q.Hr.pop());
            } else if (q.isRecopying && q.H.isEmpty() && q.T.isEmpty() && q.nowCopying == 1) {
                q.isRecopying = false;
                q.nowCopying--;
                q.HH.push(q.Hr.pop());
                q.H = q.HH;
                q.T = q.TT;
                q.HH = new Stack<>();
                q.TT = new Stack<>();
                q.Hr = new Stack<>();
                q.h = new Stack<>();
            } else if (q.isRecopying && q.H.isEmpty() && q.T.isEmpty() && q.nowCopying == 0) {
                q.isRecopying = false;
                q.H = q.HH;
                q.T = q.TT;
                q.HH = new Stack<>();
                q.TT = new Stack<>();
                q.Hr = new Stack<>();
                q.h = new Stack<>();
            }
            return q;
        }
    }
}