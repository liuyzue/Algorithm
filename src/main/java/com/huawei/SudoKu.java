package com.huawei;

import java.util.*;

/**
 * @author liuyuze
 * @date 2025/3/25 7:22
 */
public class SudoKu {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] board = new int[9][9];
        int total = 0;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = scanner.nextInt();
                if (board[i][j] == 0) {
                    total++;
                }
            }
        }
        dfs(board,total);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean dfs(int[][] board,int total) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != 0) {
                    continue;
                }
                for (int v = 1; v < 10; v++) {
                    if (check(board, i, v, j)) {
                        board[i][j] = v;
                        total--;
                        if (total == 0) {
                            return true;
                        }
                        if (dfs(board, total)) {
                            return true;
                        }
                        total++;
                        board[i][j] = 0;
                    }
                }
                return false;
            }
        }
        return false;
    }

    private static boolean check(int[][] board, int i, int v, int j) {
        for (int k = 0; k < 9; k++) {
            if (board[i][k] == v) {
                return false;
            }
        }
        for (int k = 0; k < 9; k++) {
            if (board[k][j] == v) {
                return false;
            }
        }
        int blockX = (i / 3) * 3;
        int blockY = (j / 3) * 3;
        for (int x = blockX; x < blockX + 3; x++) {
            for (int y = blockY; y < blockY + 3; y++) {
                if (board[x][y] == v) {
                    return false;
                }
            }
        }
        return true;
    }
}
