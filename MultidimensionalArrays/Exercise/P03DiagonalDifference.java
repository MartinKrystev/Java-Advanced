package com.company.MultidimensionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = readMatrix(size, scanner);
        int firstSum = getFirstSum(matrix, size);
        int secondSum = getSecondSum(matrix, size);


        System.out.println(Math.abs(firstSum - secondSum));
    }

    private static int getSecondSum(int[][] matrix, int size) {
        int sum = 0;
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (r + c == size - 1) {
                    sum += matrix[r][c];
                }
            }
        }
        return sum;
    }

    private static int getFirstSum(int[][] matrix, int size) {
        int sum = 0;
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (r == c) {
                    sum += matrix[r][c];
                }
            }
        }
        return sum;
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
