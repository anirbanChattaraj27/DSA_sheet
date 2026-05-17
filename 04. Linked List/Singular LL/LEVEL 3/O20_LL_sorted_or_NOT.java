// LL sorted or not check from both assending and decending
//  1 2 3 4 5 -----> true
//  5 4 3 2 1 -----> true
//  4 5 6 1 2 -----> false


// Definition for singly-linked list node
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Solution class containing the sorting logic
class Solution {
    public boolean isSorted(Node head) {
        // Base case: Empty list or single node is always sorted
        if (head == null || head.next == null) {
            return true;
        }

        // Flags to track if the list is strictly ascending or descending
        boolean ascending = true;
        boolean descending = true;

        Node temp = head;

        while (temp.next != null) {
            // If current data is greater than next, it cannot be ascending
            if (temp.data > temp.next.data) {
                ascending = false;
            }
            // If current data is smaller than next, it cannot be descending
            if (temp.data < temp.next.data) {
                descending = false;
            }

            // Early exit: if it violates both orders, it's unsorted
            if (!ascending && !descending) {
                return false;
            }

            temp = temp.next;
        }

        // Returns true if the list matches at least one sorting pattern
        return ascending || descending;
    }
}

// Main class to execute and test the code
public class O20_LL_sorted_or_NOT {
    public static void main(String[] args) {
        Solution solver = new Solution();

        // Creating test case: 19 -> 7
        Node head = new Node(19);
        head.next = new Node(7);

        // Check if the list is sorted
        boolean result = solver.isSorted(head);
        
        // Print output as 1 (true) or 0 (false) to match your platform's format
        System.out.println(result ? 1 : 0);
    }
}
