package com.jason.algs4ex.ch1_1;

import edu.princeton.cs.algs4.StdIn;

/*
1.1.30 Array exercise. Write a code fragment that creates an N-by-N boolean array a[][] such that a[i][j] is true if i
and j are relatively prime (have no common fac- tors), and false otherwise.
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
