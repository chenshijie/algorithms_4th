package com.jason.algs4ex.ch2_2;

import com.jason.algs4ex.Merge;

/*
2.2.2 按照算法2.4所示轨迹的格式给出自顶向下的归并排序是如何将数组E A S Y Q U E S T I O N排序的。
*/
public class Ex2_2_2 {
    public static void main(String[] args) {
        String s = "E A S Y Q U E S T I O N";
        String[] a = s.split("\\s");
        Merge.showTrace(true);
        Merge.sort(a);
    }
}