package com.company.StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P03MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int cycles = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < cycles; i++) {
            String command = scanner.nextLine();

            if (command.equals("2")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (command.equals("3")) {
                int maxElement = 0;
                for (Integer integer : stack) {
                    if (integer > maxElement) {
                        maxElement = integer;
                    }
                }
                System.out.println(maxElement);
            } else {
                String[] pushCommand = command.split(" ");
                int element = Integer.parseInt(pushCommand[1]);
                stack.push(element);
            }
        }
    }
}
