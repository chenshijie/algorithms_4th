package com.jason.algs4ex.ch1_2;

import edu.princeton.cs.algs4.StdOut;

/*
1.2.4 What does the following code fragment print?
String string1 = "hello";
String string2 = string1;
string1 = "world";
StdOut.println(string1);
StdOut.println(string2);
 */
public class Ex1_2_4 {

    public static void main(String[] args) {
        String string1 = "hello";
        String string2 = string1;
        string1 = "world";
        StdOut.println(string1);
        StdOut.println(string2);
    }
}
