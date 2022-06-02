package com.company.FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P10PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> people = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("Party!")) {
            BiPredicate<String, String> predicate = null;
            String action = input.split("\\s+")[0];   // {Double}, {Remove}
            String command = input.split("\\s+")[1];  // {StartsWith, {EndsWith}, {Length}
            String fragment = input.split("\\s+")[2]; // {String}, {int Length}

            switch (command) {
                case "StartsWith":
                    predicate = (s, f) -> s.startsWith(f);
                    break;
                case "EndsWith":
                    predicate = (s, f) -> s.endsWith(f);
                    break;
                case "Length":
                    predicate = (s, l) -> {
                        int length = Integer.parseInt(l);
                        return s.length() == length;
                    };
                    break;
            }

            if (action.endsWith("Double")) {
                int initialSize = people.size();
                for (int i = 0; i < initialSize; i++) {
                    if (predicate.test(people.get(i), fragment)){
                        people.add(people.get(i));
                    }
                }
            } else {
                for (int i = 0; i < people.size(); i++) {
                    if (predicate.test(people.get(i), fragment)) {
                        people.remove(i);
                        i--;
                    }
                }
            }

            input = scanner.nextLine();
        }
        if (!people.isEmpty()) {
            List<String> sortedList = people.stream()
                    .sorted()
                    .collect(Collectors.toList());
            System.out.print(String.join(", ", sortedList));
            System.out.println(" are going to the party!");
        } else {
            System.out.println("Nobody is going to the party!");
        }
    }

}
