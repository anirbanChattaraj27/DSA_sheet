// this is for separate odd even index not based on values
// Leetcode 328


class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class Solution {

    // Function to segregate even and odd nodes in a linked list
    public Node segregateEvenOdd(Node head) {

        if (head == null || head.next == null) {
            return head;
        }
        
        Node odd = head;
        Node OddHead = odd; // taking an extra pointer which is pointing to odd node's head and at last I am returning that headNode
        Node even = head.next;
        Node evenHead = even; // Save to connect at the end
        
        while (even != null && even.next != null) {
            odd.next = even.next;  // Connect current odd to next odd
            odd = even.next;        // Move odd pointer forward
            
            even.next = odd.next;  // Connect current even to next even
            even = odd.next;      // Move even pointer forward
        }
        
        odd.next = evenHead;       // Link the end of odd list to head of even list
        return OddHead;
    
    }
}

// Driver code
public class O26_II_segregate_even_odd_LL {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Creating linked list: 17 -> 15 -> 8 -> 12 -> 10 -> 5 -> 4
        Node head = new Node(17);
        head.next = new Node(14);
        head.next.next = new Node(9);
        head.next.next.next = new Node(12);
        head.next.next.next.next = new Node(10);
        head.next.next.next.next.next = new Node(5);
        head.next.next.next.next.next.next = new Node(4);

        // Call segregation function
        Node newHead = sol.segregateEvenOdd(head);

        // Print result
        while (newHead != null) {
            System.out.print(newHead.data + " ");
            newHead = newHead.next;
        }
    }
}