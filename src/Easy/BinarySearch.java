package Easy;

public class BinarySearch {
    public static void main(String args[]) {
        int [] array = {0,1,2,3,4,5,6,7,8};
        System.out.println(binarySearch(array, 8));
    }

    public static int binarySearch(int [] array, int target) {
        int left = 0;
        int right = array.length-1;
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] < target) {
                left = mid + 1;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else {
                index = mid;
                break;
            }

        }
        return index;
    }
}
