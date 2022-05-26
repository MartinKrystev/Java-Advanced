package com.company.SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Set<String> set = new LinkedHashSet<>();

        while (n-- > 0) {
            String currentWord = scanner.nextLine();
            set.add(currentWord);
        }

        set.forEach(System.out::println);
    }
}
