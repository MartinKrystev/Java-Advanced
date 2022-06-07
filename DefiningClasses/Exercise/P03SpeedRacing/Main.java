package com.company.DefiningClasses.Exercise.P03SpeedRacing;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Car> carsMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            //{Model} {FuelAmount} {FuelCostFor1km}
            String[] information = scanner.nextLine().split("\\s+");
            String model = information[0];
            double fuelAmount = Double.parseDouble(information[1]);
            double fuelCostPerKm = Double.parseDouble(information[2]);
            carsMap.putIfAbsent(model, new Car(model, fuelAmount, fuelCostPerKm));
        }
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String model = input.split("\\s+")[1];
            int distance = Integer.parseInt(input.split("\\s+")[2]);

            if (!carsMap.get(model).canDrive(distance)) {
                System.out.println("Insufficient fuel for the drive");
            }
            input = scanner.nextLine();
        }

        for (var carEntry : carsMap.entrySet()) {
            System.out.println(carEntry.getValue());
        }

    }
}
