package com.company.MultidimensionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P04MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String size = scanner.nextLine();
        int rows = Integer.parseInt(size.split("\\s+")[0]);
        int cols = Integer.parseInt(size.split("\\s+")[1]);

        int[][] matrix = readMatrix(rows, scanner);

        int[][] maxMatrix = new int[3][3];

        int sum = 0;

        for (int r = 0; r < rows - 2; r++) {
            for (int c = 0; c < cols - 2; c++) {
                int firstOne = matrix[r][c];
                int firstTwo = matrix[r][c + 1];
                int firstThree = matrix[r][c + 2];

                int secondOne = matrix[r + 1][c];
                int secondTwo = matrix[r + 1][c + 1];
                int secondThree = matrix[r + 1][c + 2];

                int thirdOne = matrix[r + 2][c];
                int thirdTwo = matrix[r + 2][c + 1];
                int thirdThree = matrix[r + 2][c + 2];

                int currSum = firstOne + firstTwo + firstThree
                        + secondOne + secondTwo + secondThree
                        + thirdOne + thirdTwo + thirdThree;

                if (sum < currSum) {
                    sum = currSum;
                    maxMatrix = new int[][]{
                            {firstOne, firstTwo, firstThree},
                            {secondOne, secondTwo, secondThree},
                            {thirdOne, thirdTwo, thirdThree}
                    };
                }
            }
        }

        System.out.println("Sum = " + sum);
        printMatrix(maxMatrix);
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int el : arr) {
                System.out.print(el + " ");
            }
            System.out.println();
        }
    }

    public static int[][] readMatrix(int rows, Scanner scanner) {
        int[][] matrix = new int[rows][];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrix;
    }
}
