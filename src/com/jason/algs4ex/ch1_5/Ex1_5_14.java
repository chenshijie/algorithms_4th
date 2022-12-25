package com.jason.algs4ex.ch1_5;

import com.jason.algs4ex.UF;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
1.5.14 根据高度加权的quick-union算法。给出UF的一个实现，使用和加权quick-union算法相同的策略，
但记录的是树的高度并总是将较矮的树连接到较高的树上。用算法证明N个触点的树的高度不会超过其大小的对数级别。
 */

public class Ex1_5_14 {
    public static void main(String[] args) {
        int N = StdIn.readInt();
        UF uf = new WeightedQuickUnionByHeightUF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();

            if (uf.connected(p, q)) {
                continue;
            }
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }

    public static class WeightedQuickUnionByHeightUF extends UF {

        protected int[] height;

        public WeightedQuickUnionByHeightUF(int N) {
            super(N);

            height = new int[N];
            for (int i = 0; i < N; i++) {
                height[i] = 1;
            }
        }

        public int find(int p) {
            while (p != id[p]) {
                p = id[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot) {
                return;
            }
            if (height[pRoot] < height[qRoot]) {
                id[pRoot] = qRoot;
                height[qRoot]++;
            } else {
                id[qRoot] = pRoot;
                height[pRoot]++;
            }
            count--;
        }
    }

}
