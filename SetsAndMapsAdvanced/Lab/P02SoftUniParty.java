package com.company.SetsAndMapsAdvanced.Lab;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P02SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeSet<String> vip = new TreeSet<>();
        TreeSet<String> regular = new TreeSet<>();

        String input = scanner.nextLine();

        while (!input.equals("PARTY")) {

            String command = "ADD";
            addElement(vip, regular, input, command);
            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("END")) {

            String command = "REMOVE";
            addElement(vip, regular, input, command);
            input = scanner.nextLine();
        }

        System.out.println(vip.size() + regular.size());
        printSetIfNotEmpty(vip);
        printSetIfNotEmpty(regular);

    }

    public static void printSetIfNotEmpty(Set<String> set) {
        if (!set.isEmpty()) {
            System.out.println(String.join(System.lineSeparator(), set));
        }
    }

    public static void addElement(TreeSet<String> vip, TreeSet<String> regular, String input, String command) {
        if (command.equals("ADD")) {
            if (Character.isDigit(input.charAt(0))) {
                vip.add(input);
            } else {
                regular.add(input);
            }
        } else {
            if (Character.isDigit(input.charAt(0))) {
                vip.remove(input);
            } else {
                regular.remove(input);
            }
        }

    }
}
