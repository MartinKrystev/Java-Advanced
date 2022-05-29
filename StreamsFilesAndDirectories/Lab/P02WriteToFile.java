package com.company.StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class P02WriteToFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String pathIn = "D:\\Java Advanced Tasks\\src\\input.txt";
        String pathOut = "D:\\Java Advanced Tasks\\src\\02.WriteToFileOutput.txt";

        Set<Character> forbiddenChars = new HashSet<>();
        Collections.addAll(forbiddenChars, ',', '.', '!', '?');

        try (FileInputStream in = new FileInputStream(pathIn);
             FileOutputStream out = new FileOutputStream(pathOut)) {
            int oneByte = in.read();
            while (oneByte != -1) {
                char byteAsChar = (char) oneByte;
                if (!forbiddenChars.contains(byteAsChar)) {
                    out.write(oneByte);
                }
                oneByte = in.read();
            }
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }

    }
}
