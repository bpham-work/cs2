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

        assertIsMaxHeap(heap, 2);
    }

    @Test
    public void shouldSinkIntoProperPosition2() {
        MaxHeap heap = new MaxHeap();
        heap.heapArray[1] = 1;
        heap.heapArray[2] = 2;
        heap.heapArray[3] = 2;
        heap.heapArray[4] = 2;

        heap.sink(1);

        assertIsMaxHeap(heap, 4);
    }

    @Test
    public void shouldHeapify() {
        MaxHeap heap = new MaxHeap();
        Integer[] toHeapify = {1, 2, 3};

        heap.heapify(toHeapify);

        assertIsMaxHeap(heap, 3);
        assertEquals(3, heap.size());
    }

    @Test
    public void shouldHeapify2() {
        MaxHeap heap = new MaxHeap();
        Integer[] toHeapify = {1, 2, 3, 4};

        heap.heapify(toHeapify);

        assertIsMaxHeap(heap, 4);
        assertEquals(4, heap.size());
    }

    @Test
    public void shouldSwim() {
        MaxHeap heap = new MaxHeap();
        heap.heapArray[1] = 1;
        heap.heapArray[2] = 2;
        heap.heapArray[3] = 3;

        heap.swim(3);

        assertIsMaxHeap(heap, 3);
    }

    @Test
    public void shouldSwim2() {
        MaxHeap heap = new MaxHeap();
        heap.heapArray[1] = 3;
        heap.heapArray[2] = 2;
        heap.heapArray[3] = 1;
        heap.heapArray[4] = 4;

        heap.swim(4);

        assertIsMaxHeap(heap, 4);
    }

    @Test
    public void shouldEnqueue() {
        MaxHeap heap = new MaxHeap();

        heap.enqueue(1);

        assertEquals((Integer) 1, heap.peek());
        assertIsMaxHeap(heap, 1);
        assertEquals(1, heap.size());
    }

    @Test
    public void shouldEnqueue2() {
        MaxHeap heap = new MaxHeap();

        heap.enqueue(1);
        heap.enqueue(2);

        assertEquals((Integer) 2, heap.peek());
        assertIsMaxHeap(heap, 2);
        assertEquals(2, heap.size());
    }

    @Test
    public void shouldDequeue() {
        MaxHeap heap = new MaxHeap();
        heap.enqueue(1);
        heap.enqueue(2);
        heap.enqueue(3);

        Integer result = heap.dequeue();

        assertEquals((Integer) 3, result);
        assertEquals(2, heap.size());
        assertIsMaxHeap(heap, 2);
    }

    @Test
    public void shouldDequeue3() {
        MaxHeap heap = new MaxHeap();
        heap.enqueue(1);
        heap.enqueue(2);
        heap.enqueue(3);
        heap.enqueue(4);

        Integer result = heap.dequeue();

        assertEquals((Integer) 4, result);
        assertEquals(3, heap.size());
        assertIsMaxHeap(heap, 3);
    }

    private void assertIsMaxHeap(MaxHeap heap, int length) {
        Integer[] heapArray = heap.heapArray;
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
