package com.jason.algs4ex.ch1_3;

import com.jason.algs4ex.LinkedList;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

/*
1.3.40 Move-to-front. Read in a sequence of characters from standard input and
maintain the characters in a linked list with no duplicates. When you read in a previously
unseen character, insert it at the front of the list. When you read in a duplicate
character, delete it from the list and reinsert it at the beginning. Name your program
MoveToFront: it implements the well-known move-to-front strategy, which is useful for
caching, data compression, and many other applications where items that have been
recently accessed are more likely to be reaccessed.
 */
public class Ex1_3_40 {
    public static void main(String[] args) {
        LinkedList<Character> list = new LinkedList<>();
        String s = StdIn.readLine();
        StdOut.println(s);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char fc;
            try {
                fc = list.getFirst();
                if (fc != c) {
                    list.remove(c);
                    list.addFirst(c);
                }
            } catch (NoSuchElementException e) {
                list.addFirst(c);
            }

            StdOut.println(list);
        }
    }
}