package com.jason.algs4ex.ch2_1;

import com.jason.algs4ex.Selection;
import com.jason.algs4ex.Transaction;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
2.1.22 交易排序测试用例。编写一个SortTransaction类，在静态方法main()中从标准输入读取一系列交易
，将它们排序并在标准输出中打印结果（请见练习1.3.17）。
*/
public class Ex2_1_22 {

    public static void main(String[] args) {
        String[] lines = StdIn.readAllLines();
        Transaction[] transactions = new Transaction[lines.length];
        for (int i = 0; i < lines.length; i++) {
            transactions[i] = new Transaction(lines[i]);
        }

        Transaction.WhenComparator comparator = new Transaction.WhenComparator();
        Selection.sort(transactions, comparator);

        for (Transaction t : transactions) {
            StdOut.println(t);
        }
    }
}