package Recursion;

import java.util.Arrays;

public class SudokuSolver {
    public static void main(String[] args) {
        char[][] board = new char[][] {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
            };
        helper(board, 0, 0);
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }

        // System.out.println(isValidToAdd(board, 1, 2, 3));
    }

    private static boolean helper(char[][] board, int i, int j) {
        if (i == board.length) {
            i = 0;
            if (++j == board[i].length) {
                return true;
            }
        }

        if (board[i][j] != '.') {
            return helper(board, i + 1, j);
        }

        for (int val = 1; val <= board.length; ++val) {
            if (isValidToAdd(board, i, j, val)) {
                board[i][j] = (char)(val + '0');
                if(helper(board, i + 1, j)) return true;
            }
        }
        board[i][j] = '.';
        return false;
    }

    private static boolean isValidToAdd(char[][] board, int i, int j, int val) {
        // check row
        for (int idx = 0; idx < board[i].length; idx++) {
            if (board[i][idx] == (char)(val + '0')) return false;
        }

        // check col
        for (int idx = 0; idx < board.length; idx++) {
            if (board[idx][j] == (char)(val + '0')) return false;
        }
        // check region
        int regionSize = (int)Math.sqrt(board.length);
        int I = i / regionSize, J = j / regionSize;
        for (int r = 0; r < regionSize; ++r) {
            for (int c = 0; c < regionSize; ++c) {
                if (board[regionSize * I + r][regionSize * J + c] == (char)(val + '0')) {
                    return false;
                }
            }
        }
        return true;
    }
}
