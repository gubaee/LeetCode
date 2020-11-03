package FacebookCodingChallenge;

public class SubMatrixContainsAllDigits {
    // sub matrix contains all digits 1 ~ 9?
    public static void main(String args[]) {
//        int [][] array = { {1,2,3,2,5,7}, {4,5,6,1,7,6} , {7,8,9,4,8,3} };
        int [][] array = { {1,2,3}, {4,7,9} , {8,5,6} };
        boolean [] array2 = new boolean[array.length];
        array2 = isSubmatrixFull(array);

        for(int i = 0; i < array2.length; i++) {
            System.out.print(array2[i] + ", ");
        }
    }
    static boolean[] isSubmatrixFull(int[][] numbers) {
        int slidingSize = numbers[0].length - 2;
        boolean[] result = new boolean [slidingSize];
        int [] array = new int [10];

        firstRound(numbers, array);

        if (isAllOnes(array)) {
            result[0] = true;
            System.out.println(result[0]);
        }

        // numbers.length = 6  i = 0 ~ 3
        for (int i = 1; i < slidingSize; i++) {
            subtractNewValue(numbers, i-1, array);
            addNewValue(numbers, i+2, array);
            if (isAllOnes(array)) {
                result[i] = true;
            }
        }
        return result;
    }
    static void firstRound(int [][] numbers, int [] array) {
        for (int j = 0; j < 3; j++) {
            addNewValue(numbers, j, array);
        }
    }
    static boolean isAllOnes(int [] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] != 1) {
                return false;
            }
        }
        return true;
    }

    static void subtractNewValue(int [][] numbers, int columnIndex, int [] array) {
        for (int i = 0; i < 3; i++) {
            int number = numbers[i][columnIndex];
            array[number]--;
        }
    }

    static void addNewValue(int [][] numbers, int columnIndex, int [] array) {
        for (int i = 0; i < 3; i++) {
            int number = numbers[i][columnIndex];
            array[number]++;
        }
    }
}
