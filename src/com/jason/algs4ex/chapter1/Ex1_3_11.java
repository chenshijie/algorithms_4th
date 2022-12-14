package com.jason.algs4ex.chapter1;

import com.jason.algs4ex.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
1.3.11 Write a program EvaluatePostfix that takes a postfix expression from standard
input, evaluates it, and prints the value. (Piping the output of your program from
the previous exercise to this program gives equivalent behavior to Evaluate.)
 */
public class Ex1_3_11 {
    public static boolean isOperator(String s) {
        return (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"));
    }

    public static double cal(double v1, double v2, String op) {
        if (!isOperator(op)) {
            throw new RuntimeException("operator " + op + " is not supported");
        } else {
            return switch (op) {
                case "+" -> v1 + v2;
                case "-" -> v1 - v2;
                case "*" -> v1 * v2;
                case "/" -> v1 / v2;
                default -> 0;
            };
        }
    }

    public static void main(String[] args) {
        Stack<Double> vals = new Stack<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (isOperator(s)) {
                Double v1 = vals.pop();
                Double v2 = vals.pop();
                Double result = cal(v1, v2, s);
                vals.push(result);
            } else {
                vals.push(Double.parseDouble(s));
            }
        }
        StdOut.println(vals.pop());
    }
}