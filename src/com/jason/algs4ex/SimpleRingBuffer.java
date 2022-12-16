package com.jason.algs4ex;

import java.util.Arrays;

public class SimpleRingBuffer<Item> {
    private final Item[] array;
    private int itemCount;

    private int addIndex; //下一个要添加item的位置

    private int deleteIndex; //下一个要删除的item的位置

    public SimpleRingBuffer(int maxSize) {
        array = (Item[]) new Object[maxSize];
        itemCount = 0;
        deleteIndex = 0;
        addIndex = 0;
    }

    public int getItemCount() {
        return itemCount;
    }

    public int getAddIndex() {
        return addIndex;
    }

    public int getDeleteIndex() {
        return deleteIndex;
    }

    public boolean isEmpty() {
        return itemCount == 0;
    }

    public boolean isFull() {
        return itemCount == array.length;
    }


    public boolean add(Item item) {
        if (isFull()) {
            return false;
        }
        array[addIndex] = item;
        if (addIndex == array.length - 1) {
            addIndex = 0;
        } else {
            addIndex++;
        }

        itemCount++;
        return true;
    }


    public Item delete() {
        if (isEmpty()) {
            return null;
        }
        Item item = array[deleteIndex];
        array[deleteIndex] = null;
        if (deleteIndex == array.length - 1) {
            deleteIndex = 0;
        } else {
            deleteIndex++;
        }
        itemCount--;
        return item;
    }

    public String toString() {
        Item[] temp = (Item[]) new Object[itemCount];
        for (int i = deleteIndex; i < deleteIndex + itemCount; i++) {
            int index = i % array.length;
            temp[i - deleteIndex] = array[index];
        }
        return Arrays.toString(temp);
    }

    public String info() {
        return String.format("itemCount:%3d, deleteIndex:%3d, addIndex:%3d, remains: %s", itemCount, deleteIndex, addIndex, this);
    }
}
