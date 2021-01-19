package Medium;
import java.util.*;
class Pair {
    int i;
    int j;
    public Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
public class RottenOranges {
    static int freshOrange = 0;

    public static void main(String args[]) {
        int [][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        orangesRotting(grid);
    }

    public static int orangesRotting(int[][] grid) {
        //[2,1,1]
        //[0,1,1]
        //[1,0,1]
        // use stack and push index pair of rotten place
        // rotten other things to its 4 direction while pushing its index
        // when there is nothing to rotten, break out of loop
        // check whether there are any fresh left
        // if fresh left, return -1, otherwise count

        Queue<Pair> rottenOranges = new LinkedList<Pair>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    rottenOranges.add(new Pair(i, j));
                }
                if (grid[i][j] == 1) {
                    freshOrange++;
                }
            }
        }

        if (freshOrange == 0) {
            return 0;
        }

        int count = 0;

        while (!rottenOranges.isEmpty()) {
            int size = rottenOranges.size();
            for (int k = 0; k < size; k++) {
                Pair indices = rottenOranges.remove();
                int i = indices.i;
                int j = indices.j;

                rottenNearOranges(rottenOranges, i, j+1, grid);
                rottenNearOranges(rottenOranges, i, j-1, grid);
                rottenNearOranges(rottenOranges, i+1, j, grid);
                rottenNearOranges(rottenOranges, i-1, j, grid);
                if (freshOrange == 0) {
                    return count;
                }
            }
            count++;
        }

        return freshOrange == 0 ? count-1 : -1;
    }

    public static void rottenNearOranges(Queue<Pair> q, int i, int j, int [][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 2 || grid[i][j] == 0) {
            return ;
        }

        grid[i][j] = 2;
        freshOrange--;
        q.add(new Pair(i, j));
    }
}
