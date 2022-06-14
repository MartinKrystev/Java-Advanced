package com.company.ExamPrep.Exam1;

import java.util.Scanner;

public class P02Armory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        char[][] matrix = readCharMatrix(rows, scanner);

        int officerRow = -1;
        int officerCol = -1;

        // Find the Officer position
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'A') {
                    officerRow = row;
                    officerCol = col;
                }
            }
        }

        // Starts moving
        boolean isInside = true;
        int coins = 0;
        while (coins < 65) {
            String direction = scanner.nextLine();

            switch (direction) {
                case "up":
                    if (officerRow - 1 < 0) {
                        isInside = leavesTheMatrix(matrix[officerRow], officerCol, isInside);
                        break;
                    }
                    if (matrix[officerRow - 1][officerCol] >= 48 && matrix[officerRow - 1][officerCol] <= 57) { // is digit
                        int currDigit = swordValue(matrix, officerRow - 1, officerCol);
                        coins += currDigit;
                        matrix[officerRow][officerCol] = '-';       // leaves the old spot to '-'
                        matrix[officerRow - 1][officerCol] = 'A';   // moves the mark         'A'
                        officerRow -= 1;
                    } else if (matrix[officerRow - 1][officerCol] == '-') {                                     // is empty slot
                        matrix[officerRow][officerCol] = '-';       // leaves the old spot to '-'
                        matrix[officerRow - 1][officerCol] = 'A';   // moves the mark         'A'
                        officerRow -= 1;
                    } else if (matrix[officerRow - 1][officerCol] == 'M') {                                     // has to move to the other 'M'
                        matrix[officerRow][officerCol] = '-';       // leaves the old spot to '-'
                        matrix[officerRow - 1][officerCol] = '-';   // moves to the new spot to Teleport and leaves '-'
                        for (int r = 0; r < rows; r++) {
                            for (int c = 0; c < matrix[r].length; c++) {
                                if (matrix[r][c] == 'M') {          //found the second 'M'
                                    matrix[r][c] = 'A';
                                    officerRow = r;
                                    officerCol = c;
                                    break;
                                }
                            }
                        }
                    }
                    break;
                case "down":
                    if (officerRow + 1 >= rows) {
                        isInside = leavesTheMatrix(matrix[officerRow], officerCol, isInside);
                        break;
                    }
                    if (matrix[officerRow + 1][officerCol] >= 48 && matrix[officerRow + 1][officerCol] <= 57) { // is digit
                        int currDigit = swordValue(matrix, officerRow + 1, officerCol);
                        coins += currDigit;
                        matrix[officerRow][officerCol] = '-';       // leaves the old spot to '-'
                        matrix[officerRow + 1][officerCol] = 'A';   // moves the mark         'A'
                        officerRow += 1;
                    } else if (matrix[officerRow + 1][officerCol] == '-') {                                     // is empty slot
                        matrix[officerRow][officerCol] = '-';       // leaves the old spot to '-'
                        matrix[officerRow + 1][officerCol] = 'A';   // moves the mark         'A'
                        officerRow += 1;
                    } else if (matrix[officerRow + 1][officerCol] == 'M') {                                     // has to move to the other 'M'
                        matrix[officerRow][officerCol] = '-';       // leaves the old spot to '-'
                        matrix[officerRow + 1][officerCol] = '-';   // moves to the new spot to Teleport and leaves '-'
                        for (int r = 0; r < rows; r++) {
                            for (int c = 0; c < matrix[r].length; c++) {
                                if (matrix[r][c] == 'M') {          //found the second 'M'
                                    matrix[r][c] = 'A';
                                    officerRow = r;
                                    officerCol = c;
                                    break;
                                }
                            }
                        }
                    }
                    break;
                case "left":
                    if (officerCol - 1 < 0) {
                        isInside = leavesTheMatrix(matrix[officerRow], officerCol, isInside);
                        break;
                    }
                    if (matrix[officerRow][officerCol - 1] >= 48 && matrix[officerRow][officerCol - 1] <= 57) { // is digit
                        int currDigit = swordValue(matrix, officerRow, officerCol - 1);
                        coins += currDigit;
                        matrix[officerRow][officerCol] = '-';       // leaves the old spot to '-'
                        matrix[officerRow][officerCol - 1] = 'A';   // moves the mark         'A'
                        officerCol -= 1;
                    } else if (matrix[officerRow][officerCol - 1] == '-') {                                     // is empty slot
                        matrix[officerRow][officerCol] = '-';       // leaves the old spot to '-'
                        matrix[officerRow][officerCol - 1] = 'A';   // moves the mark         'A'
                        officerCol -= 1;
                    } else if (matrix[officerRow][officerCol - 1] == 'M') {                                     // has to move to the other 'M'
                        matrix[officerRow][officerCol] = '-';       // leaves the old spot to '-'
                        matrix[officerRow][officerCol - 1] = '-';   // moves to the new spot to Teleport and leaves '-'
                        for (int r = 0; r < rows; r++) {
                            for (int c = 0; c < matrix[r].length; c++) {
                                if (matrix[r][c] == 'M') {          //found the second 'M'
                                    matrix[r][c] = 'A';
                                    officerRow = r;
                                    officerCol = c;
                                    break;
                                }
                            }
                        }
                    }
                    break;
                case "right":
                    if (officerCol + 1 >= rows) {
                        isInside = leavesTheMatrix(matrix[officerRow], officerCol, isInside);
                        break;
                    }
                    if (matrix[officerRow][officerCol + 1] >= 48 && matrix[officerRow][officerCol + 1] <= 57) { // is digit
                        int currDigit = swordValue(matrix, officerRow, officerCol + 1);
                        coins += currDigit;
                        matrix[officerRow][officerCol] = '-';       // leaves the old spot to '-'
                        matrix[officerRow][officerCol + 1] = 'A';   // moves the mark         'A'
                        officerCol += 1;
                    } else if (matrix[officerRow][officerCol + 1] == '-') {                                     // is empty slot
                        matrix[officerRow][officerCol] = '-';       // leaves the old spot to '-'
                        matrix[officerRow][officerCol + 1] = 'A';   // moves the mark         'A'
                        officerCol += 1;
                    } else if (matrix[officerRow][officerCol + 1] == 'M') {                                     // has to move to the other 'M'
                        matrix[officerRow][officerCol] = '-';       // leaves the old spot to '-'
                        matrix[officerRow][officerCol + 1] = '-';   // moves to the new spot to Teleport and leaves '-'
                        for (int r = 0; r < rows; r++) {
                            for (int c = 0; c < matrix[r].length; c++) {
                                if (matrix[r][c] == 'M') {          //found the second 'M'
                                    matrix[r][c] = 'A';
                                    officerRow = r;
                                    officerCol = c;
                                    break;
                                }
                            }
                        }
                    }
                    break;
            }
            if (coins >= 65) {
                break;
            }
            if (!isInside){
                break;
            }
        }

        if (!isInside){
            System.out.println("I do not need more swords!");
        } else {
            System.out.println("Very nice swords, I will come back for more!");
        }
        System.out.printf("The king paid %d gold coins. %n", coins);
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

    private static boolean leavesTheMatrix(char[] matrix, int officerCol, boolean isInside) {
        //boolean isInside;
        matrix[officerCol] = '-';
        isInside = false;
        return isInside;
    }

    private static int swordValue(char[][] matrix, int officerRow, int officerCol) {
        if (matrix[officerRow][officerCol] == 48) {
            return 0;
        } else if (matrix[officerRow][officerCol] == 49) {
            return 1;
        } else if (matrix[officerRow][officerCol] == 50) {
            return 2;
        } else if (matrix[officerRow][officerCol] == 51) {
            return 3;
        } else if (matrix[officerRow][officerCol] == 52) {
            return 4;
        } else if (matrix[officerRow][officerCol] == 53) {
            return 5;
        } else if (matrix[officerRow][officerCol] == 54) {
            return 6;
        } else if (matrix[officerRow][officerCol] == 55) {
            return 7;
        } else if (matrix[officerRow][officerCol] == 56) {
            return 8;
        } else {
            return 9;
        }
    }

    public static char[][] readCharMatrix(int rows, Scanner scanner) {
        char[][] matrix = new char[rows][rows];
        for (int row = 0; row < rows; row++) {
            String input = scanner.nextLine();
            for (int i = 0; i < rows; i++) {
                char curr = input.charAt(i);
                matrix[row][i] = curr;
            }
        }
        return matrix;
    }
}
