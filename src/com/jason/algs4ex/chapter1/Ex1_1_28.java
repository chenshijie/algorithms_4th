package com.jason.algs4ex.chapter1;

import com.jason.algs4ex.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

import java.util.ArrayList;
import java.util.Arrays;

/*

1.1.28 Remove duplicates. Modify the test client in BinarySearch to remove any du- plicate keys in the whitelist after the sort.
 */
public class Ex1_1_28 {

    public static void main(String[] args) {
        System.out.println("Ex1_1_28");
        //int[] whitelist = In.readInts(args[0]);
        int[] whitelist = new In("./data/tinyW_not_unqiue.txt").readAllInts();
        Arrays.sort(whitelist);
        System.out.println(Arrays.toString(whitelist));
        whitelist = uniqArray(whitelist);
        System.out.println(Arrays.toString(whitelist));
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            int pos = BinarySearch.rank(key, whitelist);
            System.out.printf("key=%d, pod=%d\n", key, pos);
        }
    }

    public static int[] uniqArray(int[] a) {
        int length = a.length;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < length - 1; i++) {
            if (a[i] != a[i + 1]) {
                list.add(a[i]);
            }
        }
        list.add(a[length - 1]);
        int[] ints = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ints[i] = list.get(i);
        }
        return ints;
    }
}
