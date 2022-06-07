package com.company.DefiningClasses.Exercise.P01OpinionPoll;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Person> pool = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String namePerson = input[0];
            int agePerson = Integer.parseInt(input[1]);
            Person currPerson = new Person(namePerson, agePerson);
            pool.add(currPerson);
        }

        pool.stream()
                .filter(p -> p.getAge() > 30)
                .sorted(Comparator.comparing(Person::getName)) // <->  (a, b) -> a.getName().compareTo(b.getName())
                .forEach(e -> {
                    System.out.print(e.getName() + " - " + e.getAge());
                    System.out.println();
                });

    }
}
