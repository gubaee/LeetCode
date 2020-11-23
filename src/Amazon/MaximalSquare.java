package Amazon;

public class MaximalSquare {
    public static void main(String args[]) {
//        char[][] matrix = new char[4][5];
//        matrix[0] = new char[]{'1', '1', '1'};
//        matrix[1] = new char[]{'1', '1', '1'};
//        matrix[2] = new char[]{'1', '1', '1'};
//        matrix[3] = new char[]{'1', '0', '0'};
        char[][] matrix = new char[4][5];
        matrix[0] = new char[]{'1', '0', '1', '0', '0'};
        matrix[1] = new char[]{'1', '0', '1', '1', '1'};
        matrix[2] = new char[]{'1', '1', '1', '1', '1'};
        matrix[3] = new char[]{'1', '0', '0', '1', '0'};
        System.out.println(maximalSquare(matrix));
    }
    public static int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int [][] dp = new int [matrix.length][matrix[0].length];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < dp[0].length; i++) {
            if (matrix[0][i]-'0' == 1) {
                dp[0][i] = 1;
                max = 1;
            }

        }
        for (int j = 0; j < dp.length; j++) {
            dp[j][0] = Integer.valueOf(matrix[j][0]-'0');
            if (matrix[j][0]-'0' == 1) {
                dp[j][0] = 1;
                max = 1;
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }
                dp[i][j] = 1 + Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]);
                max = Math.max(max, dp[i][j]);
            }
        }

        return max*max;
    }
}
