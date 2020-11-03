package Medium;
import javax.swing.tree.TreeNode;
import java.util.*;
public class VerticalOrderTraversalBinaryTree {
    public void main (String args[]) {

    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public class Pair{
        int val;
        int depth;
        public Pair(int val, int depth) {
            this.val = val;
            this.depth = depth;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<Pair>> map = new TreeMap<>( (i, j) -> i-j);

        helper(root, map, 0, 0);

        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry e : map.entrySet()) {
            List<Pair> array = new ArrayList<Pair>((ArrayList<Pair>)e.getValue());
            Collections.sort(array, (i, j) -> i.depth-j.depth);

            List<Integer> subResult = new ArrayList<>();
            for (int i = 0; i < array.size(); i++) {
                subResult.add(array.get(i).val);
            }
            result.add(subResult);
        }
        return result;
    }
    public void helper(TreeNode root, Map<Integer, List<Pair>> map, int xPos, int depth) {
        // pair <value, depth>
        if (root == null) {
            return ;
        }
        if (!map.containsKey(xPos)) {
            List<Pair> array = new ArrayList<>();
            array.add(new Pair(root.val, depth));
            map.put(xPos, array);
        } else {
            List<Pair> array = map.get(xPos);
            array.add(new Pair(root.val, depth));
            map.put(xPos, array);
        }

        helper(root.left, map, xPos-1, depth + 1);
        helper(root.right, map, xPos+1, depth + 1);

    }
}
