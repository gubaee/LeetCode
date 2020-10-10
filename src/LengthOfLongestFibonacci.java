import java.util.ArrayList;

public class LengthOfLongestFibonacci {
    // ArrayList<Integer> currentLongest;
    public static void main(String args[]) {
        int [] array = {1,2,3,4,5,6,7,8};
        System.out.println(lenLongestFibSubseq(array));
    }
//    public static int lenLongestFibSubseq(int[] A) {
//        if (A.length < 3) {
//            return 0;
//        }
//        int result = 0;
//        for (int i = 0; i < A.length-2; i++) {
//            int firstNumber = A[i];
//            for (int j = i+1; j < A.length; j++) {
//                int secondNumber = A[j];
//                result = Math.max(result, longestFibonacci(firstNumber, secondNumber, A, j+1));
//            }
//        }
//        return result;
//    }
//    public static int longestFibonacci(int firstNumber, int secondNumber, int[] originalArray, int currentPointer) {
//        int longestFibonacciLength = 2;
//        if (currentPointer >= originalArray.length) {
//            return 0;
//        }
//        int firstPointer = 0;
//        int secondPointer = 1;
//        for (int i = currentPointer; i < originalArray.length; i++) {
//            int target = firstNumber + secondNumber;
//            if (originalArray[i] == target) {
//                firstNumber = secondNumber;
//                secondNumber = target;
//                target = firstNumber + secondNumber;
//                longestFibonacciLength++;
//            }
//        }
//        return longestFibonacciLength < 3 ? 0 : longestFibonacciLength;
//    }
    public static int lenLongestFibSubseq(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < A.length-2; i++) {
            ArrayList<Integer> currentLongest = new ArrayList<Integer>();
            currentLongest.add(A[i]);
            for (int j = i+1; j < A.length; j++) {
                currentLongest.add(A[j]);
                result = Math.max(result, longestFibonacci((ArrayList<Integer>) currentLongest.clone(), A, j+1));
                currentLongest.remove(1);
            }
        }
        return result;
    }

    public static int longestFibonacci(ArrayList<Integer> currentLongest, int[] originalArray, int currentPointer) {
        if (currentPointer >= originalArray.length) {
            return currentLongest.size() < 3 ? 0 : currentLongest.size();
        }
        int firstPointer = 0;
        int secondPointer = 1;
        for (int i = currentPointer; i < originalArray.length; i++) {
            int target = currentLongest.get(firstPointer) + currentLongest.get(secondPointer);
            if (originalArray[i] == target) {
                currentLongest.add(originalArray[i]);
                firstPointer++;
                secondPointer++;
            }
        }
        return currentLongest.size() < 3 ? 0 : currentLongest.size();
    }


//    public static int longestFibonacci(ArrayList<Integer> currentLongest, int[] originalArray, int currentPointer) {
//        if (currentPointer >= originalArray.length) {
//            return currentLongest.size() < 3 ? 0 : currentLongest.size();
//        }
//        int firstPointer = 0;
//        int secondPointer = 1;
//        for (int i = currentPointer; i < originalArray.length; i++) {
//            int target = currentLongest.get(firstPointer) + currentLongest.get(secondPointer);
//            if (originalArray[i] == target) {
//                currentLongest.add(originalArray[i]);
//                firstPointer++;
//                secondPointer++;
//            }
//        }
//        return currentLongest.size() < 3 ? 0 : currentLongest.size();
//    }
}
