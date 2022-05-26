package com.company.SetsAndMapsAdvanced.Lab;

import java.util.*;

public class P05AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> gradesMap = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String student = input.split("\\s+")[0];
            double currentGrade = Double.parseDouble(input.split("\\s+")[1]);

            gradesMap.putIfAbsent(student, new ArrayList<>());
            gradesMap.get(student).add(currentGrade);

        }

        for (Map.Entry<String, List<Double>> entry : gradesMap.entrySet()) {
//            double avg = Arrays.stream(entry.getValue().stream()
//                            .mapToDouble(e -> e)
//                            .toArray())
//                    .average().getAsDouble();

            double sum = 0;

            for (int i = 0; i < entry.getValue().size(); i++) {
                sum += entry.getValue().get(i);
            }
            double avg = sum / entry.getValue().size();

            System.out.print(entry.getKey() + " -> ");

            entry.getValue().forEach(grade -> {
                System.out.printf("%.2f ", grade);
            });
            System.out.printf("(avg: %.2f)%n", avg);
        }


    }
}
