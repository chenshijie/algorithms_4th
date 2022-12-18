package com.jason.algs4ex.ch1_3;

import com.jason.algs4ex.DoubleLinkedList;
import edu.princeton.cs.algs4.StdOut;

/*
1.3.31 Implement a nested class DoubleNode for building doubly-linked lists, where
each node contains a reference to the item preceding it and the item following it in the
list (null if there is no such item). Then implement static methods for the following
tasks: insert at the beginning, insert at the end, remove from the beginning, remove
from the end, insert before a given node, insert after a given node, and remove a given
node.
 */
public class Ex1_3_31 {

    public static <E> void showList(DoubleLinkedList<E> list) {
        for (E e : list) {
            StdOut.print(e + " ");
        }
        StdOut.println();
    }

    public static void main(String[] args) {
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        for (int i = 0; i < 5; i++) {
            DoubleLinkedList.addLast(list, String.valueOf(i));
        }
        DoubleLinkedList.addFirst(list, "First");
        DoubleLinkedList.addLast(list, "Last");
        showList(list);

        StdOut.println("removeFirst: " + DoubleLinkedList.removeFirst(list));
        StdOut.println("removeLast: " + DoubleLinkedList.removeLast(list));

        StdOut.println("remove node which index is 2: " + DoubleLinkedList.remove(list, list.node(2)));
        showList(list);

        DoubleLinkedList.addBefore(list, "two", list.node(2));
        showList(list);

        DoubleLinkedList.addAfter(list, "3.5", list.node(3));
        showList(list);
    }
}