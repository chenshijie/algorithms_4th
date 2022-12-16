package com.jason.algs4ex.chapter1;

import com.jason.algs4ex.SimpleRingBuffer;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/*
1.3.39 Ring buffer.
A ring buffer, or circular queue, is a FIFO data structure of a fixed
size N. It is useful for transferring data between asynchronous processes or for storing
log files. When the buffer is empty, the consumer waits until data is deposited; when the
buffer is full, the producer waits to deposit data. Develop an API for a RingBuffer and
an implementation that uses an array representation (with circular wrap-around).
 */
public class Ex1_3_39 {
    public static void main(String[] args) {
        int capacity = 10;
        SimpleRingBuffer<Integer> ringBuffer = new SimpleRingBuffer<>(capacity);
        for (int i = 0; i <= capacity; i++) {
            boolean r = ringBuffer.add(i);
            StdOut.printf("add %d , %b \n", i, r);
            StdOut.println(ringBuffer.info());
        }
        StdOut.println("--------------------------------");
        for (int i = 10; i <= capacity * 3; i++) {
            if (StdRandom.bernoulli(0.5)) {
                int x = ringBuffer.delete();
                StdOut.printf("delete %d from buffer\n", x);
            } else {
                boolean r = ringBuffer.add(i);
                StdOut.printf("add %d , %b \n", i, r);
            }
            StdOut.println(ringBuffer.info());
        }
    }
}