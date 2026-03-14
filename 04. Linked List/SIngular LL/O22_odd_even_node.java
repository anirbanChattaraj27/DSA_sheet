// https://leetcode.com/problems/odd-even-linked-list/

public class O22_odd_even_node{
    // function for odd even node
    public Node oddEvenList(Node head) {
        if (head == null)return null;
        
        // odd pointer points to head node
        Node odd = head;
        
        // even pointer points to head.next // if 1st node is odd then 2nd node will be even
        Node even = head.next;
        
        //evenHead pointer points to even noce
        Node evenHead = even;
        
        //if even pointer does not points to null and even.next does not points to null
        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        
        odd.next = evenHead;
        return head;
    }
}