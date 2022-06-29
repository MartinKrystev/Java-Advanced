package com.company.ExamPrep.Exam11;

import java.util.Scanner;

public class Snake {
    private static int snakeRow = -1;
    private static int snakeCol = -1;
    private static int food = 0;
    private static boolean isOutside = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = readCharMatrix(size, scanner);

        while (food < 10 ) {
            String command = scanner.nextLine();
            switch (command) {
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
            if (isOutside) {
                break;
            }
        }

        if (isOutside) {
            System.out.println("Game over!");
            matrix[snakeRow][snakeCol] = '.';
        } else {
            System.out.println("You won! You fed the snake.");
        }
        System.out.printf("Food eaten: %d%n", food);
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

    public static boolean nextMoveInside(char[][] matrix, int rowMutator, int colMutator) {
        return rowMutator >= 0 && rowMutator < matrix.length && colMutator >= 0 && colMutator <= matrix[0].length;
    }

    private static void move(char[][] matrix, int rowMutator, int colMutator) {
        if (nextMoveInside(matrix, snakeRow + rowMutator, snakeCol + colMutator)) {
            int nextRow = snakeRow + rowMutator;
            int nextCol = snakeCol + colMutator;

            if (matrix[nextRow][nextCol] == '*') {
                food++;
                changeTheMark(matrix, nextRow, nextCol);
            } else if (matrix[nextRow][nextCol] == 'B') {
                matrix[snakeRow][snakeCol] = '.';
                matrix[nextRow][nextCol] = '.';
                burrowAndUp(matrix);
            } else {
                changeTheMark(matrix, nextRow, nextCol);
            }
        } else {
            isOutside = true;
        }
    }

    private static void burrowAndUp(char[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 'B'){
                    snakeRow = r;
                    snakeCol = c;
                    matrix[r][c] = 'S';
                }
            }
        }
    }

    private static void changeTheMark(char[][] matrix, int nextRow, int nextCol) {
        matrix[snakeRow][snakeCol] ='.';
        matrix[nextRow][nextCol] = 'S';
        snakeRow = nextRow;
        snakeCol = nextCol;
    }

    public static char[][] readCharMatrix(int rows, Scanner scanner) {
        char[][] matrix = new char[rows][rows];
        for (int r = 0; r < rows; r++) {
            String[] input = scanner.nextLine().split("");
            for (int c = 0; c < input.length; c++) {
                matrix[r][c] = input[c].charAt(0);
                if (matrix[r][c] == 'S') {
                    snakeRow = r;
                    snakeCol = c;
                }
            }

        }
        return matrix;
    }
}
