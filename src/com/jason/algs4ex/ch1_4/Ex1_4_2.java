package com.jason.algs4ex.ch1_4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/*
1.4.2 修改ThreeSum，正确处理两个较大的int值相加可能溢出的情况。
*/
public class Ex1_4_2 {
    public static int count(int[] a) {  // Count triples that sum to 0.
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++)
            for (int j = i + 1; j < N; j++)
                for (int k = j + 1; k < N; k++)
                    if ((long) a[i] + a[j] + a[k] == 0)
                        cnt++;
        return cnt;
    }

    public static void main(String[] args) {
        int[] a = new In(args[0]).readAllInts();
        StdOut.println(count(a));
    }
}
