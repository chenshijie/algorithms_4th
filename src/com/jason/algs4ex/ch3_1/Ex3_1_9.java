package com.jason.algs4ex.ch3_1;

/*
3.1.9 在FrequencyCounter中添加追踪put()方法的最后一次调用的代码。打印出最后插入的那个单词以及在此之前总共从输入中处理了多少个单词。
用你的程序处理tale.txt中长度分别大于等于1、8和10的单词。
 */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex3_1_9 {

    public static void outputLastPutAndMaxCountWord(int wordLength) {
        ST<String, Integer> st = new ST<>();
        String lastPutWord = "";
        int wordCount = 0;
        while (!StdIn.isEmpty()) {
            String key = StdIn.readString();
            if (key.length() < wordLength) {
                continue;
            }
            wordCount++;
            if (st.contains(key)) {
                st.put(key, st.get(key) + 1);
                lastPutWord = key;
            } else {
                st.put(key, 1);
            }
        }
        StdOut.println("Last Put: " + lastPutWord + "\t words count: " + wordCount);
        String max = "";
        st.put(max, 0);
        for (String word : st.keys()) {
            if (st.get(word) > st.get(max))
                max = word;
        }

        StdOut.println(max + " " + st.get(max));
    }
    public static void main(String[] args) {
        outputLastPutAndMaxCountWord(10);
    }
}
