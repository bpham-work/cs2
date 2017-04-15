package com.bpham.sorts;

public class SelectionSort extends AbstractSort {
    public static void sort(int[] array) {
        for (int baseIndex = 0; baseIndex < array.length; baseIndex++) {
            int lowestValueIndex = baseIndex;
            for (int searchingIndex = baseIndex + 1; searchingIndex < array.length; searchingIndex++) {
                int lowestValue = array[lowestValueIndex];
                int comparingValue = array[searchingIndex];
                if (comparingValue < lowestValue) {
                    lowestValueIndex = searchingIndex;
                }
            }
            swap(baseIndex, lowestValueIndex, array);
        }
    }
}
