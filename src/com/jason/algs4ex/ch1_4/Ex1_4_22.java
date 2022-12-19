package com.jason.algs4ex.ch1_4;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/*
1.4.22 Binary search with only addition and subtraction. [Mihai Patrascu] Write a
program that, given an array of N distinct int values in ascending order, determines
whether a given integer is in the array. You may use only additions and subtractions
and a constant amount of extra memory. The running time of your program should be
proportional to log N in the worst case.
Answer : Instead of searching based on powers of two (binary search), use Fibonacci
numbers (which also grow exponentially). Maintain the current search range to be the
interval [i, i + F k] and keep F k and Fk–1 in two variables. At each step compute Fk–2 via
subtraction, check element i + Fk–2 , and update the current range to either [i, i + Fk–2]
or [i + Fk–2, i + Fk–2 + Fk–1].

1.4.22 仅用加减实现的二分查找（Mihai Patrascu）。编写一个程序，给定一个含有N个不同int值的按照升序排列的数组，
判断它是否含有给定的整数。只能使用加法和减法以及常数的额外内存空间。程序的运行时间在最坏情况下应该和logN成正比。

答：用斐波纳契数代替2的幂（二分法）进行查找。用两个变量保存Fk和Fk-1并在[i,i+Fk]之间查找。在每一步中，
使用减法计算Fk-2，检查i+Fk-2处的元素，并根据结果将搜索范围变为[ i, i+Fk-2]或是[ i+Fk-2, i+Fk-2+Fk-1]。
*/
public class Ex1_4_22 {

    public static void main(String[] args) {
        int N = 20;
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = StdRandom.uniformInt(i * 2, (i + 1) * 2);
        }
        StdOut.println(Arrays.toString(array));
        int key = StdIn.readInt();
        int index = rank(array, key);

        if (index > -1) {
            StdOut.printf("find %d which index is %d\n", key, index);
        } else {
            StdOut.printf("%d is not in array\n", key);
        }

    }

    public static int rank(int[] array, int key) {
        int Fk = 1;
        int Fk_1 = 1;

        int low = 0;
        int high = array.length - 1;
        int mid;

        while (Fk <= high) {
            Fk = Fk + Fk_1;
            Fk_1 = Fk - Fk_1;
        }

        while (Fk - Fk_1 >= 0) {
            mid = low + Fk - Fk_1;
            if (mid > high) {
                mid = high;
            }

            if (array[mid] == key) {
                return mid;
            } else if (array[mid] > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            Fk_1 = Fk - Fk_1;
            Fk = Fk - Fk_1;
        }

        return -1;
    }
}
