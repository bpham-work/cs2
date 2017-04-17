package com.bpham.collections.linkedlist;

public class LinkedList<T> {
    private Node<T> headNode;

    public void addFirst(T value) {
        Node<T> newHead = new Node<>(value);
        if (headNode == null) {
            headNode = newHead;
        } else {
            Node<T> temp = headNode;
            headNode = newHead;
            headNode.nextNode = temp;
        }
    }

    public void addLast(T value) {
        if (headNode == null) {
            addFirst(value);
        } else {
            Node<T> newNode = new Node<>(value);
            addToEnd(headNode, newNode);
        }
    }

    public T getFirst() {
        return headNode.value;
    }

    public T getLast() {
        return getLastNode(headNode).value;
    }

    private void addToEnd(Node<T> listNode, Node<T> newNode) {
        if (listNode.nextNode == null) {
            listNode.nextNode = newNode;
        } else {
            addToEnd(listNode.nextNode, newNode);
        }
    }

    private Node<T> getLastNode(Node<T> listNode) {
        if (listNode.nextNode == null) {
            return listNode;
        }
        return getLastNode(listNode.nextNode);
    }

    private class Node<T> {
        T value;
        Node<T> nextNode;

        Node(T value) {
            this.value = value;
        }
    }
}
