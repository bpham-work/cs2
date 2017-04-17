package com.bpham.collections.queue;

public interface Queue<T> {
    T dequeue();
    void enqueue(T value);
    T peek();
}
