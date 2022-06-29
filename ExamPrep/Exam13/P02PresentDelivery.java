package com.company.ExamPrep.Exam13;

import java.util.Scanner;

public class P02PresentDelivery {
    private static int santaRow = -1;
    private static int santaCol = -1;
    private static int happyKids = 0;
    private static int allNiceKids = 0;
    private static int presents = -1;
    private static boolean outOfPresents = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        presents = Integer.parseInt(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = readCharMatrix(size, scanner);

        String command = scanner.nextLine();
        while (!command.equals("Christmas morning") && presents > 0) {

            switch (command) {
                case "up":
                    moveSanta(matrix, -1, 0);
                    break;
                case "down":
                    moveSanta(matrix, 1, 0);
                    break;
                case "left":
                    moveSanta(matrix, 0, -1);
                    break;
                case "right":
                    moveSanta(matrix, 0, 1);
                    break;
            }

            if (presents <= 0) {
                outOfPresents = true;
                break;
            }
            command = scanner.nextLine();
        }

        if (outOfPresents) {
            System.out.println("Santa ran out of presents!");
        }
        printMatrix(matrix);

        if (allNiceKids - happyKids > 0) {
            System.out.printf("No presents for %d nice kid/s.", allNiceKids - happyKids);
        } else {
            System.out.printf("Good job, Santa! %d happy nice kid/s.",happyKids);
        }

    }

    public static void printMatrix(char[][] matrix) {
        for (char[] arr : matrix) {
            for (char el : arr) {
                System.out.print(el + " ");
            }
            System.out.println();
        }
    }

    public static boolean santaIsInTheMatrix(char[][] matrix, int rowMutator, int colMutator) {
        return rowMutator >= 0 && rowMutator < matrix.length && colMutator >= 0 && colMutator <= matrix[0].length;
    }

    private static void moveSanta(char[][] matrix, int rowMutator, int colMutator) {
        if (!santaIsInTheMatrix(matrix, santaRow + rowMutator, santaCol + colMutator)) {
            outOfPresents = true;
        } else {
            int nextRow = santaRow + rowMutator;
            int nextCol = santaCol + colMutator;

            if (matrix[nextRow][nextCol] == 'C') {
                checkAround(matrix, nextRow, nextCol);
            } else if (matrix[nextRow][nextCol] == 'V') {
                happyKids++;
                presents--;

            }

            matrix[santaRow][santaCol] = '-';
            matrix[nextRow][nextCol] = 'S';
            santaRow = nextRow;
            santaCol = nextCol;
        }
    }

    private static void checkAround(char[][] matrix, int nextRow, int nextCol) {
        // up
        if (matrix[nextRow - 1][nextCol] == 'V') {
            happyKids++;
            presents--;
        } else if (matrix[nextRow - 1][nextCol] == 'X') {
            presents--;
        }
        // down
        if (matrix[nextRow + 1][nextCol] == 'V') {
            happyKids++;
            presents--;
        } else if (matrix[nextRow + 1][nextCol] == 'X') {
            presents--;
        }
        // left
        if (matrix[nextRow][nextCol - 1] == 'V') {
            happyKids++;
            presents--;
        } else if (matrix[nextRow][nextCol - 1] == 'X') {
            presents--;
        }
        // right
        if (matrix[nextRow][nextCol + 1] == 'V') {
            happyKids++;
            presents--;
        } else if (matrix[nextRow][nextCol + 1] == 'X') {
            presents--;
        }
        matrix[nextRow - 1][nextCol] = '-';
        matrix[nextRow + 1][nextCol] = '-';
        matrix[nextRow][nextCol - 1] = '-';
        matrix[nextRow][nextCol + 1] = '-';
    }

    public static char[][] readCharMatrix(int rows, Scanner scanner) {
        char[][] matrix = new char[rows][rows];
        for (int r = 0; r < rows; r++) {
            String[] input = scanner.nextLine().split("\\s+");
            for (int c = 0; c < input.length; c++) {
                matrix[r][c] = input[c].charAt(0);
                if (matrix[r][c] == 'S') {
                    santaRow = r;
                    santaCol = c;
                }
                if (matrix[r][c] == 'V') {
                    allNiceKids++;
                }
            }

        }
        return matrix;
    }
}
