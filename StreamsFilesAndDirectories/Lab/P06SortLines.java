package com.company.StreamsFilesAndDirectories.Lab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class P06SortLines {
    public static void main(String[] args) throws IOException {
        // String inPath = "D:\\Java Advanced Tasks\\src\\input.txt";
        // String outPath = "D:\\Java Advanced Tasks\\src\\06.SortLinesOutput.txt";

        Path inPath = Paths.get("D:\\Java Advanced Tasks\\src\\input.txt");
        Path outPath = Paths.get("D:\\Java Advanced Tasks\\src\\06.SortLinesOutput.txt");

        List<String> lines = Files.readAllLines(inPath);
        Collections.sort(lines);
        Files.write(outPath, lines);

    }
}
