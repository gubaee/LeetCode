package Medium;
import java.util.*;

public class CombinationSum2 {
    public static void main(String args[]) {
        // [10,1,2,7,6,1,5] , 8
        // [1, 1, 2, 5, 6, 7, 10]
        int [] array = {10, 1, 2, 7, 6, 1, 5};
//        int [] array = {1, 2};
        combinationSum2(array, 8);
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        dfs(list, 0, 0, target, candidates, result);

        return result;
    }
    public static void dfs(List<Integer> list, int index, int curSum, int target, int[] candidates, List<List<Integer>> result) {
        if (curSum == target) {
            result.add(new ArrayList<>(list));
            return;
        } else if (curSum > target) {
            return ;
        }
        if (index >= candidates.length) {
            return ;
        }        // [1, 1, 2, 5, 6, 7, 10]
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i-1]) {
                continue;
            }
            list.add(candidates[i]);
            dfs(list, i+1, curSum + candidates[i], target, candidates, result);
            list.remove(list.size()-1);
        }


    }
}
