package com.jason.algs4ex.ch1_2;

import edu.princeton.cs.algs4.StdOut;

/*
1.2.19 Parsing. Develop the parse constructors for your Date and Transaction implementations
of Exercise 1.2.13 that take a single String argument to specify the
initialization values, using the formats given in the table below.
Partial solution:
public Date(String date)
{
String[] fields = date.split("/");
month = Integer.parseInt(fields[0]);
day = Integer.parseInt(fields[1]);
year = Integer.parseInt(fields[2]);
}

type format example
Date integers separated by slashes 5/22/1939
Transaction customer, date, and amount,
separated by whitespace Turing 5/22/1939 11.99
 */
public class Ex1_2_19 {
    public static void main(String[] args) {
        StdOut.println("参考Ex1_2_13");
    }
}
