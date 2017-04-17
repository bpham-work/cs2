package com.bpham.collections.queue;

import com.bpham.collections.linkedlist.Node;

public class LinkedListQueue<T> implements Queue<T> {
    private Node<T> headNode;
    private Node<T> tailNode;

    @Override
    public T dequeue() {
        Node<T> nodeToDequeue = headNode;
        T valueToReturn = nodeToDequeue.getValue();
        headNode = nodeToDequeue.getNextNode();
        nodeToDequeue = null;
        return valueToReturn;
    }

    @Override
    public void enqueue(T value) {
        Node<T> newNode = new Node<>(value);
        if (headNode == null) {
            headNode = newNode;
            tailNode = newNode;
        } else {
            tailNode.setNextNode(newNode);
            tailNode = newNode;
        }
    }

    @Override
    public T peek() {
        return headNode.getValue();
    }
}
