package com.solucionesEDA.algorithms;

import java.util.Random;

public class QuickSort {

    private static final Random random = new Random();

    public static void quickSortFirstPivot(int[] arr) {
        quickSortFirstPivot(arr, 0, arr.length - 1);
    }

    private static void quickSortFirstPivot(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partitionFirst(arr, low, high);
            quickSortFirstPivot(arr, low, pivotIndex - 1);
            quickSortFirstPivot(arr, pivotIndex + 1, high);
        }
    }

    private static int partitionFirst(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low + 1;

        for (int j = low + 1; j <= high; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }

        swap(arr, low, i - 1);
        return i - 1;
    }

    public static void quickSortRandomPivot(int[] arr) {
        quickSortRandomPivot(arr, 0, arr.length - 1);
    }

    private static void quickSortRandomPivot(int[] arr, int low, int high) {
        if (low < high) {
            int randomIndex = low + random.nextInt(high - low + 1);
            swap(arr, low, randomIndex);

            int pivotIndex = partitionFirst(arr, low, high);
            quickSortRandomPivot(arr, low, pivotIndex - 1);
            quickSortRandomPivot(arr, pivotIndex + 1, high);
        }
    }

    public static void quickSortMedianOfThree(int[] arr) {
        quickSortMedianOfThree(arr, 0, arr.length - 1);
    }

    private static void quickSortMedianOfThree(int[] arr, int low, int high) {
        if (low < high) {
            int medianIndex = medianOfThree(arr, low, high);
            swap(arr, low, medianIndex);

            int pivotIndex = partitionFirst(arr, low, high);
            quickSortMedianOfThree(arr, low, pivotIndex - 1);
            quickSortMedianOfThree(arr, pivotIndex + 1, high);
        }
    }

    private static int medianOfThree(int[] arr, int low, int high) {
        int mid = low + (high - low) / 2;

        if (arr[mid] < arr[low]) {
            if (arr[high] < arr[mid]) {
                return mid;
            } else if (arr[high] < arr[low]) {
                return high;
            } else {
                return low;
            }
        } else {
            if (arr[high] < arr[low]) {
                return low;
            } else if (arr[high] < arr[mid]) {
                return high;
            } else {
                return mid;
            }
        }
    }

    public static void quickSortHoare(int[] arr) {
        quickSortHoare(arr, 0, arr.length - 1);
    }

    private static void quickSortHoare(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = hoarePartition(arr, low, high);
            quickSortHoare(arr, low, pivotIndex);
            quickSortHoare(arr, pivotIndex + 1, high);
        }
    }

    private static int hoarePartition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low - 1;
        int j = high + 1;

        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);

            do {
                j--;
            } while (arr[j] > pivot);

            if (i >= j) {
                return j;
            }

            swap(arr, i, j);
        }
    }

    public static <T extends Comparable<T>> void quickSortGeneric(T[] arr) {
        quickSortGeneric(arr, 0, arr.length - 1);
    }

    private static <T extends Comparable<T>> void quickSortGeneric(T[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partitionGeneric(arr, low, high);
            quickSortGeneric(arr, low, pivotIndex - 1);
            quickSortGeneric(arr, pivotIndex + 1, high);
        }
    }

    private static <T extends Comparable<T>> int partitionGeneric(T[] arr, int low, int high) {
        T pivot = arr[low];
        int i = low + 1;

        for (int j = low + 1; j <= high; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                swapGeneric(arr, i, j);
                i++;
            }
        }

        swapGeneric(arr, low, i - 1);
        return i - 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static <T> void swapGeneric(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}