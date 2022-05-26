package com.company.MultidimensionalArrays.Lab;

import java.util.Scanner;

public class P03IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = readCharMatrix(rows, cols, scanner);
        char[][] secondMatrix = readCharMatrix(rows, cols, scanner);

        char[][] finalMatrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char fillChar = firstMatrix[row][col] == secondMatrix[row][col]
                        ? firstMatrix[row][col] : '*';
                finalMatrix[row][col] = fillChar;
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(finalMatrix[row][col] + " ");
            }
            System.out.println();
        }

    }

    public static char[][] readCharMatrix(int rows, int cols, Scanner scanner) {
        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            String line = scanner.nextLine();
            String[] elements = line.split("\\s+");
            for (int i = 0; i < elements.length; i++) {
                char curr = elements[i].charAt(0);
                matrix[row][i] = curr;
            }
        }
        return matrix;
    }
}
