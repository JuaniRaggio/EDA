package com.solucionesEDA.algorithms;

import java.util.*;

public class QGrams {

    public static Set<String> generateQGrams(String text, int q) {
        if (text == null || text.length() < q || q <= 0) {
            return new HashSet<>();
        }

        Set<String> qgrams = new HashSet<>();
        for (int i = 0; i <= text.length() - q; i++) {
            qgrams.add(text.substring(i, i + q));
        }
        return qgrams;
    }

    public static Map<String, Integer> generateQGramFrequencies(String text, int q) {
        if (text == null || text.length() < q || q <= 0) {
            return new HashMap<>();
        }

        Map<String, Integer> frequencies = new HashMap<>();
        for (int i = 0; i <= text.length() - q; i++) {
            String qgram = text.substring(i, i + q);
            frequencies.put(qgram, frequencies.getOrDefault(qgram, 0) + 1);
        }
        return frequencies;
    }

    public static double jaccardSimilarity(String text1, String text2, int q) {
        Set<String> qgrams1 = generateQGrams(text1, q);
        Set<String> qgrams2 = generateQGrams(text2, q);

        if (qgrams1.isEmpty() && qgrams2.isEmpty()) {
            return 1.0;
        }

        Set<String> intersection = new HashSet<>(qgrams1);
        intersection.retainAll(qgrams2);

        Set<String> union = new HashSet<>(qgrams1);
        union.addAll(qgrams2);

        return (double) intersection.size() / union.size();
    }

    public static double diceSimilarity(String text1, String text2, int q) {
        Set<String> qgrams1 = generateQGrams(text1, q);
        Set<String> qgrams2 = generateQGrams(text2, q);

        if (qgrams1.isEmpty() && qgrams2.isEmpty()) {
            return 1.0;
        }

        Set<String> intersection = new HashSet<>(qgrams1);
        intersection.retainAll(qgrams2);

        return (2.0 * intersection.size()) / (qgrams1.size() + qgrams2.size());
    }

    public static double cosineSimilarity(String text1, String text2, int q) {
        Map<String, Integer> freq1 = generateQGramFrequencies(text1, q);
        Map<String, Integer> freq2 = generateQGramFrequencies(text2, q);

        if (freq1.isEmpty() && freq2.isEmpty()) {
            return 1.0;
        }

        Set<String> allQGrams = new HashSet<>(freq1.keySet());
        allQGrams.addAll(freq2.keySet());

        double dotProduct = 0.0;
        double norm1 = 0.0;
        double norm2 = 0.0;

        for (String qgram : allQGrams) {
            int count1 = freq1.getOrDefault(qgram, 0);
            int count2 = freq2.getOrDefault(qgram, 0);

            dotProduct += count1 * count2;
            norm1 += count1 * count1;
            norm2 += count2 * count2;
        }

        if (norm1 == 0.0 || norm2 == 0.0) {
            return 0.0;
        }

        return dotProduct / (Math.sqrt(norm1) * Math.sqrt(norm2));
    }

    public static double overlapCoefficient(String text1, String text2, int q) {
        Set<String> qgrams1 = generateQGrams(text1, q);
        Set<String> qgrams2 = generateQGrams(text2, q);

        if (qgrams1.isEmpty() && qgrams2.isEmpty()) {
            return 1.0;
        }

        Set<String> intersection = new HashSet<>(qgrams1);
        intersection.retainAll(qgrams2);

        int minSize = Math.min(qgrams1.size(), qgrams2.size());
        if (minSize == 0) {
            return 0.0;
        }

        return (double) intersection.size() / minSize;
    }

    public static List<String> findSimilarStrings(String query, List<String> candidates, int q, double threshold) {
        List<String> similar = new ArrayList<>();
        for (String candidate : candidates) {
            double similarity = jaccardSimilarity(query, candidate, q);
            if (similarity >= threshold) {
                similar.add(candidate);
            }
        }
        return similar;
    }

    public static int distance(String text1, String text2, int q) {
        Set<String> qgrams1 = generateQGrams(text1, q);
        Set<String> qgrams2 = generateQGrams(text2, q);

        Set<String> union = new HashSet<>(qgrams1);
        union.addAll(qgrams2);

        Set<String> intersection = new HashSet<>(qgrams1);
        intersection.retainAll(qgrams2);

        return union.size() - intersection.size();
    }
}