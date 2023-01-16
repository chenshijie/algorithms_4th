package com.jason.algs4ex.ch2_5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Comparator;

/*
2.5.2 编写一段程序，从标准输入读入一列单词并打印出其中所有由两个单词组成的组合词。例如，如果输入的单词为after、thought和afterthought，
那么afterthought就是一个组合词。
 */
public class Ex2_5_2 {
    public static int binarySearchByLength(int length, String[] a, int lo, int hi) {
        // Array must be sorted.
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if (length < a[mid].length()) hi = mid - 1;
            else if (length > a[mid].length()) lo = mid + 1;
            else {
                while (mid >= lo && a[mid].length() == length)
                    mid--;
                return mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] s = StdIn.readLine().split("\\s+");
        Arrays.sort(s, new StringLengthComparator());
        StdOut.println(Arrays.toString(s));
        if (s.length == 0) {
            StdOut.println("error");
            System.exit(0);
        }
        int minLength = s[0].length() * 2;
        int x = 0;
        while (x < s.length && s[x].length() < minLength)
            x++;

        while (x < s.length) {
            for (int i = 0; i < x; i++) {
                int l = binarySearchByLength(s[x].length() - s[i].length(), s, i, x);
                if (l != -1) {
                    while (s[i].length() + s[l].length() == s[x].length()) {
                        if ((s[l] + s[i]).equals(s[x])) {
                            StdOut.println(s[x] + "=" + s[l] + "+" + s[i]);
                        } else if ((s[i] + s[l]).equals(s[x])) {
                            StdOut.println(s[x] + "=" + s[i] + "+" + s[l]);
                        }
                        l++;
                    }
                }
            }
            x++;
        }
    }

    public static class StringLengthComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return o1.length() - o2.length();
        }
    }
}
