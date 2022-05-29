package com.company.StreamsFilesAndDirectories.Exercise;

import java.io.*;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class P04CountCharacterTypes {
    public static void main(String[] args) {
        String path = "D:\\Java Advanced Tasks\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        Set<Character> vowels = getVowels();
        Set<Character> marks = getMarks();

        int vowelsCount = 0;
        int punctuation = 0;
        int consonants = 0;


        try (BufferedReader bf = new BufferedReader(new FileReader(path));
             PrintWriter pw = new PrintWriter(new FileWriter("output04.txt"))) {

            String line = bf.readLine();
            while (line != null) {
                for (int i = 0; i < line.length(); i++) {
                    char current = line.charAt(i);
                    if (vowels.contains(current)) {
                        vowelsCount++;
                    } else if (marks.contains(current)) {
                        punctuation++;
                    } else if (current != 32) {
                        consonants++;
                    }
                }

                line = bf.readLine();
            }
            pw.write("Vowels: " + vowelsCount);
            pw.println();
            pw.write("Consonants: " + consonants);
            pw.println();
            pw.write("Punctuation: " + punctuation);
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static Set<Character> getMarks() {
        Set<Character> marks = new HashSet<>();
        marks.add('.');
        marks.add(',');
        marks.add('!');
        marks.add('?');
        return marks;
    }

    private static Set<Character> getVowels() {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('o');
        vowels.add('u');
        vowels.add('i');
        return vowels;
    }
}
