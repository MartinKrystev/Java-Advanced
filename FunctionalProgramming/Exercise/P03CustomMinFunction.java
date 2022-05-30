package com.company.FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class P03CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        Integer[] currArr = Arrays.stream(input)
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        if (currArr.length != 0) {
            System.out.println(findSmallestNumber.apply(currArr));
        } else {
            System.out.println(0);
        }

    }

    public static Function<Integer[], Integer> findSmallestNumber = arr -> { //new Function<Integer[], Integer>()   <--replaced with Lambda
        int min = arr[0];
        for (Integer num : arr) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    };
}
