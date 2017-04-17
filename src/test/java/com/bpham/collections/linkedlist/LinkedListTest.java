package com.bpham.collections.linkedlist;

import com.bpham.collections.linkedlist.LinkedList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinkedListTest {
    @Test
    public void shouldAddFirst() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(1);

        assertEquals((Integer) 1, list.getFirst());
    }

    @Test
    public void shouldAddFirst2() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(1);
        list.addFirst(2);

        assertEquals((Integer) 2, list.getFirst());
    }

    @Test
    public void shouldAddToEndAsHeadIfNoHead() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(1);

        assertEquals((Integer) 1, list.getFirst());
    }

    @Test
    public void shoudAddToEnd() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(1);
        list.addLast(2);

        assertEquals((Integer) 2, list.getLast());
    }
}
