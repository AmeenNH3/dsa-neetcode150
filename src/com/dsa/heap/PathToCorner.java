package com.dsa.heap;

import java.util.ArrayList;
import java.util.List;

public class PathToCorner {

    private void printAllPaths(int[][] matrix, int i, int j, List<Integer> path) {
        int m = matrix.length;
        int n = matrix[0].length;

        // Add the current cell to the path
        path.add(matrix[i][j]);

        // Check if we've reached the bottom-right corner
        if (i == m - 1 && j == n - 1) {
            // If we have, print the path
            System.out.println(path);
            // Remove the current cell from the path and return
            path.remove(path.size() - 1);
            return;
        }

        // Try moving right, if possible
        if (j < n - 1) {
            printAllPaths(matrix, i, j + 1, path);
        }

        // Try moving down, if possible
        if (i < m - 1) {
            printAllPaths(matrix, i + 1, j, path);
        }

        // If moving right or down was not possible, we're at a dead end,
        // so we remove the current cell from the path and return
        path.remove(path.size() - 1);
    }

    public void printAllPaths(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        printAllPaths(matrix, 0, 0, new ArrayList<>());
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        new PathToCorner().printAllPaths(matrix);
    }
}