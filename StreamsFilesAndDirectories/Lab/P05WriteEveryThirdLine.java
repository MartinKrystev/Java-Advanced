package com.company.StreamsFilesAndDirectories.Lab;

import java.io.*;
import java.util.Scanner;

public class P05WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        String inPath = "D:\\Java Advanced Tasks\\src\\input.txt";
        String outPath = "D:\\Java Advanced Tasks\\src\\05.WriteEveryThirdLineOutput.txt";

        Scanner in = new Scanner(new FileReader(inPath));
        PrintWriter out = new PrintWriter(new FileWriter(outPath));

        int coutner = 1;
        String line = in.nextLine();
        while (in.hasNextLine()) {
            if (coutner % 3 == 0) {
                out.println(line);
            }
            coutner++;
            line = in.nextLine();
        }
        out.close();
    }
}
