package com.jason.algs4ex;

public class ResizingArrayQueueOfStrings {

    private String[] queue;
    private int count;

    private int first;

    public ResizingArrayQueueOfStrings(int cap) {
        this.queue = new String[cap];
        this.count = 0;
        this.first = 0;
    }

    public ResizingArrayQueueOfStrings() {
        this(1);
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void resize(int max) {
        String[] temp = new String[max];
        if (count >= 0) {
            System.arraycopy(queue, first, temp, 0, count);
        }
        queue = temp;
        first = 0;
    }

    public boolean isFull() {
        return first + count == queue.length;
    }

    public void enqueue(String item) {
        if (isFull()) {
            resize(2 * queue.length);
        }
        int pos = first + count;
        this.queue[pos] = item;
        count++;
    }

    public String dequeue() {
        if (isEmpty()) {
            return null;
        }
        String item = queue[first];
        first++;
        count--;
        if (count > 0 && count == queue.length / 4) {
            resize(queue.length / 2);
        }
        return item;
    }

    public int size() {
        return count;
    }

    public int arraySize() {
        return queue.length;
    }

    public String info() {
        return String.format("Queue Size: %d, First Item Pos: %d, Array Size: %d", count, first, queue.length);
    }
}