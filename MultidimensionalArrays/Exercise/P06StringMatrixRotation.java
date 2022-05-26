package com.company.MultidimensionalArrays.Exercise;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P06StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rotationCommand = scanner.nextLine();
        String regex = "[0-9]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(rotationCommand);

        int degrees = 0;
        while (matcher.find()) {
            degrees = Integer.parseInt(matcher.group());
        }

        String input = scanner.nextLine();

        ArrayList<String> text = new ArrayList<>();
        while (!input.equals("END")) {
            text.add(input);
            input = scanner.nextLine();
        }

        int cols = 0;
        for (int i = 0; i < text.size(); i++) {
            if (cols < text.get(i).length()) {
                cols = text.get(i).length();
            }
        }

        char[][] matrix = new char[text.size()][cols];

        for (int i = 0; i < text.size(); i++) {
            while (text.get(i).length() < cols) {
                text.set(i, text.get(i) + " ");
            }
            matrix[i] = text.get(i).toCharArray();
        }

        int rotations = degrees / 90;
        while (rotations >= 4) {
            rotations -= 4;
        }

        for (int i = 0; i < rotations; i++) {
            matrix = rotate90(matrix);
        }
        printMatrix(matrix);
    }

    private static char[][] rotate90(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        char[][] rotatedMatrix = new char[cols][rows];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                rotatedMatrix[col][matrix.length - 1 - row] = matrix[row][col];
            }
        }
        return rotatedMatrix;
    }

    public static void printMatrix(char[][] matrix) {
        for (char[] arr : matrix) {
            for (char el : arr) {
                System.out.print(el + " ");
            }
            System.out.println();
        }
    }
}
