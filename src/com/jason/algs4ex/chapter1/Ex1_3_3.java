package com.jason.algs4ex.chapter1;

import com.jason.algs4ex.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.List;

/*
1.3.3 Suppose that a client performs an intermixed sequence of (stack) push and pop
operations. The push operations put the integers 0 through 9 in order onto the stack;
the pop operations print out the return values. Which of the following sequence(s)
could not occur?
a. 4 3 2 1 0 9 8 7 6 5
b. 4 6 8 7 5 3 2 9 0 1
c. 2 5 6 7 4 8 9 3 1 0
d. 4 3 2 1 0 5 6 7 8 9
e. 1 2 3 4 5 6 9 8 7 0
f. 0 4 6 5 3 8 1 7 2 9
g. 1 4 7 9 8 6 5 3 0 2
h. 2 1 4 3 6 5 8 7 9 0
 */
public class Ex1_3_3 {

    public static boolean fromS1toS2(Stack<Integer> s1, Stack<Integer> s2, int x) {
        if (s1.isEmpty()) {
            return false;
        }
        while (!s1.isEmpty()) {
            int t = s1.pop();
            if (t <= x) {
                s2.push(t);
            } else {
                s1.push(t);
                break;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>(10);
        for (int i = 9; i >= 0; i--) {
            s1.push(i);
        }


        //String s = "4 3 2 1 0 9 8 7 6 5";
        String s = StdIn.readLine();
        List<Integer> l = Arrays.stream(s.split("\\s")).map(Integer::parseInt).toList();
        StdOut.println(l.toString());

        Stack<Integer> s2 = new Stack<>(10);
        Stack<Integer> s3 = new Stack<>(10);
        for (int i = 0; i < l.size(); i++) {
            int t = l.get(i);
            if (s2.isEmpty()) {
                fromS1toS2(s1, s2, t);
            }

            if (!s2.isEmpty()) {
                int x = s2.pop();
                if (x == t) {
                    s3.push(x);
                } else if (x < t) {
                    s2.push(x);
                    if (fromS1toS2(s1, s2, t)) {
                        i--;
                    }
                } else {
                    StdOut.println("FAIL");
                    s2.push(x);
                    break;
                }
            }
        }
        StdOut.println(s3);
        StdOut.println(s1);
        StdOut.println(s2);
    }
}
