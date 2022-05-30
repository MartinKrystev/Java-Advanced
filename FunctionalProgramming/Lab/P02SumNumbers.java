package com.company.FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P02SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        //4, 2, 1, 3, 5, 7, 1, 4, 2, 12
        Function<String, Integer> function = e -> Integer.parseInt(e);


        System.out.println("Count = " + input.length);

        List<Integer> numbers = Arrays.stream(input)
                .map(function)
                .collect(Collectors.toList());

        int sum = Arrays.stream(input)
                .mapToInt(e -> Integer.parseInt(e))
                .sum();
        System.out.println("Sum = " + sum);


    }
}
