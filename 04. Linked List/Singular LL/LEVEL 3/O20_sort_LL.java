// https://leetcode.com/problems/sort-list/

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class O20_sort_LL {
    public ListNode sortList(ListNode head) {

        // Base case to stop recursion and prevent NullPointerException
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode slow = head; // slow will points to mid and from slow I will divide in 2 parts
        ListNode fast = head;

        // Find middle while keeping track of the node before 'slow'
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Disconnect the first half from the second half
        prev.next = null;

        // Recursively sort both halves
        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        // Merge sorted halves
        return merge(left, right);

    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        if (l1 != null) {
            tail.next = l1;
        } else {
            tail.next = l2;
        }

        // Return head of merged list
        return dummy.next;
    }
}