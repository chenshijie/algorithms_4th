package com.jason.algs4ex.ch1_5;

import com.jason.algs4ex.WeightedQuickUnionUF;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/*
1.5.3 使用加权quick-union算法（请见算法1.5）完成练习1.5.1。
 1--2--7
    4--0--9
     --3
    8--5
 6
 */
public class Ex1_5_3 {
    public static void main(String[] args) {
        int[] input = {9, 0, 3, 4, 5, 8, 7, 2, 2, 1, 5, 7, 0, 3, 4, 2};
        WQUUF uf = new WQUUF(10);
        for (int i = 0; i < input.length / 2; i++) {
            uf.union(input[2 * i], input[2 * i + 1]);
            printForest(uf.getId());
            StdOut.println(" visit count: " + uf.getVisitCnt());
            uf.resetVisitCnt();
        }
    }

    public static void printForest(int[] a) {
        StdOut.printf(Arrays.toString(a));
    }

    public static class WQUUF extends WeightedQuickUnionUF {
        private int visitCnt = 0;

        public WQUUF(int N) {
            super(N);
        }

        public int getVisitCnt() {
            return visitCnt;
        }

        public void resetVisitCnt() {
            visitCnt = 0;
        }

        @Override
        public int find(int p) {
            visitCnt++;
            while (p != id[p]) {
                p = id[p];
                visitCnt += 2;
            }
            return p;
        }

        @Override
        public void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot) {
                return;
            }
            if (sz[pRoot] < sz[qRoot]) {
                id[pRoot] = qRoot;
                sz[qRoot] += sz[pRoot];
            } else {
                id[qRoot] = pRoot;
                sz[pRoot] += sz[qRoot];
            }
            visitCnt++;
            count--;
        }

        public int[] getId() {
            return id;
        }
    }
}
