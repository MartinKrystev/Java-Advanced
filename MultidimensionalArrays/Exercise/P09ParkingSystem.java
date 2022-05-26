package com.company.MultidimensionalArrays.Exercise;

import java.util.Scanner;

public class P09ParkingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        boolean[][] matrix = fillMatrix(rows, cols);
        String input = scanner.nextLine();

        while (!input.equals("stop")) {
            int entryRow = Integer.parseInt(input.split(" ")[0]);
            int targetRow = Integer.parseInt(input.split(" ")[1]);
            int targetCol = Integer.parseInt(input.split(" ")[2]);

            int distance = (Math.abs(targetRow - entryRow)) + 1;
            boolean isParked = false;
            boolean isParkedLeft = false;
            boolean isParkedRight = false;
            int leftCol = 0;
            int rightCol = 0;

            if (matrix[targetRow][targetCol]) {// can NOT park
                int counter = 1;
                while (counter < Integer.MAX_VALUE) {
                    // test LEFT <---
                    if (targetCol - counter < 1 && targetCol + counter >= cols) {
                        break;
                    }
                    if (targetCol - counter > 0 && !matrix[targetRow][targetCol - counter]) { // park there
                        isParked = true;
                        isParkedLeft = true;
                        leftCol = targetCol - counter;
                        break;
                    }
                    // test RIGHT --->
                    if (targetCol + counter < cols && !matrix[targetRow][targetCol + counter]) { // park there
                        isParked = true;
                        isParkedRight = true;
                        rightCol = targetCol + counter;
                        break;
                    }
                    counter++;
                }
                if (isParkedLeft) {
                    matrix[targetRow][leftCol] = true;
                    distance += leftCol;
                } else if (isParkedRight) {
                    matrix[targetRow][rightCol] = true;
                    distance += rightCol;
                }

            } else {
                matrix[targetRow][targetCol] = true; // park there
                isParked = true;
                distance += targetCol;
            }

            if (isParked) {
                System.out.println(distance);
            } else {
                System.out.printf("Row %d full%n", targetRow);
            }
            input = scanner.nextLine();
        }
    }

    private static boolean[][] fillMatrix(int rows, int cols) {
        boolean[][] matrix = new boolean[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                matrix[r][c] = false;
            }
        }
        return matrix;
    }
}
