package com.company.MultidimensionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String size = scanner.nextLine();
        int rows = Integer.parseInt(size.split("\\s+")[0]);
        int cols = Integer.parseInt(size.split("\\s+")[1]);

        String[][] matrix = readMatrix(rows, scanner);

        String command = scanner.nextLine();

        while (!command.equals("END")) {
            if (isValidCommand(command, rows, cols)) {
                String[] tokens = command.split("\\s+");
                int row1 = Integer.parseInt(tokens[1]);
                int col1 = Integer.parseInt(tokens[2]);
                int row2 = Integer.parseInt(tokens[3]);
                int col2 = Integer.parseInt(tokens[4]);

                String firstEl = matrix[row1][col1];
                String secondEl = matrix[row2][col2];

                matrix[row1][col1] = secondEl;
                matrix[row2][col2] = firstEl;

                printMatrix(matrix);
            } else {
                System.out.println("Invalid input!");
            }

            command = scanner.nextLine();
        }

    }

    public static boolean isValidCommand(String command, int rows, int cols) {
        String[] tokens = command.split("\\s+");
        if (!tokens[0].equals("swap")) {
            return false;
        }

        if (tokens.length != 5) {
            return false;
        }

        int row1 = Integer.parseInt(tokens[1]);
        int col1 = Integer.parseInt(tokens[2]);
        int row2 = Integer.parseInt(tokens[3]);
        int col2 = Integer.parseInt(tokens[4]);

        if (row1 < 0 || row1 > rows || col1 < 0 || col1 > cols
                || row2 < 0 || row2 > rows || col2 < 0 || col2 > cols) {
            return false;
        }
        return true;
    }

    public static void printMatrix(String[][] matrix) {
        for (String[] arr : matrix) {
            for (String el : arr) {
                System.out.print(el + " ");
            }
            System.out.println();
        }
    }

    public static String[][] readMatrix(int rows, Scanner scanner) {
        String[][] matrix = new String[rows][];
        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
        return matrix;
    }
}
