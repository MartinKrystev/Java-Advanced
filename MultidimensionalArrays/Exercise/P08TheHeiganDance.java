package com.company.MultidimensionalArrays.Exercise;

import java.util.Scanner;

public class P08TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = new int[15][15];
        int playerHealth = 18_500;
        double bossHealth = 3_000_000;
        double playerDamage = Double.parseDouble(scanner.nextLine());

        int[] playerPos = new int[2];
        playerPos[0] = 7;
        playerPos[1] = 7;
        boolean isInCloud = false;

        String lastSpell = "";

        while (playerHealth > 0) {
            bossHealth -= playerDamage;

            if (isInCloud) {
                playerHealth -= 3500;
                isInCloud = false;
            }

            if (playerHealth <= 0) {
                lastSpell = "Cloud";
                break;
            }
            if (bossHealth <= 0) {
                break;
            }

            String[] input = scanner.nextLine().split("\\s+");
            String spell = input[0];
            int targetRow = Integer.parseInt(input[1]);
            int targetCol = Integer.parseInt(input[2]);

            boolean isPlayerDamaged = checkIfPlayerHit(playerPos[0], playerPos[1], targetRow, targetCol);

            int damageDone = 0;
            if (isPlayerDamaged) {
                if (spell.equals("Cloud")) {
                    damageDone = 3500;
                } else {
                    damageDone = 6000;
                }
                boolean canMove = playerCanMoveAndMovePlayer(playerPos, targetRow, targetCol);

                if (!canMove) {
                    playerHealth -= damageDone;
                    if (spell.equals("Cloud")) {
                        isInCloud = true;
                    }
                }
            }
        }
        if (bossHealth > 0) {
            System.out.printf("Heigan: %.2f%n", bossHealth);
        } else {
            System.out.println("Heigan: Defeated!");
        }
        if (playerHealth <= 0) {
            lastSpell = lastSpell.equals("Cloud") ? "Plague Cloud" : "Eruption";
            System.out.printf("Player: Killed by %s%n", lastSpell);
        } else {
            System.out.printf("Player: %d%n", playerHealth);
        }

        System.out.printf("Final position: %d, %d%n", playerPos[0], playerPos[1]);

    }

    private static boolean playerCanMoveAndMovePlayer(int[] position, int row, int col) {
        boolean canMove = false;

        int r = position[0];
        int c = position[1];

        if (isInBounds(r - 1, c) && !checkIfPlayerHit(r - 1, c, row, col)) {
            r--;
            canMove = true;
        } else if (isInBounds(r, c + 1) && !checkIfPlayerHit(r, c + 1, row, col)) {
            c++;
            canMove = true;
        } else if (isInBounds(r + 1, c) && !checkIfPlayerHit(r + 1, c, row, col)) {
            r++;
            canMove = true;
        } else if (isInBounds(r, c - 1) && !checkIfPlayerHit(r, c - 1, row, col)) {
            c--;
            canMove = true;
        }

        position[0] = r;
        position[1] = c;

        return canMove;
    }

    private static boolean isInBounds(int r, int c) {
        return r >= 0 && r < 15 && c >= 0 && c < 15;
    }

    private static boolean checkIfPlayerHit(int r, int c, int targetRow, int targetCol) {
        return r >= targetRow - 1 && r <= targetRow + 1
                && c >= targetCol - 1 && c <= targetCol + 1;
    }
}
