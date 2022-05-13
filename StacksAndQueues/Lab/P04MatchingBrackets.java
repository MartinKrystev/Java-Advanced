package com.company.StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P04MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        //1 + (2 - (2 + 3) * 4 / (3 + 1)) * 5
        for (int i = 0; i < input.length(); i++) {
            char curr = input.charAt(i);
            if (curr == '(') {
                stack.push(i);
            } else if (curr == ')'){
                int startIndex = stack.pop();
                System.out.println(input.substring(startIndex, i + 1));
            }
        }
    }
}
