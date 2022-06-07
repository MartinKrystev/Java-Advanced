package com.company.DefiningClasses.Exercise.P07Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> peopleMap = new HashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] data = input.split("\\s+");

            String name = data[0];
            String type = data[1];

            peopleMap.putIfAbsent(name, new Person(name));
            switch (type) {
                case "company":
                    String companyName = data[2];
                    String companyDepartment = data[3];
                    double companySalary = Double.parseDouble(data[4]);
                    Company company = new Company(companyName, companyDepartment, companySalary);
                    peopleMap.get(name).setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = data[2];
                    String pokemonType = data[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    peopleMap.get(name).getPokemons().add(pokemon);
                    break;
                case "parents":
                    String parentName = data[2];
                    String parentBirthday = data[3];
                    Parent parent = new Parent(parentName, parentBirthday);
                    peopleMap.get(name).getParents().add(parent);
                    break;
                case "children":
                    String childName = data[2];
                    String childBirthday = data[3];
                    Child child = new Child(childName, childBirthday);
                    peopleMap.get(name).getChildren().add(child);
                    break;
                case "car":
                    String model = data[2];
                    String speed = data[3];
                    Car car = new Car(model, speed);
                    peopleMap.get(name).setCar(car);
                    break;
            }


            input = scanner.nextLine();
        }
        String searchedPerson = scanner.nextLine();
        Person theOne = peopleMap.get(searchedPerson);
        System.out.println(theOne);
    }
}
