package com.company.SetsAndMapsAdvanced.Lab;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        LinkedHashSet<String> cars = new LinkedHashSet<>();

        while (!input.equals("END")) {

            String[] command = input.split(", ");

            if (command[0].equals("IN")) {
                cars.add(command[1]);
            } else {
                cars.remove(command[1]);
            }
            input = scanner.nextLine();
        }

        if (cars.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            System.out.println(String.join(System.lineSeparator(), cars));
        }

    }
}
