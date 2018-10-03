package com.bpham.collections.linkedlist;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayListTest {
    @Test
    public void getIndex0() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        assertEquals((Integer) 1, list.get(0));
    }

    @Test
    public void getIndex1() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        assertEquals((Integer) 2, list.get(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getIndexOutOfbounds() {
        List<Integer> list = new ArrayList<>();
        list.get(0);
    }

    @Test
    public void addItem() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        assertEquals((Integer) 1, list.get(0));
        assertEquals((Integer) 2, list.get(1));
    }

    @Test
    public void addCheckSize() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        assertEquals(2, list.length());
    }

    @Test
    public void addItemAtHead() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3, 0);
        assertEquals((Integer) 3, list.get(0));
        assertEquals((Integer) 1, list.get(1));
        assertEquals((Integer) 2, list.get(2));
    }

    @Test
    public void addItemAtIndex() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3, 1);
        assertEquals((Integer) 1, list.get(0));
        assertEquals((Integer) 3, list.get(1));
        assertEquals((Integer) 2, list.get(2));
    }

    @Test
    public void addItemAtIndexCheckSize() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3, 1);
        assertEquals(3, list.length());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addItemAtIndexOutOfBound() {
        List<Integer> list = new ArrayList<>();
        list.add(3, 1);
    }

    @Test
    public void removeAtHead() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.remove(0);
        assertEquals((Integer) 2, list.get(0));
    }

    @Test
    public void removeAtIndex() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(1);
        assertEquals((Integer) 1, list.get(0));
        assertEquals((Integer) 3, list.get(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeIndexOutOfBounds() {
        List<Integer> list = new ArrayList<>();
        list.remove(0);
    }

    @Test
    public void removeCheckSize() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.remove(0);
        assertEquals(1, list.length());
    }

    @Test
    public void findItem() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        int result = list.find(1);
        assertEquals(0, result);
    }

    @Test
    public void findItemThatDoesNotExist() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        int result = list.find(3);
        assertEquals(-1, result);
    }

    @Test
    public void getFirst() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        assertEquals((Integer) 1, list.first());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getFirstIndexOutOfBounds() {
        List<Integer> list = new ArrayList<>();
        list.first();
    }

    @Test
    public void isEmpty() {
        List<Integer> list = new ArrayList<>();
        assertTrue(list.isEmpty());
    }

    @Test
    public void isNotEmpty() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        assertFalse(list.isEmpty());
    }

    @Test
    public void iterateTest() {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.begin();
        int value = 0;
        while (!list.end()) {
            assertEquals((Integer) value, list.next());
            value++;
        }
    }
}
