package com.jason.algs4ex.ch1_4;

import com.jason.algs4ex.Queue;
import edu.princeton.cs.algs4.StdOut;

/*
1.4.28 Stack with a queue. Implement a stack with a single queue so that each stack
operations takes a linear number of queue operations. Hint : To delete an item, get all
of the elements on the queue one at a time, and put them at the end, except for the last
one which you should delete and return. (This solution is admittedly very inefficient.)

1.4.28 一个队列实现的栈。使用一个队列实现一个栈，使得每个栈操作所需的队列操作数量为线性级别。
提示：要删除一个元素，将队列中的所有元素一一出列再入列，除了最后一个元素，应该将它删除并返回（这种方法的确非常低效）。
*/
public class Ex1_4_28 {

    public static void main(String[] args) {
        StackWithQueue<Integer> stack = new StackWithQueue<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }

        StdOut.println(stack.pop());
        StdOut.println(stack.pop());
        stack.push(10);
        while (stack.size() > 0) {
            StdOut.println(stack.pop());
        }
    }

    public static class StackWithQueue<Item> {
        private final Queue<Item> queue;

        public StackWithQueue() {
            queue = new Queue<>();
        }

        public int size() {
            return queue.size();
        }

        public void push(Item item) {
            queue.enqueue(item);
        }

        public Item pop() {
            for (int i = 0; i < queue.size() - 1; i++) {
                queue.enqueue(queue.dequeue());
            }
            return queue.dequeue();
        }
    }

}
