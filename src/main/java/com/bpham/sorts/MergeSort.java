package com.bpham.sorts;

import java.util.Arrays;

public class MergeSort extends AbstractSort {
    public static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    public static void sort(int[] array, int low, int hi) {
        if (low == hi) {
            return;
        }
        int mid = (low + hi) / 2;
        sort(array, low, mid);
        sort(array, mid + 1, hi);
        merge(array, low, hi);
    }

    public static void merge(int[] array, int low, int hi) {
        int[] auxArray = Arrays.copyOf(array, array.length);
        int leftPointer = low;
        int mid = (low + hi) / 2;
        int rightPointer = mid + 1;
        for (int x = low; x <= hi; x++) {
            if (rightPointer > hi) {
                array[x] = auxArray[leftPointer];
                leftPointer++;
            } else if (leftPointer > mid) {
                array[x] = auxArray[rightPointer];
                rightPointer++;
            } else {
                int leftValue = auxArray[leftPointer];
                int rightValue = auxArray[rightPointer];
                if (leftValue < rightValue || leftValue == rightValue) {
                    array[x] = leftValue;
                    leftPointer++;
                } else {
                    array[x] = rightValue;
                    rightPointer++;
                }
            }
        }
    }
}
