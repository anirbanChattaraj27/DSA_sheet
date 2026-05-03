class Node {
    int data;
    Node next;

    Node(int val) {
        data = val;
        next = null;
    }
}

public class O10_reverse_pairs {

    // Function to swap data of nodes in pairs
    static void pairwiseSwap(Node head) {
        Node curr = head;

        // Traverse the list and swap data in pairs
        while (curr != null && curr.next != null) {
            
            // Swap data of current node and the next node
            int temp = curr.data;
            curr.data = curr.next.data;
            curr.next.data = temp;

            // Move to the next pair
            curr = curr.next.next;
        }
    }

    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if(temp.next!=null)
            {
                System.out.print(" -> ");
            }
            temp = temp.next;
        }
        System.out.println();
    } 

    public static void main(String[] args) {
        
        // Creating the linked list: 
      	// 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        pairwiseSwap(head);

        printList(head);
    }
}