package com.company.ExamPrep.Exam12;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Lootbox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] queueInput = scanner.nextLine().split("\\s+");
        String[] stackInput = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> numQueue = new ArrayDeque<>();
        ArrayDeque<Integer> numStack = new ArrayDeque<>();

        fillQueue(queueInput, numQueue);
        fillStack(stackInput, numStack);

        int claimed = 0;

        while (!numQueue.isEmpty() && !numStack.isEmpty()) {

            int currQueue = numQueue.peek();
            int currStack = numStack.peek();
            int sum = currQueue + currStack;

            if (sum % 2 == 0) {
                claimed += sum;
                numQueue.poll();
                numStack.pop();
            } else {
                numStack.pop();
                numQueue.offer(currStack);
            }
        }

        if (numQueue.isEmpty()) {
            System.out.println("First lootbox is empty");
        }
        if (numStack.isEmpty()) {
            System.out.println("Second lootbox is empty");
        }

        if (claimed >= 100) {
            System.out.printf("Your loot was epic! Value: %d%n", claimed);
        } else {
            System.out.printf("Your loot was poor... Value: %d%n", claimed);
        }



    }

    private static void fillStack(String[] stackInput, ArrayDeque<Integer> numStack) {
        for (String el : stackInput) {
            numStack.push(Integer.parseInt(el));
        }
    }

    private static void fillQueue(String[] queueInput, ArrayDeque<Integer> numQueue) {
        for (String el : queueInput) {
            numQueue.offer(Integer.parseInt(el));
        }
    }
}
