package com.company.StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P05BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        //{[()]} YES     {[(])} NO     {{[[(())]]}} YES
        boolean isBalanced = true;

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (current == '{' || current == '[' || current == '(') {
                stack.push(current);
            } else {
                if (stack.isEmpty()) {
                    isBalanced = false;
                    break;
                }
                char topElement = stack.pop();
                if (current == '}' && topElement != '{') {
                    isBalanced = false;
                    break;
                } else if (current == ']' && topElement != '[') {
                    isBalanced = false;
                    break;
                } else if (current == ')' && topElement != '(') {
                    isBalanced = false;
                    break;
                }
            }
        }
        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
