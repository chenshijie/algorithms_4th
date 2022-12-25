package com.jason.algs4ex.ch1_5;

import com.jason.algs4ex.WeightedQuickUnionUF;

/*
1.5.13 使用路径压缩的加权quick-union算法。修改加权quick-union算法（算法1.5），实现如练习1.5.12所述的路径压缩。
给出一列输入，使该方法能够产生一棵高度为4的树。
注意：该算法的所有操作的均摊成本已知被限制在反Ackermann函数的范围之内，且对于实际应用中可能出现的所有N值均小于5。
 */

public class Ex1_5_13 {
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
