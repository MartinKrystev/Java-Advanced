package com.company.SetsAndMapsAdvanced.Exercise;

import java.util.*;

public class P07HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> pokerMap = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.endsWith("JOKER")) {
            String name = input.split(":\\s+")[0];
            String[] cards = input.split(":\\s+")[1].split(", ");

            Set<String> currCards = new HashSet<>();
            Collections.addAll(currCards, cards);

            if (!pokerMap.containsKey(name)) {
                pokerMap.put(name, currCards);
            } else {
                Set<String> drawingCards = pokerMap.get(name);
                drawingCards.addAll(currCards);
                pokerMap.put(name, drawingCards);
            }
            input = scanner.nextLine();
        }

        for (Map.Entry<String, Set<String>> entry : pokerMap.entrySet()) {
            int totalPoints = getCardPoints(entry.getValue());
            System.out.println(entry.getKey() + ": " + totalPoints);
        }

    }

    private static int getCardPoints(Set<String> cards) {
        int sum = 0;
        Map<Character, Integer> pointsValues = getPointsValues();
        for (String card : cards) {
            int points = 0;
            if (card.contains("10")) {
                char strength = card.charAt(2);
                points = 10 * pointsValues.get(strength);
            } else {
                char number = card.charAt(0);
                char strength = card.charAt(1);
                points = pointsValues.get(number) * pointsValues.get(strength);
            }
            sum += points;
        }
        return sum;
    }

    private static Map<Character, Integer> getPointsValues() {
        Map<Character, Integer> points = new HashMap<>();
        points.put('1', 1);
        points.put('2', 2);
        points.put('3', 3);
        points.put('4', 4);
        points.put('5', 5);
        points.put('6', 6);
        points.put('7', 7);
        points.put('8', 8);
        points.put('9', 9);
        points.put('J', 11);
        points.put('Q', 12);
        points.put('K', 13);
        points.put('A', 14);
        points.put('S', 4);
        points.put('H', 3);
        points.put('D', 2);
        points.put('C', 1);

        return points;
    }
}
