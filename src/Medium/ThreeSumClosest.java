package Medium;
import java.util.*;

public class ThreeSumClosest {
    static final int SUM_COUNT = 3;
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>((i, j)->j-i);
    public static void main(String args[]) {
        threeSumClosest(new int [] {1,1,-1,-1, 3}, 1);
    }
    public static int threeSumClosest(int[] nums, int target) {
        // Max heap [target] if something is less than target, we want to put it into Maxheap
        // Min heap [target] if something is greater than target, we weant to put it into Minheap
        // Max heap [1, -2, -5,-6 ]
        // Min heap [1, 4, 5, 6]
        minHeap.add(target);
        maxHeap.add(target);
        dfs(nums, 0, 0, target, 0);
        minHeap.remove();
        maxHeap.remove();
        int minHeapCandidate = Integer.MAX_VALUE;
        int maxHeapCandidate = Integer.MAX_VALUE;
        if (!minHeap.isEmpty()) {
            minHeapCandidate = minHeap.remove();
        }
        if (!maxHeap.isEmpty()) {
            maxHeapCandidate = maxHeap.remove();
        }

        if (minHeapCandidate == target) {
            return minHeapCandidate;
        }
        if (maxHeapCandidate == target) {
            return maxHeapCandidate;
        }

        int absFirst = Math.abs(target-minHeapCandidate);
        int absSecond = Math.abs(target-maxHeapCandidate);

        if (absFirst < absSecond) {
            return minHeapCandidate;
        } else {
            return maxHeapCandidate;
        }

    }

    public static void dfs(int[] nums, int count, int curSum, int target, int index) {
        if (SUM_COUNT == count) {
            if (curSum <= target) {
                maxHeap.add(curSum);
            } else if (curSum > target) {
                minHeap.add(curSum);
            }
            return ;
        }

        for (int i = index; i < nums.length; i++) {
            dfs(nums, count+1, curSum + nums[i], target, i + 1);
        }
    }
}
