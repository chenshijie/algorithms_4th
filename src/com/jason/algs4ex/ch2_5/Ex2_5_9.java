package com.jason.algs4ex.ch2_5;

/*
2.5.9 为将右侧所示的数据排序编写一个新的数据类型。

输入：
1-Oct-28      3500000
2-Oct-28      3850000
3-Oct-28      4060000
4-Oct-28      4330000
5-Oct-28      4360000
...
30-Dec-99   554680000
31-Dec-99   374049984
3-Jan-00   931800000
4-Jan-00  1009000000
5-Jan-00  1085500032
...

输出：
19-Aug-40130000
26-Aug-40160000
24-Jul-40200000
10-Aug-42210000
23-Jun-42210000
...
23-Jul-022441019904
17-Jul-022566500096
15-Jul-022574799872
19-Jul-022654099968
24-Jul-022775559936
*/
public class Ex2_5_9 {

    public static void main(String[] args) {
    }

    public static class DJIA implements Comparable<DJIA> {
        private String date;
        private long volume;

        public DJIA(String date, long volume) {
            this.date = date;
            this.volume = volume;
        }

        @Override
        public int compareTo(DJIA o) {
            return Long.compare(this.volume, o.volume);
        }

        @Override
        public String toString() {
            return this.date + "-" + this.volume;
        }
    }
}
