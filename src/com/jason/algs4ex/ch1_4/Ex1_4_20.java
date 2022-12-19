package com.jason.algs4ex.ch1_4;

import edu.princeton.cs.algs4.StdOut;

/*
1.4.20 Bitonic search. An array is bitonic if it is comprised of an increasing sequence
of integers followed immediately by a decreasing sequence of integers. Write a program
that, given a bitonic array of N distinct int values, determines whether a given integer
is in the array. Your program should use ~3lg N compares in the worst case.

1.4.20 双调查找。如果一个数组中的所有元素是先递增后递减的，则称这个数组为双调的。编写一个程序，给定一个含有N个不同int值的双调数组，
判断它是否含有给定的整数。程序在最坏情况下所需的比较次数为～3lgN。
*/
public class Ex1_4_20 {

    public static int getIndexOfMaxValue(int[] array) {
        if (array == null) {
            return -1;
        }
        int low = 0;
        int high = array.length - 1;
        int mid = (low + high) / 2;
        while (low <= high) {
            if (array[mid] > array[mid + 1] && array[mid] > array[mid - 1]) {
                return mid;
            } else {
                if (array[mid] < array[mid + 1]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
                mid = (low + high) / 2;
            }
        }
        return -1;
    }


    public static int rank4DescendingArray(int[] a, int lo, int hi, int key) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) {
                lo = mid + 1;
            } else if (key > a[mid]) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int rank4AscendingArray(int[] a, int lo, int hi, int key) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static int rank(int[] array, int key) {
        int maxIndex = getIndexOfMaxValue(array);
        if (array[maxIndex] == key) {
            return maxIndex;
        }
        int index = rank4AscendingArray(array, 0, maxIndex, key);
        if (index == -1) {
            return rank4DescendingArray(array, maxIndex, array.length - 1, key);
        }
        return index;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 9, 8, 6, 5, 4, 2, 0, -1, -2, -8};
        StdOut.println(rank(array, 0));
        StdOut.println(rank(array, 5));
        StdOut.println(rank(array, 10));
    }
}
