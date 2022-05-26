package com.company.MultidimensionalArrays.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P07Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dimensions = scanner.nextLine();
        int rows = Integer.parseInt(dimensions.split(" ")[0]);
        int cols = Integer.parseInt(dimensions.split(" ")[1]);

        List<List<Integer>> matrix = fillMatrix(rows, cols);

        String command = scanner.nextLine();

        while (!command.equals("Nuke it from orbit")) {
            int row = Integer.parseInt(command.split(" ")[0]);
            int col = Integer.parseInt(command.split(" ")[1]);
            int radius = Integer.parseInt(command.split(" ")[2]);

            for (int currRow = row - radius; currRow <= row + radius; currRow++) {
                if (isInside(currRow, col, matrix) && currRow != row) {
                    matrix.get(currRow).remove(col);
                }
            }

            for (int currCol = col + radius; currCol >= col - radius; currCol--) {
                if (isInside(row, currCol, matrix)) {
                    matrix.get(row).remove(currCol);
                }
            }

            matrix.removeIf(List::isEmpty);

            command = scanner.nextLine();
        }

        printMatrix(matrix);
    }

    private static boolean isInside(int row, int col, List<List<Integer>> matrix) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }


    public static void printMatrix(List<List<Integer>> matrix) {
        for (List<Integer> row : matrix) {
            for (int el : row) {
                System.out.print(el + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> fillMatrix(int rows, int cols) {
        List<List<Integer>> matrix = new ArrayList<>();
        int n = 1;
        for (int r = 0; r < rows; r++) {
            List<Integer> row = new ArrayList<>();
            for (int c = 0; c < cols; c++) {
                row.add(n);
                n++;
            }
            matrix.add(row);
        }
        return matrix;
    }
}
