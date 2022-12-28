package com.jason.algs4ex.ch2_1;

import com.jason.algs4ex.BaseSort;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/*
2.1.17 动画。修改插入排序和选择排序的代码，使之将数组内容绘制成正文中所示的棒状图。在每一轮排序后重绘图片来产生动画效果，
并以一张“有序”的图片作为结束，即所有圆棒均已按照高度有序排列。
提示：使用类似于正文中的用例来随机生成Double值，在排序代码的适当位置调用show()方法，并在show()方法中清理画布并绘制棒状图。
 */
public class Ex2_1_17 extends BaseSort {
    public static void insertionSort(Double[] a) {  // 将a[]按升序排列
        int N = a.length;
        for (int i = 1; i < N; i++) {  // 将a[i] 插入到a[i-1]、a[i-2]、a[i-3]..．之中
            int j;
            for (j = i; j > 0; j--) {
                if (less(a[j], a[j - 1])) {
                    draw(i, j, j - 1, a, false);
                    exch(a, j, j - 1);
                    draw(i, j, j - 1, a, true);
                } else {
                    break;
                }

            }
        }
    }

    public static void selectionSort(Double[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            int j = i + 1;
            for (; j < N; j++) {
                draw(i, j, min, a);
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
            draw(min, j, i, a);
        }
    }

    public static void draw(int l1, int l2, int min, Double[] a) {
        StdDraw.clear();
        for (int i = 0; i < a.length; i++) {
            double up = 0.0;
            if (i == min) {
                up = 0.0;
                StdDraw.setPenColor(StdDraw.RED);
            } else if (i == l1) {
                StdDraw.setPenColor(StdDraw.BLUE);
            } else if (i >= l1 && i <= l2) {
                StdDraw.setPenColor(StdDraw.BLACK);
            } else {
                StdDraw.setPenColor(StdDraw.GRAY);
            }
            StdDraw.filledRectangle(i + 0.5, a[i] / 2 + up, 0.4, a[i] / 2);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

    }

    public static void draw(int l1, int l2, int ex, Double[] a, boolean exchangeDone) {
        StdDraw.clear();
        for (int i = 0; i < a.length; i++) {
            double up = 0;
            if (i == l2) {
                if (exchangeDone) {
                    StdDraw.setPenColor(StdDraw.BLUE);
                } else {
                    up = 0.1;
                    StdDraw.setPenColor(StdDraw.RED);
                }
            } else if (i == ex) {
                if (exchangeDone)
                    StdDraw.setPenColor(StdDraw.RED);
                else
                    StdDraw.setPenColor(StdDraw.BLUE);
            } else if (i > l1) {
                StdDraw.setPenColor(StdDraw.GRAY);
            } else if (i >= ex) {
                StdDraw.setPenColor(StdDraw.BLACK);
            } else {
                StdDraw.setPenColor(StdDraw.GRAY);
            }
            StdDraw.filledRectangle(i + 0.5, a[i] / 2 + up, 0.4, a[i] / 2);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

    }

    public static void draw(Double[] a) {
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int i = 0; i < a.length; i++) {
            StdDraw.filledRectangle(i + 0.5, a[i] / 2, 0.4, a[i] / 2);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }

    public static void main(String[] args) {
        int N = 10;
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniformDouble(0.2, 1);
        }
        a[0] = 0.5;
        StdOut.println(Arrays.toString(a));
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(-0.1, 1.1);
        draw(a);
        insertionSort(a);
        StdRandom.shuffle(a);
        draw(a);
        selectionSort(a);
    }
}