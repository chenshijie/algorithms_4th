package com.jason.algs4ex;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<Item> implements Iterable<Item> {
    private Node<Item> first;
    private Node<Item> last;
    private transient int size;

    public LinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    public LinkedList(Node<Item> first) {
        this.first = first;
        refresh();
    }

    public static int maxByRecursion(LinkedList<Integer> list) {

        if (list.first == null)
            return 0;

        LinkedList<Integer> newList = new LinkedList<>(list.first.next);
        int max = maxByRecursion(newList);

        if (list.getFirst() > max)
            return list.getFirst();
        else
            return max;
    }

    public boolean isEmpty() {
        return first == null;
    }

    private static int mergeTimes = 0;

    public void addLast(Item item) {
        Node<Item> newNode = new Node<>(item, null);
        if (last == null) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        size++;
    }

    public Item getFirst() {
        final Node<Item> f = first;
        if (f == null) {
            throw new NoSuchElementException();
        }
        return f.item;
    }

    public Item getLast() {
        final Node<Item> l = last;
        if (l == null) {
            throw new NoSuchElementException();
        }
        return l.item;
    }

    public Item removeFirst() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        Node<Item> oldFirst = first;
        Item element = oldFirst.item;

        first = oldFirst.next;
        oldFirst.item = null;
        oldFirst.next = null;
        if (first == null) {
            last = null;
        }

        size--;
        return element;
    }

    public Item removeLast() {
        if (last == null) {
            throw new NoSuchElementException();
        }
        Item element = last.item;

        Node<Item> nodeBeforeLast = findNodeBeforeLast();
        if (nodeBeforeLast == first) {
            first = null;
            last = null;
        } else {
            last = nodeBeforeLast;
            last.next = null;
        }

        size--;
        return element;
    }

    public Item delete(int position) {
        int index = position - 1;
        if (isInvalidIndex(index)) {
            throw new NoSuchElementException();
        }
        if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        }

        Node<Item> x = findNode(index - 1);
        Node<Item> deleteNode = x.next;
        Item element = deleteNode.item;
        x.next = deleteNode.next;

        deleteNode.item = null;
        deleteNode.next = null;

        size--;
        return element;
    }

    public void removeAfter(Node<Item> itemNode) {
        if (itemNode == null || itemNode.next == null) {
            return;
        }
        Node<Item> current = itemNode.next;
        itemNode.next = null;

        while (current != null) {
            Node<Item> temp = current.next;
            current.next = null;
            current.item = null;
            current = temp;
        }
    }

    public static <T extends Comparable<T>> Node<T> maxNode(LinkedList<T> list) {
        if (list.isEmpty()) {
            return null;
        }
        Node<T> max = list.first;
        Node<T> t = max.next;
        while (t != null) {
            if (less(max.item, t.item)) {
                max = t;
            }
            t = t.next;
        }
        return max;
    }

    public void remove(Item item) {
        if (first == null) {
            return;
        }
        Node<Item> current = first;
        Node<Item> pre = first;
        while (current != null) {
            if (current.item.equals(item)) {
                if (current == first) {
                    removeFirst();
                    pre = first;
                    current = first;
                } else {
                    Node<Item> next = current.next;
                    current.next = null;
                    current.item = null;
                    pre.next = next;
                    current = next;
                    size--;
                }
            } else {
                pre = current;
                current = current.next;
            }
        }
    }

    public static int max(LinkedList<Integer> list) {
        if (list.isEmpty()) {
            return 0;
        }
        int max = list.getFirst();
        for (int e : list) {
            if (max < e) {
                max = e;
            }
        }
        return max;
    }

    public Item delete(Node<Item> node) {
        if (first == null) {
            return null;
        }
        Node<Item> current = first;
        Node<Item> pre = first;
        while (current != null) {
            if (current == node) {
                Item item = current.item;
                if (current == first) {
                    removeFirst();
                } else {
                    Node<Item> next = current.next;
                    current.next = null;
                    current.item = null;
                    pre.next = next;
                    size--;
                }
                return item;
            } else {
                pre = current;
                current = current.next;
            }
        }
        return null;
    }

    private void refresh() {
        if (first == null) {
            this.size = 0;
            this.last = null;
            return;
        }
        int size = 0;
        Node<Item> current = first;
        while (current.next != null) {
            size++;
            current = current.next;
        }
        last = current;
        this.size = size;
    }

    public void insertAfter(Node<Item> itemNode, Node<Item> newNode) {
        if (itemNode == null || newNode == null) {
            return;
        }
        newNode.next = itemNode.next;
        itemNode.next = newNode;
    }

    public Node<Item> findNode(int index) {
        if (isInvalidIndex(index)) {
            throw new NoSuchElementException();
        }
        Node<Item> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public boolean find(Item item) {

        Node<Item> current = first;
        while (current != null) {
            if (current.item.equals(item)) {
                return true;
            }
            if (current == last) {
                return false;
            }
            current = current.next;
        }
        return false;
    }

    public boolean isInvalidIndex(int index) {
        return index < 0 || index >= size;
    }


    public Node<Item> findNodeBeforeLast() {
        Node<Item> current = first;

        while (current.next != null && current.next.next != null) {
            current = current.next;
        }

        return current;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<Item> temp = first;
        while (temp != null) {
            Item item = temp.item;
            sb.append(item).append(" ");
            temp = temp.next;
        }

        return sb.toString();
    }

    public int size() {
        return size;
    }

    public Node<Item> generateNode(Item item) {
        return new Node<>(item, null);
    }


    public Node<Item> reverse(Node<Item> x) {
        Node<Item> first = x;
        Node<Item> reverse = null;
        while (first != null) {
            Node<Item> second = first.next;
            first.next = reverse;
            reverse = first;
            first = second;
        }
        return reverse;
    }

    public Node<Item> reverseRecursive(Node<Item> first) {
        if (first == null) {
            return null;
        }
        if (first.next == null) {
            return first;
        }
        Node<Item> second = first.next;
        Node<Item> rest = reverse(second);
        second.next = first;
        first.next = null;
        return rest;
    }

    //sort
    public static <T> void sort(LinkedList<Comparable<T>> list) {
        Node<Comparable<T>> mid = findSortedSubList(list.first);
        Node<Comparable<T>> hi = mid;

        while (mid.next != null && hi != list.last) {
            hi = findSortedSubList(mid.next);
            merge(list, mid, hi);
            if (less(mid.item, hi.item)) {
                mid = hi;
            }
            if (mergeTimes > 10) {
                break;
            }
        }
    }

    private static <T> boolean less(Comparable<T> v, Comparable<T> w) {
        return v.compareTo((T) w) < 0;
    }

    public static <T> void merge(LinkedList<Comparable<T>> list, Node<Comparable<T>> mid, Node<Comparable<T>> hi) {
        mergeTimes++;
        Node<Comparable<T>> current = list.first;
        Node<Comparable<T>> pre = null;

        //左侧所有元素全部都判断完成退出循环
        while (current != mid.next) {
            //当前元素比中间下一个元素小，游标下移
            if (less(current.item, mid.next.item)) {
                pre = current;
                current = current.next;
                continue;
            }
            //当前元素比中间下一个元素大，将其插入到当前元素之前，点前元素是first时需要重置first
            Node<Comparable<T>> t = mid.next;
            mid.next = t.next;
            if (current == list.first) {
                t.next = current;
                list.first = t;
            } else {
                pre.next = t;
                t.next = current;
            }
            //右侧最大元素被移动后退出
            if (t == hi) {
                break;
            }
            pre = t;
        }
    }

    public static <T> Node<Comparable<T>> findSortedSubList(Node<Comparable<T>> start) {
        Node<Comparable<T>> current = start;
        while (current != null && current.next != null && current.item.compareTo((T) current.next.item) < 0) {
            current = current.next;
        }
        return current;
    }

    public void addFirst(Item item) {
        this.first = new Node<>(item, this.first);
        if (last == null) {
            last = first;
        }
        size++;
    }
    //sort end

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;

        public Node(Item item, Node<Item> next) {
            this.item = item;
            this.next = next;
        }

    }

    public Iterator<Item> iterator() {
        return new LinkedIterator(first);
    }

    private class LinkedIterator implements Iterator<Item> {
        private Node<Item> current;

        public LinkedIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

}
