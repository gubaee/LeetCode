package Medium;
import java.util.*;

public class SubArraySumEqualK {
    public static void main(String args[]) {
        int array[] = {2, 2, -4, 2, 2, -4, 2, 2};
        System.out.println(subarraySum(array, 4));
    }
    public static int subarraySum(int[] nums, int k) {
        // [6, 10, 2, 4, 6]   k = 12
        // [6, 16,18,22,28]
        // (-6, 1) (4, 1) (6, 1) (10, 1) (16, 1)
        //  we keep track of the numbers we have added to the queue, and
        // whenever the number is greater than equal to K, we remove the value from queue, and
        // subtract from current sum and keep moving on.
        int count = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
