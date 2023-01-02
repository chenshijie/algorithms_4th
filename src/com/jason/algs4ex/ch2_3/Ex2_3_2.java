package com.jason.algs4ex.ch2_3;
/*
2.3.2 按照本节中快速排序所示轨迹的格式给出快速排序是如何将数组E A S Y Q U E S T I O N排序的（出于练习的目的，可以忽略开头打乱数组的部分）。
2.3.2 Show, in the style of the quicksort trace given in this section, how quicksort sorts
the array E A S Y Q U E S T I O N (for the purposes of this exercise, ignore the
initial shuffle).
 */

import com.jason.algs4ex.ConsoleColor;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Ex2_3_2 {

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
            sb.append(ConsoleColor.color("j", "%4s", ConsoleColor.COLOR_BLUE));
            sb.append(ConsoleColor.color("hi", "%4s", ConsoleColor.COLOR_BLUE));
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

        public static String getLeftCoordinate(int lo, int j, int hi) {
            StringBuilder sb = new StringBuilder();

            int color = ConsoleColor.COLOR_YELLOW;
            if (lo == hi) {
                color = ConsoleColor.COLOR_GRAY;
            }
            if (lo >= 0) {
                sb.append(ConsoleColor.color(lo + "", "%4s", color));
            } else {
                sb.append("    ");
            }
            if (j >= 0) {
                sb.append(ConsoleColor.color(j + "", "%4s", ConsoleColor.COLOR_RED, ConsoleColor.FONT_TYPE_BOLD));
            } else {
                sb.append("    ");
            }
            if (hi >= 0) {
                sb.append(ConsoleColor.color(hi + "", "%4s", color));
            } else {
                sb.append("    ");
            }
            return sb.toString();
        }

        public static <T> String getFormatData(T[] a, int lo, int j, int hi) {
            StringBuilder sb = new StringBuilder();
            sb.append(getLeftCoordinate(lo, j, hi));

            for (int i = 0; i < a.length; i++) {
                if (i < lo || i > hi) {
                    sb.append(ConsoleColor.color(a[i] + "", "%4s", ConsoleColor.COLOR_GRAY));
                } else if (i == j) {
                    sb.append(ConsoleColor.color(a[i] + "", "%4s", ConsoleColor.COLOR_RED, ConsoleColor.FONT_TYPE_BOLD));
                } else {
                    sb.append(ConsoleColor.color(a[i] + "", "%4s", ConsoleColor.COLOR_YELLOW));
                }
            }

            return sb.toString();

        }

        public static <T extends Comparable<T>> void sort(T[] a) {
            printHeader(a);
            StdOut.println(getFormatData(a, -1, -1, -1));
            StdRandom.shuffle(a);
            StdOut.println(getFormatData(a, -1, -1, -1));

            sort(a, 0, a.length - 1);
        }

        protected static <T extends Comparable<T>> void sort(T[] a, int lo, int hi) {
            if (hi <= lo) {
                return;
            }
            int j = partition(a, lo, hi);
            StdOut.println(getFormatData(a, lo, j, hi));
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
            while (true) {
                while (less(a[++i], v)) {
                    if (i == hi) {
                        break;
                    }
                }
                while (less(v, a[--j])) {
                    if (j == lo) {
                        break;
                    }
                }
                if (i >= j) {
                    break;
                }
                exchange(a, i, j);
            }
            exchange(a, lo, j);
            return j;
        }
    }
}
