package com.company.StacksAndQueues.Exercise;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class P10Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputRobots = scanner.nextLine();
        String[] robotsData = inputRobots.split(";");
        LinkedHashMap<String, Integer> robots = getRobotsMap(robotsData);
        LinkedHashMap<String, Integer> robotsWorkingTime = getRobotsWorkingTimeMap(robotsData);

        String startTime = scanner.nextLine();
        int startTimeInSeconds = getStartTimeInSeconds(startTime);

        ArrayDeque<String> products = new ArrayDeque<>();
        String product = scanner.nextLine();
        while (!product.equals("End")) {
            products.offer(product);
            product = scanner.nextLine();
        }
        while (!products.isEmpty()) {
            String currProduct = products.poll();
            boolean isTaken = false;
            startTimeInSeconds++;
            decreseWorkingTime(robotsWorkingTime);
            for (Map.Entry<String, Integer> robot : robotsWorkingTime.entrySet()) {
                if (robot.getValue() == 0) {
                    System.out.println(robot.getKey() + " - " + currProduct + " [" + getStartTime(startTimeInSeconds) + "]");
                    robotsWorkingTime.put(robot.getKey(), robots.get(robot.getKey()));
                    isTaken = true;
                    break;
                }
            }
            if (!isTaken) {
                products.offer(currProduct);
            }
        }
    }

    private static void decreseWorkingTime(LinkedHashMap<String, Integer> robotsWorkingTime) {
        for (Map.Entry<String, Integer> robot : robotsWorkingTime.entrySet()) {
            if (robot.getValue() > 0) {
                robotsWorkingTime.put(robot.getKey(), robot.getValue() - 1);
            }
        }

    }

    private static LinkedHashMap<String, Integer> getRobotsWorkingTimeMap(String[] robotsData) {
        LinkedHashMap<String, Integer> robots = new LinkedHashMap<>();
        for (String robotData : robotsData) {
            String robotName = robotData.split("-")[0];
            robots.put(robotName, 0);
        }
        return robots;
    }

    private static int getStartTimeInSeconds(String startTime) {
        int hours = Integer.parseInt(startTime.split(":")[0]);
        int minutes = Integer.parseInt(startTime.split(":")[1]);
        int seconds = Integer.parseInt(startTime.split(":")[2]);
        return hours * 3600 + minutes * 60 + seconds;
    }

    public static String getStartTime(int startTimeInSeconds) {
        int hours = (startTimeInSeconds / 3600) % 24;
        int minutes = startTimeInSeconds % 3600 / 60;
        int seconds = startTimeInSeconds % 60;
        if (hours >= 24) {
            hours -= 24;
        }
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    private static LinkedHashMap<String, Integer> getRobotsMap(String[] robotsData) {
        LinkedHashMap<String, Integer> robots = new LinkedHashMap<>();
        for (String robotData : robotsData) {
            String robotName = robotData.split("-")[0];
            int processingTime = Integer.parseInt(robotData.split("-")[1]);
            robots.put(robotName, processingTime);
        }
        return robots;
    }
}
