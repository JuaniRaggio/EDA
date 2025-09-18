package com.solucionesEDA.algorithms;

import org.junit.Test;
import static org.junit.Assert.*;

public class KMPTest {

    @Test
    public void testKMPSearch() {
        assertEquals(0, KMP.search("ABRACADABRA", "ABRA"));
        assertEquals(-1, KMP.search("ABRACADABRA", "XYZ"));
        assertEquals(0, KMP.search("AABAACAADAABAAABAA", "AABA"));
    }

    @Test
    public void testBuildNext() {
        int[] expected1 = {0, 0, 0, 1};
        assertArrayEquals(expected1, KMP.buildNext("ABRA"));

        int[] expected2 = {0, 0, 0, 1, 0, 1, 0, 1, 2, 3, 4};
        assertArrayEquals(expected2, KMP.buildNext("ABRACADABRA"));

        int[] expected3 = {0, 0, 1};
        assertArrayEquals(expected3, KMP.buildNext("ABA"));
    }

    @Test
    public void testFindAllOccurrences() {
        int[] occurrences = KMP.findAllOccurrences("ABRACADABRA", "ABRA");
        assertArrayEquals(new int[]{0, 7}, occurrences);

        int[] occurrences2 = KMP.findAllOccurrences("AAAA", "AA");
        assertArrayEquals(new int[]{0, 1, 2}, occurrences2);
    }

    @Test
    public void testContains() {
        assertTrue(KMP.contains("ABRACADABRA", "ABRA"));
        assertFalse(KMP.contains("ABRACADABRA", "XYZ"));
        assertTrue(KMP.contains("Hello World", "World"));
    }

    @Test
    public void testCountOccurrences() {
        assertEquals(2, KMP.countOccurrences("ABRACADABRA", "ABRA"));
        assertEquals(0, KMP.countOccurrences("ABRACADABRA", "XYZ"));
        assertEquals(3, KMP.countOccurrences("AAAA", "AA"));
    }

    @Test
    public void testEmptyPattern() {
        assertEquals(0, KMP.search("ABRACADABRA", ""));
        assertArrayEquals(new int[0], KMP.findAllOccurrences("ABRACADABRA", ""));
        assertEquals(0, KMP.countOccurrences("ABRACADABRA", ""));
    }

    @Test
    public void testEmptyText() {
        assertEquals(-1, KMP.search("", "ABRA"));
        assertArrayEquals(new int[0], KMP.findAllOccurrences("", "ABRA"));
        assertEquals(0, KMP.countOccurrences("", "ABRA"));
    }
}