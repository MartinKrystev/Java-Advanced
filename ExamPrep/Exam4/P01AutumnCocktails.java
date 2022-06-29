package com.company.ExamPrep.Exam4;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P01AutumnCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> ingredientsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> freshnessStack = new ArrayDeque<>();

        String[] ingredientsInput = scanner.nextLine().split("\\s+");
        String[] freshnessInput = scanner.nextLine().split("\\s+");

        fillQueue(ingredientsQueue, ingredientsInput);
        fillStack(freshnessStack, freshnessInput);

        Map<String, Integer> cocktails = new TreeMap<>();
        while (!ingredientsQueue.isEmpty() || !freshnessStack.isEmpty()) {
            if (ingredientsQueue.size() <= 0 || freshnessStack.size() <= 0) {
                break;
            }

            if (ingredientsQueue.peek() == 0) {
                ingredientsQueue.poll();
                continue;
            }

            int currSum = ingredientsQueue.peek() * freshnessStack.peek();

            switch (currSum) {
                case 150:
                    addPearSour(ingredientsQueue, freshnessStack, cocktails);
                    break;
                case 250:
                    addTheHarvest(ingredientsQueue, freshnessStack, cocktails);
                    break;
                case 300:
                    addAppleHinny(ingredientsQueue, freshnessStack, cocktails);
                    break;
                case 400:
                    addHighFashion(ingredientsQueue, freshnessStack, cocktails);
                    break;
                default:
                    noCocktailMade(ingredientsQueue, freshnessStack);
                    break;
            }
        }

        printPartyOrNot(cocktails);
        printIfAnyIngredients(ingredientsQueue);
        printCocktails(cocktails);

    }

    private static void noCocktailMade(ArrayDeque<Integer> ingredientsQueue, ArrayDeque<Integer> freshnessStack) {
        freshnessStack.pop();
        int increasedElement = ingredientsQueue.poll() + 5;
        ingredientsQueue.offer(increasedElement);
    }

    private static void addHighFashion(ArrayDeque<Integer> ingredientsQueue, ArrayDeque<Integer> freshnessStack, Map<String, Integer> cocktails) {
        cocktails.putIfAbsent("High Fashion", 0);
        cocktails.put("High Fashion", cocktails.get("High Fashion") + 1);
        removeElements(ingredientsQueue, freshnessStack);
    }

    private static void addAppleHinny(ArrayDeque<Integer> ingredientsQueue, ArrayDeque<Integer> freshnessStack, Map<String, Integer> cocktails) {
        cocktails.putIfAbsent("Apple Hinny", 0);
        cocktails.put("Apple Hinny", cocktails.get("Apple Hinny") + 1);
        removeElements(ingredientsQueue, freshnessStack);
    }

    private static void addTheHarvest(ArrayDeque<Integer> ingredientsQueue, ArrayDeque<Integer> freshnessStack, Map<String, Integer> cocktails) {
        cocktails.putIfAbsent("The Harvest", 0);
        cocktails.put("The Harvest", cocktails.get("The Harvest") + 1);
        removeElements(ingredientsQueue, freshnessStack);
    }

    private static void addPearSour(ArrayDeque<Integer> ingredientsQueue, ArrayDeque<Integer> freshnessStack, Map<String, Integer> cocktails) {
        cocktails.putIfAbsent("Pear Sour", 0);
        cocktails.put("Pear Sour", cocktails.get("Pear Sour") + 1);
        removeElements(ingredientsQueue, freshnessStack);
    }

    private static void printCocktails(Map<String, Integer> cocktails) {
        if (!cocktails.isEmpty()) {
            cocktails.forEach((key, value) -> System.out.printf(" # %s --> %d%n", key, value));
        }
    }

    private static void printIfAnyIngredients(ArrayDeque<Integer> ingredientsQueue) {
        if (!ingredientsQueue.isEmpty()) {
            int ingredientSum = 0;
            for (Integer el : ingredientsQueue) {
                ingredientSum += el;
            }
            System.out.println("Ingredients left: " + ingredientSum);
        }
    }

    private static void printPartyOrNot(Map<String, Integer> cocktails) {
        if (cocktails.size() < 4) {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        } else {
            System.out.println("It's party time! The cocktails are ready!");
        }
    }

    private static void removeElements(ArrayDeque<Integer> ingredientsQueue, ArrayDeque<Integer> freshnessStack) {
        ingredientsQueue.poll();
        freshnessStack.pop();
    }

    private static void fillStack(ArrayDeque<Integer> freshnessStack, String[] freshnessInput) {
        for (int i = 0; i < freshnessInput.length; i++) {
            freshnessStack.push(Integer.parseInt(freshnessInput[i]));
        }
    }

    private static void fillQueue(ArrayDeque<Integer> ingredientsQueue, String[] ingredientsInput) {
        for (int i = 0; i < ingredientsInput.length; i++) {
            ingredientsQueue.offer(Integer.parseInt(ingredientsInput[i]));
        }
    }
}
