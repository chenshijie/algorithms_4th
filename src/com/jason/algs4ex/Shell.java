package com.jason.algs4ex;

import edu.princeton.cs.algs4.StdOut;

public abstract class Shell extends BaseSort {
    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    public static void sortAndPrint(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (less(a[j], a[j - h])) {
                        exch(a, j, j - h);
                        formatShow(h, i, j, j - h, a);
                    } else {
                        formatShow(h, i, j, -1, a);
                    }
                }
            }
            show(a, "\t", 3);
            h = h / 3;
        }
    }

    public static void main(String[] args) {
        //S O R T E X A M P L E
        String[] a = {"E", "A", "S", "Y", "S", "H", "E", "L", "L", "S", "O", "R", "T", "Q", "U", "E", "S", "T", "I", "O", "N"};
        //String[] a = StdIn.readAllStrings();
        String[] index = new String[a.length + 3];
        index[0] = "h";
        index[1] = "i";
        index[2] = "j";
        for (int i = 3; i < a.length + 3; i++) {
            index[i] = String.format("%d", i - 3);
        }
        show(index, "\t");

        StdOut.println("-------------------------------------------------------------------------------------------------");
        sortAndPrint(a);
        assert isSorted(a);
    }

    public static void show(Comparable[] a, String sepString, int beginSepStringCnt) {
        for (int i = 0; i < beginSepStringCnt; i++) {
            StdOut.print(" " + sepString);
        }
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + sepString);
        }
        StdOut.println();
    }

    public static void formatShow(int h, int l1, int l2, int markIndex, Comparable[] a) {
        StdOut.print(h);
        StdOut.print("\t");
        StdOut.print(l1);
        StdOut.print("\t");
        StdOut.print(l2);
        StdOut.print("\t");
        for (int i = 0; i < a.length; i++) {
            if (markIndex == i) {
                StdOut.print(String.format("\033[%d;%dm%s\033[0m", 31, 2, a[i]));
            } else {
                if (l2 == i) {
                    StdOut.print(a[i]);
                } else {
                    StdOut.print(String.format("\033[%d;%dm%s\033[0m", 37, 2, a[i]));
                }
            }

            StdOut.print("\t");
        }
        StdOut.println();
    }
}