package com.company.ExamPrep.Exam1;

import java.util.*;

public class P01Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> steelQueue = new ArrayDeque<>();
        ArrayDeque<Integer> carbonStack = new ArrayDeque<>();

        String[] steelInput = scanner.nextLine().split("\\s+");
        String[] carbonInput = scanner.nextLine().split("\\s+");

        for (int i = 0; i < steelInput.length; i++) {
            steelQueue.offer(Integer.parseInt(steelInput[i]));
        }

        for (int i = 0; i < carbonInput.length; i++) {
            carbonStack.push(Integer.parseInt(carbonInput[i]));
        }

        Map<String, Integer> swords = new TreeMap<>();
        while (steelQueue.size() != 0 || carbonStack.size() != 0) {
            if (steelQueue.size() == 0 || carbonStack.size() == 0) {
                break;
            }
            int currSum = steelQueue.peek() + carbonStack.peek();
            if (currSum == 70) {
                swords.putIfAbsent("Gladius", 0);
                swords.put("Gladius", swords.get("Gladius") + 1);
                removeElements(steelQueue, carbonStack);
            } else if (currSum == 80) {
                swords.putIfAbsent("Shamshir", 0);
                swords.put("Shamshir", swords.get("Shamshir") + 1);
                removeElements(steelQueue, carbonStack);
            } else if (currSum == 90) {
                swords.putIfAbsent("Katana", 0);
                swords.put("Katana", swords.get("Katana") + 1);
                removeElements(steelQueue, carbonStack);
            } else if (currSum == 110) {
                swords.putIfAbsent("Sabre", 0);
                swords.put("Sabre", swords.get("Sabre") + 1);
                removeElements(steelQueue, carbonStack);
            } else {
                steelQueue.poll();
                int currCarbon = carbonStack.pop() + 5;
                carbonStack.push(currCarbon);
            }
        }

        if (swords.isEmpty()) {
            System.out.println("You did not have enough resources to forge a sword.");
            printSteel(steelQueue);
            printCarbon(carbonStack);
        } else {
            int sum = 0;
            for (Integer value : swords.values()) {
                sum += value;
            }
            System.out.printf("You have forged %d swords.%n", sum);
            printSteel(steelQueue);
            printCarbon(carbonStack);
            swords.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
        }
    }

    private static void printCarbon(ArrayDeque<Integer> carbonStack) {
        if (carbonStack.isEmpty()) {
            System.out.println("Carbon left: none");
        } else {
            System.out.print("Carbon left: ");
            while (!carbonStack.isEmpty()) {
                System.out.printf("%d", carbonStack.pop());
                if (!carbonStack.isEmpty()) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }

    private static void printSteel(ArrayDeque<Integer> steelQueue) {
        if (steelQueue.isEmpty()) {
            System.out.println("Steel left: none");
        } else {
            System.out.print("Steel left: ");
            while (!steelQueue.isEmpty()) {
                System.out.printf("%d", steelQueue.poll());
                if (!steelQueue.isEmpty()) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }

    private static void removeElements(ArrayDeque<Integer> steelQueue, ArrayDeque<Integer> carbonStack) {
        steelQueue.poll();
        carbonStack.pop();
    }
}
