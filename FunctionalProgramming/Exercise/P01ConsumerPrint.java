package com.company.FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class P01ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        Consumer<String> printConsumer = e -> System.out.println(e);
        Arrays.stream(input)
                .forEach(printConsumer);

    }
}
