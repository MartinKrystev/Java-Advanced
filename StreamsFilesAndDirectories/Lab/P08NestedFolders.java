package com.company.StreamsFilesAndDirectories.Lab;

import java.io.*;
import java.util.ArrayDeque;

public class P08NestedFolders {
    public static void main(String[] args) throws FileNotFoundException {


        File file = new File("D:\\Java Advanced Tasks\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        PrintStream out = new PrintStream("D:\\Java Advanced Tasks\\src\\08.NestedFolders.txt");

        ArrayDeque<File> queue = new ArrayDeque<>();

        int counter = 0;

        queue.offer(file);

        while (!queue.isEmpty()) {
            File current = queue.poll();

            if (current.isDirectory()) {
                out.println(current.getName());
                counter++;

                File[] currDir = current.listFiles();
                for (File file1 : currDir) {
                    queue.offer(file1);
                }
            }
        }
        out.printf("%d folders", counter);
    }
}
