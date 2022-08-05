package Graph;

import java.util.*;

public class FloodFill {
    private static int[][] offsets = new int[][] {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> image = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>();
        row.add(7);
        row.add(7);
        row.add(7);
        row.add(7);
        row.add(7);
        row.add(7);
        image.add(row);
        ArrayList<ArrayList<Integer>> result = flood_fill(0, 4, 7, image);
        System.out.println(result);
    }

    private static ArrayList<ArrayList<Integer>> flood_fill(Integer pixel_row, Integer pixel_column,
                                                            Integer new_color, ArrayList<ArrayList<Integer>> image) {
        Queue<Point> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Integer currColor = image.get(pixel_row).get(pixel_column);
        Point start = new Point(pixel_row, pixel_column);
        queue.add(start);
        visited.add(pixel_row + pixel_column.toString());
        image.get(pixel_row).set(pixel_column, new_color);

        while(!queue.isEmpty()) {
            Point curr = queue.poll();
            for (Point neighbor : getNeighbors(image, curr, currColor)) {
                if (visited.contains(neighbor.row + String.valueOf(neighbor.col))) continue;
                queue.add(neighbor);
                image.get(neighbor.row).set(neighbor.col, new_color);
                visited.add(neighbor.row + String.valueOf(neighbor.col));
            }
        }

        return image;
    }

    private static ArrayList<Point> getNeighbors(ArrayList<ArrayList<Integer>> image, Point p, Integer color) {
        ArrayList<Point> neighbors = new ArrayList<>();
        for (int[] offset : offsets) {
            int nextRow = p.row + offset[0];
            int nextCol = p.col + offset[1];
            if (nextRow >= 0 && nextCol >= 0 && nextRow < image.size() && nextCol < image.get(0).size()
            && Objects.equals(image.get(nextRow).get(nextCol), color)) {
                neighbors.add(new Point(nextRow, nextCol));
            }
        }
        return neighbors;
    }

    private static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
