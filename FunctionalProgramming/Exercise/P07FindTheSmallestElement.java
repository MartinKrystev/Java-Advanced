package com.company.FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P07FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        // gets the Index of the smallest element
        Function<List<Integer>, Integer> getIndexOfSmallestElement = list -> list.lastIndexOf(Collections.min(list));
        System.out.println(getIndexOfSmallestElement.apply(numbers));
    }
}
