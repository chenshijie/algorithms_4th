package com.jason.algs4ex;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;

public class Cat {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage:\njava Cat infile1 [in_file2 ...] outfile");
            return;
        }
        //最后一个命令行参数作为输出文件名
        Out out = new Out(args[args.length - 1]);

        for (int i = 0; i < args.length - 1; i++) {
            In in = new In(args[i]);
            String s = in.readAll();
            out.println(s);
            in.close();
        }

        out.close();
    }
}
