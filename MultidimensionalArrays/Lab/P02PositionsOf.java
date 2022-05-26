package com.company.MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P02PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine().split("\\s+")[0]);

        int[][] matrix = readMatrix(rows, scanner);

        boolean isFound = false;

        int numberToFind = Integer.parseInt(scanner.nextLine());

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (numberToFind == matrix[row][col]) {
                    isFound = true;
                    System.out.println(row + " " + col);
                }
            }
        }

        if (!isFound) {
            System.out.println("not found");
        }
    }

    public static int[][] readMatrix(int rows, Scanner scanner) {
        int[][] matrix = new int[rows][];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(e -> Integer.parseInt(e))
                    .toArray();
        }
        return matrix;
    }

}
