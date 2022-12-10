package com.jason.algs4ex.chapter1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
1.2.7 What does the following recursive function return?
public static String mystery(String s)
{
int N = s.length();
if (N <= 1) return s;
String a = s.substring(0, N/2);
String b = s.substring(N/2, N);
return mystery(b) + mystery(a);
}
 */
public class Ex1_2_7 {

    public static void main(String[] args) {
        StdOut.println("Ex1_2_7");
        StdOut.println("Please input a string:");
        String s = StdIn.readString();
        String t = mystery(s);
        StdOut.println(t);
    }

    public static String mystery(String s) {
        int N = s.length();
        if (N <= 1) return s;
        String a = s.substring(0, N / 2);
        String b = s.substring(N / 2, N);
        return mystery(b) + mystery(a);
    }
}
