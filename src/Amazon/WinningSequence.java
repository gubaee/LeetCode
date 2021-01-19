package Amazon;
import java.util.*;

public class WinningSequence {
    public static void main(String args[]) {
        // 3 cases.
        // Best case, corner case, cannot construct
        System.out.println(getResult(5, 3, 10)); // 9 10 9 8 7
        System.out.println(getResult(7, 6, 10)); // 8 9 10 9 8 7 6
        System.out.println(getResult(5, 6, 10)); // 6 7 8 9 10 // cannot construct
        System.out.println(getResult(7, 9, 10)); // cannot construct.

    }

    public static int [] getResult(int num, int lowerEnd, int upperEnd) {
        int [] result = new int [num];
        int allowedNumCounts = upperEnd - lowerEnd + 1; // range of numbers from upper to lower
        int increasingElementCount = num - allowedNumCounts; // size of array - allowed numbers from upper to lower

        if (increasingElementCount == 0) {
            return new int[] {-1}; // cannot construct. it can only decrease
        } else if (increasingElementCount < 0) {
            // everything is covered.
            result[0] = upperEnd-1;
            for (int i = 1; i < result.length; i++) {
                result[i] = upperEnd-i+1;
            }
            return result;
        }

        int startingNum = upperEnd - increasingElementCount;
        if (startingNum < lowerEnd) {
            return new int[] {-1}; // cannot construct allowed number range is too small
        }
        for (int i = 0; i < increasingElementCount; i++) {
            result[i] = startingNum + i;
        }

        for (int i = increasingElementCount; i < num; i++) {
            result[i] = upperEnd - i + increasingElementCount;
        }

        return result;
    }
}
