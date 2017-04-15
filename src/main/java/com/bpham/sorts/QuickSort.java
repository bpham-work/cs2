package com.bpham.sorts;

public class QuickSort extends AbstractSort {
    public static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    public static void sort(int[] array, int low, int hi) {
        if (low >= hi) {
            return;
        }
        int partitionIndex = partition(array, low, hi);
        sort(array, low, partitionIndex - 1);
        sort(array, partitionIndex + 1, hi);
    }

    public static int partition(int[] array, int low, int hi) {
        int partitionValue = array[low];
        int leftPointer = low + 1;
        int rightPointer = hi;
        while (true) {
            while (array[leftPointer] < partitionValue) {
                leftPointer++;
                if (leftPointer == hi) {
                    break;
                }
            }
            while (array[rightPointer] > partitionValue) {
                rightPointer--;
                if (rightPointer == low) {
                    break;
                }
            }

            if (leftPointer >= rightPointer) {
                swap(low, rightPointer, array);
                break;
            }
            swap(leftPointer, rightPointer, array);
        }

        return rightPointer;
    }
}
