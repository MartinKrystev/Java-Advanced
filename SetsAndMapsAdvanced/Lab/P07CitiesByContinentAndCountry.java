package com.company.SetsAndMapsAdvanced.Lab;

import java.util.*;

public class P07CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, LinkedHashMap<String, List<String>>> map = new LinkedHashMap<>();
        while (n-- > 0) {
            String input = scanner.nextLine();

            String continent = input.split("\\s+")[0];
            String country = input.split("\\s+")[1];
            String city = input.split("\\s+")[2];

            map.putIfAbsent(continent, new LinkedHashMap<>());
            map.get(continent).putIfAbsent(country, new ArrayList<>());
            map.get(continent).get(country).add(city);

        }
        for (Map.Entry<String, LinkedHashMap<String, List<String>>> continent : map.entrySet()) {
            System.out.printf("%s:%n", continent.getKey());

            for (Map.Entry<String, List<String>> country : continent.getValue().entrySet()) {
                System.out.printf("  %s -> %s%n", country.getKey(), String.join(", ", country.getValue()));
            }

        }

    }
}
