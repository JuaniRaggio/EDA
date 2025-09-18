package com.solucionesEDA.algorithms;

public class Soundex {

    public static String encode(String word) {
        if (word == null || word.isEmpty()) {
            return "0000";
        }

        word = word.toUpperCase().replaceAll("[^A-Z]", "");
        if (word.isEmpty()) {
            return "0000";
        }

        StringBuilder soundex = new StringBuilder();
        soundex.append(word.charAt(0));

        String previousCode = getCode(word.charAt(0));

        for (int i = 1; i < word.length() && soundex.length() < 4; i++) {
            char currentChar = word.charAt(i);
            String currentCode = getCode(currentChar);

            if (!currentCode.equals("0") && !currentCode.equals(previousCode)) {
                soundex.append(currentCode);
            }

            if (!currentCode.equals("0")) {
                previousCode = currentCode;
            }
        }

        while (soundex.length() < 4) {
            soundex.append("0");
        }

        return soundex.toString();
    }

    private static String getCode(char c) {
        switch (c) {
            case 'B':
            case 'F':
            case 'P':
            case 'V':
                return "1";
            case 'C':
            case 'G':
            case 'J':
            case 'K':
            case 'Q':
            case 'S':
            case 'X':
            case 'Z':
                return "2";
            case 'D':
            case 'T':
                return "3";
            case 'L':
                return "4";
            case 'M':
            case 'N':
                return "5";
            case 'R':
                return "6";
            default:
                return "0";
        }
    }

    public static double similarity(String word1, String word2) {
        String soundex1 = encode(word1);
        String soundex2 = encode(word2);

        if (soundex1.equals(soundex2)) {
            return 1.0;
        }

        int matches = 0;
        for (int i = 0; i < 4; i++) {
            if (soundex1.charAt(i) == soundex2.charAt(i)) {
                matches++;
            }
        }

        return matches / 4.0;
    }

    public static boolean areSimilar(String word1, String word2) {
        return encode(word1).equals(encode(word2));
    }
}