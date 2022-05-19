package com.company.StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P01ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split(" ");
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (String number : numbers) {
            stack.push(number);
        }

        for (String s : stack) {
            System.out.print(s + " ");
        }

    }
}
