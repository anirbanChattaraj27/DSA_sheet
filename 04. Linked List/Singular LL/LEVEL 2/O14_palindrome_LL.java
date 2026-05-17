// approch: take fast and slow pointer and reverse 2nd half from slow pointer and compare each value
// LEETCODE: 234 ---> https://leetcode.com/problems/palindrome-linked-list/description/


class Solution {
    public boolean isPalindrome(ListNode head) {
        // Base case
        if (head == null || head.next == null) return true;

        ListNode fast = head;
        ListNode slow = head;

        // 1. Move the loop to find the middle FIRST
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 2. Start reversal from 'slow' AFTER the finding loop ends
        ListNode prev = null; // Changed to null so the last node points to null
        ListNode curr = slow;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev; // Fixed the typo 'crr'
            prev = curr;
            curr = next;
        }

        // 3. Compare the two halves
        ListNode p1 = head;
        ListNode p2 = prev; // Head of the reversed second half
        
        while (p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }
}