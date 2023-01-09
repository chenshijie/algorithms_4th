package com.jason.algs4ex.ch2_4;

import com.jason.algs4ex.MaxPQ;
import edu.princeton.cs.algs4.StdOut;

/*
2.4.5 将E A S Y Q U E S T I O N顺序插入一个面向最大元素的堆中，给出结果。
 */
public class Ex2_4_5 {
    public static void main(String[] args) {
        String s = "E A S Y Q U E S T I O N";
        String[] a = s.split("\\s");
        MaxPQ<String> pq = new MaxPQ<>();

        for (String x : a) {
            pq.insert(x);
            Object[] temp = pq.getHeap();
            for (int i = 1; i <= pq.size(); i++) {
                StdOut.print(temp[i] + " ");
            }
            StdOut.println();
        }
    }
}
