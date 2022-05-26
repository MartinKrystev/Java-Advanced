package com.company.SetsAndMapsAdvanced.Lab;

import java.text.DecimalFormat;
import java.util.*;

public class P08AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        TreeMap<String, String[]> students = new TreeMap<>();

        while (n-- > 0) {
            String name = scanner.nextLine();
            String[] scores = scanner.nextLine().split("\\s+");

            students.putIfAbsent(name, scores);
        }

        for (Map.Entry<String, String[]> entry : students.entrySet()) {
//            double avg = Arrays.stream(Arrays.stream(entry.getValue())
//                    .mapToDouble(Double::parseDouble)
//                    .toArray())
//                    .average().getAsDouble();
            double sum = 0;
            for (int i = 0; i < entry.getValue().length; i++) {
                sum += Double.parseDouble(entry.getValue()[i]);
            }
            double avg = sum / entry.getValue().length;
            if (sum == 0) {
                avg = 0;
            }

            DecimalFormat df = new DecimalFormat("0.####################");
            //System.out.printf("%s is graduated with %f%n", entry.getKey(), avg);
            System.out.print(entry.getKey() + " is graduated with " + df.format(avg));
            System.out.println();

        }


    }
}
