package com.jason.algs4ex;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class VirtualAccumulator extends Accumulator {

    public VirtualAccumulator(int trials, double max) {
        StdDraw.setXscale(0, trials);
        StdDraw.setYscale(0, max);

        StdDraw.setPenRadius(0.002);
        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        StdDraw.line(0, 0.5, trials, 0.5);
        StdDraw.setPenRadius(0.005);
    }

    public static void main(String[] args) {
        int T = Integer.parseInt(args[0]);
        Accumulator a = new VirtualAccumulator(T, 1.0);
        for (int i = 0; i < T; i++) {
            a.addDataValue(StdRandom.uniformDouble());
        }
        StdOut.println(a);
    }

    public void addDataValue(double val) {
        super.addDataValue(val);

        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.point(count, val);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.point(count, total / count);
    }
}
