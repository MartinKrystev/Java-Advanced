package com.company.FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        List<String> evenNumbers = Arrays.stream(input)
                .map(Integer::parseInt)
                .filter(e -> e % 2 == 0)
                .map(e -> e.toString())
                .collect(Collectors.toList());

        System.out.println(String.join(", ", evenNumbers));


        List<String> sorted = evenNumbers.stream()
                .map(Integer::parseInt)
                .sorted(Integer::compareTo)
                .map(e -> e.toString())
                .collect(Collectors.toList());

        System.out.println(String.join(", ", sorted));
    }
}
