package com.jason.algs4ex;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/*
1.2.10 Develop a class VisualCounter that allows both increment and decrement
operations. Take two arguments N and max in the constructor, where N specifies the
maximum number of operations and max specifies the maximum absolute value for
the counter. As a side effect, create a plot showing the value of the counter each time its
tally changes.
 */
public class VisualCounter {

    private final int maxOperationTimes;
    private final int maxAbsCount;
    private int count = 0;
    private int operationTimes = 0;


    public VisualCounter(int N, int max) {
        this.maxOperationTimes = N;
        this.maxAbsCount = max;

        StdDraw.setXscale(0, N);
        StdDraw.setYscale(-max, max);
        StdDraw.line(0, 0, N, 0);
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int max = Integer.parseInt(args[1]);

        VisualCounter vc = new VisualCounter(N, max);
        for (int i = 0; i < N; i++) {
            if (StdRandom.bernoulli(0.5)) {
                vc.increment();
            } else {
                vc.decrement();
            }
            vc.draw();
            if (i > max) {
                if (vc.isEnd()) {
                    break;
                }
            }
        }
    }

    public void increment() {
        if (operationTimes < maxOperationTimes && Math.abs(count) < maxAbsCount) {
            operationTimes++;
            count++;
        }

    }

    public void decrement() {
        if (operationTimes < maxOperationTimes && Math.abs(count) < maxAbsCount) {
            operationTimes++;
            count--;
        }
    }

    public int tally() {
        return count;
    }

    public void draw() {
        StdDraw.line(operationTimes, 0, operationTimes, count);
    }

    public boolean isEnd() {
        return operationTimes == maxOperationTimes || Math.abs(count) == maxAbsCount;
    }
}
