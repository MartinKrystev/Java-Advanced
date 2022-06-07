package com.company.DefiningClasses.Exercise.P04RawData;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Car> garage = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String model = data[0];
            int speed = Integer.parseInt(data[1]);
            int engine = Integer.parseInt(data[2]);
            int cargo = Integer.parseInt(data[3]);
            String cargoType = data[4];

            double tire1Pressure = Double.parseDouble(data[5]);
            int tire1Age = Integer.parseInt(data[6]);
            double tire2Pressure = Double.parseDouble(data[7]);
            int tire2Age = Integer.parseInt(data[8]);
            double tire3Pressure = Double.parseDouble(data[9]);
            int tire3Age = Integer.parseInt(data[10]);
            double tire4Pressure = Double.parseDouble(data[11]);
            int tire4Age = Integer.parseInt(data[12]);

            Car car = new Car(speed, engine, cargo, cargoType, tire1Pressure, tire1Age, tire2Pressure, tire2Age, tire3Pressure, tire3Age, tire4Pressure, tire4Age);

            garage.putIfAbsent(model, car);
        }

        String input = scanner.nextLine();
        if (input.equals("fragile")) {
            garage.entrySet().stream()
                    .filter(e -> e.getValue().getCargoType().equals("fragile"))
                    .filter(e -> e.getValue().getTire1Pressure() < 1
                            || e.getValue().getTire2Pressure() < 1
                            || e.getValue().getTire3Pressure() < 1
                            || e.getValue().getTire4Pressure() < 1)
                    .forEach(e -> System.out.println(e.getKey()));
        } else {
            garage.entrySet().stream().filter(e -> e.getValue().getCargoType().equals("flamable"))
                    .filter(e -> e.getValue().getEngine() > 250)
                    .forEach(e -> System.out.println(e.getKey()));
        }

    }
}
