package com.company.MultidimensionalArrays.Lab;

import java.util.Scanner;

public class P07FindTheRealQueenSS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] matrix = readMatrix(8, scanner);

        int[] realQueen = new int[2];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                char current = matrix[r][c];

                if (UpIsInside(matrix, 8, 8)) {

                }
            }
        }


        System.out.println(realQueen);


    }

    public static char[][] readMatrix(int rows, Scanner scanner) {
        char[][] matrix = new char[rows][8];
        for (int r = 0; r < rows; r++) {
            String line = scanner.nextLine();
            String[] elements = line.split("\\s+");
            for (int c = 0; c < elements.length; c++) {
                char curr = elements[c].charAt(0);
                matrix[r][c] = curr;
            }
        }
        return matrix;
    }

    public static boolean UpIsInside(char[][] matrix, int r, int c) {
        if (r - 1 < 0) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean UpRightIsInside(char[][] matrix, int r, int c) {
        if (r - 1 < 0 || c + 1 >= matrix[r].length) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean RightIsInside(char[][] matrix, int r, int c) {
        if (c + 1 >= matrix[r].length) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean DownRightIsInside(char[][] matrix, int r, int c) {
        if (r + 1 >= matrix.length || c + 1 >= matrix[r].length) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean DownInside(char[][] matrix, int r, int c) {
        if (r + 1 >= matrix.length) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean DownLeftIsInside(char[][] matrix, int r, int c) {
        if (r + 1 >= matrix.length || c - 1 < 0) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean leftIsInside(char[][] matrix, int r, int c) {
        if (c - 1 < 0) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean LeftUpIsInside(char[][] matrix, int r, int c) {
        if (r - 1 < 0 || c - 1 < 0) {
            return false;
        } else {
            return true;
        }
    }


}
