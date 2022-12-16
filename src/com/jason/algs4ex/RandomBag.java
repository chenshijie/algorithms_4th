package com.jason.algs4ex;

import java.util.Iterator;

public class RandomBag<Item> implements Iterable<Item> {
    private Item[] array;
    private int itemCount;

    public RandomBag() {
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

    public void add(Item item) {
        if (itemCount == array.length) {
            resize(array.length * 2);
        }
        array[itemCount++] = item;
    }

    public Iterator<Item> iterator() {
        return new RandomArrayIterator<>(array, itemCount);
    }


}
