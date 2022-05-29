package com.company.StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P08InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        ArrayDeque<String> operatorsStack = new ArrayDeque<>();
        ArrayDeque<String> expressionQueue = new ArrayDeque<>();

        Map<String, Integer> priorities = new HashMap<>();
        priorities.put("*", 3);
        priorities.put("/", 3);
        priorities.put("+", 2);
        priorities.put("-", 2);
        priorities.put("(", 1);

        for (String anInput : input) {
            try {
                double num = Double.parseDouble(anInput);
                expressionQueue.offer(anInput);
            } catch (Exception e) {
                switch (anInput) {
                    case "x":
                        expressionQueue.offer(anInput);
                        break;
                    case "(":
                        operatorsStack.push(anInput);
                        break;
                    case ")":
                        String symbol = operatorsStack.pop();
                        while (!symbol.equals("(")) {
                            expressionQueue.offer(symbol);
                            symbol = operatorsStack.pop();
                        }
                        break;
                    default:
                        while (!operatorsStack.isEmpty() && priorities.get(operatorsStack.peek()) >= priorities.get(anInput)) {
                            expressionQueue.addLast(operatorsStack.pop());
                        }
                        operatorsStack.push(anInput);
                        break;
                }
            }
        }
        while (!operatorsStack.isEmpty()) {
            expressionQueue.offer(operatorsStack.pop());
        }

        while (expressionQueue.size() > 0) {
            System.out.print(expressionQueue.pop() + " ");
        }
    }
}