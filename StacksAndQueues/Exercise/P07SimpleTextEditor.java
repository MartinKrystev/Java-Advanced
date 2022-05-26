package com.company.StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P07SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cycles = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < cycles; i++) {
            String input = scanner.nextLine();
            String commandNum = input.split("\\s+")[0];

            switch (commandNum) {
                case "1": //1 {string}" - appends [string] to the end of the text
                    String textToAdd = input.split("\\s+")[1];
                    sb.append(textToAdd);
                    stack.push(sb.toString());
                    break;
                case "2": //2 {count}" - erases the last [count] elements from the text.
                    int count = Integer.parseInt(input.split("\\s+")[1]);
                    int startIndex = sb.length() - count;
                    sb.delete(startIndex, startIndex + count);
                    stack.push(sb.toString());
                    break;
                case "3": //3 {index}" - returns the element at position [index] from the text.
                    int index = Integer.parseInt(input.split("\\s+")[1]);
                    System.out.println(sb.charAt(index - 1));
                    break;
                case "4":
                    //4" - undoes the last not-undone commandNum of type 1 or 2 and returns the text to the state before that operation.
                    if (stack.size() > 1) {
                        stack.pop();
                        sb = new StringBuilder(stack.peek());
                    } else {
                        sb = new StringBuilder();
                    }
                    break;
            }
        }

    }
}
