package com.company.ExamPrep.Exam11;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] queueInput = scanner.nextLine().split(", ");
        String[] stackInput = scanner.nextLine().split(", ");

        ArrayDeque<Integer> effectsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> casingStack = new ArrayDeque<>();

        fillQueue(queueInput, effectsQueue);
        fillStack(stackInput, casingStack);

        Map<String, Integer> craftedMap = new TreeMap<>();
        craftedMap.put("Datura Bombs", 0);
        craftedMap.put("Cherry Bombs", 0);
        craftedMap.put("Smoke Decoy Bombs", 0);

        while (!effectsQueue.isEmpty() && !casingStack.isEmpty()) {

            int currEffect = effectsQueue.peek();
            int currCasing = casingStack.peek();
            int sum = currEffect + currCasing;

            switch (sum) {
                case 40:
                    craftedMap.put("Datura Bombs", craftedMap.get("Datura Bombs") + 1);
                    eraseTwoElements(effectsQueue, casingStack);
                    break;
                case 60:
                    craftedMap.put("Cherry Bombs", craftedMap.get("Cherry Bombs") + 1);
                    eraseTwoElements(effectsQueue, casingStack);
                    break;
                case 120:
                    craftedMap.put("Smoke Decoy Bombs", craftedMap.get("Smoke Decoy Bombs") + 1);
                    eraseTwoElements(effectsQueue, casingStack);
                    break;
                default:
                    casingStack.pop();
                  //  if (currCasing - 5 > 0) {
                        casingStack.push(currCasing - 5);
                   // }
                    break;
            }
            if (heWon(craftedMap)) {
                break;
            }
        }

        if (heWon(craftedMap)) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        printEffectsQueue(effectsQueue);

        printCasingStack(casingStack);

        craftedMap.forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });

    }

    private static void printCasingStack(ArrayDeque<Integer> casingStack) {
        if (!casingStack.isEmpty()) {
            System.out.printf("Bomb Casings: %s%n", casingStack.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        } else {
            System.out.println("Bomb Casings: empty");
        }
    }

    private static void printEffectsQueue(ArrayDeque<Integer> effectsQueue) {
        if (!effectsQueue.isEmpty()) {
            System.out.printf("Bomb Effects: %s%n", effectsQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        } else {
            System.out.println("Bomb Effects: empty");
        }
    }

    private static boolean heWon(Map<String, Integer> craftedMap) {
        return craftedMap.get("Datura Bombs") >= 3
                && craftedMap.get("Cherry Bombs") >= 3
                && craftedMap.get("Smoke Decoy Bombs") >= 3;
    }

    private static void eraseTwoElements(ArrayDeque<Integer> effectsQueue, ArrayDeque<Integer> casingStack) {
        effectsQueue.poll();
        casingStack.pop();
    }

    private static void fillQueue(String[] queueInput, ArrayDeque<Integer> effectsQueue) {
        for (String el : queueInput) {
            effectsQueue.offer(Integer.parseInt(el));
        }
    }

    private static void fillStack(String[] stackInput, ArrayDeque<Integer> casingStack) {
        for (String el : stackInput) {
            casingStack.push(Integer.parseInt(el));
        }
    }

}
