package com.jason.algs4ex;

public class Connection {
    int p;
    int q;

    public Connection(int p, int q) {
        this.p = p;
        this.q = q;
    }

    @Override
    public String toString() {
        return "Connection{" +
                "p=" + p +
                ", q=" + q +
                '}';
    }

    public int getP() {
        return p;
    }

    public int getQ() {
        return q;
    }
}
