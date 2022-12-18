package com.jason.algs4ex.ch1_4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/*
1.4.12 编写一个程序，有序打印给定的两个有序数组（含有N个int值）中的所有公共元素，程序在最坏情况下所需的运行时间应该和N成正比。
*/
public class Ex1_4_12 {
    public static void main(String[] args) {
        int N = 20;
        int[] a1 = new int[N];
        int[] a2 = new int[N];

        int step1 = 5;
        for (int i = 0; i < N; i++) {
            a1[i] = StdRandom.uniformInt(i * step1, (i + 1) * step1);
        }
        int step2 = 5;
        for (int i = 0; i < N; i++) {
            a2[i] = StdRandom.uniformInt(i * step2, (i + 1) * step2);
        }
        StdOut.println("a1: " + Arrays.toString(a1));
        StdOut.println("a2: " + Arrays.toString(a2));
        int j = 0;
        int findCnt = 0;
        for (int i = 0; i < N; i++) {
            while (j < N) {
                findCnt++;
                if (a1[i] < a2[j]) {
                    break;
                } else if (a1[i] == a2[j]) {
                    StdOut.print(a1[i] + " ");
                    j++;
                    break;
                } else {
                    j++;
                }
            }
        }

        StdOut.println();
        double rate = (double) findCnt / N;
        StdOut.printf("Find times: %d, rate: %f\n", findCnt, rate);
    }
}
