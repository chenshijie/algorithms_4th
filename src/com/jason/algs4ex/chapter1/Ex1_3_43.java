package com.jason.algs4ex.chapter1;

import com.jason.algs4ex.Queue;
import edu.princeton.cs.algs4.StdOut;

import java.io.File;

/*
1.3.43 Listing files. A folder is a list of files and folders. Write a program that takes the
name of a folder as a command-line argument and prints out all of the files contained
in that folder, with the contents of each folder recursively listed (indented) under that
folder’s name. Hint : Use a queue, and see java.io.File.
 */
public class Ex1_3_43 {

    public static Queue<String> listFiles(File file) {
        Queue<String> queue = new Queue<>();
        listFiles(file, queue, 0);
        return queue;
    }

    public static void listFiles(File file, Queue<String> queue, int depth) {
        File[] files = file.listFiles();
        assert files != null;
        for (File f : files) {
            queue.enqueue("    ".repeat(Math.max(0, depth)) + f.getName());
            if (f.isDirectory()) {
                listFiles(f, queue, depth + 1);
            }
        }
    }

    public static void main(String[] args) {
        String path = ".\\";
        if (args.length != 0) {
            path = args[0];
        }
        File file = new File(path);
        for (String s : listFiles(file)) {
            StdOut.println(s);
        }
    }
}