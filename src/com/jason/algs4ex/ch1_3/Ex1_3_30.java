package com.jason.algs4ex.ch1_3;

import com.jason.algs4ex.LinkedList;
import edu.princeton.cs.algs4.StdOut;

/*
1.3.30 Write a function that takes the first Node in a linked list as argument and (destructively)
reverses the list, returning the first Node in the result.
Iterative solution : To accomplish this task, we maintain references to three consecutive
nodes in the linked list, reverse, first, and second. At each iteration, we extract the
node first from the original linked list and insert it at the beginning of the reversed
list. We maintain the invariant that first is the first node of what’s left of the original
list, second is the second node of what’s left of the original list, and reverse is the first
node of the resulting reversed list.
    public Node reverse(Node x)
    {
        Node first = x;
        Node reverse = null;
        while (first != null)
        {
            Node second = first.next;
            first.next = reverse;
            reverse = first;
            first = second;
        }
        return reverse;
    }
When writing code involving linked lists, we must always be careful to properly handle
the exceptional cases (when the linked list is empty, when the list has only one or two
nodes) and the boundary cases (dealing with the first or last items). This is usually
much trickier than handling the normal cases.
Recursive solution : Assuming the linked list has N nodes, we recursively reverse the last
N – 1 nodes, and then carefully append the first node to the end.
    public Node reverse(Node first)
    {
        if (first == null) return null;
        if (first.next == null) return first;
        Node second = first.next;
        Node rest = reverse(second);
        second.next = first;
        first.next = null;
        return rest;
    }
 */
public class Ex1_3_30 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        //init
        for (int i = 0; i < 10; i++) {
            list.addLast(i);
        }

        StdOut.println("list after init: ");
        StdOut.println(list);
        StdOut.println(new LinkedList<>(list.reverse(list.findNode(0))));
        //原来的链表已经被破坏
        StdOut.println(list);

        LinkedList<Integer> list2 = new LinkedList<>();
        //init
        for (int i = 0; i < 10; i++) {
            list2.addLast(i);
        }

        StdOut.println("list2 after init: ");
        StdOut.println(list2);
        StdOut.println(new LinkedList<>(list2.reverseRecursive(list2.findNode(0))));
        //原来的链表已经被破坏
        StdOut.println(list2);
    }
}