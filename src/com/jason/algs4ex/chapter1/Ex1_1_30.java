package com.jason.algs4ex.chapter1;

import edu.princeton.cs.algs4.StdIn;

/*
1.1.29 Equal keys. Add to BinarySearch a static method rank() that takes a key and a sorted array of int values
 (some of which may be equal) as arguments and returns the number of elements that are smaller than the key and a
 similar method count() that returns the number of elements equal to the key. Note : If i and j are the values returned
 byrank(key, a)andcount(key, a)respectively,thena[i..i+j-1]arethevaluesin the array that are equal to key.
  */
public class Ex1_1_30 {
    public static void main(String[] args) {
        System.out.println("Ex1_1_30");
        int N = StdIn.readInt();
        boolean[][] a = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                a[i][j] = gcd(i, j) == 1;
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int gcd(int p, int q) {
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }
}
