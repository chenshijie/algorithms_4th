package com.jason.algs4ex.ch1_4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/*
.4.19 Local minimum of a matrix. Given an N-by-N array a[] of N 2 distinct integers,
design an algorithm that runs in time proportional to N to find a local minimum:
a pair of indices i and j such that a[i][j] < a[i+1][j], a[i][j] < a[i][j+1],
a[i][j] < a[i-1][j], and a[i][j] < a[i][j-1]. The running time of your program
 should be proportional to N in the worst case.

 1.4.19 矩阵的局部最小元素。给定一个含有N2个不同整数的N×N数组a[]。设计一个运行时间和N成正比的算法来找出一个局部最小元素：
 满足a[i][j]＜a[i+1][j]、a[i][j]＜a[i][j+1]、a[i][j]＜a[i-1][j]以及a[i][j]＜a[i][j-1]的索引i和j。
 程序的运行时间在最坏情况下应该和N成正比。
*/
public class Ex1_4_19 {

    public static void initMatrix(int[][] matrix, int N) {
        int[] temp = new int[N * N];
        for (int i = 0; i < N * N; i++) {
            temp[i] = i;
        }
        StdRandom.shuffle(temp);
        int n = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = temp[n++];
            }
        }
    }

    public static void printMatrix(int[][] matrix, int N) {
        for (int i = 0; i < N; i++) {
            StdOut.printf("%3d: ", i);
            for (int j = 0; j < N; j++) {
                StdOut.printf("%3d ", matrix[i][j]);
            }
            StdOut.println();
        }

        StdOut.print(" r/c ");
        for (int j = 0; j < N; j++) {
            StdOut.printf("%3d ", j);
        }
        StdOut.println();
    }

    public static void main(String[] args) {
        int N = 10;
        int[][] matrix = new int[N][N];
        initMatrix(matrix, N);
        printMatrix(matrix, N);

        int r = N / 2;
        int c = N / 2;
        int loopCnt = 0;
        int current, left, right, top, bottom;
        while (r >= 0 && c >= 0 && r < N && c < N) {
            loopCnt++;
            current = matrix[r][c];
            top = r - 1 >= 0 ? matrix[r - 1][c] : Integer.MAX_VALUE;
            bottom = r + 1 < N ? matrix[r + 1][c] : Integer.MAX_VALUE;
            left = c - 1 >= 0 ? matrix[r][c - 1] : Integer.MAX_VALUE;
            right = c + 1 < N ? matrix[r][c + 1] : Integer.MAX_VALUE;

            int minValue = min(current, top, bottom, left, right);
            if (current == minValue) {
                StdOut.printf("matrix[%d][%d] is one local minimum of a matrix, loop times:%d\n", r, c, loopCnt);
                break;
            } else if (top == minValue) {
                r--;
            } else if (bottom == minValue) {
                r++;
            } else if (left == minValue) {
                c--;
            } else {
                c++;
            }
        }
    }

    public static int min(int... values) {
        Arrays.sort(values);
        return values[0];
    }
}
