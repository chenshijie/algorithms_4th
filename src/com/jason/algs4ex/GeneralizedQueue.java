package com.jason.algs4ex;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class GeneralizedQueue<Item> {
    private Item[] array;
    private int itemCount;

    public GeneralizedQueue() {
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


    public void insert(Item item) {
        if (itemCount == array.length) {
            resize(itemCount * 2);
        }
        array[itemCount++] = item;
    }

    public Item delete(int k) {
        if (k > itemCount || k < 1) {
            throw new NoSuchElementException();
        }
        if (itemCount == array.length / 4) {
            resize(itemCount * 2);
        }

        int index = k - 1;
        Item item = array[index];
        for (; index < itemCount - 1; index++) {
            array[index] = array[index + 1];
        }
        itemCount--;
        return item;
    }

    public String toString() {
        return Arrays.toString(Arrays.copyOf(array, itemCount));
    }

    public int size() {
        return itemCount;
    }
}
