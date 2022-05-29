package com.company.StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class P03CopyBytes {
    public static void main(String[] args) throws FileNotFoundException {
        String inPath = "D:\\Java Advanced Tasks\\src\\input.txt";
        String outPath = "D:\\Java Advanced Tasks\\src\\03.CopyBytesOutput.txt";

        try (FileInputStream in = new FileInputStream(inPath);
             FileOutputStream out = new FileOutputStream(outPath)) {
            int oneByte = in.read();
            while (oneByte >= 0) {
                if (oneByte == 10 || oneByte == 32) {
                    out.write(oneByte);
                } else {
                    String digits = String.valueOf(oneByte);
                    for (int i = 0; i < digits.length(); i++) {
                        out.write(digits.charAt(i));
                    }
                }
                oneByte = in.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
