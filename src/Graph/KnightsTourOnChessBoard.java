package Graph;

import java.util.*;

public class KnightsTourOnChessBoard {
    private static int[][] moves = new int[][] {{2, 1}, {-2, 1}, {2, -1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};

    public static void main(String[] args) {
        int res = find_minimum_number_of_moves(5, 5,0, 0, 4, 1);
        System.out.println(res);
    }

    private static int find_minimum_number_of_moves(int rows, int cols, int start_row, int start_col, int end_row, int end_col) {
        // Write your code here.
        Queue<Tracker> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        Tracker start = new Tracker(start_row, start_col, 0);
        queue.add(start);
        visited[start_row][start_col] = true;

        while (!queue.isEmpty()) {
            Tracker curr = queue.poll();
            if (curr.row == end_row && curr.col == end_col) {
                return curr.moves;
            }
            for (Tracker neighbor : getNeighbors(rows, cols, curr)) {
                if (visited[neighbor.row][neighbor.col]) continue;
                queue.add(neighbor);
                visited[neighbor.row][neighbor.col] = true;
            }
        }
        return -1;
    }

    private static List<Tracker> getNeighbors(int rows, int cols, Tracker prev) {
        List<Tracker> neighbors = new ArrayList<>();
        for (int[] move : moves) {
            int nextRow = prev.row + move[0];
            int nextCol = prev.col + move[1];
            if (nextRow >= 0 && nextCol >= 0 && nextRow < rows && nextCol < cols) {
                neighbors.add(new Tracker(nextRow, nextCol, prev.moves + 1));
            }
        }
        return neighbors;
    }

    private static class Tracker {
        int row;
        int col;
        int moves;

        public Tracker(int row, int col, int moves) {
            this.row = row;
            this.col = col;
            this.moves = moves;
        }
    }
}
