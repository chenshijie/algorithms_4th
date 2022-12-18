package com.jason.algs4ex.ch1_2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/*
1.2.15 File input. Develop a possible implementation of the static readInts() method
from In (which we use for various test clients, such as binary search on page 47) that
is based on the split() method in String.
Solution:
public static int[] readInts(String name)
{
In in = new In(name);
String input = StdIn.readAll();
String[] words = input.split("\\s+");
int[] ints = new int[words.length;
for int i = 0; i < word.length; i++)
ints[i] = Integer.parseInt(words[i]);
return ints;
}
We will consider a different implementation in Section 1.3 (see page 126).
 */
public class Ex1_2_15 {
    public static void main(String[] args) {
        int[] numbers = In.readInts(args[0]);
        StdOut.println(Arrays.toString(numbers));
    }
}
