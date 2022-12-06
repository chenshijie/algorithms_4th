package com.jason.algs4ex.chapter1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Random;

/*
1.1.11 Write a code fragment that prints the contents of a two-dimensional boolean array,
using * to represent true and a space to represent false. Include row and column numbers.
 */
public class Ex1_1_11 {
    public static void main(String[] args) {
        StdOut.println("Ex1_1_11");
        StdOut.println("An array[x][y] should be initialized");
        StdOut.println("Please input x:");
        int x = StdIn.readInt();
        StdOut.println("Please input y:");
        int y = StdIn.readInt();

        boolean[][] array = initTwoDimensionalBooleanArray(x, y);
        displayTwoDimensionalBooleanArray(array);
    }

    public static void displayTwoDimensionalBooleanArray(boolean[][] array) {
        int x = array.length;
        int y = array[0].length;
        for (int i = -1; i < x; i++) {
            if (i == -1) {
                StdOut.print("x\\y");
            } else {
                StdOut.printf("%2d ", i);
            }

            for (int j = 0; j < y; j++) {
                if (i == -1) {
                    StdOut.printf("%2d ", j);
                } else {
                    StdOut.print(array[i][j] ? " * " : "   ");
                }
            }
            StdOut.println();
        }
    }

    /**
     * 初始化一个随机二维boolean数组,方法名改成initBooleanMatrix是不是更好
     *
     * @param xLength int 第一维长度
     * @param yLength int 第二维长度
     * @return boolean[][]
     */
    public static boolean[][] initTwoDimensionalBooleanArray(int xLength, int yLength) {
        boolean[][] array = new boolean[xLength][yLength];
        Random random = new Random();
        for (int i = 0; i < xLength; i++) {
            for (int j = 0; j < yLength; j++) {
                array[i][j] = random.nextBoolean();
            }
        }
        return array;
    }
}
