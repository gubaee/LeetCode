package Medium;
import java.util.*;

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode (int val) {
        this.val = val;
    }
}

public class PathSum3 {
    static int result = 0;
    static int count = 0;
    public static void main(String args[]) {
//        root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        System.out.println(pathSum(root, 8));
    }
    static HashMap<Integer, Integer> map = new HashMap<>();

    public static int pathSum(TreeNode root, int sum) {
        dfs(root, 0, sum);
        return count;
    }

    public static void dfs(TreeNode node, int curSum, int target) {
        if (node == null) {
            return ;
        }

        curSum += node.val;

        if (curSum == target) {
            count++;
        }

        count += map.getOrDefault(curSum - target, 0);

        map.put(curSum, map.getOrDefault(curSum, 0) + 1);

        dfs(node.left, curSum, target);
        dfs(node.right, curSum, target);

        map.put(curSum, map.get(curSum) - 1);
    }
//    public static int pathSum(TreeNode root, int sum) {
//        if (root == null) {
//            return result;
//        }
//
//
//        dfs(root, sum);
//        return result;
//    }
//
//    public static void dfs(TreeNode root, int target) {
//        if (root == null) {
//            return ;
//        }
//
//        findTargetSum(root, target, root.val);
//        dfs(root.left, target);
//        dfs(root.right, target);
//    }
//
//    public static void findTargetSum(TreeNode root, int target, int curSum) {
//        if (root == null) {
//            return ;
//        }
//
//        if (curSum + root.val == target) {
//            result++;
//        }
//
//        findTargetSum(root.left, target, curSum + root.val);
//        findTargetSum(root.right, target, curSum + root.val);
//    }
}
