package com.jason.algs4ex.chapter1;

import edu.princeton.cs.algs4.StdOut;

public class Ex1_1_2 {
    public static void main(String[] args) {
        StdOut.println("1.1.2 答案：");
        StdOut.println("(1 + 2.236) / 2 = " + (1 + 2.236) / 2 + "\ttype:double");
        StdOut.println("1 + 2 + 3 + 4.0 = " + 1 + 2 + 3 + 4.0 + "\ttype:double");
        StdOut.println("4.1 >= 4 = " + (4.1 >= 4) + "\ttype:boolean");
        StdOut.println("1 + 2 + \"3\" = " + (1 + 2 + "3") + "\ttype:"+(1 + 2 + "3").getClass().getName());
    }
}
