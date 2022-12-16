package com.jason.algs4ex.chapter1;

import com.jason.algs4ex.RandomQueue;
import edu.princeton.cs.algs4.StdOut;

/*
1.3.35 Random queue. A random queue stores a collection of items and supports the
following API:
public class RandomQueue<Item>
RandomQueue() create an empty random queue
boolean isEmpty() is the queue empty?
void enqueue(Item item) add an item
Item dequeue() remove and return a random item (sample without replacement)
Item sample() return a random item, but do not remove (sample with replacement)

API for a generic random queue
Write a class RandomQueue that implements this API. Hint : Use an array representation
(with resizing). To remove an item, swap one at a random position (indexed 0 through
N-1) with the one at the last position (index N-1). Then delete and return the last object,
as in ResizingArrayStack. Write a client that deals bridge hands (13 cards each)
using RandomQueue<Card>.
 */
public class Ex1_3_35 {
    public static void main(String[] args) {
        RandomQueue<Card> cards = new RandomQueue<>();
        for (int type = 0; type < 4; type++) {
            for (int value = 0; value < 13; value++) {
                cards.enqueue(new Card(type, value));
            }
        }
        for (int player = 1; player <= 4; player++) {
            StdOut.printf("cards for player%d:\n", player);
            for (int i = 0; i < 13; i++) {
                Card c = cards.dequeue();
                StdOut.print(c + " ");
            }
            StdOut.println();
        }
    }

    public static class Card {
        private static final String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        private static final String[] types = {"♠", "♥", "♣", "♦"};
        private final int type;
        private final int value;

        public Card(int type, int value) {
            if (type > 3 || type < 0) {
                throw new IllegalArgumentException("type should be in [0,3]");
            }
            if (value > 12 || value < 0) {
                throw new IllegalArgumentException("value should be in [0,12]");
            }
            this.type = type;
            this.value = value;
        }

        public String getTypeName() {
            return types[type];
        }

        public String getValueName() {
            return values[value];
        }

        @Override
        public String toString() {
            return "[" + getTypeName() + getValueName() + "]";
        }
    }
}