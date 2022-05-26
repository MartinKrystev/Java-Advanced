package com.company.SetsAndMapsAdvanced.Lab;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<Integer> playerOne = readDeck(scanner.nextLine());
        LinkedHashSet<Integer> playerTwo = readDeck(scanner.nextLine());

        int rounds = 50;

        while (rounds-- > 0) {
            int firstCard = getFirst(playerOne);
            int secondCard = getFirst(playerTwo);

            playerOne.remove(firstCard);
            playerTwo.remove(secondCard);

            if (firstCard > secondCard) {
                playerOne.add(firstCard);
                playerOne.add(secondCard);
            } else if (secondCard > firstCard) {
                playerTwo.add(firstCard);
                playerTwo.add(secondCard);
            }

            if (playerOne.isEmpty() || playerTwo.isEmpty()) {
                break;
            }
        }

        if (playerOne.size() > playerTwo.size()) {
            System.out.println("First player win!");
        } else if (playerTwo.size() > playerOne.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }

    }

    public static int getFirst(LinkedHashSet<Integer> set) {
        for (Integer card : set) {
            return card;
        }
        return 0;
    }

    private static LinkedHashSet<Integer> readDeck(String line) {
        return Arrays.stream(line.split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
