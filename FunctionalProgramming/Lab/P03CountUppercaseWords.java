package com.company.FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P03CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] text = scanner.nextLine().split(" ");

        Predicate<String> upperCase = word -> Character.isUpperCase(word.charAt(0));
        Consumer<String> print = word -> System.out.println(word);

        List<String> filtered = Arrays.stream(text)
                .filter(upperCase)
                .collect(Collectors.toList());

        System.out.println(filtered.size());
        filtered.forEach(print);
    }
}
