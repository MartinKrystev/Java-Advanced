package com.company.FunctionalProgramming.Exercise;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P11ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> people = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        Map<String, Predicate<String>> predicates = new HashMap<>();

        String tprfCommand = scanner.nextLine();
        while (!tprfCommand.equals("Print")) {

            String command = tprfCommand.split(";")[0];
            String type = tprfCommand.split(";")[1];
            String parameter = tprfCommand.split(";")[2];

            if (command.contains("Add")) {
                // adds predicate to the Map
                predicates.put(type + parameter, predicateCreator(type, parameter));
            } else {
                // removes predicate from the Map
                predicates.remove(type + parameter);
            }
            tprfCommand = scanner.nextLine();
        }

        people.stream()
                .filter(name -> {
                    boolean isValid = true;
                    for (Predicate<String> predicate : predicates.values()) {
                        if (predicate.test(name)) {
                            isValid = false;
                            break;
                        }
                    }
                    return isValid;
                }).forEach(name -> System.out.print(name + " "));
    }

    public static Predicate<String> predicateCreator(String type, String parameter) {
        Predicate<String> checkIf;

        if (type.equals("Starts with")) {
            checkIf = name -> name.startsWith(parameter);
        } else if (type.equals("Ends with")) {
            checkIf = name -> name.endsWith(parameter);
        } else if (type.equals("Contains")) {
            checkIf = name -> name.contains(parameter);
        } else {
            checkIf = name -> name.length() == Integer.parseInt(parameter);
        }
        return checkIf;
    }
}
