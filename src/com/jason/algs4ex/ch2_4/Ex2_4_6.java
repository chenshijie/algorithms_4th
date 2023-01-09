package com.jason.algs4ex.ch2_4;

import com.jason.algs4ex.MaxPQ;
import edu.princeton.cs.algs4.StdOut;

/*
2.4.6 按照练习2.4.1的规则，用序列P R I O ＊ R ＊ ＊ I ＊ T ＊ Y ＊ ＊ ＊ Q U E ＊ ＊ ＊ U ＊ E操作一个初始为空的面向最大元素的堆，
给出每次操作后堆的内容。
 */
public class Ex2_4_6 {
    public static void main(String[] args) {
        String s = "P R I O ＊ R ＊ ＊ I ＊ T ＊ Y ＊ ＊ ＊ Q U E ＊ ＊ ＊ U ＊ E";
        String[] a = s.split("\\s");
        MaxPQ<String> pq = new MaxPQ<>();

        for (String i : a) {
            if (i.equals("＊")) {
                pq.delMax();
            } else {
                pq.insert(i);
            }
            for (String x : pq) {
                StdOut.print(x);
            }
            StdOut.println();
        }
    }
}
