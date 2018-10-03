package com.bpham.collections.linkedlist;

public interface List<T> {
    T get(int index);
    void add(T item);
    void add(T item, int index);
    void remove(int index);
    int find(T item);
    void begin();
    T next();
    boolean end();
    T first();
    boolean isEmpty();
    int length();
}
