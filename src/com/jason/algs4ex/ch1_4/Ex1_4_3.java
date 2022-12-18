package com.jason.algs4ex.ch1_4;

import com.jason.algs4ex.DoublingTest;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

/*
1.4.3 修改DoublingTest，使用StdDraw产生类似于正文中的标准图像和对数图像，根据需要调整比例使图像总能够充满窗口的大部分区域。
*/
public class Ex1_4_3 {
    public static void main(String[] args) {
        int count = 20;
        int step = 200;
        double[] numbers = new double[count];
        double[] times = new double[count];
        numbers[0] = 0;
        times[0] = 0;
        for (int i = 1; i < count; i++) {
            int N = i * step;
            double time = DoublingTest.timeTrial(N);
            numbers[i] = N;
            times[i] = time;
            StdOut.printf("%7d %5.5f\n", N, time);
        }
        double maxNumbers = numbers[count - 1];
        double maxTime = max(times);
        StdDraw.setXscale(-maxNumbers * 0.05, maxNumbers * 1.05);
        StdDraw.setYscale(-maxTime * 0.05, maxTime * 1.05);
        StdDraw.line(0, 0, maxNumbers, 0);
        StdDraw.line(0, 0, 0, maxTime);
        for (int i = 1; i < count; i++) {
            StdDraw.line(numbers[i - 1], times[i - 1], numbers[i], times[i]);
        }
    }

    public static double max(double[] array) {
        assert array.length > 0;
        double max = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max, array[i]);
        }
        return max;

    }
}
