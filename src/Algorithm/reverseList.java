package Algorithm;

public class reverseList {
    public static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
    }
    public static ListNode iterationReverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static ListNode recursionReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = recursionReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = recursionReverseList(head);

        while (result != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }
        System.out.print("null");
    }
}
