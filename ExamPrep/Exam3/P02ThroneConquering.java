package com.company.ExamPrep.Exam3;

import java.util.Scanner;

public class P02ThroneConquering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());
        int rows = Integer.parseInt(scanner.nextLine());
        char[][] field = readCharMatrix(rows, scanner);

        int parisRow = -1;
        int parisCol = -1;

        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if (field[row][col] == 'P') {
                    parisRow = row;
                    parisCol = col;
                }
            }
        }

        boolean isAbducted = false;

        while (energy > 0) {
            String[] command = scanner.nextLine().split("\\s+");

            String direction = command[0];
            int spawnRow = Integer.parseInt(command[1]);
            int spawnCol = Integer.parseInt(command[2]);

            field[spawnRow][spawnCol] = 'S';
            energy--;

            switch (direction) {
                case "up":
                    if (parisRow - 1 >= 0) {
                        field[parisRow][parisCol] = '-';
                        parisRow--;
                        if (field[parisRow][parisCol] == 'S') { // Spartan
                            energy -= 2;
                            if (energy <= 0) {
                                field[parisRow][parisCol] = 'X';
                            } else {
                                field[parisRow][parisCol] = 'P';
                            }
                        } else if (field[parisRow][parisCol] == 'H') { // Helen
                            field[parisRow][parisCol] = '-';
                            isAbducted = true;
                            break;
                        } else { // empty slot
                            field[parisRow][parisCol] = 'P';
                        }
                    }
                    break;
                case "down":
                    if (parisRow + 1 < field.length) {
                        field[parisRow][parisCol] = '-';
                        parisRow++;

                        if (field[parisRow][parisCol] == 'S') { // Spartan
                            energy -= 2;
                            if (energy <= 0) {
                                field[parisRow][parisCol] = 'X';
                            } else {
                                field[parisRow][parisCol] = 'P';
                            }
                        } else if (field[parisRow][parisCol] == 'H') { // Helen
                            field[parisRow][parisCol] = '-';
                            isAbducted = true;
                            break;
                        } else { // empty slot
                            field[parisRow][parisCol] = 'P';
                        }
                    }
                    break;
                case "left":
                    if (parisCol - 1 >= 0) {
                        field[parisRow][parisCol] = '-';
                        parisCol--;
                        if (field[parisRow][parisCol] == 'S') { // Spartan
                            energy -= 2;
                            if (energy <= 0) {
                                field[parisRow][parisCol] = 'X';
                            } else {
                                field[parisRow][parisCol] = 'P';
                            }
                        } else if (field[parisRow][parisCol] == 'H') { // Helen
                            field[parisRow][parisCol] = '-';
                            isAbducted = true;
                            break;
                        } else { // empty slot
                            field[parisRow][parisCol] = 'P';
                        }
                    }
                    break;
                case "right":
                    if (parisCol + 1 < field[parisRow].length) {
                        field[parisRow][parisCol] = '-';
                        parisCol++;
                        if (field[parisRow][parisCol] == 'S') { // Spartan
                            energy -= 2;
                            if (energy <= 0) {
                                field[parisRow][parisCol] = 'X';
                            } else {
                                field[parisRow][parisCol] = 'P';
                            }
                        } else if (field[parisRow][parisCol] == 'H') { // Helen
                            field[parisRow][parisCol] = '-';
                            isAbducted = true;
                            break;
                        } else { // empty slot
                            field[parisRow][parisCol] = 'P';
                        }
                    }
                    break;
            }

            if (isAbducted) {
                break;
            }

        }

        if (energy <= 0) {
            field[parisRow][parisCol] = 'X';
            System.out.printf("Paris died at %d;%d.%n", parisRow, parisCol);
        } else {
            System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", energy);
        }

        printMatrix(field);
    }

    public static char[][] readCharMatrix(int rows, Scanner scanner) {
        char[][] matrix = new char[rows][];
        for (int row = 0; row < rows; row++) {
            char[] arr = scanner.nextLine().toCharArray();
            matrix[row] = arr;
        }
        return matrix;
    }

    public static void printMatrix(char[][] matrix) {
        for (char[] arr : matrix) {
            for (char el : arr) {
                System.out.print(el);
            }
            System.out.println();
        }
    }

}
