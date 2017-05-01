package com.bpham.collections.tree;

import com.bpham.collections.queue.LinkedListQueue;
import com.bpham.collections.queue.Queue;

public class BinarySearchTree {
    public BSTNode<Integer> root;

    public void add(Integer value) {
        BSTNode<Integer> newNode = new BSTNode<>(value);
        root = insert(newNode, root);
    }

    private BSTNode<Integer> insert(BSTNode<Integer> newNode, BSTNode<Integer> parentNode) {
        if (parentNode == null) {
            return newNode;
        }
        if (newNode.value < parentNode.value) {
            parentNode.leftChild = insert(newNode, parentNode.leftChild);
        } else {
            parentNode.rightChild = insert(newNode, parentNode.rightChild);
        }
        return parentNode;
    }

    public boolean contains(Integer value) {
        return contains(value, root);
    }

    private boolean contains(Integer value, BSTNode<Integer> node) {
        if (node == null) {
            return false;
        }
        if (value < node.value) {
            return contains(value, node.leftChild);
        } else if (value > node.value) {
            return contains(value, node.rightChild);
        } else {
            return true;
        }
    }

    public Integer findMax() {
        return findMax(root).value;
    }

    private BSTNode<Integer> findMax(BSTNode<Integer> node) {
        if (node == null) {
            return null;
        }
        if (node.rightChild == null) {
            return node;
        }
        return findMax(node.rightChild);
    }

    public Integer findMin() {
        return findMin(root).value;
    }

    private BSTNode<Integer> findMin(BSTNode<Integer> node) {
        if (node == null) {
            return null;
        }
        if (node.leftChild == null) {
            return node;
        }
        return findMin(node.leftChild);
    }

    public void delete(Integer value) {
        if (root.leftChild == null && root.rightChild == null) {
            root = null;
        } else {
            delete(value, root);
        }
    }

    private BSTNode<Integer> delete(Integer value, BSTNode<Integer> node) {
        if (node == null) return null;
        if (value < node.value) {
            node.leftChild = delete(value, node.leftChild);
        } else if (value > node.value) {
            node.rightChild = delete(value, node.rightChild);
        } else {
            if (node.hasNoChildren()) {
                return null;
            } else if (node.hasOnlyLeftChild()) {
                return node.leftChild;
            } else if (node.hasOnlyRightChild()) {
                return node.rightChild;
            } else {
                BSTNode<Integer> replaceNode = findMin(node.rightChild);
                node.rightChild = delete(replaceNode.value, node.rightChild);
                replaceNode.leftChild = node.leftChild;
                replaceNode.rightChild = node.rightChild;
                return replaceNode;
            }
        }
        return node;
    }

    public void inOrderTraversal(TraversalCallback cb) {
        inOrderTraversal(cb, root);
    }

    private void inOrderTraversal(TraversalCallback cb, BSTNode<Integer> node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(cb, node.leftChild);
        cb.execute(node.value);
        inOrderTraversal(cb, node.rightChild);
    }

    public void preOrderTraversal(TraversalCallback cb) {
        preOrderTraversal(cb, root);
    }

    public void preOrderTraversal(TraversalCallback cb, BSTNode<Integer> node) {
        if (node == null) {
            return;
        }
        cb.execute(node.value);
        preOrderTraversal(cb, node.leftChild);
        preOrderTraversal(cb, node.rightChild);
    }

    public void postOrderTraversal(TraversalCallback cb) {
        postOrderTraversal(cb, root);
    }

    public void postOrderTraversal(TraversalCallback cb, BSTNode<Integer> node) {
        if (node == null) {
            return;
        }
        postOrderTraversal(cb, node.leftChild);
        postOrderTraversal(cb, node.rightChild);
        cb.execute(node.value);
    }

    public void breadthFirstTraversal(TraversalCallback cb) {
        Queue<BSTNode<Integer>> queue = new LinkedListQueue<>();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            BSTNode<Integer> node = queue.dequeue();
            if (node == null) continue;
            cb.execute(node.value);
            queue.enqueue(node.leftChild);
            queue.enqueue(node.rightChild);
        }
    }

    public class BSTNode<T> {
        T value;
        BSTNode<T> leftChild;
        BSTNode<T> rightChild;

        BSTNode(T value) {
            this.value = value;
        }

        public boolean hasTwoChildren() {
            return this.leftChild != null && this.rightChild != null;
        }

        public boolean hasNoChildren() {
            return this.leftChild == null && this.rightChild == null;
        }

        public boolean hasOnlyLeftChild() {
            return this.leftChild != null && this.rightChild == null;
        }

        public boolean hasOnlyRightChild() {
            return this.leftChild == null && this.rightChild != null;
        }
    }

    public interface TraversalCallback {
        void execute(Integer value);
    }
}
