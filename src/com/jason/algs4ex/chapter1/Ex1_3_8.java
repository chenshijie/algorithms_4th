package com.jason.algs4ex.chapter1;

import com.jason.algs4ex.Stack;

/*
1.3.8 Give the contents and size of the array for DoublingStackOfStrings with the
input
it was - the best - of times - - - it was - the - -
 */
public class Ex1_3_8 {

    public static void main(String[] args) {
        String data = "it was - the best - of times - - - it was - the - -";
        Stack<String> stack = new Stack<String>(1);
        String[] inputs = data.split("\\s");
        for (int i = 0; i < inputs.length; i++) {
            if (inputs[i].equals("-")) {
                stack.pop();
            } else {
                stack.push(inputs[i]);
            }
            System.out.print("stack: " + stack);
            System.out.println();
            System.out.println("ArraySize: " + stack.arraySize());

        }
    }
}