package com.jason.algs4ex.ch1_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

import java.util.Arrays;

/*
1.1.29 Equal keys. Add to BinarySearch a static method rank() that takes a key and a sorted array of int values
 (some of which may be equal) as arguments and returns the number of elements that are smaller than the key and a
 similar method count() that returns the number of elements equal to the key. Note : If i and j are the values returned
 byrank(key, a)andcount(key, a)respectively,thena[i..i+j-1]arethevaluesin the array that are equal to key.
  */
public class Ex1_1_29 {

    public static void main(String[] args) {
        System.out.println("Ex1_1_29");
        int[] whitelist = new In("./data/tinyW_not_unqiue.txt").readAllInts();
        Arrays.sort(whitelist);
        System.out.println(Arrays.toString(whitelist));

        int key = StdIn.readInt();
        int pos = rank(key, whitelist);
        int count = count(key, whitelist);
        System.out.printf("key=%d, pod=%d, count=%d\n", key, pos, count);
    }

    public static int rank(int key, int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (key == a[i]) {
                return i;
            }
        }
        return -1;
    }

    public static int count(int key, int[] a) {
        int pos = 0;
        for (int i = 0; i < a.length; i++) {
            if (key == a[i] && pos == 0) {
                pos = i;
            }
            if (key < a[i]) {
                return i - pos;
            }
        }
        return -1;
    }
}
