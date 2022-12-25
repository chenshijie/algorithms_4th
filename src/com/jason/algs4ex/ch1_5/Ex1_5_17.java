package com.jason.algs4ex.ch1_5;

import com.jason.algs4ex.ErdosRenyi;
import edu.princeton.cs.algs4.StdOut;

/*
1.5.17 随机连接。设计UF的一个用例ErdosRenyi，从命令行接受一个整数N，在0到N-1之间产生随机整数对，
调用connected()判断它们是否相连，如果不是则调用union()方法（和我们的开发用例一样）。不断循环直到所有触点均相互连通并打印出生成的连接总数。
将你的程序打包成一个接受参数N并返回连接总数的静态方法count()，添加一个main()方法从命令行接受N，调用count()并打印它的返回值。
 */

public class Ex1_5_17 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);          // number of vertices
        int edges = ErdosRenyi.count(n);

        StdOut.println(n);
        StdOut.println(edges);
    }
}
