package com.bpham.collections.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MaxHeapTest {
    @Test
    public void shouldSinkIntoProperPosition() {
        MaxHeap heap = new MaxHeap();
        heap.heapArray[1] = 1;
        heap.heapArray[2] = 2;

        heap.sink(1);

        assertEquals((Integer) 2, heap.heapArray[1]);
        assertEquals((Integer) 1, heap.heapArray[2]);
    }

    @Test
    public void shouldSinkIntoProperPosition2() {
        MaxHeap heap = new MaxHeap();
        heap.heapArray[1] = 1;
        heap.heapArray[2] = 2;
        heap.heapArray[3] = 2;
        heap.heapArray[4] = 2;

        heap.sink(1);

        assertEquals((Integer) 2, heap.heapArray[1]);
        assertEquals((Integer) 2, heap.heapArray[2]);
        assertEquals((Integer) 2, heap.heapArray[3]);
        assertEquals((Integer) 1, heap.heapArray[4]);
    }

    @Test
    public void shouldHeapify() {
        MaxHeap heap = new MaxHeap();
        Integer[] toHeapify = {1, 2, 3};

        heap.heapify(toHeapify);

        assertIsMaxHeap(heap.heapArray, 3);
        assertEquals(3, heap.size());
    }

    @Test
    public void shouldHeapify2() {
        MaxHeap heap = new MaxHeap();
        Integer[] toHeapify = {1, 2, 3, 4};

        heap.heapify(toHeapify);

        assertIsMaxHeap(heap.heapArray, 4);
        assertEquals(4, heap.size());
    }

    private void assertIsMaxHeap(Integer[] heapArray, int length) {
        for (int x = 1; x <= length; x++) {
            int leftChildIndex = x * 2;
            int rightChildIndex = leftChildIndex + 1;
            Integer parent = heapArray[x];
            Integer leftChild = heapArray[leftChildIndex];
            Integer rightChild = heapArray[rightChildIndex];
            boolean isParentGteLeft = false;
            boolean isParentGteRight = false;
            if (leftChild == null || parent >= leftChild) {
                isParentGteLeft = true;
            }
            if (rightChild == null || parent >= rightChild) {
                isParentGteRight = true;
            }
            assertTrue(isParentGteLeft && isParentGteRight);
        }
    }
}
