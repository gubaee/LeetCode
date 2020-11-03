package FacebookPractice;
import java.util.*;
public class NumberOfVisibleNodes {
    static class Node {
        int data;
        Node left;
        Node right;
        Node() {
            this.data = 0;
            this.left = null;
            this.right = null;
        }
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static void main(String args[]) {
        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);
        System.out.println(visibleNodes(root));
    }
    // DFS
    static int visibleNodes(Node root) {
        if (root == null) {
            return 0;
        }
        return visibleNodes(root, 0);
    }
    private static int visibleNodes(Node root, int level) {
        if (root == null) {
            return level;
        }
        int left = visibleNodes(root.left, level + 1);
        int right = visibleNodes(root.right, level + 1);
        return Math.max(left, right);
    }

//    // BFS
//    static int visibleNodes(Node root) {
//        // Write your code here
//        if (root == null) {
//            return 0;
//        }
//        Queue<Node> queue = new LinkedList<Node>();
//        queue.add(root);
//        int result = 0;
//
//        while (!queue.isEmpty()) {
//            Queue<Node> childQueue = new LinkedList<Node>();
//            while (!queue.isEmpty()) {
//                Node children = queue.remove();
//                if (children.left != null) {
//                    childQueue.add(children.left);
//                }
//                if (children.right != null) {
//                    childQueue.add(children.right);
//                }
//            }
//            queue = childQueue;
//            result++;
//        }
//        return result;
//    }
}
