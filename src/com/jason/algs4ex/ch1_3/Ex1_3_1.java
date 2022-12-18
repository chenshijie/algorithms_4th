package com.jason.algs4ex.ch1_3;

import com.jason.algs4ex.FixedCapacityStackOfStrings;
import edu.princeton.cs.algs4.StdIn;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/*
1.3.1 Add a method isFull() to FixedCapacityStackOfStrings.
 */
public class Ex1_3_1 {
    public static void main(String[] args) {
        FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(5);

        try {
            FileInputStream input = new FileInputStream("./data/tobe.txt");
            System.setIn(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            stack.push(item);
        }
    }
}
