package com.jason.algs4ex.ch1_1;

import edu.princeton.cs.algs4.StdOut;

/*
What does the following program print?
int f = 0;
int g = 1;
for (int i = 0; i <= 15; i++)
{
 StdOut.println(f);
 f = f + g;
 g = f - g;
}
 */
public class Ex1_1_6 {
    public static void main(String[] args) {
        String[] fullClassName = Thread.currentThread().getStackTrace()[1].getClassName().split("\\.");
        int length = fullClassName.length;
        StdOut.println(fullClassName[length - 1]);

        int f = 0;
        int g = 1;
        //菲波列契数列
        for (int i = 0; i <= 15; i++) {
            StdOut.println(f);
            f = f + g;
            g = f - g;
        }
    }
}
