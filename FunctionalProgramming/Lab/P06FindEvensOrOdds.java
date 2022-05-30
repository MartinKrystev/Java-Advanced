package com.company.FunctionalProgramming.Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P06FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] bounds = scanner.nextLine().split("\\s+");
        int startNumber = Integer.parseInt(bounds[0]);
        int endNumber = Integer.parseInt(bounds[1]);
        String command = scanner.nextLine();

        List<Integer> numbersList = new ArrayList<>();
        for (int i = startNumber; i <= endNumber; i++) {
            numbersList.add(i);
        }

        Predicate<Integer> numPredicate;
        if (command.equals("odd")) {
            numPredicate = e -> e % 2 != 0;
        } else {
            numPredicate = e -> e % 2 == 0;

        }
        List<String> filteredList = numbersList
                .stream()
                .filter(numPredicate)
                .map(e -> e.toString())
                .collect(Collectors.toList());

        System.out.println(String.join(" ", filteredList));

    }
}
