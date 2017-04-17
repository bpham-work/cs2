package com.bpham.collections.stack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArrayStackTest {
    @Test
    public void shouldPushValue() {
        Stack<Integer> stack = new ArrayStack<>();
        stack.push(1);

        Integer result = stack.peek();

        assertEquals((Integer) 1, result);
    }

    @Test
    public void shouldPushValue2() {
        Stack<Integer> stack = new ArrayStack<>();
        stack.push(1);
        stack.push(2);

        Integer result = stack.peek();

        assertEquals((Integer) 2, result);
    }

    @Test
    public void shouldPopValue() {
        Stack<Integer> stack = new ArrayStack<>();
        stack.push(1);

        Integer result = stack.pop();

        assertEquals((Integer) 1, result);
    }
}
