package com.jason.algs4ex.ch2_5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/*
2.5.8 编写一段程序Frequency，从标准输入读取一列字符串并按照字符串出现频率由高到低的顺序打印出每个字符串及其出现次数。 */
public class Ex2_5_8 {

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        int n = a.length;
        Arrays.sort(a);

        // create an array of distinct strings and their frequencies
        Record[] records = new Record[n];
        String word = a[0];
        int freq = 1;
        int m = 0;
        for (int i = 1; i < n; i++) {
            if (!a[i].equals(word)) {
                records[m++] = new Record(word, freq);
                word = a[i];
                freq = 0;
            }
            freq++;
        }
        records[m++] = new Record(word, freq);

        // sort by frequency and print results
        Arrays.sort(records, 0, m);
        for (int i = m - 1; i >= 0; i--)
            StdOut.println(records[i]);
    }

    public static class Record implements Comparable<Record> {
        private final String key;
        private final int value;

        public Record(String key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Record o) {
            return Integer.compare(this.value, o.value);
        }

        @Override
        public String toString() {
            return "Record{" +
                    "key='" + key + '\'' +
                    ", value=" + value +
                    '}';
        }

    }
}
