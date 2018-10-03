package com.bpham.collections.linkedlist;

public class LinkedList<T> implements List<T> {
    private Node<T> headNode;
    private int size = 0;
    private Node<T> currentNodeInIteration = headNode;

    @Override
    public T get(int index) {
        validateIndex(index);
        return getNodeAt(index).value;
    }

    @Override
    public void add(T item) {
        Node<T> newNode = new Node<>(item);
        if (headNode == null) {
            headNode = newNode;
        } else {
            Node<T> lastNode = getNodeAt(size - 1);
            lastNode.nextNode = newNode;
        }
        size++;
    }

    @Override
    public void add(T item, int index) {
        validateIndex(index);
        Node<T> newNode = new Node<>(item);
        if (index == 0) {
            newNode.nextNode = headNode;
            headNode = newNode;
        } else {
            Node<T> nodeBeforeIndex = getNodeAt(index - 1);
            newNode.nextNode = nodeBeforeIndex.nextNode;
            nodeBeforeIndex.nextNode = newNode;
        }
        size++;
    }

    @Override
    public void remove(int index) {
        validateIndex(index);
        if (index == 0) {
            headNode = headNode.nextNode;
        } else {
            Node<T> nodeBeforeIndex = getNodeAt(index - 1);
            nodeBeforeIndex.nextNode = nodeBeforeIndex.nextNode.nextNode;
        }
        size--;
    }

    @Override
    public int find(T item) {
        int index = 0;
        Node<T> resultNode = headNode;
        boolean found = false;
        while (!found && resultNode != null) {
            found = resultNode.value.equals(item);
            resultNode = resultNode.nextNode;
            index = found ? index : index + 1;
        }
        return found ? index : -1;
    }

    @Override
    public void begin() {
        currentNodeInIteration = headNode;
    }

    @Override
    public T next() {
        T toReturn = currentNodeInIteration.value;
        currentNodeInIteration = currentNodeInIteration.nextNode;
        return toReturn;
    }

    @Override
    public boolean end() {
        return currentNodeInIteration == null;
    }

    @Override
    public T first() {
        validateIndex(0);
        return headNode.value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int length() {
        return size;
    }

    private Node<T> getNodeAt(int index) {
        validateIndex(index);
        if (index == -1) {
            return headNode;
        }
        int counter = 0;
        Node<T> result = headNode;
        while (counter != index) {
            counter++;
            result = result.nextNode;
        }
        return result;
    }

    private void validateIndex(int index) {
        if (index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
    }

    private class Node<T> {
        T value;
        Node<T> nextNode;

        Node(T value) {
            this.value = value;
        }
    }
}
