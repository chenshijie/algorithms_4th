package com.jason.algs4ex.ch1_4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

/*
1.4.8 编写一个程序，计算输入文件中相等的整数对的数量。如果你的第一个程序是平方级别的，请继续思考并用Array.sort()给出一个线性对数级别的解答。
*/
public class Ex1_4_8 {
    public static void main(String[] args) {
        int N = 100000;
        int MAX = 10000;
        int[] array = new int[N];

        StdOut.println("Array length: " + N);
        for (int i = 0; i < N; i++) {
            array[i] = StdRandom.uniformInt(-MAX, MAX);
        }

        int count = 0;
        Stopwatch timer1 = new Stopwatch();
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (array[i] == array[j]) {
                    count++;
                }
            }
        }
        double time1 = timer1.elapsedTime();
        StdOut.printf("Find %d pairs, use time %f\n", count, time1);


        count = 0;
        int n = 1;
        Stopwatch timer2 = new Stopwatch();
        Arrays.sort(array);
        for (int i = 1; i < N; i++) {
            if (array[i] == array[i - 1]) {
                n++;
            } else {
                if (n > 1) {
                    count += n * (n - 1) / 2;
                }
                n = 1;
            }
        }
        //这里容易遗漏
        if (n > 1) {
            count += n * (n - 1) / 2;
        }
        double time2 = timer2.elapsedTime();
        StdOut.printf("Find %d pairs, use time %f\n", count, time2);

    }
}
