package Medium;
import java.util.*;

public class DegreeOfArray {
    public static void main(String args[]) {
        List<Integer> arr = new ArrayList<>();
        arr.add(17);
        arr.add(802);
        arr.add(88);
        arr.add(747);
        arr.add(23);
        arr.add(160);
        arr.add(681);
        arr.add(254);
        arr.add(46);
        arr.add(663);
        arr.add(752);
        arr.add(741);
        arr.add(857);
        arr.add(802);
        arr.add(387);
        arr.add(790);
        arr.add(528);
        arr.add(93);
        System.out.println(degreeOfArray(arr));
    }
    static class Node {
        int num;
        int count;
        public Node(int num, int count) {

            // node (1, 2)

            this.num = num; // 1
            this.count = count; // 1
        }
    }
    static class NodePosition {
        int startIndex;
        int endIndex;
        public NodePosition(int startIndex, int endIndex) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }
    }
    public static int degreeOfArray(List<Integer> arr) {
        // arr.length = n
        // num of Keys = k
        // O(n + k)
        // max value count = m
        //
        PriorityQueue<Node> pq = new PriorityQueue<>((i, j)-> j.count - i.count);
        Map<Integer, NodePosition> posMap = new HashMap<>();
        Map<Integer, Node> countMap = new HashMap<>();
        // [1, 2, 3, 4, 5, 6]
        for (int i = 0; i < arr.size(); i++) {
            int cur = arr.get(i);

            if (!countMap.containsKey(cur)) {
                countMap.put(cur, new Node(cur, 1));
            } else {
                Node curNode = countMap.get(cur);
                curNode.count++;
                countMap.put(cur, curNode);
            }

            if (!posMap.containsKey(cur)) {
                posMap.put(cur, new NodePosition(i, i));
            } else {
                NodePosition curNodePos = posMap.get(cur);
                curNodePos.endIndex = i;
                posMap.put(cur, curNodePos);
            }
        }
        //Iterator<Map.Entry<Integer, Node> it = new Iterator<>(countMap);
        for (Map.Entry<Integer, Node> e : countMap.entrySet()) {
            pq.add(e.getValue());
        }

        // [1, 2, 1, 3 ,2]
        // 1 , 2 , 3
        Node curNode = pq.remove();
        int maxCount = curNode.count;

        int minRange = posMap.get(curNode.num).endIndex - posMap.get(curNode.num).startIndex;

        while (!pq.isEmpty() && maxCount == pq.peek().count) {
            curNode = pq.remove();
            NodePosition nPos = posMap.get(curNode.num);
            minRange = Math.min(minRange, nPos.endIndex - nPos.startIndex);
        }

        return minRange + 1;
    }
}
