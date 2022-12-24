package com.jason.algs4ex.ch1_5;

import com.jason.algs4ex.QuickFindUF;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/*
1.5.1 使用quick-find算法处理序列9-0 3-4 5-8 7-2 2-1 5-7 0-3 4-2。对于输入的每一对整数，给出id[]数组的内容和访问数组的次数。
 */
public class Ex1_5_1 {
    public static void main(String[] args) {
        int[] input = {9, 0, 3, 4, 5, 8, 7, 2, 2, 1, 5, 7, 0, 3, 4, 2};
        QFUF uf = new QFUF(10);
        for (int i = 0; i < input.length / 2; i++) {
            uf.union(input[2 * i], input[2 * i + 1]);
            StdOut.println("id[]: " + uf.getIdAsString() + " visit count: " + uf.getVisitCnt());
            uf.resetVisitCnt();
        }
    }

    public static class QFUF extends QuickFindUF {
        private int visitCnt = 0;

        public QFUF(int N) {
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
            return super.find(p);
        }

        @Override
        public void union(int p, int q) {
            int pID = find(p);
            int qID = find(q);

            if (pID == qID) {
                return;
            }

            for (int i = 0; i < id.length; i++) {
                visitCnt++;
                if (id[i] == pID) {
                    visitCnt++;
                    id[i] = qID;
                }
            }
            count--;
        }

        public String getIdAsString() {
            return Arrays.toString(id);
        }
    }
}
