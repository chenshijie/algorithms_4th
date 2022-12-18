package com.jason.algs4ex.ch1_1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
1.1.21 Write a program that reads in lines from standard input with each line containing
a name and two integers and then uses printf() to print a table with a column of
the names, the integers, and the result of dividing the first by the second, accurate to
three decimal places. You could use a program like this to tabulate batting averages for
baseball players or grades for students
 */
public class Ex1_1_21 {
    public static void main(String[] args) {

        StdOut.println("Ex1_1_21");
        readDataFromStdin();
    }


    public static void readDataFromStdin() {
        StdOut.println("Please input data");
        StdOut.println("e.g.:Mike   200 8");
        String[] lines = StdIn.readAllLines();

        for (String line : lines) {
            if (line.equals("")) {
                break;
            }
            String[] data = line.replace("\t", " ").split(" ");
            double rate = Double.parseDouble(data[1]) / Double.parseDouble(data[2]);
            StdOut.printf("%s\t%s\t%s\t%.3f\n", data[0], data[1], data[2], rate);
        }
    }
}
