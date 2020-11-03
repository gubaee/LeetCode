package Medium;

public class QuickSort {
    public static void main(String args[]) {
        int [] array = {5, 4, 3, 1, 7, 2};
        QuickSort(array, 0, array.length-1);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();
    }
//    public static void QuickSort(int [] array, int left, int right){
////        int index = partition(array,left,right);
////
////        if(left < index-1){
////            QuickSort(array,left,index-1);
////        }
////        if(index < right){
////            QuickSort(array,index,right);
////        }
//
//        if (left < right) {
//            int index = partition(array,left,right);
//            QuickSort(array,left,index-1);
//            QuickSort(array,index,right);
//        }
//    }

//    public static int partition(int [] array, int left, int right){
//        int pivot = array[left + (right - left)/2];
//
//        while(left <= right){
//            while(array[left] < pivot){
//                left++;
//            }
//            while(pivot < array[right]){
//                right--;
//            }
//
//            if(left <= right){
//                int temp = array[left];
//                array[left] = array[right];
//                array[right] = temp;
//                left++;
//                right--;
//            }
//        }
//        return left;
//    }

    public static void QuickSort(int [] array, int left, int right){
        if (left < right) {
            int partitionIndex = partition(array, left, right);

            QuickSort(array, left, partitionIndex - 1);
            QuickSort(array, partitionIndex + 1, right);
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
