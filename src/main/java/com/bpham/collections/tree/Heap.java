package com.bpham.collections.tree;

public interface Heap<T> {
    void enqueue(T value);
    T dequeue();
    T peek();
    int size();
    void heapify(T[] values);
}
