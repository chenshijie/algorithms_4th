package com.jason.algs4ex.ch1_4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

/*
1.4.15 快速3-sum。作为热身，使用一个线性级别的算法（而非基于二分查找的线性对数级别的算法）实现TwoSumFaster来计算已排序的数组
中和为0的整数对的数量。用相同的思想为3-sum问题给出一个平方级别的算法。
*/
public class Ex1_4_15 {
    public static void main(String[] args) {
        int[] a = new In(args[0]).readAllInts();

        Stopwatch timer1 = new Stopwatch();
        StdOut.println(ThreeSumFasterCount(a));
        StdOut.println(timer1.elapsedTime());
    }

    public static int ThreeSumFasterCount(int[] array) {
        Arrays.sort(array);
        int length = array.length;
        int cnt = 0;
        for (int i = 0; i < length; i++) {
            int head = i + 1;
            int tail = length - 1;
            while (head < tail) {
                int sum = array[i] + array[head] + array[tail];
                if (sum == 0) {
                    cnt++;
                    head++;
                } else if (sum > 0) {
                    tail--;
                } else {
                    head++;
                }
            }
        }
        return cnt;
    }
}
