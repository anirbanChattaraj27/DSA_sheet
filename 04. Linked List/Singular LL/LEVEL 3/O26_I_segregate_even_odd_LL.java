// this is for separate values of odd even index

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

        if (head == null || head.next == null)
            return head;

        Node evenHead = null, evenTail = null;
        Node oddHead = null, oddTail = null;
        Node current = head;

        while (current != null) {
            // 1. Save the actual next node BEFORE changing pointers
            Node nextNode = current.next;
            // 2. Isolate the current node
            current.next = null;

            if (current.data % 2 == 0) {
                if (evenHead == null) {
                    evenHead = current;
                    evenTail = current;
                } 
                else {
                    evenTail.next = current;
                    evenTail = current;
                }
            } 
            else {
                if (oddHead == null) {
                    oddHead = current;
                    oddTail = current;
                } 
                else {
                    oddTail.next = current;
                    oddTail = current;
                } 
            }
            // 3. Move to the saved next node safely
            current = nextNode;
        }

        if (evenHead == null)
            return oddHead;

        // Combine lists (oddTail.next is already null from isolation step)
        evenTail.next = oddHead;

        return evenHead;
    }
}

// Driver code
public class O26_I_segregate_even_odd_LL {
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