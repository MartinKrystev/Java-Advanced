package com.company.StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P04BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nsx = scanner.nextLine().split(" ");
        String[] numbers = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> numsQueue = new ArrayDeque<>();

        int n = Integer.parseInt(nsx[0]);
        int s = Integer.parseInt(nsx[1]);
        int x = Integer.parseInt(nsx[2]);

        for (int i = 0; i < n; i++) {
            numsQueue.add(Integer.parseInt(numbers[i]));
        }

        for (int i = 0; i < s; i++) {
            numsQueue.poll();
        }

        if (numsQueue.isEmpty()) {
            System.out.println(0);
        } else {
            boolean exist = false;
            for (Integer integer : numsQueue) {
                if (integer == x) {
                    System.out.println("true");
                    exist = true;
                }
            }
            if (!exist) {
                int smallestNumber = numsQueue.poll();
                while (!numsQueue.isEmpty()) {
                    int currNumber = numsQueue.poll();
                    if (currNumber < smallestNumber) {
                        smallestNumber = currNumber;
                    }
                }
                System.out.println(smallestNumber);
            }
        }


    }
}
