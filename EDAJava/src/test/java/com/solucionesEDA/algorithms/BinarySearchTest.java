package com.solucionesEDA.algorithms;

import org.junit.Test;
import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void testBinarySearchIterativeFound() {
        int[] arr = {1, 3, 5, 7, 9, 11, 13};
        assertEquals(3, BinarySearch.binarySearchIterative(arr, 7));
        assertEquals(0, BinarySearch.binarySearchIterative(arr, 1));
        assertEquals(6, BinarySearch.binarySearchIterative(arr, 13));
    }

    @Test
    public void testBinarySearchIterativeNotFound() {
        int[] arr = {1, 3, 5, 7, 9, 11, 13};
        assertEquals(-1, BinarySearch.binarySearchIterative(arr, 4));
        assertEquals(-1, BinarySearch.binarySearchIterative(arr, 0));
        assertEquals(-1, BinarySearch.binarySearchIterative(arr, 15));
    }

    @Test
    public void testBinarySearchRecursiveFound() {
        int[] arr = {1, 3, 5, 7, 9, 11, 13};
        assertEquals(3, BinarySearch.binarySearchRecursive(arr, 7));
        assertEquals(0, BinarySearch.binarySearchRecursive(arr, 1));
        assertEquals(6, BinarySearch.binarySearchRecursive(arr, 13));
    }

    @Test
    public void testBinarySearchRecursiveNotFound() {
        int[] arr = {1, 3, 5, 7, 9, 11, 13};
        assertEquals(-1, BinarySearch.binarySearchRecursive(arr, 4));
        assertEquals(-1, BinarySearch.binarySearchRecursive(arr, 0));
        assertEquals(-1, BinarySearch.binarySearchRecursive(arr, 15));
    }

    @Test
    public void testBinarySearchGeneric() {
        String[] arr = {"apple", "banana", "cherry", "date", "elderberry"};
        assertEquals(2, BinarySearch.binarySearchGeneric(arr, "cherry"));
        assertEquals(-1, BinarySearch.binarySearchGeneric(arr, "grape"));
    }

    @Test
    public void testFindFirstOccurrence() {
        int[] arr = {1, 2, 2, 2, 3, 4, 5};
        assertEquals(1, BinarySearch.findFirstOccurrence(arr, 2));
        assertEquals(-1, BinarySearch.findFirstOccurrence(arr, 6));
    }

    @Test
    public void testFindLastOccurrence() {
        int[] arr = {1, 2, 2, 2, 3, 4, 5};
        assertEquals(3, BinarySearch.findLastOccurrence(arr, 2));
        assertEquals(-1, BinarySearch.findLastOccurrence(arr, 6));
    }

    @Test
    public void testEmptyArray() {
        int[] arr = {};
        assertEquals(-1, BinarySearch.binarySearchIterative(arr, 5));
        assertEquals(-1, BinarySearch.binarySearchRecursive(arr, 5));
    }

    @Test
    public void testSingleElement() {
        int[] arr = {5};
        assertEquals(0, BinarySearch.binarySearchIterative(arr, 5));
        assertEquals(-1, BinarySearch.binarySearchIterative(arr, 3));
    }
}