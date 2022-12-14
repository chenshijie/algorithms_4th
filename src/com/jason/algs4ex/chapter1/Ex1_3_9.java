package com.jason.algs4ex.chapter1;

import com.jason.algs4ex.Stack;
import edu.princeton.cs.algs4.StdOut;

/*
1.3.9 Write a program that takes from standard input an expression without left parentheses
and prints the equivalent infix expression with the parentheses inserted. For
example, given the input:
1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )
your program should print
( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) )-
 */
public class Ex1_3_9 {
    public static boolean isOperator(String s) {
        return (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"));
    }

    public static void main(String[] args) {
        String str1 = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
        //System.out.println(addLeftBracket(str1));
        StdOut.println(str1);
        String[] array = str1.trim().split("\\s");
        Stack<String> ops = new Stack<>();
        Stack<String> vals = new Stack<>();

        for (String s : array) {
            if (isOperator(s)) {
                ops.push(s);
            } else if (!s.equals(")")) {
                vals.push(s);
            } else {
                String valRight = vals.pop();
                String valLeft = vals.pop();
                String op = ops.pop();
                String newVal = "( " + valLeft + " " + op + " " + valRight + " )";
                vals.push(newVal);
            }
        }

        StdOut.println(vals.pop());
    }
}