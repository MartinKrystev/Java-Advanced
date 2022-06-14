package com.company.ExamPrep.Exam2;

import java.util.*;

public class P01FoodFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] vowelsInput = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
        char[] consonantsInput = scanner.nextLine().replaceAll("\\s+", "").toCharArray();

        ArrayDeque<Character> vowelsQueue = new ArrayDeque<>();
        for (Character v : vowelsInput) {
            vowelsQueue.offer(v);
        }

        ArrayDeque<Character> consonantsStack = new ArrayDeque<>();
        for (char c : consonantsInput) {
            consonantsStack.push(c);
        }

        Set<Character> matched = new HashSet<>();
        while (!consonantsStack.isEmpty()) {
            if (!vowelsQueue.isEmpty()) {
                char currVowel = vowelsQueue.poll();
                if (checkIfVowelMatch(currVowel)) {
                    matched.add(currVowel);
                }
                vowelsQueue.offer(currVowel);
            }
            char currConsonant = consonantsStack.pop();
            if (checkIfConsonantMatch(currConsonant)) {
                matched.add(currConsonant);
            }
        }

        int wordCounter = 0;
        Set<String> formedWords = new LinkedHashSet<>();

        if (checkPear(matched)) {
            wordCounter++;
            formedWords.add("pear");
        }
        if (checkFlour(matched)) {
            wordCounter++;
            formedWords.add("flour");
        }
        if (checkPork(matched)) {
            wordCounter++;
            formedWords.add("pork");
        }
        if (checkOlive(matched)) {
            wordCounter++;
            formedWords.add("olive");
        }

        System.out.printf("Words found: %d%n", wordCounter);
        for (String word : formedWords) {
            System.out.println(word);
        }
    }

    private static boolean checkOlive(Set<Character> matched) {
        String word = "olive";
        for (int i = 0; i < word.length(); i++) {
            if (!matched.contains(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkPork(Set<Character> matched) {
        String word = "pork";
        for (int i = 0; i < word.length(); i++) {
            if (!matched.contains(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkFlour(Set<Character> matched) {
        String word = "flour";
        for (int i = 0; i < word.length(); i++) {
            if (!matched.contains(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkPear(Set<Character> matched) {
        String word = "pear";
        for (int i = 0; i < word.length(); i++) {
            if (!matched.contains(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkIfConsonantMatch(char currConsonant) {
        if (currConsonant == 'p' || currConsonant == 'r' || currConsonant == 'f' || currConsonant == 'l'
                || currConsonant == 'k' || currConsonant == 'v') {
            return true;
        }
        return false;
    }

    private static boolean checkIfVowelMatch(char currVowel) {
        if (currVowel == 'e' || currVowel == 'a' || currVowel == 'o' || currVowel == 'u' || currVowel == 'i') {
            return true;
        }
        return false;
    }
}
