package Medium;

public class rotateImage {
    public static void main(String args[]) {
        int [][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
//        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
    }
    public static void rotate(int[][] matrix) {
        int [][] copyArray = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            copyArray[i] = matrix[i].clone();
        }
        int matrixIndexI = 0;
        int matrixIndexJ = matrix.length-1;
        for (int i = 0; i < matrix.length; i++) {
            matrixIndexI = 0;
            for (int j = 0; j < matrix.length; j++) {
                matrix[matrixIndexI][matrixIndexJ] = copyArray[i][j];
                matrixIndexI++;
                print2dArray(matrix);
            }
            matrixIndexJ--;
        }
        print2dArray(matrix);

    }
//    public static void rotate(int[][] matrix) {
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = i; j < matrix.length; j++) {
//                swap(matrix, i, j);
//                print2dArray(matrix);
//            }
//        }
//        System.out.println("End of diagonal");
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < (matrix.length/2); j++) {
//                int temp = matrix[i][j];
//                matrix[i][j] = matrix[i][matrix.length-1-j];
//                matrix[i][matrix.length-1] = temp;
//                print2dArray(matrix);
//            }
//        }
//        print2dArray(matrix);
//    }
    public static void swap(int[][] matrix, int first, int second) {
        int temp = matrix[first][second];
        matrix[first][second] = matrix[second][first];
        matrix[second][first] = temp;
    }

    public static void print2dArray(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("[");
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]+", ");
            }
            System.out.print("]");
            System.out.println();
        }
        System.out.println();
    }
}
