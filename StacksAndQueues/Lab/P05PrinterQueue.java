package com.company.StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P05PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> files = new ArrayDeque<>();
        String input = scanner.nextLine();
        while (!input.equals("print")) {
            if (input.equals("cancel")) {
                if (files.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    String removed = files.poll();
                    System.out.println("Canceled " + removed);
                }
            } else {
                files.offer(input);
            }
            input = scanner.nextLine();
        }
        for (String file : files) {
            System.out.println(file);
        }
    }
}
