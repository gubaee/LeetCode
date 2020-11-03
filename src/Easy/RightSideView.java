package Easy;
import java.util.*;
public class RightSideView {
    public static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        rightSideView(root);
        System.out.println();
    }
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        result.add(root.val);

        while (queue.isEmpty()) {
            Queue<TreeNode> children = new LinkedList<>();
            TreeNode lastNode = null;

            while(queue.isEmpty()) {
                TreeNode cur = queue.remove();
                if (cur.left != null) {
                    lastNode = cur.left;
                    children.add(cur.left);
                }
                if (cur.right != null) {
                    lastNode = cur.right;
                    children.add(cur.right);
                }
            }

            if (lastNode != null) {
                result.add(lastNode.val);
            }
            queue = children;
        }
        return result;
    }
}
