package com.company.MultidimensionalArrays.Exercise;

import java.util.Scanner;

public class P02MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int rows = Integer.parseInt(input.split("\\s+")[0]);
        int cols = Integer.parseInt(input.split("\\s+")[1]);

        String[][] matrix = fillMatrix(rows, cols);
        printMatrix(matrix);
    }

    public static String[][] fillMatrix(int rows, int cols) {
        String[][] matrix = new String[rows][cols];

        char start = 97;
        char middle = 97;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                StringBuilder sb = new StringBuilder();
                sb.append(start);
                sb.append(middle);
                sb.append(start);
                matrix[r][c] = sb.toString();
                middle++;
            }
            start++;
            middle = start;
        }
        return matrix;
    }

    public static void printMatrix(String[][] matrix) {
        for (String[] arr : matrix) {
            for (String el : arr) {
                System.out.print(el + " ");
            }
            System.out.println();
        }
    }
}
