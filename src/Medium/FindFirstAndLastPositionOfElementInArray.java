package Medium;

public class FindFirstAndLastPositionOfElementInArray {
    public static void main(String args[]) {
        int [] nums = {1};
        searchRange(nums, 1);
        System.out.println();
    }
    public static int first_pos(int[] nums, int x) {
        int left = 0;
        int right = nums.length-1;

        int first_pos = nums.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= x) {
                first_pos = mid;
                right = mid - 1;
            } else { // nums[mid] < x
                left = mid + 1;
            }
        }
        return first_pos;
    }
    public static int[] searchRange(int[] nums, int target) {
        int first = first_pos(nums, target);
        int last = first_pos(nums, target + 1) - 1;
        if (first <= last) {
            return new int []{first, last};
        }
        return new int [] {-1, -1};
    }
}
