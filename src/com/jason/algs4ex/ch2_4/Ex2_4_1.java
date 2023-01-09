package com.jason.algs4ex.ch2_4;

import com.jason.algs4ex.MaxPQ;
import edu.princeton.cs.algs4.StdOut;

/*
2.4.1 用序列P R I O ＊ R ＊ ＊ I ＊ T ＊ Y ＊ ＊ ＊ Q U E ＊ ＊ ＊ U ＊ E（字母表示插入元素，星号表示删除最大元素）
操作一个初始为空的优先队列。给出每次删除最大元素返回的字符。
 */
public class Ex2_4_1 {
    public static void main(String[] args) {
        String s = "P R I O ＊ R ＊ ＊ I ＊ T ＊ Y ＊ ＊ ＊ Q U E ＊ ＊ ＊ U ＊ E";
        String[] a = s.split("\\s");
        MaxPQ<String> pq = new MaxPQ<>();

        for (String i : a) {
            if (i.equals("＊")) {
                StdOut.print(pq.delMax() + " ");
            } else {
                pq.insert(i);
            }
        }
        StdOut.println();
    }
}
