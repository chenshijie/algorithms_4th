package com.jason.algs4ex.chapter1;


import com.jason.algs4ex.RandomBag;
import edu.princeton.cs.algs4.StdOut;

/*
1.3.34 Random bag. A random bag stores a collection of items and supports the following
API:
public class RandomBag<Item> implements Iterable<Item>
RandomBag() create an empty random bag
boolean isEmpty() is the bag empty?
int size() number of items in the bag
void add(Item item) add an item
API for a generic random bag
Write a class RandomBag that implements this API. Note that this API is the same as for
Bag, except for the adjective random, which indicates that the iteration should provide
the items in random order (all N ! permutations equally likely, for each iterator). Hint :
Put the items in an array and randomize their order in the iterator’s constructor.
 */
public class Ex1_3_34 {

    public static void main(String[] args) {
        RandomBag<Integer> randomBag = new RandomBag<>();
        for (int i = 0; i < 10; i++) {
            randomBag.add(i);
        }
        for (int i = 0; i < 10; i++) {
            for (int item : randomBag) {
                StdOut.print(item + " ");
            }
            StdOut.println();
        }
    }
}