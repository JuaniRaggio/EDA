package com.solucionesEDA.algorithms;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;

public class QuickSortTest {

    @Test
    public void testQuickSortFirstPivot() {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        int[] expected = {11, 12, 22, 25, 34, 64, 90};
        QuickSort.quickSortFirstPivot(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testQuickSortRandomPivot() {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        int[] expected = {11, 12, 22, 25, 34, 64, 90};
        QuickSort.quickSortRandomPivot(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testQuickSortMedianOfThree() {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        int[] expected = {11, 12, 22, 25, 34, 64, 90};
        QuickSort.quickSortMedianOfThree(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testQuickSortHoare() {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        int[] expected = {11, 12, 22, 25, 34, 64, 90};
        QuickSort.quickSortHoare(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testQuickSortGeneric() {
        String[] arr = {"banana", "apple", "cherry", "date"};
        String[] expected = {"apple", "banana", "cherry", "date"};
        QuickSort.quickSortGeneric(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testEmptyArray() {
        int[] arr = {};
        QuickSort.quickSortFirstPivot(arr);
        assertEquals(0, arr.length);
    }

    @Test
    public void testSingleElement() {
        int[] arr = {42};
        int[] expected = {42};
        QuickSort.quickSortFirstPivot(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testAlreadySorted() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        QuickSort.quickSortFirstPivot(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testReverseSorted() {
        int[] arr = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};
        QuickSort.quickSortFirstPivot(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testDuplicates() {
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3};
        int[] expected = {1, 1, 2, 3, 3, 4, 5, 5, 6, 9};
        QuickSort.quickSortFirstPivot(arr);
        assertArrayEquals(expected, arr);
    }
}