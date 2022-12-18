package com.jason.algs4ex.ch1_1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;

/*

1.1.31 Random connections. Write a program that takes as command-line arguments an integer N and a double value p
(between 0 and 1), plots N equally spaced dots of size .05 on the circumference of a circle,
and then, with probability p for each pair of points, draws a gray line connecting them.
  */
public class Ex1_1_31 {

    public static void main(String[] args) {
        System.out.println("Ex1_1_31");
        StdOut.println("Please input an integer value:");
        int N = StdIn.readInt();
        StdOut.println("Please input a double value (between 0 and 1):");
        double p = StdIn.readDouble();

        if (p > 1) p = 1;
        if (p < 0) p = 0;

        double[][] points = new double[N][2];
        double angle = 2 * Math.PI / N;

        StdDraw.circle(0.5, 0.5, 0.5);
        //大小为0.05的点
        StdDraw.setPenRadius(0.05);
        for (int i = 0; i < N; i++) {
            points[i][0] = 0.5 + 0.5 * Math.cos(angle * i);
            points[i][1] = 0.5 + 0.5 * Math.sin(angle * i);
            StdDraw.point(points[i][0], points[i][1]);
        }

        StdDraw.setPenRadius(0.005);
        StdDraw.setPenColor(Color.GRAY);
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                /*
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                */
                if (StdRandom.bernoulli(p)) {
                    StdDraw.line(points[i][0], points[i][1], points[j][0], points[j][1]);
                }
            }
        }
    }
}
