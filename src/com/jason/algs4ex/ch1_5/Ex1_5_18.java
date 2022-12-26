package com.jason.algs4ex.ch1_5;

import com.jason.RandomGrid;
import com.jason.algs4ex.Connection;
import com.jason.algs4ex.RandomBag;
import edu.princeton.cs.algs4.StdOut;

/*
1.5.18 随机网格生成器。编写一个程序RandomGrid，从命令行接受一个int值N，生成一个N×N的网格中的所有连接。
它们的排列随机且方向随机（即（p q）和（q p）出现的可能性是相等的），将这个结果打印到标准输出中。
可以使用RandomBag将所有连接随机排列（请见练习1.3.34），并使用如右下所示的Connection嵌套类来将p和q封装到一个对象中。
将程序打包成两个静态方法：generate()，接受参数N并返回一个连接的数组；main()，从命令行接受参数N，
调用generate()，遍历返回的数组并打印出所有连接。
 */

public class Ex1_5_18 {
    public static void main(String[] args) {
        RandomBag<Connection> bag = RandomGrid.generate(10);
        for (Connection c : bag) {
            StdOut.println(c);
        }
    }
}
