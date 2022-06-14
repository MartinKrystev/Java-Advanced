package com.company.ExamPrep.Exam2;

import java.util.Scanner;

public class P02PawnWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] matrix = readCharMatrix(8, scanner);

        int wRow = -1;
        int wCol = -1;
        int bRow = -1;
        int bCol = -1;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'w') {
                    wRow = row;
                    wCol = col;
                }
            }
        }
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'b') {
                    bRow = row;
                    bCol = col;
                }
            }
        }
        boolean whiteIsPromoted = false;
        boolean blackIsPromoted = false;
        boolean whiteCaptures = false;
        boolean blackCaptures = false;

        int counter = 0;
        while (wRow >= 0 || bRow < 8) {
            if (counter % 2 == 0) {

                if (wCol - 1 < 0) {
                    if (wRow - 1 == 0 && matrix[wRow - 1][wCol + 1] == '-') {
                        matrix[wRow - 1][wCol] = 'w';
                        matrix[wRow][wCol] = '-';
                        wRow -= 1;
                        whiteIsPromoted = true;
                        break;
                    } else if (matrix[wRow - 1][wCol + 1] == 'b') {
                        matrix[wRow - 1][wCol + 1] = 'w';
                        matrix[wRow][wCol] = '-';
                        wRow -= 1;
                        wCol += 1;
                        whiteCaptures = true;
                        break;
                    } else {
                        matrix[wRow - 1][wCol] = 'w';
                        matrix[wRow][wCol] = '-';
                        wRow -= 1;
                    }
                } else if (wCol + 1 == 7) {
                    if (wRow - 1 == 0 && matrix[wRow - 1][wCol + 1] == '-') {
                        matrix[wRow - 1][wCol] = 'w';
                        matrix[wRow][wCol] = '-';
                        wRow -= 1;
                        whiteIsPromoted = true;
                        break;
                    } else if (matrix[wRow - 1][wCol + 1] == 'b') {
                        matrix[wRow - 1][wCol + 1] = 'w';
                        matrix[wRow][wCol] = '-';
                        wRow -= 1;
                        wCol += 1;
                        whiteCaptures = true;
                        break;
                    } else {
                        matrix[wRow - 1][wCol] = 'w';
                        matrix[wRow][wCol] = '-';
                        wRow -= 1;
                    }
                } else {
                    if (wRow - 1 == 0 && (matrix[wRow - 1][wCol - 1] == '-' && matrix[wRow - 1][wCol + 1] == '-')) {
                        matrix[wRow - 1][wCol] = 'w';
                        matrix[wRow][wCol] = '-';
                        wRow -= 1;
                        whiteIsPromoted = true;
                        break;
                    } else if (matrix[wRow - 1][wCol - 1] == 'b') {
                        matrix[wRow - 1][wCol - 1] = 'w';
                        matrix[wRow][wCol] = '-';
                        wRow -= 1;
                        wCol -= 1;
                        whiteCaptures = true;
                        break;
                    } else if (matrix[wRow - 1][wCol + 1] == 'b') {
                        matrix[wRow - 1][wCol + 1] = 'w';
                        matrix[wRow][wCol] = '-';
                        wRow -= 1;
                        wCol += 1;
                        whiteCaptures = true;
                        break;
                    } else {
                        matrix[wRow - 1][wCol] = 'w';
                        matrix[wRow][wCol] = '-';
                        wRow -= 1;
                    }
                }

            } else {
                if (bCol - 1 < 0) {
                    if (bRow + 1 == 7 && matrix[bRow + 1][bCol + 1] == '-') {
                        matrix[bRow + 1][bCol] = 'b';
                        matrix[bRow][bCol] = '-';
                        bRow += 1;
                        blackIsPromoted = true;
                        break;
                    } else if (matrix[bRow + 1][bCol + 1] == 'w') {
                        matrix[bRow + 1][bCol + 1] = 'b';
                        matrix[bRow][bCol] = '-';
                        bRow += 1;
                        bCol += 1;
                        blackCaptures = true;
                        break;
                    } else {
                        matrix[bRow + 1][bCol] = 'b';
                        matrix[bRow][bCol] = '-';
                        bRow += 1;
                    }
                } else if (bCol + 1 == 8) {
                    if (bRow + 1 == 7 && matrix[bRow + 1][bCol - 1] == '-') {
                        matrix[bRow + 1][bCol] = 'b';
                        matrix[bRow][bCol] = '-';
                        bRow += 1;
                        blackIsPromoted = true;
                        break;
                    } else if (matrix[bRow + 1][bCol - 1] == 'w') {
                        matrix[bRow + 1][bCol - 1] = 'b';
                        matrix[bRow][bCol] = '-';
                        bRow += 1;
                        bCol -= 1;
                        blackCaptures = true;
                        break;
                    } else {
                        matrix[bRow + 1][bCol] = 'b';
                        matrix[bRow][bCol] = '-';
                        bRow += 1;
                    }
                } else {
                    if (bRow + 1 == 7 && (matrix[bRow + 1][bCol - 1] == '-' && matrix[bRow + 1][bCol + 1] == '-')) {
                        matrix[bRow + 1][bCol] = 'b';
                        matrix[bRow][bCol] = '-';
                        bRow += 1;
                        blackIsPromoted = true;
                        break;
                    } else if (matrix[bRow + 1][bCol - 1] == 'w') {
                        matrix[bRow + 1][bCol - 1] = 'b';
                        matrix[bRow][bCol] = '-';
                        bRow += 1;
                        bCol -= 1;
                        blackCaptures = true;
                        break;
                    } else if (matrix[bRow + 1][bCol + 1] == 'w') {
                        matrix[bRow + 1][bCol + 1] = 'b';
                        matrix[bRow][bCol] = '-';
                        bRow += 1;
                        bCol += 1;
                        blackCaptures = true;
                        break;
                    } else {
                        matrix[bRow + 1][bCol] = 'b';
                        matrix[bRow][bCol] = '-';
                        bRow += 1;
                    }
                }
            }
            counter++;
        }


        if (whiteIsPromoted) {
            System.out.println("Game over! White pawn is promoted to a queen at " + refactorCoordinates(wRow, wCol) + ".");
        } else if (whiteCaptures) {
            System.out.println("Game over! White capture on " + refactorCoordinates(wRow, wCol) + ".");
        } else if (blackIsPromoted) {
            System.out.println("Game over! Black pawn is promoted to a queen at " + refactorCoordinates(bRow, bCol) + ".");
        } else if (blackCaptures) {
            System.out.println("Game over! Black capture on " + refactorCoordinates(bRow, bCol) + ".");
        }
    }

    public static String refactorCoordinates(int row, int col) {
        StringBuilder sb = new StringBuilder();
        String letter = "";
        if (col == 0) {
            letter = "a";
        } else if (col == 1) {
            letter = "b";
        } else if (col == 2) {
            letter = "c";
        }else if (col == 3) {
            letter = "d";
        }else if (col == 4) {
            letter = "e";
        }else if (col == 5) {
            letter = "f";
        }else if (col == 6) {
            letter = "g";
        }else if (col == 7) {
            letter = "h";
        }
        sb.append(letter);
        if (row == 0) {
            row = 8;
        } else if (row == 1) {
            row = 7;
        } else if (row == 2) {
            row = 6;
        } else if (row == 3) {
            row = 5;
        } else if (row == 5) {
            row = 3;
        } else if (row == 6) {
            row = 2;
        } else if (row == 7) {
            row = 1;
        }
        sb.append(row);
        return sb.toString();
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
