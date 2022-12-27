package com.jason.algs4ex;

import edu.princeton.cs.algs4.StdOut;

public class Insertion extends BaseSort {
    public static void sort(Comparable[] a) {  // 将a[]按升序排列
        int N = a.length;
        for (int i = 1; i < N; i++) {  // 将a[i] 插入到a[i-1]、a[i-2]、a[i-3]..．之中
            int j;
            for (j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    public static void sortAndPrint(Comparable[] a) {  // 将a[]按升序排列
        int N = a.length;
        for (int i = 1; i < N; i++) {  // 将a[i] 插入到a[i-1]、a[i-2]、a[i-3]..．之中
            int j;
            for (j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
            formatShow(i, j, a);
        }
    }

    public static void main(String[] args) {
        //S O R T E X A M P L E
        String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        //String[] a = StdIn.readAllStrings();
        String[] index = new String[a.length + 2];
        index[0] = "i";
        index[1] = "j";
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
