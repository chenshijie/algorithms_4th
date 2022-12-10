package com.jason.algs4ex.chapter1;

import com.jason.algs4ex.SmartDate;
import edu.princeton.cs.algs4.StdOut;

/*
1.2.11 Develop an implementation SmartDate of our Date API that raises an exception
if the date is not legal.
 */
public class Ex1_2_11 {
    public static void main(String[] args) {
        SmartDate d1, d2, d3, d4;
        try {
            d1 = new SmartDate(12, 1, 2022);
        } catch (IllegalArgumentException e) {
            StdOut.println(e);
        }
        try {
            d2 = new SmartDate(13, 1, 2022);
        } catch (IllegalArgumentException e) {
            StdOut.println(e);
        }
        try {
            d3 = new SmartDate("1/33/2020");
        } catch (IllegalArgumentException e) {
            StdOut.println(e);
        }
    }
}
