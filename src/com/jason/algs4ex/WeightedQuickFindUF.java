package com.jason.algs4ex;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class WeightedQuickFindUF extends UF {

    protected int[] sz;

    public WeightedQuickFindUF(int N) {
        super(N);
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            sz[i] = 1;
        }
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        UF uf = new WeightedQuickFindUF(N);
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

    public int find(int p) {
        return id[p];
    }

    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        if (pID == qID) {
            return;
        }

        int largerID = 0;
        int smallerID = 0;
        if (sz[pID] > sz[qID]) {
            largerID = pID;
            smallerID = qID;
            sz[pID] += sz[qID];
        } else {
            largerID = qID;
            smallerID = pID;
            sz[pID] += sz[pID];
        }

        for (int i = 0; i < id.length; i++) {
            if (id[i] == smallerID) {
                id[i] = largerID;
            }
        }
        count--;
    }
}
