package Amazon;
import java.util.*;
public class NumOfCluster {
    public static void main(String args[]) {
        int numOfRows = 3;
        List<String> grid = Arrays.asList("aabba", "aabba", "aaacb");

        int numOfRows2 = 4;
        List<String> grid2 = Arrays.asList("bbba", "abba", "acaa", "aaac");

        System.out.println(clusterCount(numOfRows, grid));
        System.out.println(clusterCount(numOfRows2, grid2));
    }

    public static int clusterCount(int numOfRows, List<String> grid) {
        int numOfCols = grid.get(0).length();
        char [][] TwoDimensionalGrid = new char[numOfRows][numOfCols];
        buildGrid(grid, TwoDimensionalGrid);

        int uniqueCount = 0;
        for (int row = 0; row < numOfRows; row++) {
            for (int col = 0; col < numOfCols; col++) {
                char curCluster = TwoDimensionalGrid[row][col];
                if (curCluster == 'a' || curCluster == 'b' || curCluster == 'c') {
                    dfs(TwoDimensionalGrid, curCluster, row, col);
                    uniqueCount++;
                }
            }
        }

        return uniqueCount;
    }

    // recursively visit and check if they are visited.
    public static void dfs(char[][] grid, char curCluster, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] != curCluster) {
            return ;
        }

        grid[row][col] = 'x';
        dfs(grid, curCluster, row, col + 1);
        dfs(grid, curCluster, row, col - 1);
        dfs(grid, curCluster, row + 1, col);
        dfs(grid, curCluster, row - 1, col);
    }

    public static void buildGrid(List<String> grid, char [][] dest) {
        for (int i = 0; i < dest.length; i++) {
            String curRow = grid.get(i); // aaabc  , aaabc , aaacb
            for (int j = 0; j < dest[i].length; j++) {
                dest[i][j] = curRow.charAt(j);
            }
        }
    }
}
