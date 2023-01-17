package com.jason.algs4ex.ch2_5;

import edu.princeton.cs.algs4.StdOut;

/*
2.5.3 找出下面这段账户余额Balance类的实现代码的错误。为什么compareTo()方法对Comparable接口的实现有缺陷？
public class Balance implements Comparable<Balance>
{
    ...
    private double amount;
    public int compareTo(Balance that)
    {
      if (this.amount < that.amount -0.005) return -1;
      if (this.amount > that.amount + 0.005) return +1;
      return 0;
    }
    ...
}
说明如何修正这个问题。
 */
public class Ex2_5_3 {
    public static void main(String[] args) {
        Balance b1 = new Balance(0.005);
        Balance b2 = new Balance(0.0);
        Balance b3 = new Balance(-0.005);

        StdOut.println("b1==b2:" + (b1.compareTo(b2) == 0));
        StdOut.println("b2==b3:" + (b2.compareTo(b3) == 0));
        StdOut.println("b1==b3:" + (b1.compareTo(b3) == 0));

        StdOut.println("b1==b2:" + (b1.compareToFixed(b2) == 0));
        StdOut.println("b2==b3:" + (b2.compareToFixed(b3) == 0));
        StdOut.println("b1==b3:" + (b1.compareToFixed(b3) == 0));
    }

    public static class Balance implements Comparable<Balance> {
        private double amount;

        public Balance(double amount) {
            this.amount = amount;
        }

        public int compareTo(Balance that) {
            if (this.amount < that.amount - 0.005) return -1;
            if (this.amount > that.amount + 0.005) return 1;
            return 0;
        }

        public int compareToFixed(Balance that) {
            if ((long) (this.amount * 100) < (long) (that.amount * 100)) return -1;
            if ((long) (this.amount * 100) > (long) (that.amount * 100)) return 1;
            return 0;
        }
    }
}
