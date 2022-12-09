package com.jason.algs4ex.chapter1;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/*
1.2.1 Write a Point2D client that takes an integer value N from the command line,
generates N random points in the unit square, and computes the distance separating
the closest pair of points.
 */
public class Ex1_2_1 {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);

        double UNIT = 1.0;

        Point2D[] points = new Point2D[N];


        StdDraw.setXscale(0, UNIT);
        StdDraw.setYscale(0, UNIT);

        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.setPenRadius(0.005);
        for (int i = 0; i < N; i++) {
            points[i] = new Point2D(StdRandom.uniformDouble(0, UNIT), StdRandom.uniformDouble(0, UNIT));
            StdDraw.point(points[i].x(), points[i].y());
        }

        double minDistance = Math.sqrt(Math.pow(UNIT, 2) + Math.pow(UNIT, 2));
        int p1 = 0, p2 = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                double d = points[i].distanceTo(points[j]);
                if (d < minDistance) {
                    minDistance = d;
                    p1 = i;
                    p2 = j;
                }
            }
        }

        StdOut.println("The closest pair of points:");
        StdOut.println(points[p1]);
        StdOut.println(points[p2]);
        StdOut.println("The distance is:" + minDistance);


        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.setPenRadius(0.002);
        StdDraw.line(points[p1].x(), points[p1].y(), points[p2].x(), points[p2].y());
    }
}
