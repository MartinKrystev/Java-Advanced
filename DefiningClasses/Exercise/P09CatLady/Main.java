package com.company.DefiningClasses.Exercise.P09CatLady;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Cat> cats = new HashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String breed = input.split("\\s+")[0];
            String name = input.split("\\s+")[1];
            double measures = Double.parseDouble(input.split("\\s+")[2]);
            Cat cat = new Cat(name, breed, measures);
            cats.putIfAbsent(name, cat);
            input = scanner.nextLine();
        }

        String searchedCat = scanner.nextLine();
        Cat theOne = new Cat();
        for (Cat value : cats.values()) {
            if (value.getName().equals(searchedCat)){
                theOne = value;
            }
        }

        System.out.println(theOne);
    }
}
