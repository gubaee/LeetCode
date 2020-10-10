import java.util.ArrayList;

public class MaximalSquare {
    static class Point {
        int xPos;
        int yPos;
        public Point(int xPos, int yPos) {
            this.xPos = xPos;
            this.yPos = yPos;
        }
    }
    private static int X_MAX_LENGTH;
    private static int Y_MAX_LENGTH;

    public static void main(String args[]) {
        char[][] matrix = new char[4][5];
        matrix[0] = new char[]{'1', '1', '1'};
        matrix[1] = new char[]{'1', '1', '1'};
        matrix[2] = new char[]{'1', '1', '1'};
        matrix[3] = new char[]{'1', '0', '0'};
        System.out.println(maximalSquare(matrix));
    }
    public static int maximalSquare(char[][] matrix) {
        if(matrix.length == 0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int[][] result = new int[matrix.length][matrix[0].length];
        for(int i = 0 ; i < matrix[0].length;i++){
            if(matrix[0][i] == '1'){
                result[0][i] = 1;
                max = 1;
            }
        }
        for(int i = 0 ; i < matrix.length;i++){
            if(matrix[i][0] == '1'){
                result[i][0] = 1;
                max = 1;
            }
        }
        for(int i = 1; i < matrix.length;i++){
            for(int j = 1; j < matrix[0].length;j++){
                if(matrix[i][j] == '0'){
                    continue;
                }

                result[i][j] = 1 + Math.min(Math.min(result[i-1][j],result[i][j-1]),result[i-1][j-1]);

                if(max < result[i][j]){
                    max = result[i][j];
                }
            }
        }
        return max*max;
    }
}
