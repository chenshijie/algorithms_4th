package com.jason.algs4ex.ch3_1;

/*
3.1.7 对于N=10、102、103、104、105和106，在N个小于1000的随机非负整数中FrequencyCounter平均能够找到多少个不同的键？
 */

import com.jason.algs4ex.SequentialSearchST;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Ex3_1_7 {

    public static int countDistinct(int[] keys, SequentialSearchST<Integer, Integer> st) {
        int distinct = 0;
        for (int key : keys) {
            if (!st.contains(key)) {
                st.put(key, distinct++);
            }
        }
        return distinct;
    }

    public static int[] genIntArray(int n) {
        int[] keys = new int[n];
        for (int i = 0; i < n; i++) {
            keys[i] = StdRandom.uniformInt(0, 1000);
        }
        return keys;
    }

    public static void main(String[] args) {
        for (int i = 1; i < 7; i++) {
            StdOut.println("10^" + i + "    " + countDistinct(genIntArray((int) Math.pow(10, i)), new SequentialSearchST<>()));
        }
    }
}
