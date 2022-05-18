package com.company.StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P07MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> kidsQueue = new ArrayDeque<>();
        String[] players = scanner.nextLine().split(" ");
        int turns = Integer.parseInt(scanner.nextLine());
        int cycle = 0;
        for (int i = 0; i < players.length; i++) {
            kidsQueue.offer(players[i]);
        }

        while (kidsQueue.size() > 1) {
            cycle += 1;
            for (int i = 1; i < turns; i++) {
                String currChild = kidsQueue.poll();
                kidsQueue.offer(currChild);
            }
            if (isPrime(cycle)) {
                System.out.println("Prime " + kidsQueue.peek());
            } else {
                String kidToRemove = kidsQueue.poll();
                System.out.println("Removed " + kidToRemove);
            }
        }
        System.out.println("Last is " + kidsQueue.peek());
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        } else if (n == 2) {
            return true;
        } else if (n % 2 == 0) {
            return false;
        } else {
            for (int i = 3; i <= Math.sqrt(n); i += 2) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
