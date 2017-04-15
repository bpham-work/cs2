package com.bpham.sorts;

public class InsertionSort extends AbstractSort {
    public static void sort(int[] array) {
        for (int index = 0; index < array.length; index++) {
            for (int searchIndex = index; searchIndex > 0; searchIndex--) {
                if (array[searchIndex] < array[searchIndex - 1]) {
                    swap(searchIndex, searchIndex - 1, array);
                } else {
                    break;
                }
            }
        }
    }
}
