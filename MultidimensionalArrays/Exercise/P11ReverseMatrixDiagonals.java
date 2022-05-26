package com.company.MultidimensionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P11ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = readMatrix(rows, scanner, " ");


        while (cols > 0) { // moves the cols to the LEFT
            int rowTemp = rows;
            int colTemp = cols;

            while (colTemp <= matrix[0].length && rowTemp - 1 >= 0) {
                System.out.print(matrix[rowTemp - 1][colTemp - 1] + " ");
                rowTemp--;
                colTemp++;
            }

            System.out.println();
            cols--;
        }

        while (rows >= 0) { // moves the rows UP
            int rowTemp = rows;
            int colsTemp = 0;

            while (rowTemp - 1 - 1 >= 0) {
                System.out.print(matrix[rowTemp - 1 - 1][colsTemp] + " ");
                rowTemp--;
                colsTemp++;
            }
            System.out.println();
            rows--;
        }


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
}
