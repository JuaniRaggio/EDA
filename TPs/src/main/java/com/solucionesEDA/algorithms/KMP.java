package com.solucionesEDA.algorithms;

public class KMP {

    public static int search(String text, String pattern) {
        if (pattern.isEmpty()) {
            return 0;
        }

        int[] next = buildNext(pattern);
        int n = text.length();
        int m = pattern.length();
        int i = 0;
        int j = 0;

        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                if (j == m) {
                    return i - j;
                }
            } else if (j > 0) {
                j = next[j - 1];
            } else {
                i++;
            }
        }

        return -1;
    }

    public static int[] buildNext(String pattern) {
        int m = pattern.length();
        int[] next = new int[m];
        int length = 0;
        int i = 1;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                next[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = next[length - 1];
                } else {
                    next[i] = 0;
                    i++;
                }
            }
        }

        return next;
    }

    public static int[] buildNextAlternative(String pattern) {
        int m = pattern.length();
        int[] next = new int[m];

        if (m == 0) return next;

        next[0] = 0;

        for (int i = 1; i < m; i++) {
            int k = next[i - 1];

            while (k > 0 && pattern.charAt(k) != pattern.charAt(i)) {
                k = next[k - 1];
            }

            if (pattern.charAt(k) == pattern.charAt(i)) {
                k++;
            }

            next[i] = k;
        }

        return next;
    }

    public static int[] findAllOccurrences(String text, String pattern) {
        if (pattern.isEmpty()) {
            return new int[0];
        }

        int[] next = buildNext(pattern);
        int n = text.length();
        int m = pattern.length();
        int i = 0;
        int j = 0;
        int[] tempResults = new int[n];
        int count = 0;

        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                if (j == m) {
                    tempResults[count++] = i - j;
                    j = next[j - 1];
                }
            } else if (j > 0) {
                j = next[j - 1];
            } else {
                i++;
            }
        }

        int[] results = new int[count];
        System.arraycopy(tempResults, 0, results, 0, count);
        return results;
    }

    public static boolean contains(String text, String pattern) {
        return search(text, pattern) != -1;
    }

    public static int countOccurrences(String text, String pattern) {
        if (pattern.isEmpty()) {
            return 0;
        }

        int[] next = buildNext(pattern);
        int n = text.length();
        int m = pattern.length();
        int i = 0;
        int j = 0;
        int count = 0;

        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                if (j == m) {
                    count++;
                    j = next[j - 1];
                }
            } else if (j > 0) {
                j = next[j - 1];
            } else {
                i++;
            }
        }

        return count;
    }
}