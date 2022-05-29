package com.company.StreamsFilesAndDirectories.Exercise;

import java.io.File;

public class P08GetFolderSize {
    public static void main(String[] args) {

        String path = "D:\\Java Advanced Tasks\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";

        File folder = new File(path);

        File[] allFiles = folder.listFiles();

        int size = 0;
        for (File file : allFiles) {
            size += file.length();
        }
        System.out.println("Folder size: " + size);

    }
}
