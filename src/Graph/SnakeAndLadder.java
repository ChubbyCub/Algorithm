package Graph;

import java.util.*;

public class SnakeAndLadder {
    public static void main(String[] args) {
        int[][] board = new int[][] {
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,35,-1,-1,13,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,15,-1,-1,-1,-1}
        };

        System.out.println(snakesAndLadders(board));
    }

    public static int snakesAndLadders(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        int target = rows * cols;

        Set<Integer> visited = new HashSet<>();
        Map<Integer, Integer> snakeLadderMap = constructSnakeLadderMap(board, rows, cols);

        Queue<Tracker> queue = new LinkedList<>();

        queue.add(new Tracker(1, 0));
        visited.add(1);

        while (!queue.isEmpty()) {
            Tracker current = queue.poll();
            int index  = current.index;
            int globalMoves = current.globalMoves;
            if (index == target) {
                return globalMoves;
            }
            for (int i = 1; i <= 6; i++) {
                int newIndex = snakeLadderMap.containsKey(index + i) ? snakeLadderMap.get(index + i) : index + i;
                if (visited.contains(newIndex)) continue;
                queue.add(new Tracker(newIndex, globalMoves + 1));
                visited.add(newIndex);
            }
        }

        return -1;
    }

    private static Map<Integer, Integer> constructSnakeLadderMap(int[][] board, int rows, int cols) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] != -1) {
                    int index = rowColToIndex(i, j, rows, cols);
                    map.put(index, board[i][j]);
                }
            }
        }
        return map;
    }

    private static int rowColToIndex(int i, int j, int rows, int cols) {
        int base = (rows - i - 1) * cols;

        if ((rows - i - 1) % 2 == 0) {
            return base + j + 1;
        } else {
            return base + cols - j;
        }
    }

    private static class Tracker {
        int index;
        int globalMoves;

        public Tracker(int index, int globalMoves) {
            this.index = index;
            this.globalMoves = globalMoves;
        }
    }

}
