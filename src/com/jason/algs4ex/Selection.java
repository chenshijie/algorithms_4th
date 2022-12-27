package com.jason.algs4ex;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public abstract class Selection extends BaseSort {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + i; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }

    public static void sortAndPrint(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + i; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            formatShow(i, min, a);
            exch(a, i, min);
        }
    }

    public static void main(String[] args) {
        //S O R T E X A M P L E
        //String[] a = {"S","O","R","T","E","X","A","M","P","L","E"};
        String[] a = StdIn.readAllStrings();
        String[] index = new String[a.length + 2];
        index[0] = "i";
        index[1] = "min";
        for (int i = 2; i < a.length + 2; i++) {
            index[i] = String.format("%d", i - 2);
        }
        show(index, "\t");

        StdOut.println("-------------------------------------------------------------------------------------------------");
        StdOut.print(" \t");
        StdOut.print(" \t");
        show(a, "\t");
        sortAndPrint(a);
        assert isSorted(a);
        //StdOut.println("-----------------------------------");
        StdOut.print(" \t");
        StdOut.print(" \t");
        show(a, "\t");
    }

    public static void formatShow(int t1, int t2, Comparable[] a) {
        StdOut.print(t1);
        StdOut.print("\t");
        StdOut.print(t2);
        StdOut.print("\t");
        for (int i = 0; i < a.length; i++) {
            if (t2 == i) {
                StdOut.print(String.format("\033[%d;%dm%s\033[0m", 31, 2, a[i]));
            } else {
                if (i < t1) {
                    StdOut.print(String.format("\033[%d;%dm%s\033[0m", 37, 2, a[i]));
                } else {
                    StdOut.print(a[i]);
                }
            }

            StdOut.print("\t");
        }
        StdOut.println();
    }
}