package com.company.StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P06HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> kidsQueue = new ArrayDeque<>();
        String[] players = scanner.nextLine().split(" ");
        int turns = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < players.length; i++) {
            kidsQueue.offer(players[i]);
        }

        while (kidsQueue.size() > 1) {
            for (int i = 1; i < turns; i++) {
                String currChild = kidsQueue.poll();
                kidsQueue.offer(currChild);
            }
            String kidToRemove = kidsQueue.poll();
            System.out.println("Removed " + kidToRemove);
        }
        System.out.println("Last is " + kidsQueue.peek());
    }
}
