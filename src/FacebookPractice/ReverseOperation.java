package FacebookPractice;

public class ReverseOperation {

    static class Node {
        int data;
        Node next;
        Node(int x) {
            data = x;
            next = null;
        }
    }
    public static void main(String args[]) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(8);
        head.next.next.next = new Node(9);
        head.next.next.next.next = new Node(12);
        head.next.next.next.next.next = new Node(16);
        head.next.next.next.next.next.next = new Node(18);
        Node newHead = reverse(head);
        System.out.println();

    }
    // Add any helper functions you may need here
    static Node reverseList(Node head, Node end) {
        Node tempHead = head;
        Node prev = null;
        while (head != end) {
            Node temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        Node temp = prev;
        while(temp.next!=null) {
            temp = temp.next;
        }
        temp.next = tempHead;

        return prev;
    }

    static Node reverse(Node head) {
        // Write your code here
        Node start = head;
        Node end = null;
        while(start.next != null) {
            // find the even number
            Node prev = start;

            // 1, 1, 1, 2, 4

            while(start.data %2 == 1) {
                if (start.next.data %2 == 1) {
                    prev = prev.next;
                }
                start = start.next;
            }
            end = start;
            while (end.next != null && end.data%2 == 0) {
                end = end.next;
            }
            if(end.next == null) {

            }
            //0-> 1-> 2->3
            //0-> 3-> 2-> 1
            prev.next = reverseList(start, end);
            start = end;
            if(start.next == null) {
                break;
            }
        }
        return head;
    }
}
