package com.jason.algs4ex.ch1_3;

import com.jason.algs4ex.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
1.3.4 Write a stack client Parentheses that reads in a text stream from standard input
and uses a stack to determine whether its parentheses are properly balanced. For example,
your program should print true for [()]{}{[()()]()} and false for [(]).
 */
public class Ex1_3_4 {

    public static boolean isPair(char c1, char c2) {
        return switch (c1) {
            case '{' -> c2 == '}';
            case '[' -> c2 == ']';
            case '(' -> c2 == ')';
            default -> false;
        };
    }

    public static void main(String[] args) {
        String s = StdIn.readLine();
        Stack<Character> stack = new Stack<>(10);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                char x = stack.pop();
                if (!isPair(x, c)) {
                    stack.push(x);
                    stack.push(c);
                }
            }
        }
        if (stack.isEmpty()) {
            StdOut.println("true");
        } else {
            StdOut.println("false");
        }
    }
}
