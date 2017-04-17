package com.bpham.collections.tree;

public class MaxHeap implements Heap<Integer> {
    public Integer[] heapArray = new Integer[100];
    private int size = 0;

    @Override
    public void enqueue(Integer value) {

    }

    @Override
    public Integer dequeue() {
        return null;
    }

    @Override
    public Integer peek() {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void heapify(Integer[] values) {
        for (int x = 0; x < values.length; x++) {
            heapArray[x + 1] = values[x];
        }
        for (int x = values.length; x > 0; x--) {
            sink(x);
        }
        size = values.length;
    }

    public void sink(int nodeIndex) {
        int leftChildIndex = nodeIndex * 2;
        int rightChildIndex = leftChildIndex + 1;
        Integer value = heapArray[nodeIndex];
        Integer leftChild = heapArray[leftChildIndex];
        Integer rightChild = heapArray[rightChildIndex];
        if (isLessThanBothChildren(value, leftChild, rightChild)) {
            if (rightChild > leftChild) {
                swap(nodeIndex, rightChildIndex);
                sink(rightChildIndex);
            } else {
                swap(nodeIndex, leftChildIndex);
                sink(leftChildIndex);
            }
        } else if (isLessThanRightChild(value, rightChild)) {
            swap(nodeIndex, rightChildIndex);
            sink(rightChildIndex);
        } else if (isLessThanLeftChild(value, leftChild)) {
            swap(nodeIndex, leftChildIndex);
            sink(leftChildIndex);
        }
    }

    private boolean isLessThanBothChildren(Integer value, Integer leftChild, Integer rightChild) {
        return leftChild != null &&
                rightChild != null &&
                value < leftChild &&
                value < rightChild;
    }

    private boolean isLessThanLeftChild(Integer value, Integer leftChild) {
        return leftChild != null && value < leftChild;
    }

    private boolean isLessThanRightChild(Integer value, Integer rightChild) {
        return rightChild != null && value < rightChild;
    }

    private void swap(int index1, int index2) {
        Integer temp = heapArray[index1];
        heapArray[index1] = heapArray[index2];
        heapArray[index2] = temp;
    }
}
