/*  ✨✨✨✨✨✨✨✨
                        WATCH Striver's video and watch revrse function from his video so that this code will work and show the explanation also
    ✨✨✨✨✨✨✨✨
*/


// leetcode --> https://leetcode.com/problems/palindrome-linked-list/
// striver --> https://www.youtube.com/watch?v=-DtNInqFUXs


public class O24_palindrom_LL {
        
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        
        ListNode slow = head;
        ListNode fast = head;
        
        // find middle of LL
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // reverse the right Half
        slow.next = reverseList(slow.next);
        
        // move slow to right half
        slow = slow.next;
        
        // check for left haf array equal or not
        while(slow != null){
            if(head.val != slow.val){
                return false;
            }
            
            head = head.next;
            slow = slow.next;
        }
        return true;        
    }
    // rest code i did not write here... so the video again
    
}
