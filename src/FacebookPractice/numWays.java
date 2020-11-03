package FacebookPractice;
import java.util.*;

public class numWays {
    public static void main(String args[]) {
        int arr [] = {1, 5, 3, 3, 3, 2, 2};
        int k = 6;
        System.out.println(numberOfWays(arr, k));
    }
    static int numberOfWays(int[] arr, int k) {
        // Write your code here
        // add all values to map, iterate through each map, and if num + num = k then increment by permuation
        // if num + k-num = num then increment by combination
        // if num + k-num != num then increment by number of elements in array

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
            } else {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
        }
        int result = 0;
        Iterator<Map.Entry<Integer, Integer>> iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Integer, Integer> e = iter.next();
            int curNum = (int) e.getKey();
            int countOfOccurance = (int) e.getValue();
            int complement = k - curNum;

            if (map.containsKey(complement)) {
                // found target value
                if (curNum == complement) {
                    // 3 + 3 = 6
                    // add combination of them. count choose 2. For example [3, 3, 3, 3] = 4 choose 2
                    result += getCombinationCount(countOfOccurance, 2);
                } else {
                    // 1 + 5 = 6
                    result += countOfOccurance;
                }
            }
            iter.remove();
        }

        return result;
    }
    static int getCombinationCount(int num, int num2) {
        if (num == 0) {
            return 0;
        }
        // num choose num2
        long numerator = 1;
        long denominator = 1;
        int nuNum = num;
        int deNum = num-num2;

        while (nuNum > num2) {
            numerator *= nuNum;
            nuNum -= 1;
        }

        while (deNum > 0) {
            denominator *= deNum;
            deNum -= 1;
        }
        return (int) ( numerator / denominator);
    }
}
