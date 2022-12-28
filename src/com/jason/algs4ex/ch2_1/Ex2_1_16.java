package com.jason.algs4ex.ch2_1;

import com.jason.algs4ex.Insertion;
import com.jason.algs4ex.Selection;
import com.jason.algs4ex.Shell;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/*
2.1.16 验证。编写一个check()方法，调用sort()对任意数组排序。如果排序成功而且数组中的所有对象均没有被修改则返回true，否则返回false。
不要假设sort()只能通过exch()来移动数据，可以信任并使用Arrays.sort()。
 */
public class Ex2_1_16 {
    public static boolean check(Comparable[] a, String sortAlgo) {
        Comparable[] backup = new Comparable[a.length];
        for (int i = 0; i < a.length; i++) {
            backup[i] = a[i];
        }
        switch (sortAlgo) {
            case "Selection" -> Selection.sort(a);
            case "Insertion" -> Insertion.sort(a);
            case "Shell" -> Shell.sort(a);
            default -> Arrays.sort(a);
        }

        boolean checkResult = true;
        for (int i = 0; i < backup.length; i++) {
            boolean find = false;
            for (int j = 0; j < a.length; j++) {
                if (backup[i] == a[j]) {
                    find = true;
                    break;
                }
            }
            if (!find) {
                checkResult = false;
                break;
            }
        }
        return checkResult;

    }

    public static void main(String[] args) {
        String[] a = {"p", "l", "a", "y", "g", "a", "m", "e"};
        String[] algos = {"Insertion", "Selection", "Shell", "Arrays.sort"};
        for (String algo : algos) {
            StdRandom.shuffle(a);
            StdOut.println(Arrays.toString(a));
            StdOut.printf("Check %s, result:%b\n", algo, check(a, algo));
            StdOut.println(algo + ".sort: " + Arrays.toString(a));
        }
    }
}