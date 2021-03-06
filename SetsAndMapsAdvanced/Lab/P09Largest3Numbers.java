package com.company.SetsAndMapsAdvanced.Lab;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class P09Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .forEach(e -> System.out.print(e + " "));

    }
}
