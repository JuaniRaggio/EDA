package com.exactSearchIndexOf;

public class ExactSearch {

    // Naive algorithm
    public static int indexOfBruteForce(char[] query, char[] target) {
        int idxSource = 0;
        int idxTarget = 0;

        while (idxSource < query.length && idxTarget < target.length) {

        }

        return idxSource;
    }


    // Sin hacer un backtracking
    public static int[] nextComputation(char[] query) {
        int[] next = new int[query.length];
        int border = 0;
        int rec = 1;
        while (rec < query.length) {
            if (query[rec] != query[border]) {
                if (border != 0) {
                    border = next[border - 1];
                } else {
                    next[rec++] = 0;
                }
            } else {
                border++;
                next[rec] = border;
                rec++;
            }
        }
        return next;
    }
    
}

