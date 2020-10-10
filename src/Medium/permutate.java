package Medium;

import java.util.ArrayList;
import java.util.List;

public class permutate {
    public static void main(String args[]) {
        List<List<Integer>> list = new ArrayList<>();
        int [] nums = {1,2,3};
        permute(nums);
        System.out.println();
    }

    static List<List<Integer>> possiblePermutations = new ArrayList<>();
    public static void permute(int[] nums) {
        permutate(nums, 0);
    }

    public static void permutate(int[] array, int start) {
        if (start == array.length) {
            List<Integer> result = new ArrayList<Integer>();
            for (int i : array) {
                result.add(i);
            }
            possiblePermutations.add(result);
        }
        for (int i = start; i < array.length; ++i) {
            swap(array, i, start); // whenever we get different index, it swaps
            permutate(array, start + 1); // recursively permute all possible combinations
            swap(array, i, start);  // after adding permutation, we want this back to be original array
        }
    }

    public static void swap(int[] array, int i, int j) {
        if (i != j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

//    public static List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> result = new ArrayList();
//        List<Integer> temp = new ArrayList();
//        if(nums.length == 0){
//            return result;
//        }
//
//        for(int i = 0 ; i < nums.length; i++){
//            result = helper(result,nums[i]);
//        }
//        return result;
//    }
//
//    public static List<List<Integer>> helper(List<List<Integer>> result , int num){
//        if(result.size() == 0){
//            List<Integer> temp = new ArrayList();
//            temp.add(num);
//            result.add(temp);
//            return result;
//        }
//
//        List<List<Integer>> finalResult = new ArrayList();
//        for( List<Integer> list : result){
//            for(int i = 0; i <=list.size(); i++){
//                List<Integer> temp = new ArrayList<>(list);
//                temp.add(i,num);
//                finalResult.add(temp);
//            }
//        }
//        return finalResult;
//    }
}
