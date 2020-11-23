package Amazon;

public class isSubTree {
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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return findSubTree(s, t);
    }

    public boolean findSubTree(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return false;
        }

        if (s.val == t.val) {
            if(isSameTree(s, t)) {
                return true;
            }
        }

        return findSubTree(s.left, t) || findSubTree(s.right, t);
    }

    public boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }

        return s.val == t.val && isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}
