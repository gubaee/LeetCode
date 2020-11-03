package Medium;
import java.util.*;
public class RorateArray {
    public static void main(String args[]) {
        int [] array = {1,2,3,4,5,6,7};
        rotate(array, 2);
        System.out.println();
    }

    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);

        // int [] array = new int [nums.length];
        // for (int i = 0; i < array.length; i++) {
        //     int index = (i + k) % nums.length;
        //     array[index] = nums[i];
        // }
        // for (int i = 0; i < nums.length; i++) {
        //     nums[i] = array[i];
        // }
    }
    public static void reverse(int [] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
