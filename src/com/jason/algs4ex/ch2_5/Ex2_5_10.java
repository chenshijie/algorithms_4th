package com.jason.algs4ex.ch2_5;

import edu.princeton.cs.algs4.StdOut;

/*
2.5.10 创建一个数据类型Version来表示软件的版本，例如115.1.1、115.10.1、115.10.2。为它实现Comparable接口，其中115.1.1的版本低于115.10.1。

*/
public class Ex2_5_10 {

    public static void main(String[] args) {
        Version v1 = new Version("115.1.1");
        Version v2 = new Version("115.10.1");
        Version v3 = new Version("115.10.01");

        StdOut.println(v1.compareTo(v2));
        StdOut.println(v2.compareTo(v1));
        StdOut.println(v2.compareTo(v3));
    }

    public static class Version implements Comparable<Version> {
        private String version;

        public Version(String version) {
            this.version = version;
        }

        @Override
        public int compareTo(Version that) {
            int[] thisV = this.versionArray();
            int[] thatV = that.versionArray();

            for (int i = 0; i < 3; i++) {
                if (thisV[i] < thatV[i]) {
                    return -1;
                }
                if (thisV[i] > thatV[i]) {
                    return 1;
                }
            }

            return 0;
        }

        private int[] versionArray() {
            int[] v = {0, 0, 0};
            String[] temp = version.split("\\.");
            for (int i = 0; i < Integer.min(3, temp.length); i++) {
                v[i] = Integer.parseInt(temp[i]);
            }
            return v;
        }

        @Override
        public String toString() {
            return version;
        }
    }
}
