package com.jason.algs4ex.chapter1;

import com.jason.algs4ex.Stack;
import edu.princeton.cs.algs4.StdOut;

/*
1.3.10 Write a filter InfixToPostfix that converts an arithmetic expression from infix
to postfix.
 */
public class Ex1_3_10 {
    public static boolean isOperator(String s) {
        return (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"));
    }

    public static boolean isBracket(String s) {
        return s.equals("(") || s.equals(")");
    }

    public static String InfixToPostfixWithBracket(String input) {
        //"( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )"
        String[] inputArray = input.trim().split("\\s");
        StringBuilder result = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for (String s : inputArray) {
            if (isOperator(s)) {
                stack.push(s);
            } else if (s.equals(")")) {
                result.append(stack.pop());
            } else if (!s.equals("(")) {
                result.append(s);
            }
        }
        if (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }

    private static int order(String op) {
        return switch (op) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            case "^" -> 3;
            default -> -1;
        };
    }

    private static String InfixToPostfix(String exp) {
        StringBuilder result = new StringBuilder();
        Stack<String> stack = new Stack<>();
        String[] expArray = exp.trim().split("\\s");
        for (String item : expArray) {
            if (!isOperator(item) && !isBracket(item)) {
                result.append(item);
            } else if (item.equals("(")) {
                stack.push(item);
            } else if (item.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    result.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && order(item) <= order(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(item);
            }
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String input = "( 2 + ( ( 3 + 4 ) * ( 5 * 6 ) ) )";
        StdOut.println(InfixToPostfixWithBracket("( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )"));
        StdOut.println(InfixToPostfixWithBracket("( 1 + 2 ) * ( 3 - 4 ) * ( 5 - 6 ) )"));
        StdOut.println(InfixToPostfixWithBracket(input));
        StdOut.println(InfixToPostfix("( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )"));
        StdOut.println(InfixToPostfix(" 2 + ( ( 3 + 4 ) * ( 5 * 6 ) )"));
        StdOut.println(InfixToPostfix(" 2 + ( 3 + 4 ) * ( 5 * 6 )"));
        StdOut.println(InfixToPostfix(" 2 + ( 3 + 4 ) * 5 * 6"));
    }
}