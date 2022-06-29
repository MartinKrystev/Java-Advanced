package com.company.ExamPrep.Exam12;

import java.util.Scanner;

public class ReVolt {
    private static int playerRow = -1;
    private static int playerCol = -1;
    private static boolean heWon = false;
    private static boolean isBonus = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int numberCommands = Integer.parseInt(scanner.nextLine());

        char[][] matrix = readCharMatrix(size, scanner);
        matrix[playerRow][playerCol] = '-';

        for (int i = 0; i < numberCommands; i++) {
            String direction = scanner.nextLine();

            switch (direction) {
                case "up":
                    move(matrix, -1, 0);
                    break;
                case "down":
                    move(matrix, +1, 0);
                    break;
                case "left":
                    move(matrix, 0, -1);
                    break;
                case "right":
                    move(matrix, 0, +1);
                    break;
            }

            if (heWon) {
                break;
            }
        }
        matrix[playerRow][playerCol] = 'f';

        if (heWon) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }

        printMatrix(matrix);


    }

    public static void printMatrix(char[][] matrix) {
        for (char[] arr : matrix) {
            for (char el : arr) {
                System.out.print(el);
            }
            System.out.println();
        }
    }

    public static boolean isInside(char[][] matrix, int rowMutator, int colMutator) {
        return rowMutator >= 0 && rowMutator < matrix.length && colMutator >= 0 && colMutator <= matrix[0].length;
    }

    public static void move(char[][] matrix, int rowMutator, int colMutator) {
        if (!isInside(matrix, playerRow + rowMutator, playerCol + colMutator)) {

            if (rowMutator < 0) {
                playerRow = matrix.length - 1;
            }
            if (rowMutator >= matrix.length) {
                playerRow = 0;
            }
            if (colMutator < 0) {
                playerCol = matrix.length - 1;
            }
            if (colMutator >= matrix[0].length) {
                playerCol = 0;
            }
        } else {
            int nextRow = playerRow + rowMutator;
            int nextCol = playerCol + colMutator;

            if (matrix[nextRow][nextCol] == 'F') {
                heWon = true;
                playerRow = nextRow;
                playerCol = nextCol;
            } else if (matrix[nextRow][nextCol] == 'B') {
                isBonus = true;
                playerRow = nextRow;
                playerCol = nextCol;
            } else if (matrix[nextRow][nextCol] == 'T') {
                //
            } else {
                playerRow = nextRow;
                playerCol = nextCol;
            }
        }

        if (matrix[playerRow][playerCol] == 'F') {
            heWon = true;
        }

        if (isBonus) {
            isBonus = false;
            move(matrix, rowMutator, colMutator);
        }

    }

    public static char[][] readCharMatrix(int rows, Scanner scanner) {
        char[][] matrix = new char[rows][rows];
        for (int r = 0; r < rows; r++) {
            String[] input = scanner.nextLine().split("");
            for (int c = 0; c < input.length; c++) {
                matrix[r][c] = input[c].charAt(0);
                if (matrix[r][c] == 'f') {
                    playerRow = r;
                    playerCol = c;
                }
            }

        }
        return matrix;
    }

}
