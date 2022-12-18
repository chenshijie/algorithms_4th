package com.jason.algs4ex.ch1_3;

import com.jason.algs4ex.Stack;
import edu.princeton.cs.algs4.StdOut;

/*
1.3.44 Text editor buffer. Develop a data type for a buffer in a text editor that implements
the following API:

public class Buffer
-----------------------------------------------------------------------
Buffer()                create an empty buffer
void insert(char c)     insert c at the cursor position
char delete()           delete and return the character at the cursor
void left(int k)        move the cursor k positions to the left
void right(int k)       move the cursor k positions to the right
int size()              number of characters in the buffer
-----------------------------------------------------------------------
                API for a text buffer
Hint : Use two stacks.
 */
public class Ex1_3_44 {

    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        String s = "1.3.44 Text editor buffer.";

        for (int i = 0; i < s.length(); i++) {
            buffer.insert(s.charAt(i));
        }

        StdOut.println(buffer);

        int cursor = buffer.size();

        buffer.left(13);
        StdOut.println("cursor position : " + (cursor -= 13));
        char x = buffer.delete();
        StdOut.println("delete : " + x);
        StdOut.println(buffer);
        x = 'E';
        buffer.insert(x);
        StdOut.println("insert : " + x);
        StdOut.println(buffer);

        buffer.right(7);
        StdOut.println("cursor position : " + (cursor += 7));
        x = buffer.delete();
        StdOut.println("delete : " + x);
        StdOut.println(buffer);
        x = 'B';
        buffer.insert(x);
        StdOut.println("insert : " + x);
        StdOut.println(buffer);
    }

    public static class Buffer {
        private final Stack<Character> leftStack = new Stack<>();
        private final Stack<Character> rightStack = new Stack<>();

        public Buffer() {

        }

        void insert(char c) {
            leftStack.push(c);
        }

        char delete() {
            //delete left character in macOS
            return leftStack.pop();
            //delete right character in Windows
            //return rightStack.pop();
        }

        void left(int k) {
            int movePositions = Math.min(k, leftStack.size());
            for (int i = 0; i < movePositions; i++) {
                rightStack.push(leftStack.pop());
            }
        }

        void right(int k) {
            int movePositions = Math.min(k, rightStack.size());
            for (int i = 0; i < movePositions; i++) {
                leftStack.push(rightStack.pop());
            }
        }

        int size() {
            return leftStack.size() + rightStack.size();
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (Character c : leftStack) {
                sb.append(c);
            }
            int length = rightStack.size();
            char[] chars = new char[length];
            for (Character c : rightStack) {
                chars[--length] = c;
            }
            sb.append(chars);
            return sb.toString();
        }
    }
}