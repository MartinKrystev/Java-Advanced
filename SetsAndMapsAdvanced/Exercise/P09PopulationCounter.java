package com.company.SetsAndMapsAdvanced.Exercise;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P09PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Long>> statistics = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("report")) {
            String country = input.split("\\|")[1];
            String city = input.split("\\|")[0];
            long population = Integer.parseInt(input.split("\\|")[2]);

            if (!statistics.containsKey(country)) {
                statistics.put(country, new LinkedHashMap<>());
            }
            if (!statistics.get(country).containsKey(city)) {
                statistics.get(country).put(city, population);
            } else {
                long newPopulation = statistics.get(country).get(country) + population;
                statistics.get(country).put(city, newPopulation);
            }
            input = scanner.nextLine();
        }

        Map<String, Long> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, LinkedHashMap<String, Long>> entry : statistics.entrySet()) {
            long sum = entry.getValue().values().stream().mapToLong(e -> e).sum();
            sortedMap.put(entry.getKey(), sum);
        }

        //Countries should be ordered by their total population in descending order and within each country,
        //the cities should be ordered by the same criterion.
        //If two countries/cities have the same population, keep them in the order in which they were entered.
        sortedMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(e -> {
                    System.out.printf("%s (total population: %s)%n", e.getKey(), e.getValue());

                    statistics.get(e.getKey()).entrySet().stream()
                            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                            .forEach(city -> {
                                System.out.printf("=>%s: %s%n", city.getKey(), city.getValue());
                            });
                });


    }
}
