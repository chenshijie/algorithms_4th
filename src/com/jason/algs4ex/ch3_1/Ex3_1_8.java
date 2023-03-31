package com.jason.algs4ex.ch3_1;

/*
3.1.8 在《双城记》中，使用频率最高的长度大于等于10的单词是什么？

Gutenberg-tm 53
 */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex3_1_8 {
    public static void main(String[] args) {
        int minLengthOfWord = 10;
        ST<String, Integer> st = new ST<>();

        while (!StdIn.isEmpty()) {
            String key = StdIn.readString();
            if (key.length() < minLengthOfWord) {
                continue;
            }
            if (st.contains(key)) {
                st.put(key, st.get(key) + 1);
            } else {
                st.put(key, 1);
            }
        }

        String max = "";
        st.put(max, 0);
        for (String word : st.keys()) {
            if (st.get(word) > st.get(max))
                max = word;
        }

        StdOut.println(max + " " + st.get(max));
    }
}
