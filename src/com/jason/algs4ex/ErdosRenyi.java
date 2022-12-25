package com.jason.algs4ex;

import edu.princeton.cs.algs4.StdRandom;

public class ErdosRenyi {
    public static int count(int n) {
        int edges = 0;
        UF uf = new WeightedQuickFindUF(n);
        while (uf.count() > 1) {
            int i = StdRandom.uniformInt(0, n);
            int j = StdRandom.uniformInt(0, n);
            if (!uf.connected(i, j)) {
                uf.union(i, j);
            }
            edges++;
        }
        return edges;
    }
}
