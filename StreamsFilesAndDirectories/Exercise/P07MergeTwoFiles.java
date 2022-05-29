package com.company.StreamsFilesAndDirectories.Exercise;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P07MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        String pathOne = "D:\\Java Advanced Tasks\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String pathTwo = "D:\\Java Advanced Tasks\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";
        PrintWriter writer = new PrintWriter("output07.txt");

        List<String> linesFileOne = Files.readAllLines(Path.of(pathOne));
        linesFileOne.forEach(line -> writer.println(line));
        List<String> linesFileTwo = Files.readAllLines(Path.of(pathTwo));
        linesFileTwo.forEach(line -> writer.println(line));

        writer.close();


    }
}
