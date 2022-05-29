package com.company.StreamsFilesAndDirectories.Exercise;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Locale;

public class P03ALLCAPITALS {
    public static void main(String[] args) {
        String path = "D:\\Java Advanced Tasks\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try (BufferedReader bf = new BufferedReader(new FileReader(path));
             BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {

            List<String> allLines = Files.readAllLines(Path.of(path));
            for (String line : allLines) {
                bw.write(line.toUpperCase(Locale.ROOT));
                bw.newLine();
            }
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
