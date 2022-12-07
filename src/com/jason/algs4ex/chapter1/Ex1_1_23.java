package com.jason.algs4ex.chapter1;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/*
1.1.23 Add to the BinarySearch test client the ability to respond to a second argument: + to print numbers from standard input that are not in the whitelist, - to print
numbers that are in the whitelist
 */
public class Ex1_1_23 {
    public static void main(String[] args) {
        StdOut.println("Ex1_1_23");
        int[] whitelist = In.readInts(args[0]);
        String filter = "+";
        if (args[1].equals("-")) {
            filter = "-";
        }
        Arrays.sort(whitelist);
        while (!StdIn.isEmpty()) {
            // Read key, print if not in whitelist.
            int key = StdIn.readInt();
            int pos = BinarySearch.rank(key, whitelist);

            if (filter.equals("+") && pos < 0) {
                StdOut.println(key);
            }
            if (filter.equals("-") && pos > 0) {
                StdOut.println(key);
            }
        }
    }
}
