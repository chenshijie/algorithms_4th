package com.jason.algs4ex.ch2_4;

import edu.princeton.cs.algs4.StdOut;

/*
2.4.26 无需交换的堆。因为sink()和swim()中都用到了初级函数exch()，所以所有元素都被多加载并存储了一次。
回避这种低效方式，用插入排序给出新的实现（请见练习2.1.25）。
 */
public class Ex2_4_26 {

    public static void main(String[] args) {
        String s = "1 6 3 2 5 8 7 4 9";
        String[] a = s.split("\\s");
        MaxPQ<String> pq = new MaxPQ<>(a.length);

        for (String i : a) {
            pq.insert(i);
        }
        while (!pq.isEmpty()) {
            StdOut.print(pq.delMax() + " ");
        }
        StdOut.println();
    }

    public static class MaxPQ<Key extends Comparable<Key>> {
        private Key[] pq;
        private int N = 0;

        public MaxPQ(int max) {
            pq = (Key[]) new Comparable[max + 1];
        }

        public boolean isEmpty() {
            return N == 0;
        }

        public int size() {
            return N;
        }

        public void insert(Key v) {
            pq[++N] = v;
            swimWithInsertion(N);
        }

        public Key delMax() {
            Key max = pq[1];
            exch(1, N--);
            pq[N + 1] = null;
            sinkWithInsertion(1);
            return max;
        }

        private boolean less(int i, int j) {
            return pq[i].compareTo(pq[j]) < 0;
        }

        private boolean less(Key a, Key b) {
            return a.compareTo(b) < 0;
        }

        private void exch(int i, int j) {
            Key swap = pq[i];
            pq[i] = pq[j];
            pq[j] = swap;
        }

        private void swim(int k) {
            while (k > 1 && less(k / 2, k)) {
                exch(k / 2, k);
                k = k / 2;
            }
        }

        private void swimWithInsertion(int k) {
            Key max = pq[k];
            while (k > 1 && less(pq[k / 2], max)) {
                pq[k] = pq[k / 2];
                k = k / 2;
            }
            pq[k] = max;
        }

        private void sink(int k) {
            while (2 * k <= N) {
                int j = 2 * k;
                if (j < N && less(j, j + 1)) {
                    j++;
                }
                if (!less(k, j)) {
                    break;
                }
                exch(k, j);
                k = j;
            }
        }

        private void sinkWithInsertion(int k) {
            Key min = pq[k];
            int j = k;
            while (2 * k <= N) {
                j = 2 * k;
                if (j < N && less(j, j + 1)) {
                    j++;
                }
                if (less(pq[j], min)) {
                    break;
                }
                pq[k] = pq[j];
                k = j;
            }
            pq[k] = min;
        }

    }
}
