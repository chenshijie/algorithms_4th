package com.jason.algs4ex.ch1_1;

import edu.princeton.cs.algs4.StdOut;

/*
1.1.27 Binomial distribution. Estimate the number of recursive calls that would be used by the code
    public static double binomial(int N, int
    {
       if ((N == 0) && k == 0) return 1.0;
       if (N < 0 || (k < 0)) return 0.0;
       return (1.0 - p)*binomial(N-1, k) + p*binomial(N-1, k-1);
    }
 */
public class Ex1_1_27 {

    public static long binomialRunCount = 0;
    public static long binomial2RunCount = 0;

    private static double[][] Matrix;

    public static double binomial(int N, int k, double p) {
        binomialRunCount++;
        if (N == 0 && k == 0) return 1.0;
        if (N < 0 || (k < 0)) return 0;
        return (1.0 - p) * binomial(N - 1, k, p) + p * binomial(N - 1, k - 1, p);
    }

    private static double binomial2(int N, int k, double p) {
        binomial2RunCount++;
        if (N == 0 && k == 0) {
            return 1.0;
        }
        if (N < 0 || k < 0) {
            return 0.0;
        }
        if (Matrix[N][k] == -1) {
            Matrix[N][k] = (1.0 - p) * binomial2(N - 1, k, p) + p * binomial2(N - 1, k - 1, p);
        }
        return Matrix[N][k];
    }

    public static void initMatrix(int N, int k) {
        Matrix = new double[N + 1][k + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= k; j++) {
                Matrix[i][j] = -1;
            }
        }
    }

    public static void main(String[] args) {
        StdOut.println("Ex1_1_27");
        int N = 100, k = 5;
        StdOut.println("result: " + binomial(100, 5, 0.25) + ", count: " + binomialRunCount);
        initMatrix(N, k);
        StdOut.println("result: " + binomial2(100, 5, 0.25) + ", count: " + binomial2RunCount);
    }
}
