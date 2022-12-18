package com.jason.algs4ex.ch1_1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;

/*

1.1.32 Histogram.
Suppose that the standard input stream is a sequence of double values. Write a program that takes an integer N and two
double values l and r from the command line and uses StdDraw to plot a histogram of the count of the numbers in the
standard input stream that fall in each of the N intervals defined by dividing (l , r) into N equal-sized intervals.

  */
public class Ex1_1_32 {

    public static ArrayList<Double> generateData(int size, double min, double max) {
        ArrayList<Double> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(StdRandom.uniformDouble(min, max));
        }
        return list;
    }

    public static int getMaxElement(int[] array) {
        int l = array.length;
        int max = array[0];
        for (int i = 1; i < l; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }

        return max;
    }

    public static int[] getHistogramData(ArrayList<Double> list, int N, double l, double r) {
        int[] counts = new int[N];
        double step = (r - l) / N;

        for (Double e : list) {
            if (e >= l && e <= r) {
                double t = (e - l) / step;
                int index = (int) t;
                counts[index]++;
            }
        }
        return counts;
    }

    public static int[] getHistogramData2Loop(ArrayList<Double> list, int N, double l, double r) {
        int[] counts = new int[N];
        double step = (r - l) / N;

        for (Double e : list) {
            if (e >= l && e <= r) {
                for (int j = 0; j < N; j++) {
                    if (e > l + step * j && e <= l + step * j + step) {
                        counts[j]++;
                    }
                }
            }
        }
        return counts;
    }

    public static void drawHistogram(int[] data) {
        int length = data.length;
        int max = getMaxElement(data);
        for (int i = 0; i < length; i++) {
            double x = (1.0 * i + 0.5) / length;
            double y = data[i] / (max * 2.0);
            double rw = 0.4 / length;
            StdDraw.filledRectangle(x, y, rw, y);
        }
    }

    public static void main(String[] args) {

        System.out.println("Ex1_1_32");

        //为了方便测试，使用随机生成的方式替代从标准输入获取
        ArrayList<Double> list = generateData(1000000, 1, 1000);

        StdOut.println("Please input an integer value:");
        int N = StdIn.readInt();

        StdOut.println("Please input a double value as left boundary:");
        double l = StdIn.readDouble();
        StdOut.println("Please input a double value as right boundary:");
        double r = StdIn.readDouble();


        int[] counts = getHistogramData2Loop(list, N, l, r);
        //int[] counts = getHistogramData(list, N, l, r);

        drawHistogram(counts);
    }
}
