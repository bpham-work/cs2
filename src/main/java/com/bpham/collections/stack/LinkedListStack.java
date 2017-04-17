package com.bpham.collections.stack;

import com.bpham.collections.linkedlist.Node;

public class LinkedListStack<T> implements Stack<T> {
    private Node<T> headNode;

    @Override
    public void push(T value) {
        Node<T> newNode = new Node<>(value);
        if (headNode == null) {
            headNode = newNode;
        } else {
            Node<T> temp = headNode;
            headNode = newNode;
            headNode.setNextNode(temp);
        }
    }

    @Override
    public T pop() {
        Node<T> nodeToPop = headNode;
        T valueToReturn = nodeToPop.getValue();
        headNode = nodeToPop.getNextNode();
        nodeToPop = null;
        return valueToReturn;
    }

    @Override
    public T peek() {
        return headNode.getValue();
    }
}
