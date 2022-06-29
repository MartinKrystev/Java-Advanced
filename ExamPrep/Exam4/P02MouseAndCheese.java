package com.company.ExamPrep.Exam4;

import java.util.Scanner;

public class P02MouseAndCheese {

    private static int mouseRow = -1;
    private static int mouseCol = -1;
    private static int cheese = 0;
    private static boolean isInside = true;
    private static boolean isBonus = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = readCharMatrix(size, scanner);

        String command = scanner.nextLine();
        while (!command.equals("end")) {

            switch (command) {
                case "up":
                    moveMouse(matrix, -1, 0);
                    break;
                case "down":
                    moveMouse(matrix, 1, 0);
                    break;
                case "left":
                    moveMouse(matrix, 0, -1);
                    break;
                case "right":
                    moveMouse(matrix, 0, 1);
                    break;
            }

            if (!isInside) {
                break;
            }

            command = scanner.nextLine();
        }

        if (!isInside) {
            System.out.println("Where is the mouse?");
        }

        if (cheese < 5) {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - cheese);
        } else {
            System.out.printf("Great job, the mouse is fed %d cheeses!", cheese);
        }

        printMatrix(matrix);

    }

    private static void moveMouse(char[][] matrix, int rowMutator, int colMutator) {

        int nextRow = mouseRow + rowMutator;
        int nextCol = mouseCol + colMutator;


        if (!isInsideTheField(matrix, nextRow, nextCol)) {
            matrix[mouseRow][mouseCol] = '-';
            isInside = false;
            return;
        }
        if (matrix[nextRow][nextCol] == 'c') {
            cheese++;
        } else if (matrix[nextRow][nextCol] == 'B') {
            isBonus = true;
        }

        matrix[mouseRow][mouseCol] = '-';
        matrix[nextRow][nextCol] = 'M';
        mouseRow = nextRow;
        mouseCol = nextCol;

        if (isBonus) {
            isBonus = false;
            moveMouse(matrix, rowMutator, colMutator);
        }
    }

    private static boolean isInsideTheField(char[][] matrix, int mouseRow, int mouseCol) {
        return mouseRow >= 0 && mouseRow < matrix.length && mouseCol >= 0 && mouseCol < matrix[mouseRow].length;
    }

    public static void printMatrix(char[][] matrix) {
        for (char[] arr : matrix) {
            for (char el : arr) {
                System.out.print(el);
            }
            System.out.println();
        }
    }

    public static char[][] readCharMatrix(int rows, Scanner scanner) {
        char[][] matrix = new char[rows][];
        for (int row = 0; row < rows; row++) {
            String line = scanner.nextLine();
            matrix[row] = line.toCharArray();
            if (line.contains("M")) {
                mouseRow = row;
                mouseCol = line.indexOf("M");
            }

        }
        return matrix;
    }
}
