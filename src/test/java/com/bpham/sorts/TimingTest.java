package com.bpham.sorts;

import com.google.common.base.Stopwatch;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.bpham.sorts.SortTest.assertIsSorted;

public class TimingTest {
    private Stopwatch s = new Stopwatch();
    private static final int ARRAY_SIZE = 999999;
    private static int[] arrayToBeSorted = new int[ARRAY_SIZE];
    static {
        int x = 0;
        while (x < ARRAY_SIZE) {
            Random rng = new Random();
            arrayToBeSorted[x++] = rng.nextInt();
        }
    }

    @Before
    public void setup() {
        s.start();
    }

    @Ignore
    @Test
    public void testSelectionSort() {
        System.out.println("Selection Sort");
        SelectionSort.sort(arrayToBeSorted);

        assertIsSorted(arrayToBeSorted);
    }

    @Ignore
    @Test
    public void testInsertionSort() {
        System.out.println("Insertion Sort");
        InsertionSort.sort(arrayToBeSorted);

        assertIsSorted(arrayToBeSorted);
    }

    @Ignore
    @Test
    public void testMergeSort() {
        System.out.println("Merge Sort");
        MergeSort.sort(arrayToBeSorted);

        assertIsSorted(arrayToBeSorted);
    }

    @Ignore
    @Test
    public void testQuickSort() {
        System.out.println("Quick Sort");
        QuickSort.sort(arrayToBeSorted);

        assertIsSorted(arrayToBeSorted);
    }

    @After
    public void teardown() {
        s.stop();
        System.out.println(s.elapsedTime(TimeUnit.SECONDS));
        s.reset();
    }
}
