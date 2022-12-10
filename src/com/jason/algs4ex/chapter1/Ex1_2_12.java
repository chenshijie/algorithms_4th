package com.jason.algs4ex.chapter1;

import com.jason.algs4ex.SmartDate;
import edu.princeton.cs.algs4.StdOut;

/*
1.2.12 Add a method dayOfTheWeek() to SmartDate that returns a String value
Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, or Sunday, giving the appropriate
day of the week for the date. You may assume that the date is in the 21st
century.
 */
public class Ex1_2_12 {
    public static void main(String[] args) {
        SmartDate d = new SmartDate("12/11/2022");
        StdOut.println(d.dayOfTheWeek());
    }
}
