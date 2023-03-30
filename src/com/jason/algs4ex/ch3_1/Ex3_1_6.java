package com.jason.algs4ex.ch3_1;

/*
3.1.6 用输入中的单词总数W和不同单词总数D的函数给出FrequencyCounter调用的put()和get()方法的次数
 */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex3_1_6 {
    public static void main(String[] args) {
        int distinct = 0, words = 0;
        int minlen = 2;
        ST<String, Integer> st = new ST<>();

        // compute frequency counts
        while (!StdIn.isEmpty()) {
            String key = StdIn.readString();
            if (key.length() < minlen) continue;
            words++;
            if (st.contains(key)) {
                st.put(key, st.get(key) + 1);
            } else {
                st.put(key, 1);
                distinct++;
            }
        }

        // find a key with the highest frequency count
        String max = "";
        st.put(max, 0);
        for (String word : st.keys()) {
            if (st.get(word) > st.get(max))
                max = word;
        }

        StdOut.println(max + " " + st.get(max));
        StdOut.println("distinct = " + distinct);
        StdOut.println("words    = " + words);
    }
}
