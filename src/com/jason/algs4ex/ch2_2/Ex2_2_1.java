package com.jason.algs4ex.ch2_2;

import com.jason.algs4ex.Merge;

/*
2.2.1 按照本节开头所示轨迹的格式给出原地归并的抽象merge()方法是如何将数组排序的。
*/
public class Ex2_2_1 {
    public static void main(String[] args) {
        String s = "A E Q S U Y E I N O S T";
        String[] a = s.split("\\s");
        Merge.showTrace(true);
        Merge.sort(a);
    }
}