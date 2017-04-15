package com.bpham.sorts;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SortTest {
    private int[] arrayToBeSorted;

    @Before
    public void setup() {
        arrayToBeSorted = new int[] {6, 5, 4, 3, 2, 1};
    }

    @Test
    public void testSelectionSort() {
        SelectionSort.sort(arrayToBeSorted);

        assertIsSorted(arrayToBeSorted);
    }

    @Test
    public void testInsertionSort() {
        InsertionSort.sort(arrayToBeSorted);

        assertIsSorted(arrayToBeSorted);
    }

    @Test
    public void testMergeSort() {
        MergeSort.sort(arrayToBeSorted);

        assertIsSorted(arrayToBeSorted);
    }

    @Test
    public void testQuickSort() {
        QuickSort.sort(arrayToBeSorted);

        assertIsSorted(arrayToBeSorted);
    }

    @Test
    public void testMerge() {
        int[] x = {1, 1};
        MergeSort.merge(x, 0, 1);

        assertIsSorted(x);
    }

    @Test
    public void testPartition() {
        int[] x = {2, 1, 3, 0};

        int partitionIndex = QuickSort.partition(arrayToBeSorted, 0, arrayToBeSorted.length - 1);

        assertEquals(5, partitionIndex);
    }

    public static void assertIsSorted(int[] array) {
        if (array.length < 2) {
            assert true;
        }
        for (int index = 0; index < array.length - 1; index++) {
            int currentValue = array[index];
            int nextValue = array[index + 1];
            assertTrue(currentValue <= nextValue);
        }
    }
}
