package com.company.MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P08WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        int[][] matrix = readMatrix(rows, scanner, "\\s+");

        int[][] outputMatrix = new int[matrix.length][matrix[0].length];

        String[] wrongIndex = scanner.nextLine().split("\\s+");
        int wrongIndexRow = Integer.parseInt(wrongIndex[0]);
        int wrongIndexCol = Integer.parseInt(wrongIndex[1]);

        int wrongNumber = matrix[wrongIndexRow][wrongIndexCol];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int current = matrix[row][col];

                int replacement = 0;

                if (current == wrongNumber) {
                    if (UpIsInside(matrix, row, col, wrongNumber)) {
                        replacement += matrix[row - 1][col];
                    }
                    if (DownIsInside(matrix, row, col, wrongNumber)) {
                        replacement += matrix[row + 1][col];
                    }
                    if (LeftIsInside(matrix, row, col, wrongNumber)) {
                        replacement += matrix[row][col - 1];
                    }
                    if (RightIsInside(matrix, row, col, wrongNumber)) {
                        replacement += matrix[row][col + 1];
                    }
                    outputMatrix[row][col] = replacement;
                } else {
                    outputMatrix[row][col] = matrix[row][col];
                }

            }
        }

        printMatrix(outputMatrix);
    }

    public static int[][] readMatrix(int rows, Scanner scanner, String splitPattern) {
        int[][] matrix = new int[rows][];
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine()
                            .split(splitPattern))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrix;
    }

    public static boolean UpIsInside(int[][] matrix, int row, int col, int wrongNumber) {
        if (row - 1 < 0 || matrix[row - 1][col] == wrongNumber) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean DownIsInside(int[][] matrix, int row, int col, int wrongNumber) {
        if (row + 1 >= matrix.length || matrix[row + 1][col] == wrongNumber) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean LeftIsInside(int[][] matrix, int row, int col, int wrongNumber) {
        if (col - 1 < 0 || matrix[row][col - 1] == wrongNumber) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean RightIsInside(int[][] matrix, int row, int col, int wrongNumber) {
        if (col + 1 >= matrix[row].length || matrix[row][col + 1] == wrongNumber) {
            return false;
        } else {
            return true;
        }
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
