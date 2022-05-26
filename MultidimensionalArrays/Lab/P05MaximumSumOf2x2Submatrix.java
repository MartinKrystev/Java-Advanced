package com.company.MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P05MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine().split(", ")[0]);

        int[][] matrix = readMatrix(rows, scanner, ", ");

        int sum = 0;
        int[][] maxMatrix = new int[2][2];

        for (int r = 0; r < matrix.length - 1; r++) {
            for (int c = 0; c < matrix[r].length - 1; c++) {
                int curr = matrix[r][c];
                int right = matrix[r][c + 1];
                int bottom = matrix[r + 1][c];
                int bottomRight = matrix[r + 1][c + 1];

                int currSum = curr + right + bottom + bottomRight;

                if (currSum > sum) {
                    sum = currSum;
                    maxMatrix = new int[][]{
                            {curr, right},
                            {bottom, bottomRight}
                    };
                }
            }
        }
        printMatrix(maxMatrix);
        System.out.println(sum);
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

    public static void printMatrix(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int el : arr) {
                System.out.print(el + " ");
            }
            System.out.println();
        }
    }
}
