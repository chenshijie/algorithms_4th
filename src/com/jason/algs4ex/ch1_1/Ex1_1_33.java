package com.jason.algs4ex.ch1_1;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/*

1.1.33 Matrix library. Write a library Matrix that implements the following API:
public class Matrix
static double dot(double[] x, double[] y) vector dot product
static double[][] mult(double[][] a, double[][] b) matrix-matrix product
static double[][] transpose(double[][] a) transpose
static double[] mult(double[][] a, double[] x) matrix-vector product
static double[] mult(double[] y, double[][] a) vector-matrix product
Develop a test client that reads values from standard input and tests all the methods

  */
public class Ex1_1_33 {

    public static void main(String[] args) {

        System.out.println("Ex1_1_33");

        double[] v1 = {1.0, 2.0, 3.0};
        double[] v2 = {3.0, 2.0, 1.0};

        StdOut.println("Vector v1:" + Arrays.toString(v1));
        StdOut.println("Vector v2:" + Arrays.toString(v2));
        double r1 = Matrix.dot(v2, v1);
        StdOut.println("v1 * v2 = " + r1);

        StdOut.println();
        double[][] m1 = {{1.0, 3.0, 2.0}, {4.0, 0, 1}};
        double[][] m2 = {{1.0, 3.0}, {0, 1}, {5.0, 2.0}};

        StdOut.println("Matrix m1:");
        Matrix.display(m1);
        StdOut.println("Matrix m2:");
        Matrix.display(m2);

        double[][] r2 = Matrix.mult(m1, m2);
        StdOut.println("Matrix m1 * Matrix m2:");
        Matrix.display(r2);

        StdOut.println();
        double[] v3 = {1.0, 0, 5.0};
        StdOut.println("Vector v3:");
        Matrix.display(v3);
        double[] r3 = Matrix.mult(m1, v3);
        StdOut.println("Matrix m1 * Vector v3:");
        Matrix.display(r3);

        StdOut.println();
        double[] v4 = {3.0, 1, 2.0};
        StdOut.println("Vector v4:");
        Matrix.display(v4);
        double[] r4 = Matrix.mult(v4, m1);
        StdOut.println("Vector v4 * Matrix m1:");
        Matrix.display(r4);

    }


    static class Matrix {
        public static void display(double[][] m) {
            for (double[] row : m) {
                display(row);
            }
        }

        public static void display(double[] v) {
            StdOut.println(Arrays.toString(v));
        }

        /**
         * vector dot product
         *
         * @param x vector x
         * @param y vector y
         * @return vector dot result
         */
        public static double dot(double[] x, double[] y) {
            int l1 = x.length;
            int l2 = y.length;
            if (l1 != l2) {
                throw new IllegalArgumentException("向量x和向量y的长度不一致");
            }
            double result = 0.0;
            for (int i = 0; i < l1; i++) {
                result += x[i] * y[i];
            }
            return result;
        }

        /**
         * matrix-matrix product
         *
         * @param a matrix[r][n]
         * @param b matrix[n][c]
         * @return matrix[r, c]
         */
        public static double[][] mult(double[][] a, double[][] b) {
            int r1 = a.length;
            int r2 = b.length;
            if (r1 == 0) {
                throw new IllegalArgumentException("matrix a is empty");
            }
            if (r2 == 0) {
                throw new IllegalArgumentException("matrix b is empty");
            }
            int c1 = a[0].length;
            int c2 = b[0].length;

            if (c1 == 0) {
                throw new IllegalArgumentException("matrix a is not a matrix");
            }
            if (c2 == 0) {
                throw new IllegalArgumentException("matrix b is not a matrix");
            }

            if (c1 != r2) {
                throw new IllegalArgumentException("matrix a's colum count must equal matrix b's row count");
            }

            double[][] r = new double[r1][c2];

            double[][] c = transpose(b);

            for (int i = 0; i < r1; i++) {
                for (int j = 0; j < c2; j++) {
                    r[i][j] += dot(a[i], c[j]);
                }
            }
            return r;
        }

        public static double[] mult(double[][] a, double[] x) {
            int r1 = a.length;
            int c1 = a[0].length;
            int r2 = x.length;
            if (c1 != r2) {
                throw new IllegalArgumentException("matrix colum count must equal vector length count");
            }

            double[] r = new double[r1];
            for (int i = 0; i < r1; i++) {
                r[i] += dot(a[i], x);
            }

            return r;
        }

        public static double[] mult(double[] y, double[][] a) {
            return mult(a, y);
        }

        /**
         * transpose
         *
         * @param a matrix
         * @return matrix transposed
         */
        static double[][] transpose(double[][] a) {
            if (a.length == 0) {
                throw new IllegalArgumentException("matrix a is empty");
            }
            int r = a.length;
            int c = a[0].length;

            double[][] m = new double[c][r];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    m[j][i] = a[i][j];
                }
            }
            return m;
        }


    }
}
