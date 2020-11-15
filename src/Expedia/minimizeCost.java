package Expedia;
import java.util.*;
public class minimizeCost {
    public static void main(String args[]) {
        List<Integer> numPeople = new ArrayList<>();
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        numPeople.add(1);
        numPeople.add(2);
        x.add(1);
        x.add(3);
        y.add(1);
        y.add(3);
        System.out.println(minimizeCost(numPeople, x, y));
    }
    public static int cost(int x, int y, int a, int b) {
        return Math.abs(x-a) + Math.abs(y-b);
    }

    // answer
//    public static int minimizeCost(List<Integer> numPeople, List<Integer> x, List<Integer> y) {
//        List<Integer> xx = new ArrayList<>();
//        List<Integer> yy = new ArrayList<>();
//        int ans = 0;
//        for (int i = 0; i < numPeople.size(); i++) {
//            int count = numPeople.get(i);
//            while (count > 0) {
//                xx.add(x.get(i));
//                yy.add(y.get(i));
//                count--;
//            }
//        }
//        Collections.sort(xx);
//        Collections.sort(yy);
//
//        int mx = xx.get(xx.size() / 2);
//        int my = yy.get(yy.size() / 2);
//
//        for (int i = 0; i < numPeople.size(); i++) {
//            ans += numPeople.get(i) * cost(mx, my, x.get(i), y.get(i));
//        }
//        return ans;
//    }

    public static int minimizeCost(List<Integer> numPeople, List<Integer> x, List<Integer> y) {
        // Write your code here
        int rowLen = Integer.MIN_VALUE;
        int colLen = Integer.MIN_VALUE;
        // find max for all matrices
        for (int n : x) {
            rowLen = Math.max(rowLen, n);
        }
        for (int m : y) {
            colLen = Math.max(colLen , m);
        }

        int[][] sum =  new int[rowLen][colLen];
        boolean [][] visited = new boolean [rowLen][colLen];

        // generate matrix for city 0
        generateMatrix(sum, x.get(0)-1, y.get(0)-1, 0, visited);

        for (int i = 1; i < numPeople.size(); i++) {
            // generate current city and add it to sum
            int [][] curCity = new int[rowLen][colLen];
            visited = new boolean [rowLen][colLen];
            generateMatrix(curCity, x.get(i)-1, y.get(i)-1, 0, visited);
            addTwoMaxtrix(sum, curCity);
        }

        //find min cost in sum
        int min = Integer.MAX_VALUE;
        int xcoord = 0;
        int ycoord = 0;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++){
                if(min > sum[i][j]) {
                    min = Math.min(min, sum[i][j]);
                    xcoord = i;
                    ycoord = j;
                }
            }
        }
        System.out.println("("+xcoord+","+ycoord+")\nmin="+min);
        return min;
    }
    // this does not work. Still have to figure out how to create matrix
    public static void generateMatrix(int [][] array, int x, int y, int numToPut, boolean [][] visited) {
        while(x < 0 || x >= array[0].length || y < 0 || y >= array.length) {
            return ;
        }
        if (visited[x][y] == false) {
            array[x][y] = numToPut;
            visited[x][y] = true;
            generateMatrix(array, x, y + 1, numToPut+1, visited);
            generateMatrix(array, x, y-1, numToPut+1, visited);
            generateMatrix(array, x + 1, y, numToPut+1, visited);
            generateMatrix(array, x - 1, y, numToPut+1, visited);
        }


    }
    
    public static void addTwoMaxtrix(int [][] sumArray, int [][] cityArray) {
        for (int i = 0; i < sumArray.length; i++) {
            for (int j = 0; j < sumArray[0].length; j++) {
                sumArray[i][j] += cityArray[i][j];
            }
        }
    }
}
