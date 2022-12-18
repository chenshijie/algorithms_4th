package com.jason.algs4ex.ch1_2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
A string s is a circular rotation of a string t if it matches when the characters
are circularly shifted by any number of positions; e.g., ACTGACG is a circular shift of
TGACGAC, and vice versa. Detecting this condition is important in the study of genomic
sequences. Write a program that checks whether two given strings s and t are circular
shifts of one another. Hint : The solution is a one-liner with indexOf(), length(), and
string concatenation.
 */
public class Ex1_2_6 {

    public static void main(String[] args) {
        StdOut.println("Ex1_2_6");
        StdOut.println("Please input a string s:");
        String s = StdIn.readString();
        StdOut.println("Please input another string t:");
        String t = StdIn.readString();

        //if (s.length() == t.length() && s.concat(s).contains(t)) {
        if (s.length() == t.length() && s.concat(s).indexOf(t) >= 0) {
            StdOut.println("s and t are circular shifts of one another");
        } else {
            StdOut.println("s and t are NOT circular shifts of one another");
        }
    }
}
