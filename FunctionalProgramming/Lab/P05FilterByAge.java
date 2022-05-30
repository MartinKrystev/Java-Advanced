package com.company.FunctionalProgramming.Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class P05FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int counts = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> people = new LinkedHashMap<>();

        for (int i = 0; i < counts; i++) {
            String[] input = scanner.nextLine().split(", ");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            people.put(name, age);
        }

        String condition = scanner.nextLine();
        int ageFilter = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        BiPredicate<Integer, Integer> filterPredicate;
        if (condition.equals("younger")) {
            filterPredicate = (age, ages) -> age <= ages;
        } else {
            filterPredicate = (age, ages) -> age >= ages;
        }

        Consumer<Map.Entry<String, Integer>> printConsumer;
        if (format.equals("name")) {
            printConsumer = person -> System.out.println(person.getKey());
        } else if (format.equals("age")) {
            printConsumer = person -> System.out.println(person.getValue());
        } else {
            printConsumer = person -> System.out.println(person.getKey() + " - " + person.getValue());
        }

        people.entrySet()
                .stream()
                .filter(person -> filterPredicate.test(person.getValue(), ageFilter))
                .forEach(printConsumer);

    }
}
