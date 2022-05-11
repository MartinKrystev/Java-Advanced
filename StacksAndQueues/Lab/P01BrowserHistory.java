package com.company.StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P01BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> browser = new ArrayDeque<>();
        String currPage = "";

        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (browser.size() > 1) {
                    browser.pop();
                    currPage = browser.peek();
                    System.out.println(currPage);
                } else {
                    System.out.println("no previous URLs");
                }
            } else {
                browser.push(input);
                currPage = browser.peek();
                System.out.println(currPage);
            }
            input = scanner.nextLine();
        }
    }
}
