package com.solucionesEDA.algorithms;

public class InsertionSort {

    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static <T extends Comparable<T>> void insertionSortGeneric(T[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            T key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void insertionSortOptimized(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int insertPos = binarySearchInsertionPosition(arr, key, 0, i - 1);

            for (int j = i - 1; j >= insertPos; j--) {
                arr[j + 1] = arr[j];
            }
            arr[insertPos] = key;
        }
    }

    private static int binarySearchInsertionPosition(int[] arr, int key, int left, int right) {
        if (left > right) {
            return left;
        }

        int mid = left + (right - left) / 2;

        if (arr[mid] == key) {
            return mid;
        } else if (arr[mid] > key) {
            return binarySearchInsertionPosition(arr, key, left, mid - 1);
        } else {
            return binarySearchInsertionPosition(arr, key, mid + 1, right);
        }
    }

    public static void insertionSortDescending(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] < key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void insertionSortRange(int[] arr, int start, int end) {
        if (arr == null || start < 0 || end >= arr.length || start >= end) {
            return;
        }

        for (int i = start + 1; i <= end; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= start && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static boolean isSorted(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return true;
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static int findInsertionPosition(int[] sortedArr, int element) {
        int left = 0;
        int right = sortedArr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (sortedArr[mid] < element) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void shellSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int n = arr.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;

                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }

                arr[j] = temp;
            }
        }
    }

    public static void insertSorted(int[] arr, int element, int size) {
        if (arr == null || size < 0 || size >= arr.length) {
            return;
        }

        int i = size - 1;
        while (i >= 0 && arr[i] > element) {
            arr[i + 1] = arr[i];
            i--;
        }
        arr[i + 1] = element;
    }
}