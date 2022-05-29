package com.company.StreamsFilesAndDirectories.Exercise;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P06WordCount {
    public static void main(String[] args) throws IOException {

        String path = "D:\\Java Advanced Tasks\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        String searchingText = "D:\\Java Advanced Tasks\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
        String result = "result.txt";

        Map<String, Integer> countWords = new HashMap<>();
        List<String> allLines = Files.readAllLines(Path.of(path));

        for (String line : allLines) {
            Arrays.stream(line.split("\\s+"))
                    .forEach(w -> {
                        countWords.put(w, 0);
                    });
        }

        List<String> allSearchingLines = Files.readAllLines(Path.of(searchingText));
        for (String line : allSearchingLines) {
            Arrays.stream(line.split("\\s+"))
                    .forEach(word -> {
                        if (countWords.containsKey(word)) {
                            countWords.put(word, countWords.get(word) + 1);
                        }
                    });
        }
        PrintWriter pr = new PrintWriter(result);
        //Sort by value in descending order -> e2.value > e1.value
        countWords.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(e -> {
                    pr.println(e.getKey() + " - " + e.getValue());
                });
        pr.close();
    }
}
