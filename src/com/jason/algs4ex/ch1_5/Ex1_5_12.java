package com.jason.algs4ex.ch1_5;

import com.jason.algs4ex.WeightedQuickUnionUF;

/*
1.5.12 使用路径压缩的quick-union算法。根据路径压缩修改quick-union算法（请见1.5.2.3节），
在find()方法中添加一个循环来将从p到根节点的路径上的每个触点都连接到根节点。给出一列输入，
使该方法能够产生一条长度为4的路径。注意：该算法的所有操作的均摊成本已知为对数级别。
 */

public class Ex1_5_12 {
    public static void main(String[] args) {
        QuickUnionPathCompressionUF.main(args);
    }

    public static class QuickUnionPathCompressionUF extends WeightedQuickUnionUF {
        public QuickUnionPathCompressionUF(int N) {
            super(N);
        }

        /**
         * @param p element
         * @return root
         */
        @Override
        public int find(int p) {
            int root = p;
            while (root != id[root])
                root = id[root];
            while (p != root) {
                int newp = id[p];
                id[p] = root;
                p = newp;
            }
            return root;
        }
    }
}
