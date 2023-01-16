package com.jason.algs4ex.ch2_5;

import edu.princeton.cs.algs4.StdOut;

/*
2.5.1 在下面这段String类型的compareTo()方法的实现中，第三行对提高运行效率有何帮助？

    public int compareTo(String that)
    {
        if (this == that) return 0;  // 这一行
        int n = Math.min(this.length(), that.length());
        for (int i = 0; i < n; i++)
        {
            if       (this.charAt(i) < that.charAt(i)) return -1;
      else if (this.charAt(i) ＞ that.charAt(i)) return +1;
        }
        return this.length() - that.length();
    }
 */
public class Ex2_5_1 {
    public static void main(String[] args) {
        String s1 = "Ex2_5_1";
        String s2 = s1;
        //s1和s2 是同一个对象的引用
        StdOut.println(s1.compareTo(s2));
    }
}
