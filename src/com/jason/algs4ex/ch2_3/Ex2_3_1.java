package com.jason.algs4ex.ch2_3;
/*
2.3.1 按照partition()方法的轨迹的格式给出该方法是如何切分数组E A S Y Q U E S T I O N的。
2.3.1 Show, in the style of the trace given with partition(), how that method patitions
the array E A S Y Q U E S T I O N.
 */

import com.jason.algs4ex.ConsoleColor;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Ex2_3_1 {

    public static void main(String[] args) {
        String s = "E A S Y Q U E S T I O N";
        String[] a = s.split("\\s+");
        QuickSort.sort(a);
    }

    public static class QuickSort {

        public static <T> void printHeader(T[] a) {
            StringBuilder sb = new StringBuilder();
            StringBuilder line = new StringBuilder();
            sb.append(ConsoleColor.color("lo", "%4s", ConsoleColor.COLOR_BLUE));
            sb.append(ConsoleColor.color("i", "%4s", ConsoleColor.COLOR_BLUE));
            sb.append(ConsoleColor.color("j", "%4s", ConsoleColor.COLOR_BLUE));
            sb.append(ConsoleColor.color("hi", "%4s", ConsoleColor.COLOR_BLUE));
            line.append("                  ");
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

        public static String getLeftCoordinate(int lo, int i, int j, int hi) {
            if (i < 0 || j < 0 || lo < 0 || hi < 0) {
                return "                ";
            }
            StringBuilder sb = new StringBuilder();

            int color = ConsoleColor.COLOR_YELLOW;
            if (lo == hi) {
                color = ConsoleColor.COLOR_GRAY;
            }
            sb.append(ConsoleColor.color(lo + "", "%4s", ConsoleColor.COLOR_GREEN));
            sb.append(ConsoleColor.color(i + "", "%4s", color));
            sb.append(ConsoleColor.color(j + "", "%4s", color));
            sb.append(ConsoleColor.color(hi + "", "%4s", color));

            return sb.toString();
        }

        public static <T> String getFormatData(T[] a, int lo, int i, int j, int hi) {
            StringBuilder sb = new StringBuilder();
            sb.append(getLeftCoordinate(lo, i, j, hi));

            for (int n = 0; n < a.length; n++) {
                if (n < lo || n > hi) {
                    sb.append(ConsoleColor.color(a[n] + "", "%4s", ConsoleColor.COLOR_GRAY));
                } else if (n == lo) {
                    sb.append(ConsoleColor.color(a[n] + "", "%4s", ConsoleColor.COLOR_GREEN, ConsoleColor.FONT_TYPE_BOLD));
                } else if (n == i) {
                    sb.append(ConsoleColor.color(a[n] + "", "%4s", ConsoleColor.COLOR_BLUE));
                } else if (n == j) {
                    sb.append(ConsoleColor.color(a[n] + "", "%4s", ConsoleColor.COLOR_BLUE));
                } else {
                    sb.append(ConsoleColor.color(a[n] + "", "%4s", ConsoleColor.COLOR_YELLOW));
                }
            }
            return sb.toString();
        }

        public static <T> String getExchangeFormatData(T[] a, int i, int j) {
            StringBuilder sb = new StringBuilder();
            sb.append(getLeftCoordinate(-1, -1, -1, -1));

            for (int n = 0; n < a.length; n++) {
                if (n == i || n == j) {
                    sb.append(ConsoleColor.color(a[n] + "", "%4s", ConsoleColor.COLOR_RED));
                } else {
                    sb.append(ConsoleColor.color(a[n] + "", "%4s", ConsoleColor.COLOR_GRAY));
                }
            }
            return sb.toString();
        }

        public static <T extends Comparable<T>> void sort(T[] a) {
            printHeader(a);
            StdOut.println(getFormatData(a, -1, -1, -1, -1));
            StdRandom.shuffle(a);
            StdOut.println(getFormatData(a, -1, -1, -1, -1));

            sort(a, 0, a.length - 1);
        }

        protected static <T extends Comparable<T>> void sort(T[] a, int lo, int hi) {
            if (hi <= lo) {
                return;
            }
            int j = partition(a, lo, hi);

            sort(a, lo, j - 1);
            sort(a, j + 1, hi);
        }

        protected static <T extends Comparable<T>> boolean less(T a, T b) {
            return a.compareTo(b) < 0;
        }

        protected static <T extends Comparable<T>> void exchange(T[] a, int x, int y) {
            T t = a[x];
            a[x] = a[y];
            a[y] = t;
        }

        public static <T extends Comparable<T>> int partition(T[] a, int lo, int hi) {
            int i = lo, j = hi + 1;
            T v = a[lo];
            StdOut.println(getFormatData(a, lo, i, j, hi));
            while (true) {
                while (less(a[++i], v)) {
                    StdOut.println(getFormatData(a, lo, i, j, hi));
                    if (i == hi) {
                        break;
                    }
                }
                StdOut.println(getFormatData(a, lo, i, j, hi));
                while (less(v, a[--j])) {
                    StdOut.println(getFormatData(a, lo, i, j, hi));
                    if (j == lo) {
                        break;
                    }
                }
                StdOut.println(getFormatData(a, lo, i, j, hi));
                if (i >= j) {
                    break;
                }
                StdOut.println(getExchangeFormatData(a, i, j));
                exchange(a, i, j);
                StdOut.println(getExchangeFormatData(a, i, j));
            }
            StdOut.println(getExchangeFormatData(a, lo, j));
            exchange(a, lo, j);
            StdOut.println(getExchangeFormatData(a, lo, j));
            return j;
        }
    }
}
