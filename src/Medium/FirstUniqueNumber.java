package Medium;
import java.util.*;

class Node {
    Node next;
    Node prev;
    boolean active = true;
    int val;
    public Node() {}
}

public class FirstUniqueNumber {
    public static void main(String args[]) {
        int [] array = {1,1,5};
        FirstUniqueNumber fn = new FirstUniqueNumber(array);
        System.out.println(fn.showFirstUnique());
        fn.add(1);
        System.out.println(fn.showFirstUnique());
        fn.add(1);
        System.out.println(fn.showFirstUnique());
        fn.add(1);
        System.out.println(fn.showFirstUnique());
    }

    Map<Integer, Node> map;
    Node head;
    Node tail;
    public FirstUniqueNumber(int[] nums) {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;

        map = new HashMap<>();
        for (int e : nums) {
            add(e);
        }
    }

    public int showFirstUnique() {
        if (head.next != tail) {
            return head.next.active ? head.next.val : -1;
        }
        return -1;
    }

    public void add(int value) {
        if (!map.containsKey(value)) {

            Node newNode = new Node();
            newNode.val = value;

            map.put(value, newNode);
            //    [] <-  [] ->  []
            //       ->     <-
            newNode.next = tail;
            newNode.prev = tail.prev;

            tail.prev.next = newNode;
            tail.prev = newNode;
        } else {

            Node curNode = map.get(value);
             if (curNode.active) {
                curNode.active = false;

                Node next = curNode.next;
                Node prev = curNode.prev;

                prev.next = next;
                next.prev = prev;
             }

        }
    }
}
