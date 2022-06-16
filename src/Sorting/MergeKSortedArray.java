package Sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedArray {
    public static void main(String[] args) {
        int[][] input = new int[][]{
                {1, 3, 5, 7},
                {2, 4, 6, 8},
                {0, 9, 10, 11}
        };

        System.out.println(Arrays.toString(mergeKSorted(input)));
    }

    private static int[] mergeKSorted(int[][] input) {
        int rows = input.length;
        int cols = input[0].length;

        int[] result = new int[rows * cols];

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));

        for(int r = 0; r < rows; r++) {
            Node n = new Node(r, 0, input[r][0]);
            pq.add(n);
        }

        int curr = 0;

        while(!pq.isEmpty()) {
            Node n = pq.poll();
            int row = n.row;
            int col = n.col;
            int val = n.val;
            result[curr++] = val;
            if (row < rows && col < cols - 1) {
                Node newNode = new Node(row, col + 1, input[row][col + 1]);
                pq.add(newNode);
            }
        }

        return result;
    }

    private static class Node {
        int row;
        int col;
        int val;

        public Node(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

}
