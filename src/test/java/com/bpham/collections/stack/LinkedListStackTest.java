package com.bpham.collections.stack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinkedListStackTest {
    @Test
    public void shouldPushValue() {
        Stack<Integer> stack = new LinkedListStack<>();
        stack.push(1);

        Integer result = stack.peek();

        assertEquals((Integer) 1, result);
    }

    @Test
    public void shouldPushValue2() {
        Stack<Integer> stack = new LinkedListStack<>();
        stack.push(1);
        stack.push(2);

        Integer result = stack.peek();

        assertEquals((Integer) 2, result);
    }

    @Test
    public void shouldPopValue() {
        Stack<Integer> stack = new LinkedListStack<>();
        stack.push(1);

        Integer result = stack.pop();

        assertEquals((Integer) 1, result);
    }

    @Test
    public void shouldPopValue2() {
        Stack<Integer> stack = new LinkedListStack<>();
        stack.push(1);
        stack.push(2);

        Integer result1 = stack.pop();
        Integer result2 = stack.pop();

        assertEquals((Integer) 2, result1);
        assertEquals((Integer) 1, result2);
    }
}
