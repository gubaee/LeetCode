package Medium;
import java.util.*;
class ListNode {
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}
public class ReverseLinkedList2 {

    public static void main(String args[]) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);

        ListNode result = reverseBetween(root, 2, 4);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }


    }
    Map<Integer, ListNode> nodeMap = new HashMap<>();
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }

        ListNode temp = new ListNode(-1);
        temp.next = head;

        ListNode firstPrev = null;
        ListNode secondPrev = null;
        while (temp.next != null) {
            if (temp.next.val == m) {
                firstPrev = temp;
            }
            if (temp.next.val == n) {
                secondPrev = temp;
            }
            temp = temp.next;
        }

        swapPosition(firstPrev, secondPrev);

        return head;
    }

    public static void swapPosition(ListNode firstPrev, ListNode secondPrev) {
        // 1->2->3->4->5->NULL, m = 2, n = 4
        // firstprev = 1
        // secondprev = 3
        ListNode first = firstPrev.next; //2
        ListNode second = secondPrev.next; //4
        ListNode firstNext = first.next;
        ListNode secondNext = second.next;
        firstPrev.next = second;
        second.next = firstNext;

        secondPrev.next = first;
        first.next = secondNext;

    }
}
