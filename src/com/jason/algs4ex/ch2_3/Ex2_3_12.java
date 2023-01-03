package com.jason.algs4ex.ch2_3;
/*
2.3.12 按照代码所示轨迹的格式给出信息量最佳的快速排序第一次是如何切分数组B A B A B A B A B A B A C A D A B R A的。
 */

import com.jason.algs4ex.ConsoleColor;
import edu.princeton.cs.algs4.StdOut;

public class Ex2_3_12 {

    public static void main(String[] args) {
        String s = "B A B A B A B A C A D A B R A";
        String[] a = s.split("\\s+");
        QuickSort.sort(a);
    }

    public static class QuickSort {

        protected static boolean isFirstPartition = true;

        public static <T> void printHeader(T[] a) {
            StringBuilder sb = new StringBuilder();
            StringBuilder line = new StringBuilder();
            sb.append(ConsoleColor.color("lt", "%4s", ConsoleColor.COLOR_BLUE));
            sb.append(ConsoleColor.color("i", "%4s", ConsoleColor.COLOR_BLUE));
            sb.append(ConsoleColor.color("gt", "%4s", ConsoleColor.COLOR_BLUE));
            line.append("              ");
            for (int i = 0; i < a.length; i++) {
                sb.append(ConsoleColor.color(i + "", "%4s", ConsoleColor.COLOR_BLUE));
                if (i == 0) {
                    line.append("--");
                } else {
                    line.append("----");
                }

            }
            StdOut.println(sb);
            StdOut.println(line);
        }

        public static String getLeftCoordinate(int lt, int i, int gt) {
            if (lt < 0 || gt < 0 || i < 0) {
                return "            ";
            }

            return ConsoleColor.color(lt + "", "%4s", ConsoleColor.COLOR_GREEN) + ConsoleColor.color(i + "", "%4s", ConsoleColor.COLOR_RED) + ConsoleColor.color(gt + "", "%4s", ConsoleColor.COLOR_BLUE);

        }

        public static <T> String getFormatData(T[] a, int lt, int i, int gt) {
            StringBuilder sb = new StringBuilder();
            sb.append(getLeftCoordinate(lt, i, gt));

            for (int n = 0; n < a.length; n++) {
                if (n == lt) {
                    sb.append(ConsoleColor.color(a[n] + "", "%4s", ConsoleColor.COLOR_GREEN));
                } else if (n == i) {
                    sb.append(ConsoleColor.color(a[n] + "", "%4s", ConsoleColor.COLOR_RED));
                } else if (n == gt) {
                    sb.append(ConsoleColor.color(a[n] + "", "%4s", ConsoleColor.COLOR_BLUE));
                } else if (n < lt || n > gt) {
                    sb.append(ConsoleColor.color(a[n] + "", "%4s", ConsoleColor.COLOR_GRAY));
                } else {
                    sb.append(ConsoleColor.color(a[n] + "", "%4s", ConsoleColor.COLOR_YELLOW));
                }
            }
            return sb.toString();
        }

        public static <T extends Comparable<T>> void sort(T[] a) {
            printHeader(a);
            StdOut.println(getFormatData(a, -1, -1, -1));

            sort(a, 0, a.length - 1);
        }

        protected static <T extends Comparable<T>> void sort(T[] a, int lo, int hi) {
            if (hi <= lo) return;
            int lt = lo, i = lo + 1, gt = hi;
            T v = a[lo];
            while (i <= gt) {
                int cmp = a[i].compareTo(v);
                if (cmp < 0) {
                    exchange(a, lt++, i++);
                    if (isFirstPartition) StdOut.println(getFormatData(a, lt, i, gt));
                } else if (cmp > 0) {
                    exchange(a, i, gt--);
                    if (isFirstPartition) StdOut.println(getFormatData(a, lt, i, gt));
                } else {
                    i++;
                    if (isFirstPartition) StdOut.println(getFormatData(a, lt, i, gt));
                }
            }  // 现在a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi]成立
            isFirstPartition = false;
            sort(a, lo, lt - 1);
            sort(a, gt + 1, hi);
        }

        protected static <T extends Comparable<T>> boolean less(T a, T b) {
            return a.compareTo(b) < 0;
        }

        protected static <T extends Comparable<T>> void exchange(T[] a, int x, int y) {
            T t = a[x];
            a[x] = a[y];
            a[y] = t;
        }
    }
}
