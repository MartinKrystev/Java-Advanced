package com.company.FunctionalProgramming.Exercise;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P05ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());

        List<Integer> numsList = Arrays.stream(input)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Collections.reverse(numsList);

        Predicate<Integer> tryDivision = e -> e % n == 0;
        numsList.removeIf(tryDivision);

        numsList.forEach(e -> System.out.print(e + " "));

    }

}
