package com.jason.algs4ex.ch1_5;

import com.jason.RandomGrid;
import com.jason.algs4ex.Connection;
import com.jason.algs4ex.RandomBag;
import edu.princeton.cs.algs4.StdDraw;

/*
1.5.19 动画。编写一个RandomGrid（请见练习1.5.18）的用例，和我们的开发用例一样使用UnionFind来检查触点的连通性并在处理的同时用StdDraw将它们绘出。
 */

public class Ex1_5_19 {
    public static void main(String[] args) {
        int n = 10;
        StdDraw.setXscale(-1, n);
        StdDraw.setYscale(-1, n);
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.setPenRadius(0.01);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                StdDraw.point(j, i);
            }
        }
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.002);

        RandomBag<Connection> bag = RandomGrid.generate(n);


        for (Connection c : bag) {
            StdDraw.line(c.getP() / n, c.getP() % n, c.getQ() / n, c.getQ() % n);
        }
    }
}
