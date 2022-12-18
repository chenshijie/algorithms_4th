package com.jason.algs4ex.ch1_2;

import edu.princeton.cs.algs4.*;

import java.awt.*;

/*
1.2.3 Write an Interval2D client that takes command-line arguments N, min, and max
and generates N random 2D intervals whose width and height are uniformly distributed
between min and max in the unit square. Draw them on StdDraw and print the number
of pairs of intervals that intersect and the number of intervals that are contained in one
another.
 */
public class Ex1_2_3 {

    public static Interval1D randomeGenerateInterval1D(double min, double max) {
        double x1 = StdRandom.uniformDouble(min, max);
        double x2 = StdRandom.uniformDouble(min, max);
        return new Interval1D(Math.min(x1, x2), Math.max(x1, x2));
    }

    public static Color getRandomColor() {
        Color[] colors = {StdDraw.RED, StdDraw.BLUE, StdDraw.CYAN, StdDraw.GREEN, StdDraw.MAGENTA, StdDraw.ORANGE, StdDraw.YELLOW};
        int i = StdRandom.uniformInt(0, 7);
        return colors[i];
    }

    public static void main(String[] args) {

        int N = Integer.parseInt(args[0]);

        double min = Double.parseDouble(args[1]);
        double max = Double.parseDouble(args[2]);

        Interval2D[] intervals = new Interval2D[N];

        Point2D[][] points = new Point2D[N][2];

        StdDraw.setXscale(0, max);
        StdDraw.setYscale(0, max);
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.setPenRadius(0.002);

        for (int i = 0; i < N; i++) {
            Interval1D x = randomeGenerateInterval1D(min, max);
            Interval1D y = randomeGenerateInterval1D(min, max);

            intervals[i] = new Interval2D(x, y);

            points[i][0] = new Point2D(x.min(), y.min());
            points[i][1] = new Point2D(x.max(), y.max());

            StdDraw.setPenColor(getRandomColor());
            intervals[i].draw();
        }

        int intersectCnt = 0;
        int containCnt = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (intervals[i].intersects(intervals[j])) {
                    intersectCnt++;
                }
                if (intervals[i].contains(points[j][0]) && intervals[i].contains(points[j][1])) {
                    containCnt++;
                }
            }
        }


        StdOut.printf("There are %d pairs of intervals that intersect\n", intersectCnt);
        StdOut.printf("There are %d intervals that are contained in one another.\n", containCnt);
    }
}
