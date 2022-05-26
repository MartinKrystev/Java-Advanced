package com.company.SetsAndMapsAdvanced.Exercise;

import java.util.*;

public class P03PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Set<String> elements = new TreeSet<>();

        while (n-- > 0) {
            String[] currElements = scanner.nextLine().split("\\s+");
            elements.addAll(Arrays.asList(currElements));
        }

        elements.forEach(e -> System.out.print(e + " "));

    }
}
