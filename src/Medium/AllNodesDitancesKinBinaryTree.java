package Medium;
import java.util.*;

public class AllNodesDitancesKinBinaryTree {
    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int x) {
            this.val = x;
        }
    }

    public static void main(String args[]) {
        //3,5,1,6,2,0,8,null,null,7,4
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        distanceK(root, root.left, 2);

    }




    private static Map<TreeNode, TreeNode> map = new HashMap<>();

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> set = new HashSet<>();
        q.add(target);

        buildGraph(root, root);

        List<Integer> result = new ArrayList<>();
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            if (count == K) {
                for (int i = 0; i < size; i++) {
                    result.add(q.remove().val);
                }

                return result;
            } else {
                for (int i = 0; i < size; i++) {
                    TreeNode cur = q.remove();

                    if (!set.contains(cur)) {
                        if (!set.contains(cur.left)) {
                            if (cur.left != null) {
                                q.add(cur.left);
                            }
                        }
                        if (!set.contains(cur.right)) {
                            if (cur.right != null) {
                                q.add(cur.right);
                            }
                        }
                        if (!set.contains(map.get(cur))) {
                            if (map.get(cur) != cur) {
                                q.add(map.get(cur));
                            }
                        }
                        set.add(cur);

                    }

                }
            }

            count++;
        }
        return result;
    }

    public static void buildGraph(TreeNode node, TreeNode parent) {
        if (node == null) {
            return;
        }

        if (!map.containsKey(node)) {
            map.put(node, parent);
        }

        buildGraph(node.left, node);
        buildGraph(node.right, node);

        //buildGraph()
    }
}

