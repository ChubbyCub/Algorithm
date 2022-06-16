package Recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {

    }

    private static void helper(int boardSize, List<Integer> board, int currRow, List<List<Integer>> placements) {
        if (currRow == boardSize) {
            placements.add(new ArrayList<>(board));
            return;
        }

        for(int col = 0; col < boardSize; col++) {
            if(isValid(board, currRow, col)) {
                board.add(col);
                helper(boardSize, board, currRow + 1, placements);
                board.remove(board.size() - 1);
            }
        }
    }

    private static boolean isValid(List<Integer> board, int currRow, int currCol) {
        // check col
        for (int col = 0; col < board.size(); col++) {
            if (currCol == board.get(col)) return false;
        }
        // check diagonal line
        // remember the diagonal line has a slope of 1. then remember how do we calculate a slope of a line?
        for (int m = 0; m < board.size(); m++) {
            if (Math.abs(m - currRow) == Math.abs(board.get(m) - currCol)) return false;
        }
        return true;
    }
}
