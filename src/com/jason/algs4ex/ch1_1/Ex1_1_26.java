package com.jason.algs4ex.ch1_1;

import edu.princeton.cs.algs4.StdOut;

/*
1.1.26 Sorting three numbers. Suppose that the variables a, b, c, and t are all of the
same numeric primitive type. Show that the following code puts a, b, and c in ascending
order:
if (a > b) { t = a; a = b; b = t; }
if (a > c) { t = a; a = c; c = t; }
if (b > c) { t = b; b = c; c = t; }
 */
public class Ex1_1_26 {
    public static void main(String[] args) {
        StdOut.println("Ex1_1_26");
        //将a,b,c看成三个连续的位置，下面if判断，然后交换 就是选在排序法
        //一直将数值小的向a的方向移动
        int a = 10, b = 5, c = 8, t;
        StdOut.printf("%d\t%d\t%d\n", a, b, c);
        if (a > b) {
            t = a;
            a = b;
            b = t;
        }
        if (a > c) {
            t = a;
            a = c;
            c = t;
        }
        if (b > c) {
            t = b;
            b = c;
            c = t;
        }
        StdOut.printf("%d\t%d\t%d\n", a, b, c);
    }
}
