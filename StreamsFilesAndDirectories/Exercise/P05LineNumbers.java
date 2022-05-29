package com.company.StreamsFilesAndDirectories.Exercise;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P05LineNumbers {
    public static void main(String[] args) throws IOException {
        String path = "D:\\Java Advanced Tasks\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";

        List<String> allLines = Files.readAllLines(Path.of(path));
        BufferedReader bf = new BufferedReader(new FileReader(path));
        BufferedWriter bw = new BufferedWriter(new FileWriter("output05.txt"));

        int counter = 1;
        for (String line : allLines) {
            bw.write(counter + ". " + line);
            bw.newLine();
            counter++;
        }
        bw.close();


    }
}
