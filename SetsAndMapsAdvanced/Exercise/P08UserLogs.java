package com.company.SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P08UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Integer>> log = new TreeMap<>();
        String input = scanner.nextLine();
        while (!input.endsWith("end")) {
            String currentIP = input.split("\\s+")[0].substring(3);
            String currentUser = input.split("\\s+")[2].substring(5);

            if (!log.containsKey(currentUser)) {
                log.put(currentUser, new LinkedHashMap<>());
            }
            if (!log.get(currentUser).containsKey(currentIP)) {
                log.get(currentUser).put(currentIP, 1);
            } else {
                int counter = log.get(currentUser).get(currentIP) + 1;
                log.get(currentUser).put(currentIP, counter);
            }
            input = scanner.nextLine();
        }

        for (var entry : log.entrySet()) {
            System.out.printf("%s: %n", entry.getKey());
            LinkedHashMap<String, Integer> attack = entry.getValue();
            StringBuilder sb = new StringBuilder();

            for (var ipAttack : attack.entrySet()) {
                String formattedAttack = String.format("%s => %d, ", ipAttack.getKey(), ipAttack.getValue());
                sb.append(formattedAttack);
            }

            String finalOutput = sb.substring(0, sb.length() - 2);
            finalOutput = finalOutput + ".";

            System.out.println(finalOutput);

        }


    }
}
