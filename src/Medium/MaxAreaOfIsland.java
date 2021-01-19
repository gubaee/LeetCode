package Medium;
import java.util.*;
public class MaxAreaOfIsland {
    static int max = 0;
    static int subCount = 0;
    public static void main(String args[]) {
        int [][] grid = {{1, 1, 0, 0}, {1, 1, 0, 0}, {0, 0, 1, 1}, {0, 0, 1, 1}};
        maxAreaOfIsland(grid);
    }
    public static int maxAreaOfIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    max = Math.max(max , subCount);
                    subCount = 0;
                }
            }
        }

        return max;
    }

    public static void dfs(int [][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] == 0) {
            return ;
        }

        subCount++;

        grid[row][col] = 0;

        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);

        grid[row][col] = 1;
    }
}
