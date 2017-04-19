package com.bpham.collections.tree;

public class MinHeap implements Heap<Integer> {
    public Integer[] heapArray = new Integer[100];
    private int size = 0;

    @Override
    public void enqueue(Integer value) {
        int insertIndex = size + 1;
        heapArray[insertIndex] = value;
        swim(insertIndex);
        size++;
    }

    @Override
    public Integer dequeue() {
        Integer toReturn = heapArray[1];
        swap(1, size);
        heapArray[size] = null;
        sink(1);
        size--;
        return toReturn;
    }

    @Override
    public Integer peek() {
        return heapArray[1];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void heapify(Integer[] values) {
        for (Integer value : values) {
            enqueue(value);
        }
        size = values.length;
    }

    public void sink(int nodeIndex) {
        int leftChildIndex = nodeIndex * 2;
        int rightChildIndex = (nodeIndex * 2) + 1;
        int value = heapArray[nodeIndex];
        Integer leftChildValue = heapArray[leftChildIndex];
        Integer rightChildValue = heapArray[rightChildIndex];
        if (isGreaterThan(value, leftChildValue, rightChildValue)) {
            if (leftChildValue < rightChildValue) {
                swap(nodeIndex, leftChildIndex);
                sink(leftChildIndex);
            } else {
                swap(nodeIndex, rightChildIndex);
                sink(rightChildIndex);
            }
        } else if (isGreaterThan(value, leftChildValue)) {
            swap(nodeIndex, leftChildIndex);
            sink(leftChildIndex);
        } else if (isGreaterThan(value, rightChildIndex)) {
            swap(nodeIndex, rightChildIndex);
            sink(rightChildIndex);
        }
    }

    public void swim(int nodeIndex) {
        if (nodeIndex == 1) {
            return;
        }
        int parentIndex = getParentIndex(nodeIndex);
        Integer parentValue = heapArray[parentIndex];
        Integer childValue = heapArray[nodeIndex];
        if (parentValue > childValue) {
            swap(nodeIndex, parentIndex);
            swim(parentIndex);
        }
    }

    private int getParentIndex(int nodeIndex) {
        boolean isNodeIndexEven = nodeIndex % 2 == 0;
        if (isNodeIndexEven) {
            return nodeIndex / 2;
        } else {
            return (nodeIndex - 1) / 2;
        }
    }

    private boolean isGreaterThan(Integer value, Integer toCompare1, Integer toCompare2) {
        return toCompare1 != null &&
                toCompare2 != null &&
                value > toCompare1 &&
                value > toCompare2;
    }

    private boolean isGreaterThan(Integer value, Integer toCompare) {
        return toCompare != null && value > toCompare;
    }

    private void swap(int index1, int index2) {
        Integer temp = heapArray[index1];
        heapArray[index1] = heapArray[index2];
        heapArray[index2] = temp;
    }
}
