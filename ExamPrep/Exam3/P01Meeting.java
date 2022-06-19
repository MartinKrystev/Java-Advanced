package com.company.ExamPrep.Exam3;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Scanner;

public class P01Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] males = scanner.nextLine().split("\\s+");
        String[] females = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> maleStack = new ArrayDeque<>();
        for (int i = 0; i < males.length; i++) {
            maleStack.push(Integer.parseInt(males[i]));
        }
        ArrayDeque<Integer> femaleQueue = new ArrayDeque<>();
        for (int i = 0; i < females.length; i++) {
            femaleQueue.offer(Integer.parseInt(females[i]));
        }

        int matchesCount = 0;
        while (maleStack.size() > 0 && femaleQueue.size() > 0) {

            int currentMale = maleStack.peek();
            int currentFemale = femaleQueue.peek();
            // checks if n > 0
            while (currentMale <= 0) {
                maleStack.pop();
                if (maleStack.size() > 0) {
                    currentMale = maleStack.peek();
                }
            }
            if (oneIsEmpty(maleStack, femaleQueue)) break;
            while (currentFemale <= 0) {
                femaleQueue.poll();
                if (femaleQueue.size() > 0) {
                    currentFemale = femaleQueue.peek();
                }
            }
            // checks if n % 25 == 0
            if (oneIsEmpty(maleStack, femaleQueue)) break;
            while (currentMale % 25 == 0) {
                maleStack.pop();
                if (maleStack.size() > 0) {
                    maleStack.pop();
                }
                if (maleStack.size() > 0) {
                    currentMale = maleStack.peek();
                } else {
                    break;
                }
            }
            if (oneIsEmpty(maleStack, femaleQueue)) break;
            while (currentFemale % 25 == 0) {
                femaleQueue.poll();
                if (femaleQueue.size() > 0) {
                    femaleQueue.poll();
                }
                if (femaleQueue.size() > 0) {
                    currentFemale = femaleQueue.peek();
                } else {
                    break;
                }
            }
            // checks if the collections still have elements
            if (oneIsEmpty(maleStack, femaleQueue)) break;
            // checks if male == female
            if (currentMale != currentFemale) {
                if (currentMale - 2 > 0) {
                    currentMale = maleStack.pop();
                    maleStack.push(currentMale - 2);
                    femaleQueue.poll();
                } else {
                    maleStack.pop();
                    femaleQueue.poll();
                }
            } else {
                matchesCount++;
                maleStack.pop();
                femaleQueue.poll();
            }
        }

        System.out.printf("Matches: %d%n", matchesCount);
        printMales(maleStack);
        printFemales(femaleQueue);
    }

    private static boolean oneIsEmpty(ArrayDeque<Integer> maleStack, ArrayDeque<Integer> femaleQueue) {
        return maleStack.size() <= 0 || femaleQueue.size() <= 0;
    }

    private static void printMales(ArrayDeque<Integer> maleStack) {
        if (maleStack.size() <= 0) {
            System.out.println("Males left: none");
        } else {
//            System.out.print("Males left: ");
//            while (maleStack.size() > 0) {
//                System.out.print(maleStack.poll());
//                if (maleStack.size() > 0) {
//                    System.out.print(", ");
//                } else {
//                    System.out.println();
//                }
//            }

            StringBuilder sb = new StringBuilder();
            while (maleStack.size() > 0) {
                sb.append(maleStack.poll());
                if (maleStack.size() > 0) {
                    sb.append(", ");
                }
            }
            System.out.println("Males left: " + sb);
        }
    }

    private static void printFemales(ArrayDeque<Integer> femaleQueue) {
        if (femaleQueue.size() <= 0) {
            System.out.println("Females left: none");
        } else {
//            System.out.print("Females left: ");
//            while (femaleQueue.size() > 0) {
//                System.out.print(femaleQueue.poll());
//                if (femaleQueue.size() > 0) {
//                    System.out.print(", ");
//                } else {
//                    System.out.println();
//                }
//            }
            StringBuilder sb = new StringBuilder();
            while (femaleQueue.size() > 0) {
                sb.append(femaleQueue.poll());
                if (femaleQueue.size() > 0) {
                    sb.append(", ");
                }
            }
            System.out.println("Females left: " + sb);
        }
    }
}
