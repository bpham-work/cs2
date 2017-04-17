package com.bpham.collections.stack;

public class ArrayStack<T> implements Stack<T> {
    private T[] array = (T[]) new Object[10];
    private Integer headPointer = null;

    @Override
    public void push(T value) {
        if (headPointer == null) {
            headPointer = 0;
            array[headPointer] = value;
        } else {
            headPointer++;
            array[headPointer] = value;
        }
    }

    @Override
    public T pop() {
        T valueToPop = array[headPointer];
        array[headPointer] = null;
        headPointer--;
        return valueToPop;
    }

    @Override
    public T peek() {
        return array[headPointer];
    }
}
