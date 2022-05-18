package com.company.StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P08BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<String> backStack = new ArrayDeque<>();
        ArrayDeque<String> forwardQueue = new ArrayDeque<>();
        String currPage = "";

        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (backStack.size() >= 2) { // защо 2 ??? - и защо не работи с ifEmpty?
                    currPage = backStack.pop();
                    forwardQueue.push(currPage);
                    System.out.println(backStack.peek());
                } else {
                    System.out.println("no previous URLs");
                }
            } else if (input.equals("forward")) {
                if (!forwardQueue.isEmpty()) {
                    currPage = forwardQueue.pop();
                    backStack.push(currPage);
                    System.out.println(currPage);
                } else {
                    System.out.println("no next URLs");
                }
            } else {
                backStack.push(input);
                System.out.println(input);
                forwardQueue.clear();
            }
            input = scanner.nextLine();
        }

    }
}
