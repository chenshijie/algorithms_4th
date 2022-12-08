package com.jason.algs4ex;

import edu.princeton.cs.algs4.StdOut;

public class Transaction implements Comparable<Transaction> {
    private final String who;
    private final Date when;
    private final double amount;

    public Transaction(String who, Date when, double amount) {
        if (Double.isNaN(amount) || Double.isInfinite(amount)) {
            throw new IllegalArgumentException("Amount cannot be NaN or infinite");
        }
        this.who = who;
        this.when = when;
        this.amount = amount;
    }

    public Transaction(String transaction) {
        String[] a = transaction.split("\\s+");
        who = a[0];
        when = new Date(a[1]);
        amount = Double.parseDouble(a[2]);
        if (Double.isNaN(amount) || Double.isInfinite(amount)) {
            throw new IllegalArgumentException("Amount cannot be NaN or infinite");
        }
    }

    public static void main(String[] args) {
        Transaction t1 = new Transaction("Turing   6/17/1990  644.08");
        Transaction t2 = new Transaction("Tarjan   3/26/2002 4121.85");

        StdOut.println(t1.compareTo(t2));

        StdOut.println(t2);
        StdOut.println(t1.hashCode());
    }

    public String who() {
        return who;
    }

    public Date when() {
        return when;
    }

    public double amount() {
        return amount;
    }

    @Override
    public int compareTo(Transaction that) {
        return Double.compare(this.amount, that.amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        if (Double.compare(that.amount, amount) != 0) return false;
        if (!who.equals(that.who)) return false;
        return when.equals(that.when);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = who.hashCode();
        result = 31 * result + when.hashCode();
        temp = Double.doubleToLongBits(amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s\t%s\t%.3f", who, when, amount);
    }
}
