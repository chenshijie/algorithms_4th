package com.jason;

import com.jason.algs4ex.Connection;
import com.jason.algs4ex.RandomBag;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomGrid {
    public static RandomBag<Connection> generate(int n) {
        RandomBag<Connection> bag = new RandomBag<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                StdOut.println();
                if (StdRandom.bernoulli(0.5)) {
                    bag.add(new Connection(i * n + j, (i * n) + j + 1));
                    bag.add(new Connection(j * n + i, ((j + 1) * n) + i));
                } else {
                    bag.add(new Connection((i * n) + j + 1, i * n + j));
                    bag.add(new Connection(((j + 1) * n) + i, j * n + i));
                }
            }
        }

        return bag;
    }
}
