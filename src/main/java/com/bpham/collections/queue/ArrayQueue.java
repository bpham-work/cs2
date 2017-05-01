package com.bpham.collections.queue;

public class ArrayQueue<T> implements Queue<T> {
    private T[] array = (T[]) new Object[10];
    private int endIndex = 0;

    @Override
    public T dequeue() {
        T valueToReturn = array[0];
        shiftForward();
        return valueToReturn;
    }

    @Override
    public void enqueue(T value) {
        array[endIndex++] = value;
    }

    @Override
    public T peek() {
        return array[0];
    }

    @Override
    public boolean isEmpty() {
        return array.length == 0;
    }

    private void shiftForward() {
        for (int index = 1; index < array.length; index++) {
            array[index-1] = array[index];
        }
    }
}
