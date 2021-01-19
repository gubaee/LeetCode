package Medium;
import java.util.*;
public class SpiralOrder {
    public static void main(String args[]) {
        int [][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
        spiralOrder(matrix);
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int totalVisited = 0;
        int toVisit = matrix[0].length * matrix.length;

        int rowUpLimit = 0;
        int rowDownLimit = matrix.length-1;
        int colLeftLimit = 0;
        int colRightLimit = matrix[0].length-1;

        while (totalVisited<toVisit) {
            for (int col = colLeftLimit; col <= colRightLimit; col++) {
                // going right
                result.add(matrix[rowUpLimit][col]);
                totalVisited++;
            }
            if (totalVisited == toVisit) {
                break;
            }
            rowUpLimit++;

            for (int row = rowUpLimit; row <= rowDownLimit; row++) {
                // going down
                result.add(matrix[row][colRightLimit]);
                totalVisited++;
            }
            if (totalVisited == toVisit) {
                break;
            }
            colRightLimit--;
            for (int col = colRightLimit; col >= colLeftLimit; col--) {
                // going left
                result.add(matrix[rowDownLimit][col]);
                totalVisited++;

            }
            if (totalVisited == toVisit) {
                break;
            }
            rowDownLimit--;
            for (int row = rowDownLimit; row >= rowUpLimit; row--) {
                // going up
                result.add(matrix[row][colLeftLimit]);
                totalVisited++;

            }
            if (totalVisited == toVisit) {
                break;
            }
            colLeftLimit++;
        }

        return result;
    }
}
