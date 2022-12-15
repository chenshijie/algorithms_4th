package com.jason.algs4ex;

import java.util.Arrays;
import java.util.Iterator;

public class ResizingArrayDeque<Item> implements Iterable<Item> {
    private Item[] stack;
    private int number;
    private int leftIndex;

    public ResizingArrayDeque(int cap) {
        this.stack = (Item[]) new Object[cap];
        this.number = 0;
        this.leftIndex = cap / 2;
    }

    public ResizingArrayDeque() {
        this(2);
    }

    public boolean isEmpty() {
        return this.number == 0;
    }

    public boolean isLeftFull() {
        return leftIndex == 0;
    }


    public boolean isRightFull() {
        return leftIndex + number == stack.length;
    }

    public int size() {
        return this.number;
    }

    public int arraySize() {
        return stack.length;
    }

    public void pushRight(Item item) {
        int rightIndex = leftIndex + number;
        //当数组尾端没有空间时，调整数组大小为元素数量的3倍
        if (isRightFull()) {
            resize(3 * stack.length);
        }

        number++;
        this.stack[rightIndex] = item;
    }

    public void pushLeft(Item item) {
        //当数组首端没有空间时，调整数组大小为元素数量的3倍
        if (isLeftFull()) {
            resize(3 * stack.length);
        }
        leftIndex--;
        number++;
        this.stack[leftIndex] = item;
    }

    public Item popRight() {
        --number;
        int rightIndex = leftIndex + number;
        Item item = stack[rightIndex];
        stack[rightIndex] = null;
        if (number > 0 && number <= stack.length / 6) {
            resize(stack.length / 3);
        }
        return item;
    }

    public Item popLeft() {
        Item item = stack[leftIndex];
        stack[leftIndex] = null;
        leftIndex++;
        number--;
        if (number > 0 && number <= stack.length / 6) {
            resize(stack.length / 3);
        }
        return item;
    }

    public Item rightPeek() {
        return stack[leftIndex + number - 1];
    }

    public Item leftPeek() {
        return stack[leftIndex];
    }

    public void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        if (number >= 0) {
            int srcPos = leftIndex;
            leftIndex = max / 3;
            System.arraycopy(stack, srcPos, temp, leftIndex, number);
        }
        stack = temp;
    }

    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(stack, leftIndex, leftIndex + number));
    }

    public int leftFreePositions() {
        return leftIndex;
    }

    public int rightFreePositions() {
        return stack.length - leftIndex - number;
    }

    public String debugInfo() {
        return String.format("array size:%3d, deque size: %3d, left free space: %3d, right free space: %3d", arraySize(),
                size(), leftFreePositions(), rightFreePositions());
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    public class ArrayIterator implements Iterator<Item> {
        private int i = 0;

        @Override
        public boolean hasNext() {
            return i < number;
        }

        @Override
        public Item next() {
            return stack[i++];
        }

        @Override
        public void remove() {

        }
    }
}