package Medium;

public class KthLargestElement {
    public static void main(String args[]) {
        System.out.println(findKthLargest(new int []{3,6,1,7,5}, 4));
    }
    public static int findKthLargest(int[] nums, int k) {

        return findKthLargest(nums, nums.length - k, 0, nums.length-1);
    }
    public static int findKthLargest(int [] nums, int kthSmallest, int left, int right) {
        int index = partition(nums, left, right);

        if (kthSmallest == index) {
            return nums[index];
        } else if (index < kthSmallest) {
            return findKthLargest(nums, kthSmallest, index+1, right);

        } else {
            return findKthLargest(nums, kthSmallest, left, index-1);
        }

    }

    private static int partition(int [] array, int left, int right) {
        int pivot = array[right];
        int pointer = left;
        for (int i = left; i <= right; i++) {
            if (array[i] < pivot) {
                int temp = array[i];
                array[i] = array[pointer];
                array[pointer] = temp;
                pointer++;
            }
        }

        int temp = array[right];
        array[right] = array[pointer];
        array[pointer] = temp;

        return pointer;

    }

}
