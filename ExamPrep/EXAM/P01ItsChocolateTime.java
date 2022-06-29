package com.company.EXAM;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P01ItsChocolateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] milkInput = scanner.nextLine().split("\\s+");
        String[] cacaoInput = scanner.nextLine().split("\\s+");

        ArrayDeque<Double> milkQueue = new ArrayDeque<>();
        ArrayDeque<Double> cacaoStack = new ArrayDeque<>();

        fillQueue(milkInput, milkQueue);
        fillStack(cacaoInput, cacaoStack);

        Map<String, Integer> chocolatesMap = new TreeMap<>();
        chocolatesMap.put("Milk Chocolate", 0);
        chocolatesMap.put("Dark Chocolate", 0);
        chocolatesMap.put("Baking Chocolate", 0);

        //Milk Chocolate	30
        //Dark Chocolate	50
        //Baking Chocolate	100
        boolean haveThreeChocolates = false;
        while (!milkQueue.isEmpty() && !cacaoStack.isEmpty()) {

            double currMilk = milkQueue.peek(); // 0
            double currCacao = cacaoStack.peek(); //100

            double percentage = (currCacao / (currMilk + currCacao)) * 100;

            if (percentage == 30) {
                removeItems(milkQueue, cacaoStack);
                chocolatesMap.put("Milk Chocolate", chocolatesMap.get("Milk Chocolate") + 1);
            } else if (percentage == 50) {
                removeItems(milkQueue, cacaoStack);
                chocolatesMap.put("Dark Chocolate", chocolatesMap.get("Dark Chocolate") + 1);
            } else if (percentage == 100) {
                removeItems(milkQueue, cacaoStack);
                chocolatesMap.put("Baking Chocolate", chocolatesMap.get("Baking Chocolate") + 1);
            } else {
                double increasedMilk = milkQueue.poll() + 10;
                milkQueue.offer(increasedMilk);
                cacaoStack.pop();
            }


        }

        if (haveAllThree(chocolatesMap)) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }

        chocolatesMap.forEach((key, value) -> {
            if (value > 0) {
                System.out.printf("# %s --> %d%n", key, value);
            }
        });

    }

    private static boolean haveAllThree(Map<String, Integer> chocolatesMap) {
        return chocolatesMap.get("Milk Chocolate") > 0 && chocolatesMap.get("Dark Chocolate") > 0 && chocolatesMap.get("Baking Chocolate") > 0;
    }

    private static void removeItems(ArrayDeque<Double> milkQueue, ArrayDeque<Double> cacaoStack) {
        milkQueue.poll();
        cacaoStack.pop();
    }

    private static void fillStack(String[] cacaoInput, ArrayDeque<Double> cacaoStack) {
        for (String s : cacaoInput) {
            cacaoStack.push(Double.parseDouble(s));
        }
    }

    private static void fillQueue(String[] milkInput, ArrayDeque<Double> milkQueue) {
        for (String s : milkInput) {
            milkQueue.offer(Double.parseDouble(s));
        }
    }
}
