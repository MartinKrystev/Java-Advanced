package com.company.ExamPrep.Exam13;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class P01SantasPresentFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] materialsInput = scanner.nextLine().split("\\s+");
        String[] magicInput = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> materialsStack = new ArrayDeque<>();
        ArrayDeque<Integer> magicQueue = new ArrayDeque<>();

        for (int i = 0; i < materialsInput.length; i++) {
            materialsStack.push(Integer.parseInt(materialsInput[i]));
        }

        for (int i = 0; i < magicInput.length; i++) {
            magicQueue.offer(Integer.parseInt(magicInput[i]));
        }

        Map<String, Integer> presentMap = new TreeMap<>();
        while (!materialsStack.isEmpty() || !magicQueue.isEmpty()) {

            if (materialsStack.size() <= 0 || magicQueue.size() <= 0) {
                break;
            }
            // Check if the element == 0
            if (materialsStack.peek() == 0) {
                materialsStack.pop();
                continue;
            }
            if (magicQueue.peek() == 0) {
                magicQueue.poll();
                continue;
            }

            int sum = materialsStack.peek() * magicQueue.peek();


            if (sum < 0) {
                int sumToAdd = magicQueue.poll() + materialsStack.pop();
                materialsStack.push(sumToAdd);
            } else {
                switch (sum) {
                    case 150:
                        addDoll(materialsStack, magicQueue, presentMap);
                        break;
                    case 250:
                        addWoodenTrain(materialsStack, magicQueue, presentMap);
                        break;
                    case 300:
                        addTeddyBear(materialsStack, magicQueue, presentMap);
                        break;
                    case 400:
                        addBicycle(materialsStack, magicQueue, presentMap);
                        break;
                    default:
                        noToyMade(materialsStack, magicQueue);
                        break;
                }
            }
        }

        if (presentMap.containsKey("Doll") && presentMap.containsKey("Wooden train")
                || presentMap.containsKey("Teddy bear") && presentMap.containsKey("Bicycle")) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }

        printMaterialsLeft(materialsStack);
        printMagicLeft(magicQueue);
        printCraftedPresents(presentMap);

    }

    private static void printCraftedPresents(Map<String, Integer> presentMap) {
        presentMap.entrySet().stream().filter(e -> e.getValue() > 0).forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));
    }

    private static void printMagicLeft(ArrayDeque<Integer> magicQueue) {
        if (!magicQueue.isEmpty()) {
            System.out.printf("Magic left: %s%n", magicQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
    }

    private static void printMaterialsLeft(ArrayDeque<Integer> materialsStack) {
        if (!materialsStack.isEmpty()) {
            System.out.printf("Materials left: %s%n", materialsStack.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
    }

    private static void noToyMade(ArrayDeque<Integer> materialsStack, ArrayDeque<Integer> magicQueue) {
        magicQueue.poll();
        int increasedElement = materialsStack.pop() + 15;
        materialsStack.push(increasedElement);
    }

    private static void addBicycle(ArrayDeque<Integer> materialsStack, ArrayDeque<Integer> magicQueue, Map<String, Integer> presentMap) {
        presentMap.putIfAbsent("Bicycle", 0);
        presentMap.put("Bicycle", presentMap.get("Bicycle") + 1);
        removeElements(materialsStack, magicQueue);
    }

    private static void addTeddyBear(ArrayDeque<Integer> materialsStack, ArrayDeque<Integer> magicQueue, Map<String, Integer> presentMap) {
        presentMap.putIfAbsent("Teddy bear", 0);
        presentMap.put("Teddy bear", presentMap.get("Teddy bear") + 1);
        removeElements(materialsStack, magicQueue);
    }

    private static void addWoodenTrain(ArrayDeque<Integer> materialsStack, ArrayDeque<Integer> magicQueue, Map<String, Integer> presentMap) {
        presentMap.putIfAbsent("Wooden train", 0);
        presentMap.put("Wooden train", presentMap.get("Wooden train") + 1);
        removeElements(materialsStack, magicQueue);
    }

    private static void addDoll(ArrayDeque<Integer> materialsStack, ArrayDeque<Integer> magicQueue, Map<String, Integer> presentMap) {
        presentMap.putIfAbsent("Doll", 0);
        presentMap.put("Doll", presentMap.get("Doll") + 1);
        removeElements(materialsStack, magicQueue);
    }

    private static void removeElements(ArrayDeque<Integer> materialsStack, ArrayDeque<Integer> magicQueue) {
        materialsStack.pop();
        magicQueue.poll();
    }
}
