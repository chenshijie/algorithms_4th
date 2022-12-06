package com.jason.algs4ex.chapter1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
Write a code fragment that puts the binary representation of a positive integer N
into a String s.
Solution: Java has a built-in method Integer.toBinaryString(N) for this job, but the point of the exercise is to see how such a method might be implemented. Here is a particularly concise solution:
    String s = "";
    for (int n = N; n > 0; n /= 2)
        s = (n % 2) + s;
 */
public class Ex1_1_9 {
    public static void main(String[] args) {
        StdOut.println("Ex1_1_9");
        StdOut.println("Please input a positive integer:");
        int num = StdIn.readInt();

        StdOut.println(toBinaryString0(num));
        StdOut.println(toBinaryString1(num));
        StdOut.println(toBinaryString2(num));
    }

    /**
     * integer to binary string
     *
     * @param number int
     * @return String
     */
    public static String toBinaryString0(int number) {
        String s = "";
        for (int n = number; n > 0; n /= 2) {
            s = (n % 2) + s;
        }
        return s;
    }

    public static String toBinaryString1(int number) {
        StringBuilder str = new StringBuilder();
        double bitCount = Math.ceil(Math.log(number) / Math.log(2));
        for (int i = 0; i < bitCount; i++) {
            str.append(number & 1);
            number = number >>> 1;
        }
        return str.reverse().toString();
    }

    public static String toBinaryString2(int number) {
        char[] str = new char[32];
        int mask = 1, i = 0, pos = 31;
        while (i < 32) {
            if ((mask & number) >= 1) {
                str[pos = 31 - i] = '1';
            } else {
                str[31 - i] = '0';
            }
            mask = mask << 1;
            i++;
        }
        return new String(str, pos, 32 - pos);
        //if not use pos
        //StringBuilder binaryString = new StringBuilder();
        //binaryString.append(str);
        //return binaryString.substring(binaryString.indexOf("1"));
    }
}
