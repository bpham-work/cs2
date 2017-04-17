package com.bpham.collections.queue;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinkedListQueueTest {
    @Test
    public void shouldEnqueue() {
        Queue<Integer> queue = new LinkedListQueue<>();
        queue.enqueue(1);

        Integer result = queue.peek();

        assertEquals((Integer) 1, result);
    }

    @Test
    public void shouldEnqueue2() {
        Queue<Integer> queue = new LinkedListQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);

        Integer result = queue.peek();

        assertEquals((Integer) 1, result);
    }

    @Test
    public void shouldDequeue() {
        Queue<Integer> queue = new LinkedListQueue<>();
        queue.enqueue(1);

        Integer result = queue.dequeue();

        assertEquals((Integer) 1, result);
    }

    @Test
    public void shouldDequeue2() {
        Queue<Integer> queue = new LinkedListQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);

        Integer result1 = queue.dequeue();
        Integer result2 = queue.dequeue();

        assertEquals((Integer) 1, result1);
        assertEquals((Integer) 2, result2);
    }
}
