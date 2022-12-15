package com.jason.algs4ex.chapter1;


import com.jason.algs4ex.Deque;
import com.jason.algs4ex.ResizingArrayDeque;
import edu.princeton.cs.algs4.StdOut;

/*
1.3.33 Deque. A double-ended queue or deque (pronounced “deck”) is like a stack or
a queue but supports adding and removing items at both ends. A deque stores a collection
of items and supports the following API:
public class Deque<Item> implements Iterable<Item>
Deque() create an empty deque
boolean isEmpty() is the deque empty?
int size() number of items in the deque
void pushLeft(Item item) add an item to the left end
void pushRight(Item item) add an item to the right end
Item popLeft() remove an item from the left end
Item popRight() remove an item from the right end
API for a generic double-ended queue
Write a class Deque that uses a doubly-linked list to implement this API and a class
ResizingArrayDeque that uses a resizing array.
 */
public class Ex1_3_33 {

    public static void main(String[] args) {
        Deque<Integer> dq = new Deque<>();
        for (int i = 0; i < 5; i++) {
            dq.pushLeft(i);
        }
        StdOut.println(dq);
        StdOut.println(dq.popLeft());
        StdOut.println(dq.popRight());
        StdOut.println(dq);
        dq.pushRight(11);
        dq.pushRight(12);
        StdOut.println(dq);
        StdOut.println("------------------------------------------");

        ResizingArrayDeque<Integer> radq = new ResizingArrayDeque<>();
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                radq.pushLeft(i);
            } else {
                radq.pushRight(i);
            }
            StdOut.println(radq.debugInfo());
            StdOut.println(radq);
        }

        int temp;
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                temp = radq.popRight();
                StdOut.println("radq.popRight():" + temp);
            } else {
                temp = radq.popLeft();
                StdOut.println("radq.popLeft():" + temp);
            }
            StdOut.println(radq.debugInfo());
            StdOut.println(radq);
        }
    }
}