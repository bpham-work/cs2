package com.bpham.collections.stack;

public class ArrayStack<T> implements Stack<T> {
    private T[] array = (T[]) new Object[10];
    private Integer headPointer = null;
    private int size = 0;

    @Override
    public void push(T value) {
        if (headPointer == null) {
            headPointer = 0;
            array[headPointer] = value;
        } else {
            headPointer++;
            array[headPointer] = value;
        }
        size++;
    }

    @Override
    public T pop() {
        T valueToPop = array[headPointer];
        array[headPointer] = null;
        headPointer--;
        size--;
        return valueToPop;
    }

    @Override
    public T peek() {
        return array[headPointer];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
