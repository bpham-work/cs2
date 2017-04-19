package com.bpham.collections.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MinHeapTest {
    @Test
    public void shouldSinkIntoProperPosition() {
        MinHeap heap = new MinHeap();
        heap.heapArray[1] = 2;
        heap.heapArray[2] = 1;

        heap.sink(1);

        assertIsMinHeap(heap, 2);
    }

    @Test
    public void shouldSinkIntoProperPosition2() {
        MinHeap heap = new MinHeap();
        heap.heapArray[1] = 4;
        heap.heapArray[2] = 1;
        heap.heapArray[3] = 2;
        heap.heapArray[4] = 3;

        heap.sink(1);

        assertIsMinHeap(heap, 4);
    }

    @Test
    public void shouldHeapify() {
        MinHeap heap = new MinHeap();
        Integer[] toHeapify = {3, 2, 1};

        heap.heapify(toHeapify);

        assertIsMinHeap(heap, 3);
        assertEquals(3, heap.size());
    }

    @Test
    public void shouldHeapify2() {
        MinHeap heap = new MinHeap();
        Integer[] toHeapify = {4, 3, 2, 1};

        heap.heapify(toHeapify);

        assertIsMinHeap(heap, 4);
        assertEquals(4, heap.size());
    }

    @Test
    public void shouldSwim() {
        MinHeap heap = new MinHeap();
        heap.heapArray[1] = 2;
        heap.heapArray[2] = 3;
        heap.heapArray[3] = 1;

        heap.swim(3);

        assertIsMinHeap(heap, 3);
    }

    @Test
    public void shouldSwim2() {
        MinHeap heap = new MinHeap();
        heap.heapArray[1] = 2;
        heap.heapArray[2] = 3;
        heap.heapArray[3] = 4;
        heap.heapArray[4] = 1;

        heap.swim(4);

        assertIsMinHeap(heap, 4);
    }

    @Test
    public void shouldEnqueue() {
        MinHeap heap = new MinHeap();

        heap.enqueue(1);

        assertEquals((Integer) 1, heap.peek());
        assertIsMinHeap(heap, 1);
        assertEquals(1, heap.size());
    }

    @Test
    public void shouldEnqueue2() {
        MinHeap heap = new MinHeap();

        heap.enqueue(2);
        heap.enqueue(1);

        assertEquals((Integer) 1, heap.peek());
        assertIsMinHeap(heap, 2);
        assertEquals(2, heap.size());
    }

    @Test
    public void shouldDequeue() {
        MinHeap heap = new MinHeap();
        heap.enqueue(1);
        heap.enqueue(2);
        heap.enqueue(3);

        Integer result = heap.dequeue();

        assertEquals((Integer) 1, result);
        assertEquals(2, heap.size());
        assertIsMinHeap(heap, 2);
    }

    @Test
    public void shouldDequeue3() {
        MinHeap heap = new MinHeap();
        heap.enqueue(1);
        heap.enqueue(2);
        heap.enqueue(3);
        heap.enqueue(4);

        Integer result = heap.dequeue();

        assertEquals((Integer) 1, result);
        assertEquals(3, heap.size());
        assertIsMinHeap(heap, 3);
    }

    private void assertIsMinHeap(MinHeap heap, int length) {
        Integer[] heapArray = heap.heapArray;
        for (int x = 1; x <= length; x++) {
            int leftChildIndex = x * 2;
            int rightChildIndex = leftChildIndex + 1;
            Integer parent = heapArray[x];
            Integer leftChild = heapArray[leftChildIndex];
            Integer rightChild = heapArray[rightChildIndex];
            boolean isParentLteLeft = false;
            boolean isParentLteRight = false;
            if (leftChild == null || parent <= leftChild) {
                isParentLteLeft = true;
            }
            if (rightChild == null || parent <= rightChild) {
                isParentLteRight = true;
            }
            assertTrue(isParentLteLeft && isParentLteRight);
        }
    }
}
