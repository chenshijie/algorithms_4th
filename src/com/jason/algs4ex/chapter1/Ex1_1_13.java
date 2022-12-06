package com.jason.algs4ex.chapter1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
1.1.13 Write a code fragment to print the transposition (rows and columns changed)
of a two-dimensional array with M rows and N columns
 */
public class Ex1_1_13 {
    public static void main(String[] args) {
        StdOut.println("Ex1_1_13");
        StdOut.println("An array[m][n] should be initialized");
        StdOut.println("Please input m:");
        int x = StdIn.readInt();
        StdOut.println("Please input n:");
        int y = StdIn.readInt();

        int[][] array = initIntMatrix(x, y);
        displayIntMatrix(array);

        displayTranspositionIntMatrix(array);
    }

    public static void displayIntMatrix(int[][] array) {
        int x = array.length;
        int y = array[0].length;
        for (int i = -1; i < x; i++) {
            if (i == -1) {
                //StdOut.print("x\\y");
                StdOut.print(String.format("\033[%d;%dm%s\033[0m", 31, 2, "x\\y"));
            } else {
                //StdOut.printf("%2d ", i);
                StdOut.print(String.format("\033[%d;%dm%2d \033[0m", 33, 2, i));
            }

            for (int j = 0; j < y; j++) {
                if (i == -1) {
                    // StdOut.printf("%2d ", j);
                    StdOut.print(String.format("\033[%d;%dm%2d \033[0m", 32, 2, j));
                } else {
                    StdOut.printf("%2d ", array[i][j]);
                }
            }
            StdOut.println();
        }
    }

    public static void displayTranspositionIntMatrix(int[][] array) {
        int x = array.length;
        int y = array[0].length;
        for (int i = -1; i < y; i++) {
            if (i == -1) {
                //StdOut.print("y\\x");
                StdOut.print(String.format("\033[%d;%dm%s\033[0m", 31, 2, "y\\x"));
            } else {
                //StdOut.printf("%2d ", i);
                StdOut.print(String.format("\033[%d;%dm%2d \033[0m", 32, 2, i));
            }

            for (int j = 0; j < x; j++) {
                if (i == -1) {
                    //StdOut.printf("%2d ", j);
                    StdOut.print(String.format("\033[%d;%dm%2d \033[0m", 33, 2, j));
                } else {
                    StdOut.printf("%2d ", array[j][i]);
                }
            }
            StdOut.println();
        }
    }

    public static int[][] initIntMatrix(int m, int n) {
        int[][] array = new int[m][n];
        int x = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = x++;
            }
        }
        return array;
    }
}
