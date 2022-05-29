package com.company.StreamsFilesAndDirectories.Exercise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class P02SumBytes {
    public static void main(String[] args) {
        String path = "D:\\Java Advanced Tasks\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        long sum = 0;
        try (BufferedReader bf = new BufferedReader(new FileReader(path));) {
            String line = bf.readLine();

            while (line != null) {
                for (int i = 0; i < line.length(); i++) {
                    char current = line.charAt(i);
                    sum += current;
                }
                line = bf.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sum);
    }
}
