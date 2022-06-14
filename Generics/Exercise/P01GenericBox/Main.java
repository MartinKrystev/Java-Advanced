package com.company.Generics.Exercise.P01GenericBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Box<Double> box = new Box<>();
        for (int i = 0; i < n; i++) {
            //String text = scanner.nextLine();
            double num = Double.parseDouble(scanner.nextLine());
            box.add(num);
        }

        //String searchedEl = scanner.nextLine();
        double searchedEl = Double.parseDouble(scanner.nextLine());

        System.out.println(box.countGreaterThan(searchedEl));

    }
}
