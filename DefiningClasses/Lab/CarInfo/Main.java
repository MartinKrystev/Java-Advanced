package com.company.DefiningClasses.Lab.CarInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Car> carsList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String brand = input[0];

            if (input.length == 1) {
                Car car = new Car(brand);
                carsList.add(car);
            } else {
                String model = input[1];
                int horsePowers = Integer.parseInt(input[2]);
                Car car = new Car(brand, model, horsePowers);
                carsList.add(car);
            }
        }

        carsList.forEach(car -> System.out.println(car.carInfo()));

    }
}
