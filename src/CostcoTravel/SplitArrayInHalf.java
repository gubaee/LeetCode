package CostcoTravel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SplitArrayInHalf {
    // Split Array In Half, but there shouldn't be any duplicate
    public static void main(String args[]) {
        int [] a = {2,1,2,3,3,4};
        int [][]array = result(a);

        int b = 1;

    }
    public static int [][] result(int [] a) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            if (!map.containsKey(a[i])) {
                map.put(a[i], 1);
            } else {
                map.put(a[i], map.get(a[i]) + 1);
            }
        }

        List<Integer> firstHalf = new ArrayList<>();
        List<Integer> secondHalf = new ArrayList<>();
        int oddEvenCounter = 0;
        for (Map.Entry e : map.entrySet()) {
            int key = (int) e.getKey();
            int value = (int) e.getValue();
            if (value >= 3) {
                return new int[2][];
            }
            if (value / 2 == 0) {
                if (oddEvenCounter % 2 == 0) {
                    firstHalf.add(key);
                } else {
                    secondHalf.add(key);
                }
                oddEvenCounter++;
                continue;
            }

            int firstIterationSize = value/2;
            int secondIterationSize = value-firstIterationSize;
            for (int i = 0; i < value/2; i++) {
                firstHalf.add(key);
            }
            for (int i = 0; i < secondIterationSize; i++) {
                secondHalf.add(key);
            }

        }

        int [][] result = new int [2][];

        result[0] = firstHalf.stream().mapToInt(Integer::intValue).toArray();
        result[1] = secondHalf.stream().mapToInt(Integer::intValue).toArray();
        return result;
    }
}
