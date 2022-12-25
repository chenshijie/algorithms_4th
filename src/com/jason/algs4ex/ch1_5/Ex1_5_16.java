package com.jason.algs4ex.ch1_5;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/*
1.5.16 均摊成本的图像。修改你为练习1.5.7给出的实现，绘出如正文所示的均摊成本的图像。
 */

public class Ex1_5_16 {
    public static void main(String[] args) {

        String[] lines = new In("./data/mediumUF.txt").readAllLines();
        int N = Integer.parseInt(lines[0]);
        //Ex1_5_1.QFUF uf = new Ex1_5_1.QFUF(N);
        Ex1_5_2.QUUF uf = new Ex1_5_2.QUUF(N);
        int pairCnt = lines.length;
        int[] data = new int[pairCnt];
        int max = 0;
        for (int i = 1; i < pairCnt; i++) {
            uf.resetVisitCnt();
            String[] temp = lines[i].split("\\s");
            int p = Integer.parseInt(temp[0]);
            int q = Integer.parseInt(temp[1]);

            if (uf.connected(p, q)) {
                data[i] = uf.getVisitCnt();
                max = Math.max(max, data[i - 1]);
                continue;
            }
            uf.union(p, q);
            data[i] = uf.getVisitCnt();
            max = Math.max(max, data[i - 1]);
            StdOut.println(p + " " + q);
        }
        StdOut.println(Arrays.toString(data));
        StdOut.println(max);
        StdOut.println(uf.count() + " components");

        draw(pairCnt, max, data);
    }

    public static void draw(int N, int max, int[] data) {
        StdDraw.setXscale(-20, N);
        StdDraw.setYscale(-20, max);

        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.line(0, 0, N, 0);
        StdDraw.line(0, 0, 0, max);
        double total = 0;
        for (int i = 1; i < N; i++) {
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.point(i, data[i]);
            total += data[i];
            double avg = total / (i);
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.point(i, avg);
        }
    }

}
