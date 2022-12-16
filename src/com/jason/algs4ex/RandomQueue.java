package com.jason.algs4ex;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class RandomQueue<Item> implements Iterable<Item> {
    private Item[] array;
    private int itemCount;

    public RandomQueue() {
        array = (Item[]) new Object[1];
        itemCount = 0;
    }

    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        System.arraycopy(array, 0, temp, 0, itemCount);
        array = temp;
    }

    public boolean isEmpty() {
        return itemCount == 0;
    }

    public int size() {
        return itemCount;
    }

    public void enqueue(Item item) {
        if (itemCount == array.length) {
            resize(itemCount * 2);
        }
        array[itemCount++] = item;
    }

    public Item dequeue() {
        if (itemCount == array.length / 4) {
            resize(itemCount * 2);
        }
        int randomIndex = StdRandom.uniformInt(0, itemCount);
        Item temp = array[randomIndex];
        array[randomIndex] = array[--itemCount];
        return temp;
    }

    public Item sample() {
        int index = StdRandom.uniformInt(0, itemCount);
        return array[index];
    }

    public Iterator<Item> iterator() {
        return new RandomArrayIterator<>(array, itemCount);
    }

}
