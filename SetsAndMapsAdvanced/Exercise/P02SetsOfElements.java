package com.company.SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P02SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        String input = scanner.nextLine();
        int firstLength = Integer.parseInt(input.split("\\s+")[0]);
        int secondLength = Integer.parseInt(input.split("\\s+")[1]);

        for (int i = 0; i < firstLength; i++) {
            int currNumber = Integer.parseInt(scanner.nextLine());
            firstSet.add(currNumber);
        }

        for (int i = 0; i < secondLength; i++) {
            int currNumber = Integer.parseInt(scanner.nextLine());
            secondSet.add(currNumber);
        }

        firstSet.retainAll(secondSet);

        firstSet.forEach(e -> System.out.print(e + " "));

    }
}
