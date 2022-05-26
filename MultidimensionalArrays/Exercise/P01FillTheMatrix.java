package com.company.MultidimensionalArrays.Exercise;

import java.util.Scanner;

public class P01FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int rows = Integer.parseInt(input.split(", ")[0]);
        String pattern = input.split(", ")[1];

        if (pattern.equals("A")) {
            int[][] matrix = fillMatrixA(rows);
            printMatrix(matrix);
        } else if (pattern.equals("B")) {
            int[][] matrix = fillMatrixB(rows);
            printMatrix(matrix);
        }

    }

    public static int[][] fillMatrixA(int rows) {
        int[][] matrix = new int[rows][rows];
        int currentNumber = 1;
        for (int c = 0; c < rows; c++) {
            for (int r = 0; r < rows; r++) {
                matrix[r][c] = currentNumber;
                currentNumber++;
            }
        }
        return matrix;
    }

    private static int[][] fillMatrixB(int rows) {
        int[][] matrix = new int[rows][rows];
        int currentNumber = 1;
        for (int c = 0; c < rows; c++) {
            if (c % 2 == 0) {
                for (int r = 0; r < rows; r++) {
                    matrix[r][c] = currentNumber;
                    currentNumber++;
                }
            } else {
                for (int r = rows - 1; r >= 0; r--) {
                    matrix[r][c] = currentNumber;
                    currentNumber++;
                }
            }
        }

        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int el : arr) {
                System.out.print(el + " ");
            }
            System.out.println();
        }
    }
}
