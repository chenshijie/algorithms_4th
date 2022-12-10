package com.jason.algs4ex.chapter1;

import com.jason.algs4ex.Counter;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/*
1.2.9 Instrument BinarySearch (page 47) to use a Counter to count the total number
of keys examined during all searches and then print the total after all searches are complete.
Hint : Create a Counter in main() and pass it as an argument to rank().
 */
public class Ex1_2_9 {

    public static void main(String[] args) {
        int[] whitelist = {84, 48, 68, 10, 18, 98, 12, 23, 54, 57, 33, 16, 77, 11, 29};
        Arrays.sort(whitelist);
        StdOut.println("White list: " + Arrays.toString(whitelist));
        StdOut.println("Please input an integer to search:");
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            Counter c = new Counter("BinarySearch_" + key);
            if (BinarySearch.rank(key, whitelist, c) > 0) {
                StdOut.printf("Find %d in white list, the total number of keys examined is %d\n", key, c.tally());
            } else {
                StdOut.printf("Do NOT find %d in white list, the total number of keys examined is %d\n", key, c.tally());
            }
        }
    }

    static class BinarySearch {
        public static int rank(int key, int[] a, Counter c) { // Array must be sorted.
            int lo = 0;
            int hi = a.length - 1;
            while (lo <= hi) { // Key is in a[lo..hi] or not present.
                int mid = lo + (hi - lo) / 2;
                if (key < a[mid]) {
                    hi = mid - 1;
                    c.increment();
                } else if (key > a[mid]) {
                    lo = mid + 1;
                    c.increment();
                } else {
                    return mid;
                }
            }
            return -1;
        }
    }
}
