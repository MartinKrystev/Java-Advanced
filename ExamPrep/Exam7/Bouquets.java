package com.company.ExamPrep.Exam7;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tulipsInput = scanner.nextLine().split(", ");
        String[] daffodilsInput = scanner.nextLine().split(", ");

        ArrayDeque<Integer> tulipsStack = new ArrayDeque<>();
        ArrayDeque<Integer> daffodilsQueue = new ArrayDeque<>();

        fillStack(tulipsInput, tulipsStack);
        fillQueue(daffodilsInput, daffodilsQueue);

        int bouquets = 0;
        int flowers = 0;


        while (!daffodilsQueue.isEmpty() && !tulipsStack.isEmpty()) {

            int currQueue = daffodilsQueue.peek();
            int currStack = tulipsStack.peek();
            int sum = currQueue + currStack;

            if (sum == 15) {
                daffodilsQueue.poll();
                tulipsStack.pop();
                bouquets++;
            } else if (sum > 15) {
                Integer stackToRemove = tulipsStack.pop() - 2;
                tulipsStack.push(stackToRemove);
            } else {
                flowers += currQueue + currStack;
                daffodilsQueue.poll();
                tulipsStack.pop();
            }

            if (bouquets >= 5) {
                break;
            }
        }

        int bouquetsFromFlowers = flowers / 15;
        bouquets += bouquetsFromFlowers;

        if (bouquets >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!%n", bouquets);
        } else {
            System.out.printf("You failed... You need more %d bouquets.%n", 5 - bouquets);
        }




    }

    private static void fillStack(String[] tulipsInput, ArrayDeque<Integer> tulipsStack) {
        for (String s : tulipsInput) {
            tulipsStack.push(Integer.parseInt(s));
        }
    }

    private static void fillQueue(String[] daffodilsInput, ArrayDeque<Integer> daffodilsQueue) {
        for (String s : daffodilsInput) {
            daffodilsQueue.offer(Integer.parseInt(s));
        }
    }
}
