package Graph;

import java.sql.Array;
import java.util.*;

public class ZombieCluster {
    public static void main(String[] args) {

    }

    static Integer zombie_cluster(ArrayList<String> zombies) {
        int[][] matrix = new int[zombies.size()][zombies.get(0).length()];
        for (int i = 0; i < zombies.size(); i++) {
            String[] row = zombies.get(i).split("");
            for (int j = 0; j < row.length; j++) {
                matrix[i][j] = Integer.parseInt(row[j]);
            }
        }
        int clusters = 0;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (visited[i][j]) continue;
                dfs(visited, i, j, matrix);
                clusters++;
            }
        }
        return clusters;
    }

    static void dfs(boolean[][] visited, int row, int col, int[][] matrix) {
        if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length) return;
        if (visited[row][col]) return;
        visited[row][col] = true;
        dfs(visited, row + 1, col, matrix);
        dfs(visited, row - 1, col, matrix);
        dfs(visited, row, col + 1, matrix);
        dfs(visited, row, col - 1, matrix);
    }
}
