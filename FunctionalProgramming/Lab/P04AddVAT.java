package com.company.FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class P04AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        Function<String, Double> toDouble = e -> Double.parseDouble(e);
        Function<Double,Double> addVat = e -> e * 1.2;
        Consumer<Double> printer = e -> System.out.printf("%.2f%n", e);

        System.out.println("Prices with VAT:");
        Arrays.stream(input)
                .map(toDouble)
                .map(addVat)
                .forEach(printer);

    }
}
