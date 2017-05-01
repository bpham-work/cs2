package com.bpham.collections.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {
    @Test
    public void addSingleValueShouldBeRoot() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.add(1);

        assertEquals((Integer) 1, bst.root.value);
    }

    @Test
    public void addLesserValueAsLeftChild() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.add(2);
        bst.add(1);

        assertEquals((Integer) 2, bst.root.value);
        assertEquals((Integer) 1, bst.root.leftChild.value);
    }

    @Test
    public void addLesserValueAsLeftChild2() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.add(3);
        bst.add(2);
        bst.add(1);

        assertEquals((Integer) 3, bst.root.value);
        assertEquals((Integer) 2, bst.root.leftChild.value);
        assertEquals((Integer) 1, bst.root.leftChild.leftChild.value);
    }

    @Test
    public void addGreaterValueAsRightChild() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.add(1);
        bst.add(2);

        assertEquals((Integer) 1, bst.root.value);
        assertEquals((Integer) 2, bst.root.rightChild.value);
    }

    @Test
    public void addGreaterValueAsRightChild2() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.add(1);
        bst.add(3);
        bst.add(2);

        assertEquals((Integer) 1, bst.root.value);
        assertEquals((Integer) 3, bst.root.rightChild.value);
        assertEquals((Integer) 2, bst.root.rightChild.leftChild.value);
    }

    @Test
    public void shouldReturnFalseIfDoesNotContains() {
        BinarySearchTree bst = new BinarySearchTree();

        assertFalse(bst.contains(1));
    }

    @Test
    public void shouldReturnFalseIfDoesNotContains2() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.add(2);

        assertFalse(bst.contains(1));
    }

    @Test
    public void shouldReturnTrueIfContains() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.add(1);

        assertTrue(bst.contains(1));
    }

    @Test
    public void shouldReturnTrueIfContains2() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.add(2);
        bst.add(1);

        assertTrue(bst.contains(1));
    }

    @Test
    public void shouldReturnTrueIfContains3() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.add(2);
        bst.add(3);

        assertTrue(bst.contains(3));
    }

    @Test
    public void shouldFindMax() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(1);

        assertEquals((Integer) 1, bst.findMax());
    }

    @Test
    public void shouldFindMax2() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(1);
        bst.add(2);

        assertEquals((Integer) 2, bst.findMax());
    }

    @Test
    public void shouldFindMin() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(1);

        assertEquals((Integer) 1, bst.findMin());
    }

    @Test
    public void shouldFindMin2() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(2);
        bst.add(1);

        assertEquals((Integer) 1, bst.findMin());
    }

    @Test
    public void shouldDeleteRoot() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(2);

        bst.delete(2);

        assertFalse(bst.contains(2));
    }

    @Test
    public void shouldDeleteLeftChild() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(5);
        bst.add(4);

        bst.delete(4);

        assertFalse(bst.contains(4));
    }

    @Test
    public void shouldDeleteRightChildInLeftSubtree() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(5);
        bst.add(3);
        bst.add(4);

        bst.delete(4);

        assertFalse(bst.contains(4));
        assertIsBST(bst);
    }

    @Test
    public void shouldDeleteLeftChildWithRightChild() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(5);
        bst.add(3);
        bst.add(4);

        bst.delete(3);

        assertFalse(bst.contains(3));
        assertIsBST(bst);
    }

    @Test
    public void shouldDeleteLeftChildWithLeftChild() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(5);
        bst.add(3);
        bst.add(2);

        bst.delete(3);

        assertFalse(bst.contains(3));
        assertIsBST(bst);
    }

    @Test
    public void shouldDeleteLeftChildInLeftSubtree() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(5);
        bst.add(3);
        bst.add(2);

        bst.delete(2);

        assertFalse(bst.contains(2));
        assertIsBST(bst);
    }

    @Test
    public void shouldDeleteRightChild() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(5);
        bst.add(6);

        bst.delete(6);

        assertFalse(bst.contains(6));
        assertIsBST(bst);
    }

    @Test
    public void shouldDeleteLeftChildInRightSubtree() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(5);
        bst.add(7);
        bst.add(6);

        bst.delete(6);

        assertFalse(bst.contains(6));
        assertIsBST(bst);
    }

    @Test
    public void shouldDeleteRightChildInRightSubtree() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(5);
        bst.add(7);
        bst.add(8);

        bst.delete(8);

        assertFalse(bst.contains(8));
        assertIsBST(bst);
    }

    @Test
    public void shouldDeleteRightNodeWithRightChild() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(5);
        bst.add(6);
        bst.add(7);

        bst.delete(6);

        assertFalse(bst.contains(6));
        assertIsBST(bst);
    }

    @Test
    public void shouldDeleteRightNodeWithLeftChild() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(5);
        bst.add(8);
        bst.add(7);

        bst.delete(8);

        assertFalse(bst.contains(8));
        assertIsBST(bst);
    }

    @Test
    public void shouldDeleteNodeWithTwoChildrenInRightSubtree() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(5);
        bst.add(8);
        bst.add(9);
        bst.add(7);

        bst.delete(8);

        assertFalse(bst.contains(8));
        assertTrue(bst.contains(9));
        assertTrue(bst.contains(7));
        assertIsBST(bst);
    }

    @Test
    public void shouldDeleteNodeWithTwoChildrenInLeftSubtree() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(5);
        bst.add(2);
        bst.add(3);
        bst.add(1);

        bst.delete(2);

        assertFalse(bst.contains(2));
        assertTrue(bst.contains(1));
        assertTrue(bst.contains(3));
        assertIsBST(bst);
    }

    @Test
    public void shouldDeleteNodeWithTwoChildrenInLeftSubtree2() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(10);
        bst.add(6);
        bst.add(5);
        bst.add(8);
        bst.add(9);
        bst.add(7);

        bst.delete(6);

        assertFalse(bst.contains(6));
        assertTrue(bst.contains(5));
        assertTrue(bst.contains(8));
        assertTrue(bst.contains(9));
        assertTrue(bst.contains(7));
        assertIsBST(bst);
    }

    @Test
    public void shouldDeleteNodeWithTwoChildrenInRightSubtree2() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(5);
        bst.add(8);
        bst.add(10);
        bst.add(9);
        bst.add(11);

        bst.delete(8);

        assertFalse(bst.contains(8));
        assertTrue(bst.contains(5));
        assertTrue(bst.contains(10));
        assertTrue(bst.contains(9));
        assertTrue(bst.contains(11));
        assertIsBST(bst);
    }

    @Test
    public void shouldDeleteNodeWithTwoChildrenInRightSubtree3() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(5);
        bst.add(8);
        bst.add(10);
        bst.add(11);

        bst.delete(8);

        assertFalse(bst.contains(8));
        assertTrue(bst.contains(5));
        assertTrue(bst.contains(10));
        assertTrue(bst.contains(11));
        assertIsBST(bst);
    }

    @Test
    public void shouldTraverseInOrder() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(5);

        bst.add(2);
        bst.add(1);
        bst.add(3);

        bst.add(8);
        bst.add(7);
        bst.add(9);

        bst.inOrderTraversal((value) -> System.out.println(value));
        assertIsBST(bst);
    }

    @Test
    public void shouldTraversePreOrder() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(5);

        bst.add(2);
        bst.add(1);
        bst.add(3);

        bst.add(8);
        bst.add(7);
        bst.add(9);

        List<Integer> result = new ArrayList<>();
        bst.preOrderTraversal((value) -> System.out.println(value));
        bst.preOrderTraversal((value) -> result.add(value));
        assertEquals((Integer) 5, result.get(0));
        assertEquals((Integer) 2, result.get(1));
        assertEquals((Integer) 1, result.get(2));
        assertEquals((Integer) 3, result.get(3));
        assertEquals((Integer) 8, result.get(4));
        assertEquals((Integer) 7, result.get(5));
        assertEquals((Integer) 9, result.get(6));
        assertIsBST(bst);
    }

    @Test
    public void shouldTraversePostOrder() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(5);

        bst.add(2);
        bst.add(1);
        bst.add(3);

        bst.add(8);
        bst.add(7);
        bst.add(9);

        List<Integer> result = new ArrayList<>();
        bst.postOrderTraversal((value) -> System.out.println(value));
        bst.postOrderTraversal((value) -> result.add(value));
        assertEquals((Integer) 1, result.get(0));
        assertEquals((Integer) 3, result.get(1));
        assertEquals((Integer) 2, result.get(2));
        assertEquals((Integer) 7, result.get(3));
        assertEquals((Integer) 9, result.get(4));
        assertEquals((Integer) 8, result.get(5));
        assertEquals((Integer) 5, result.get(6));
        assertIsBST(bst);
    }

    @Test
    public void shouldTraverseBreadthFirst() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(5);

        bst.add(2);
        bst.add(1);
        bst.add(3);

        bst.add(8);
        bst.add(7);
        bst.add(9);

        List<Integer> result = new ArrayList<>();
        bst.breadthFirstTraversal((value) -> System.out.println(value));
        bst.breadthFirstTraversal((value) -> result.add(value));
        assertEquals((Integer) 5, result.get(0));
        assertEquals((Integer) 2, result.get(1));
        assertEquals((Integer) 8, result.get(2));
        assertEquals((Integer) 1, result.get(3));
        assertEquals((Integer) 3, result.get(4));
        assertEquals((Integer) 7, result.get(5));
        assertEquals((Integer) 9, result.get(6));
        assertIsBST(bst);
    }

    private void assertIsBST(BinarySearchTree bst) {
        List<Integer> list = new ArrayList<>();
        bst.inOrderTraversal((value) -> list.add(value));
        boolean isSorted = true;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i+1)) {
                isSorted = false;
            }
        }
        assertTrue(isSorted);
    }
}
