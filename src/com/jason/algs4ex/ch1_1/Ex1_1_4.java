package com.jason.algs4ex.ch1_1;

import edu.princeton.cs.algs4.StdOut;

/*
1.1.4 What (if anything) is wrong with each of the following statements?
a. if (a > b) then c = 0;
b. if a > b { c = 0; }
c. if (a > b) c = 0;
d. if (a > b) c = 0 else b = 0
 */
public class Ex1_1_4 {
    public static void main(String[] args) {
        StdOut.println("Ex1_1_4");

        int a = 1, b = 2, c = 0;
        //if (a > b) then c = 0;
        if (a > b) c = 0;
        //if a > b { c = 0; }
        if (a > b) {
            c = 0;
        }
        //if (a > b) c = 0;
        if (a > b) c = 0;
        //if (a > b) c = 0 else b = 0
        if (a > b) c = 0;else b = 0;

        StdOut.println(a);
        StdOut.println(b);
        StdOut.println(c);
    }
}
