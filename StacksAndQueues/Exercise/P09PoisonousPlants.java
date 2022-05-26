package com.company.StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P09PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] plantsArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> evenQueue = new ArrayDeque<>();
        ArrayDeque<Integer> oddQueue = new ArrayDeque<>();

        for (int i = plantsArr.length - 1; i >= 0; i--) {
            evenQueue.offer(plantsArr[i]);
        }

        int counter = 0;

        while (evenQueue.size() != oddQueue.size()) {
            int evenQueueFirst = evenQueue.size();
            int oddQueueFirst = oddQueue.size();
            boolean areEqual = false;

            if (counter % 2 == 0) {
                while (!evenQueue.isEmpty()) {
                    int currPlant = evenQueue.poll();
                    if (!evenQueue.isEmpty()) {
                        if (currPlant <= evenQueue.peek()) {
                            oddQueue.offer(currPlant);
                        }
                    } else {
                        oddQueue.offer(currPlant);
                    }
                }
                if (evenQueueFirst != oddQueue.size()) {
                    counter++;
                } else {
                    areEqual = true;
                }
            } else {
                while (!oddQueue.isEmpty()) {
                    int currPlant = oddQueue.poll();
                    if (!oddQueue.isEmpty()) {
                        if (currPlant <= oddQueue.peek()) {
                            evenQueue.offer(currPlant);
                        }
                    } else {
                        evenQueue.offer(currPlant);
                    }
                }
                if (oddQueueFirst != evenQueue.size()) {
                    counter++;
                } else {
                    areEqual = true;
                }
            }
            if (areEqual) {
                break;
            }
        }

        System.out.println(counter);
    }
}
