package com.jason.algs4ex.ch2_3;
/*
2.3.15 螺丝和螺帽。（G. J. E. Rawlins）假设有N个螺丝和N个螺帽混在一堆，你需要快速将它们配对。
一个螺丝只会匹配一个螺帽，一个螺帽也只会匹配一个螺丝。你可以试着把一个螺丝和一个螺帽拧在一起看看谁大了，
但不能直接比较两个螺丝或者两个螺帽。给出一个解决这个问题的有效方法。
*/

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Ex2_3_15 {

    public static void main(String[] args) {
        Integer[] sizes = {1, 2, 3, 4};
        int N = 20;
        Bolt<Integer>[] bolts = new Bolt[N];
        Nut<Integer>[] nuts = new Nut[20];
        for (int i = 0; i < N; i++) {
            Integer size = sizes[StdRandom.uniformInt(0, 4)];
            bolts[i] = new Bolt<>(size);
            nuts[i] = new Nut<>(size);
        }

        BoltsAndNutsMatch.sort(bolts, nuts);
        StdOut.println(Arrays.toString(bolts));
        StdOut.println(Arrays.toString(nuts));
    }

    public static class Bolt<T extends Comparable<T>> {
        T size;

        public Bolt(T size) {
            this.size = size;
        }

        public T getSize() {
            return size;
        }

        public int compareTo(Nut<T> that) {
            return this.size.compareTo(that.getSize());
        }

        @Override
        public String toString() {
            return "Bolt:" + size;
        }
    }

    public static class Nut<T extends Comparable<T>> {
        T size;

        public Nut(T size) {
            this.size = size;
        }

        public T getSize() {
            return size;
        }

        public int compareTo(Bolt<T> that) {
            return this.size.compareTo(that.getSize());
        }

        @Override
        public String toString() {
            return "Nut :" + size;
        }
    }

    public static class BoltsAndNutsMatch {
        public static <T extends Comparable<T>> void sort(Bolt<T>[] bolts, Nut<T>[] nuts) {
            StdRandom.shuffle(bolts);
            StdRandom.shuffle(nuts);
            sort(bolts, nuts, 0, nuts.length - 1);
        }


        public static <T extends Comparable<T>> void sort(Bolt<T>[] bolts, Nut<T>[] nuts, int lo, int hi) {
            if (hi <= lo)
                return;
            int j = partition(bolts, nuts, lo, hi);
            sort(bolts, nuts, lo, j - 1);
            sort(bolts, nuts, j + 1, hi);
        }

        protected static <T> void exchange(T[] a, int x, int y) {
            T t = a[x];
            a[x] = a[y];
            a[y] = t;
        }

        private static <T extends Comparable<T>> int partition(Bolt<T>[] bolts, Nut<T>[] nuts, int lo, int hi) {
            int i = lo, j = hi + 1;
            Bolt<T> pivotB = bolts[lo];
            // 找到对应螺丝
            for (int k = lo; k <= hi; k++) {
                if (nuts[k].compareTo(pivotB) == 0) {
                    exchange(nuts, k, lo);
                    break;
                }
            }
            // 先用螺母去套螺丝
            while (true) {
                while (nuts[++i].compareTo(pivotB) < 0)
                    if (i == hi)
                        break;
                while (pivotB.compareTo(nuts[--j]) < 0)
                    if (j == lo)
                        break;

                if (i >= j)
                    break;
                exchange(nuts, i, j);
            }
            exchange(nuts, lo, j);

            // 再用螺丝去比较螺母
            Nut<T> pivotN = nuts[j];
            i = lo;
            j = hi + 1;
            while (true) {
                while (bolts[++i].compareTo(pivotN) < 0)
                    if (i == hi)
                        break;
                while (pivotN.compareTo(bolts[--j]) < 0)
                    if (j == lo)
                        break;

                if (i >= j)
                    break;

                exchange(bolts, i, j);
            }
            exchange(bolts, lo, j);

            return j;
        }
    }
}
