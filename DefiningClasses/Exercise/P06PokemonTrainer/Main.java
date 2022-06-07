package com.company.DefiningClasses.Exercise.P06PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Trainer> trainersMap = new LinkedHashMap<>();

        String[] input = scanner.nextLine().split("\\s+");
        while (!input[0].equals("Tournament")) {
            String trName = input[0];
            String pokemonName = input[1];
            String pokemonElement = input[2];
            int pokemonHealth = Integer.parseInt(input[3]);

            Trainer trainer = new Trainer(trName);
            Pokemon currPokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            trainersMap.putIfAbsent(trName, trainer);
            trainersMap.get(trName).addPokemon(currPokemon);

            input = scanner.nextLine().split("\\s+");
        }

        String command = scanner.nextLine();
        while (!command.equals("End")) {

            for (Trainer trainer : trainersMap.values()) {
                if (trainer.hasElementType(command)) {
                    trainer.incrementBadges(1);
                } else {
                    trainer.damagePokemons(10);
                }
            }

            command = scanner.nextLine();
        }

        trainersMap.entrySet().stream()
                .sorted((a, b) -> b.getValue().getBadges() - a.getValue().getBadges())
                .forEach(entry -> {
                    System.out.println(entry.getValue().toString());
                });

    }
}
