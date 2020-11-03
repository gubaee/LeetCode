package Medium;
import java.util.*;

public class ThreeSum {
    public static class Trie {
        static TrieNode root;
        static List<List<Integer>> result;
        static int count;
        public Trie() {
            root = new TrieNode();
            result = new ArrayList<>();
            count = 0;
        }
        public static void insert(List<Integer> list) {

            TrieNode cur = root;
            for (int i = 0; i < list.size(); i++) {
                TrieNode next = cur.children.get(list.get(i));
                if (next == null) {
                    next = new TrieNode();
                    next.list = new ArrayList<>(cur.list);
                    next.list.add(list.get(i));
                    cur.children.put(list.get(i), next);
                }
                cur = next;
            }
            if (cur.visited == false) {
                count++;
                cur.visited = true;
                result.add(new ArrayList<>(cur.list));
            }
        }
    }


    public static class TrieNode {
        Map<Integer, TrieNode> children;
        List<Integer> list;
        boolean visited;

        public TrieNode() {
            children = new HashMap<>();
            list = new ArrayList<>();
        }

    }
    public static void main(String args[]) {
        int [] array = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> list = threeSum(array);
        System.out.println();

    }

    public static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        Trie root = new Trie();
        dfs(nums, 0, new ArrayList<>(), 0, root);
        List<List<Integer>> result = new ArrayList<>(root.result);
        return result;
    }

    public static void dfs(int [] nums, int curSum, List<Integer> curList, int index, Trie root) {
        if (curSum == 0 && curList.size() == 3) {
            root.insert(curList);
            return ;
        }

        for (int i = index; i < nums.length; i++) {
            // if (i > 0 && nums[i] == nums[i-1]) {
            //     continue;
            // }
            curList.add(nums[i]);
            dfs(nums, curSum + nums[i], curList, i+1, root);
            curList.remove(curList.size()-1);
        }

    }
}
