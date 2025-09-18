package com.solucionesEDA.algorithms;

import org.junit.Test;
import static org.junit.Assert.*;

public class LevenshteinDistanceTest {

    @Test
    public void testBasicDistance() {
        assertEquals(0, LevenshteinDistance.distance("", ""));
        assertEquals(3, LevenshteinDistance.distance("", "abc"));
        assertEquals(3, LevenshteinDistance.distance("abc", ""));
        assertEquals(0, LevenshteinDistance.distance("abc", "abc"));
    }

    @Test
    public void testExampleFromTheory() {
        assertEquals(1, LevenshteinDistance.distance("big data", "bigdata"));
        assertEquals(6, LevenshteinDistance.distance("exkusa", "ex-amigo"));
    }

    @Test
    public void testDistanceSpaceOptimized() {
        assertEquals(1, LevenshteinDistance.distanceSpaceOptimized("big data", "bigdata"));
        assertEquals(6, LevenshteinDistance.distanceSpaceOptimized("exkusa", "ex-amigo"));
        assertEquals(3, LevenshteinDistance.distanceSpaceOptimized("kitten", "sitting"));
    }

    @Test
    public void testNormalizedDistance() {
        double normalized = LevenshteinDistance.normalizedDistance("kitten", "sitting");
        assertEquals(3.0 / 7.0, normalized, 0.001);
    }

    @Test
    public void testSimilarity() {
        double similarity = LevenshteinDistance.similarity("kitten", "sitting");
        assertEquals(1.0 - (3.0 / 7.0), similarity, 0.001);
    }

    @Test
    public void testIsWithinThreshold() {
        assertTrue(LevenshteinDistance.isWithinThreshold("kitten", "sitting", 3));
        assertFalse(LevenshteinDistance.isWithinThreshold("kitten", "sitting", 2));
    }

    @Test
    public void testRestrictedDistance() {
        assertEquals(3, LevenshteinDistance.restrictedDistance("kitten", "sitting", 5));
        assertEquals(3, LevenshteinDistance.restrictedDistance("kitten", "sitting", 3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullInput() {
        LevenshteinDistance.distance(null, "test");
    }

    @Test
    public void testIdenticalStrings() {
        assertEquals(0, LevenshteinDistance.distance("hello", "hello"));
        assertEquals(0, LevenshteinDistance.distanceSpaceOptimized("hello", "hello"));
    }

    @Test
    public void testCompletelyDifferentStrings() {
        assertEquals(5, LevenshteinDistance.distance("abcde", "fghij"));
    }
}