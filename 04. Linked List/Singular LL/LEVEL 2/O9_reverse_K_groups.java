// source --> https://practice.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/1
/*
Input: k = 2,
        1 -> 2 -> 3 -> 4 -> 5 -> 6

Output: 2 -> 1 -> 4 -> 3 -> 6 -> 5
*/

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class O9_reverse_K_groups {
    
    static Node reverseKGroup(Node head, int k) {
        if (head == null) {
            return head;
        }

        Node curr = head;
        Node newHead = null;
        Node tail = null;

        while (curr != null) {
            Node groupHead = curr;
            Node prev = null;
            Node nextNode = null;
            int count = 0;

            // Reverse the nodes in the current group
            while (curr != null && count < k) {
                nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
                count++;
            }

            // If newHead is null, set it to the
            // last node of the first group
            if (newHead == null) {
                newHead = prev;
            }

            // Connect the previous group to the 
            // current reversed group
            if (tail != null) {
                tail.next = prev;
            }

            // Move tail to the end of the
          	// reversed group
            tail = groupHead;
        }

        return newHead;
    }

    static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data);
            if(curr.next != null){
                System.out.print(" -> ");
            }
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        head = reverseKGroup(head, 3);
        printList(head);
    }
}