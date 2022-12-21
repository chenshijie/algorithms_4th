package com.jason.algs4ex.ch1_4;

import com.jason.algs4ex.Stack;
import edu.princeton.cs.algs4.StdOut;

/*
1.4.27 Queue with two stacks. Implement a queue with two stacks so that each queue
operation takes a constant amortized number of stack operations. Hint : If you push
elements onto a stack and then pop them all, they appear in reverse order. If you repeat
this process, they’re now back in order.

1.4.27 两个栈实现的队列。用两个栈实现一个队列，使得每个队列操作所需的堆栈操作均摊后为一个常数。
提示：如果将所有元素压入栈再弹出，它们的顺序就被颠倒了。如果再次重复这个过程，它们的顺序则会复原。
*/
public class Ex1_4_27 {

    public static void main(String[] args) {
        QueueWith2Stacks<Integer> q = new QueueWith2Stacks<>();
        int i = 0;
        while (i++ < 5) {
            q.enqueue(i);
        }
        StdOut.println(q.dequeue());
        StdOut.println(q.dequeue());
        while (i++ < 10) {
            q.enqueue(i);
        }

        while (q.size() > 0) {
            StdOut.println(q.dequeue());
        }
    }

    public static class QueueWith2Stacks<Item> {
        private final Stack<Item> leftStack;
        private final Stack<Item> rightStack;

        public QueueWith2Stacks() {
            leftStack = new Stack<>();
            rightStack = new Stack<>();
        }

        public int size() {
            return leftStack.size() + rightStack.size();
        }

        public void enqueue(Item item) {
            rightStack.push(item);
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
