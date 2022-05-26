package com.company.SetsAndMapsAdvanced.Lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P04CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] values = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> valuesWithOccurrence = new LinkedHashMap<>();

//        for (double value : values) {
//            valuesWithOccurrence.putIfAbsent(value, 1);
//            valuesWithOccurrence.put(value, valuesWithOccurrence.get(value) + 1);
//        }

        for (double value : values) {
            if (!valuesWithOccurrence.containsKey(value)) {
                valuesWithOccurrence.put(value, 1);
            } else {
                valuesWithOccurrence.put(value, valuesWithOccurrence.get(value) + 1);
            }
        }

        for (Double key : valuesWithOccurrence.keySet()) {
            System.out.printf("%.1f -> %d%n", key, valuesWithOccurrence.get(key));
        }


    }
}
