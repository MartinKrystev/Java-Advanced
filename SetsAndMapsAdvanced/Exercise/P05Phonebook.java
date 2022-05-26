package com.company.SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P05Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> phonebook = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("search")) {
            String name = input.split("-")[0];
            String number = input.split("-")[1];
            phonebook.put(name, number);
            input = scanner.nextLine();
        }

        String searchName = scanner.nextLine();
        while (!searchName.equals("stop")) {
            if (phonebook.containsKey(searchName)) {
                System.out.println(searchName + " -> " + phonebook.get(searchName));
            } else {
                System.out.printf("Contact %s does not exist.%n", searchName);
            }
            searchName = scanner.nextLine();
        }

    }
}
