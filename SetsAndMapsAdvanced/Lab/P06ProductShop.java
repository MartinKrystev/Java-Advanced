package com.company.SetsAndMapsAdvanced.Lab;

import java.util.*;

public class P06ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Double>> storeMap = new TreeMap<>();
        String input = scanner.nextLine();

        while (!input.equals("Revision")) {
            String shop = input.split(", ")[0];
            String product = input.split(", ")[1];
            double price = Double.parseDouble(input.split(", ")[2]);

            storeMap.putIfAbsent(shop, new LinkedHashMap<>());
            storeMap.get(shop).putIfAbsent(product, price);
            storeMap.get(shop).put(product, price);

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, Double>> entry : storeMap.entrySet()) {
            System.out.printf("%s->%n", entry.getKey());
            for (Map.Entry<String, Double> shop : entry.getValue().entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", shop.getKey(), shop.getValue());
            }
        }

    }
}
