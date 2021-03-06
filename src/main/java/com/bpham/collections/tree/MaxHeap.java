package com.bpham.collections.tree;

public class MaxHeap implements Heap<Integer> {
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
        int toReturn = heapArray[1];
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
        int rightChildIndex = leftChildIndex + 1;
        Integer value = heapArray[nodeIndex];
        Integer leftChild = heapArray[leftChildIndex];
        Integer rightChild = heapArray[rightChildIndex];
        if (isLessThan(value, leftChild, rightChild)) {
            if (rightChild > leftChild) {
                swap(nodeIndex, rightChildIndex);
                sink(rightChildIndex);
            } else {
                swap(nodeIndex, leftChildIndex);
                sink(leftChildIndex);
            }
        } else if (isLessThan(value, rightChild)) {
            swap(nodeIndex, rightChildIndex);
            sink(rightChildIndex);
        } else if (isLessThan(value, leftChild)) {
            swap(nodeIndex, leftChildIndex);
            sink(leftChildIndex);
        }
    }

    public void swim(int nodeIndex) {
        if (nodeIndex == 1) {
            return;
        }
        int parentIndex = getParentIndex(nodeIndex);
        Integer value = heapArray[nodeIndex];
        Integer parentValue = heapArray[parentIndex];
        if (isLessThan(parentValue, value)) {
            swap(parentIndex, nodeIndex);
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

    private boolean isLessThan(Integer value, Integer toCompare1, Integer toCompare2) {
        return toCompare1 != null &&
                toCompare2 != null &&
                value < toCompare1 &&
                value < toCompare2;
    }

    private boolean isLessThan(Integer value, Integer toCompare) {
        return toCompare != null && value < toCompare;
    }

    private void swap(int index1, int index2) {
        Integer temp = heapArray[index1];
        heapArray[index1] = heapArray[index2];
        heapArray[index2] = temp;
    }
}
