package com.company.MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P04SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String sizes = scanner.nextLine();
        int rows = Integer.parseInt(sizes.split(", ")[0]);
        int cols = Integer.parseInt(sizes.split(", ")[1]);

        int[][] matrix = readMatrix(rows, cols, scanner);

        System.out.println(matrix.length);
        System.out.println(matrix[0].length);

        int sum = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                sum += matrix[row][col];
            }
        }

        System.out.println(sum);

    }

    public static int[][] readMatrix(int rows, int cols, Scanner scanner) {
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrix;
    }
}
