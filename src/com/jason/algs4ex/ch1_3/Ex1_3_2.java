package com.jason.algs4ex.ch1_3;

import com.jason.algs4ex.FixedCapacityStackOfStrings;
import edu.princeton.cs.algs4.StdOut;

/*
1.3.2 Give the output printed by java Stack for the input
it was - the best - of times - - - it was - the - -
 */
public class Ex1_3_2 {
    public static void main(String[] args) {
        FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(20);

        String s = "it was - the best - of times - - - it was - the - -";
        String[] a = s.split("\\s");
        for (int i = 0; i < a.length; i++) {
            String item = a[i];
            if (!item.equals("-")) {
                stack.push(item);
            } else if (!stack.isEmpty()) {
                StdOut.print(stack.pop() + " ");
            }
        }
        StdOut.println("(" + stack.size() + " left on stack)");
    }
}
