package com.company.EXAM;

import java.util.Scanner;

public class P02StickyFingers {

    private static int dRow = -1;
    private static int dCol = -1;
    private static boolean isCaught = false;
    private static long stolenMoney = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[] commands = scanner.nextLine().split(",");

        char[][] matrix = readCharMatrix(size, scanner);

        for (int i = 0; i < commands.length; i++) {

            String currMove = commands[i];

            switch (currMove) {
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

            if (isCaught) {
                break;
            }
        }

        if (!isCaught) {
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", stolenMoney);
        } else {
            System.out.printf("You got caught with %d$, and you are going to jail.%n", stolenMoney);
        }

        printMatrix(matrix);

    }

    public static void printMatrix(char[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]);
                if (c < matrix[r].length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static boolean nextMoveInside(char[][] matrix, int rowMutator, int colMutator) {
        return rowMutator >= 0 && rowMutator < matrix.length && colMutator >= 0 && colMutator < matrix[0].length;
    }

    private static void move(char[][] matrix, int rowMutator, int colMutator) {
        if (nextMoveInside(matrix, dRow + rowMutator, dCol + colMutator)) {
            int nextRow = dRow + rowMutator;
            int nextCol = dCol + colMutator;

            if (matrix[nextRow][nextCol] == '$') {
                int currMoney = nextRow * nextCol;
                stolenMoney += currMoney;

                matrix[dRow][dCol] = '+';
                dRow = nextRow;
                dCol = nextCol;
                matrix[dRow][dCol] = 'D';

                System.out.printf("You successfully stole %d$.%n", currMoney);

            } else if (matrix[nextRow][nextCol] == 'P') {

                matrix[dRow][dCol] = '+';
                dRow = nextRow;
                dCol = nextCol;
                matrix[dRow][dCol] = '#';

                isCaught = true;
            } else {
                matrix[dRow][dCol] = '+';
                dRow = nextRow;
                dCol = nextCol;
                matrix[dRow][dCol] = 'D';
            }

        } else {
            System.out.println("You cannot leave the town, there is police outside!");
        }

    }

    public static char[][] readCharMatrix(int rows, Scanner scanner) {
        char[][] matrix = new char[rows][rows];
        for (int r = 0; r < rows; r++) {
            String[] input = scanner.nextLine().split("\\s+");

            for (int c = 0; c < input.length; c++) {
                matrix[r][c] = input[c].charAt(0);
                if (matrix[r][c] == 'D') {
                    dRow = r;
                    dCol = c;
                }
            }

        }
        return matrix;
    }


}
