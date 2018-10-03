package com.bpham.collections.linkedlist;

import java.util.Arrays;

public class ArrayList<T> implements List<T> {
    private Object[] array;
    private int size = 0;
    private int allocatedSize = 100;
    private int insertPointer = 0;
    private int currentPositionInIteration = 0;

    public ArrayList() {
        array = new Object[allocatedSize];
    }

    public ArrayList(int size) {
        array = new Object[size];
    }

    @Override
    public T get(int index) {
        validateIndex(index);
        return (T) array[index];
    }

    @Override
    public void add(T item) {
        resizeArrayIfNeeded();
        array[insertPointer] = item;
        insertPointer++;
        size++;
    }

    @Override
    public void add(T item, int index) {
        validateIndex(index);
        resizeArrayIfNeeded();
        for (int i = array.length - 2; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = item;
        size++;
        insertPointer++;
    }

    @Override
    public void remove(int index) {
        validateIndex(index);
        for (int i = index; i < insertPointer + 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        insertPointer--;
    }

    @Override
    public int find(T item) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void begin() {
        currentPositionInIteration = 0;
    }

    @Override
    public T next() {
        T toReturn = (T) array[currentPositionInIteration];
        currentPositionInIteration++;
        return toReturn;
    }

    @Override
    public boolean end() {
        return currentPositionInIteration == size;
    }

    @Override
    public T first() {
        validateIndex(0);
        return (T) array[0];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int length() {
        return size;
    }

    private void validateIndex(int index) {
        if (index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void resizeArrayIfNeeded() {
        if (allocatedSize / 2 == size) {
            allocatedSize = allocatedSize ^ 2;
            array = Arrays.copyOf(array, allocatedSize);
        }
    }
}
