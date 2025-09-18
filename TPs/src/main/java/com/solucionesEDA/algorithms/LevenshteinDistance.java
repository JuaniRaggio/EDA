package com.solucionesEDA.algorithms;

public class LevenshteinDistance {

    public static int distance(String s1, String s2) {
        if (s1 == null || s2 == null) {
            throw new IllegalArgumentException("Strings cannot be null");
        }

        int m = s1.length();
        int n = s2.length();

        if (m == 0) return n;
        if (n == 0) return m;

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int cost = (s1.charAt(i - 1) == s2.charAt(j - 1)) ? 0 : 1;

                dp[i][j] = Math.min(
                    Math.min(
                        dp[i - 1][j] + 1,     // deletion
                        dp[i][j - 1] + 1      // insertion
                    ),
                    dp[i - 1][j - 1] + cost   // substitution
                );
            }
        }

        return dp[m][n];
    }

    public static int distanceSpaceOptimized(String s1, String s2) {
        if (s1 == null || s2 == null) {
            throw new IllegalArgumentException("Strings cannot be null");
        }

        int m = s1.length();
        int n = s2.length();

        if (m == 0) return n;
        if (n == 0) return m;

        if (m < n) {
            String temp = s1;
            s1 = s2;
            s2 = temp;
            int tempLen = m;
            m = n;
            n = tempLen;
        }

        int[] previousRow = new int[n + 1];
        int[] currentRow = new int[n + 1];

        for (int j = 0; j <= n; j++) {
            previousRow[j] = j;
        }

        for (int i = 1; i <= m; i++) {
            currentRow[0] = i;

            for (int j = 1; j <= n; j++) {
                int cost = (s1.charAt(i - 1) == s2.charAt(j - 1)) ? 0 : 1;

                currentRow[j] = Math.min(
                    Math.min(
                        previousRow[j] + 1,           // deletion
                        currentRow[j - 1] + 1         // insertion
                    ),
                    previousRow[j - 1] + cost         // substitution
                );
            }

            int[] temp = previousRow;
            previousRow = currentRow;
            currentRow = temp;
        }

        return previousRow[n];
    }

    public static double normalizedDistance(String s1, String s2) {
        int distance = distance(s1, s2);
        int maxLength = Math.max(s1.length(), s2.length());
        return maxLength == 0 ? 0.0 : (double) distance / maxLength;
    }

    public static double similarity(String s1, String s2) {
        return 1.0 - normalizedDistance(s1, s2);
    }

    public static String[][] getAlignmentMatrix(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int cost = (s1.charAt(i - 1) == s2.charAt(j - 1)) ? 0 : 1;

                dp[i][j] = Math.min(
                    Math.min(
                        dp[i - 1][j] + 1,
                        dp[i][j - 1] + 1
                    ),
                    dp[i - 1][j - 1] + cost
                );
            }
        }

        String[][] result = new String[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                result[i][j] = String.valueOf(dp[i][j]);
            }
        }

        return result;
    }

    public static boolean isWithinThreshold(String s1, String s2, int threshold) {
        return distance(s1, s2) <= threshold;
    }

    public static int restrictedDistance(String s1, String s2, int maxDistance) {
        if (Math.abs(s1.length() - s2.length()) > maxDistance) {
            return maxDistance + 1;
        }

        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            boolean hasValidCell = false;
            for (int j = Math.max(1, i - maxDistance); j <= Math.min(n, i + maxDistance); j++) {
                int cost = (s1.charAt(i - 1) == s2.charAt(j - 1)) ? 0 : 1;

                dp[i][j] = Math.min(
                    Math.min(
                        dp[i - 1][j] + 1,
                        dp[i][j - 1] + 1
                    ),
                    dp[i - 1][j - 1] + cost
                );

                if (dp[i][j] <= maxDistance) {
                    hasValidCell = true;
                }
            }

            if (!hasValidCell) {
                return maxDistance + 1;
            }
        }

        return dp[m][n] <= maxDistance ? dp[m][n] : maxDistance + 1;
    }
}