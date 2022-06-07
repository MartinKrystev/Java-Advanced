package com.company.DefiningClasses.Exercise.P05CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Engine>> enginesMap = new HashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            // {Model} {Power} {Displacement} {Efficiency}  ENGINES
            String[] engineData = scanner.nextLine().split("\\s+");
            String engineModel = engineData[0];
            String enginePower = engineData[1];
            String engineDisplacement = "n/a";
            String engineEfficiency = "n/a";

            if (engineData.length == 3) {
                String thirdElement = engineData[2];
                if (isDigit(thirdElement)) {
                    engineDisplacement = thirdElement;
                } else {
                    engineEfficiency = thirdElement;
                }
            } else if (engineData.length == 4) {
                engineDisplacement = engineData[2];
                engineEfficiency = engineData[3];
            }
            Engine engine = new Engine(engineModel, enginePower, engineDisplacement, engineEfficiency);
            enginesMap.putIfAbsent(engineModel, new ArrayList<>());
            enginesMap.get(engineModel).add(engine);
        }

        Map<Integer, List<Car>> carMap = new LinkedHashMap<>();

        int m = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= m; i++) {
            // {Model} {Engine} {Weight} {Color}    CARS
            String[] carData = scanner.nextLine().split("\\s+");
            String carModel = carData[0];
            String carEngine = carData[1];
            String carWeight = "n/a";
            String carColor = "n/a";

            if (carData.length == 3) {
                String thirdElement = carData[2];
                if (isDigit(thirdElement)) {
                    carWeight = thirdElement;
                } else {
                    carColor = thirdElement;
                }
            } else if (carData.length == 4) {
                carWeight = carData[2];
                carColor = carData[3];
            }

            Engine currEngine = getCurrentEngine(carEngine, enginesMap);
            Car car = new Car(carModel, currEngine, carWeight, carColor);
            carMap.putIfAbsent(i, new ArrayList<>());
            carMap.get(i).add(car);
        }

        for (Map.Entry<Integer, List<Car>> car : carMap.entrySet()) {
            car.getValue().stream().forEach(c -> {
                System.out.println(String.format("%s:" + "\n" + "%s:\n" +
                        "Power: %s\n" +
                        "Displacement: %s\n" +
                        "Efficiency: %s\n" +
                        "Weight: %s\n" +
                        "Color: %s",
                        c.getModel(),
                        c.getEngine().getModel(),
                        c.getEngine().getPower(),
                        c.getEngine().getDisplacement(),
                        c.getEngine().getEfficiency(),
                        c.getWeight(),
                        c.getColor()));
            });
        }


    }

    private static Engine getCurrentEngine(String carEngine, Map<String, List<Engine>> enginesMap) {
        List<Engine> temp = new ArrayList<>();
        Engine engine;
        for (Map.Entry<String, List<Engine>> entry : enginesMap.entrySet()) {
            String currModel = entry.getKey();
            if (currModel.equals(carEngine)) {
                String specificModel = entry.getValue().get(0).getModel();
                String enginePower = entry.getValue().get(0).getPower();
                String engineDisplacement = entry.getValue().get(0).getDisplacement();
                String engineEfficiency = entry.getValue().get(0).getEfficiency();
                return engine = new Engine(specificModel, enginePower, engineDisplacement, engineEfficiency);
            }
        }
        return null;
    }

    public static boolean isDigit(String thirdElement) {
        try {
            Integer.parseInt(thirdElement);
            return true;
        } catch (NumberFormatException e) {
            return false;

        }
    }

}
